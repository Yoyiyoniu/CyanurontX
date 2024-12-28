package me.cyanstudios.cyanurontX.events;

import me.cyanstudios.cyanurontX.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerDeathListener implements Listener {

    private final Main main = Main.getPlugin(Main.class);


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        e.setCancelled(true);

        Bukkit.dispatchCommand(
                Bukkit.getConsoleSender(),
                "bbroadcast {#801919}☠ [Muertes] ☠ {#cc5600}" + e.getEntity().getName() + " ha muerto en Cyanuront"
        );
        for (ItemStack item : e.getDrops()) {
            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), item);
        }
        e.getDrops().clear();

        Player p = e.getPlayer();
        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.playSound(p.getLocation(),"minecraft:entity.skeleton_horse.death", 1.0f, 0f);
        }
        p.setGameMode(GameMode.SPECTATOR);


        Bukkit.getScheduler().runTaskLater(main, () -> {
            p.sendMessage("Desafortunadamente moriste en el modo hardcore...");
            p.sendMessage("Pero no te preocupes, puedes volver a jugar en 1 día.");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"cmi server lobby " + p.getName());
        }, 20 * 2);

        Bukkit.getScheduler().runTaskLater(main, () -> {
            String status = "Desafortunadamente moriste en el modo hardcore...\n" +
                    "Pero no te preocupes, puedes volver a jugar en 1 día.";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "cmi tempban "+p.getName()+" 1d " + status);
        }, 20 * 4);
    }

    @EventHandler
    public void onPlayerUseTotem(EntityResurrectEvent e) {
        if (e.getEntity() instanceof Player) return;

        Bukkit.dispatchCommand(
                Bukkit.getConsoleSender(),
                "bbroadcast {#e6b300}[Aviso] &e" + e.getEntity().getName() + " popeo totem"
        );
    }

}
