package me.cyanstudios.cyanurontX.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityResurrectEvent;

public class DamageListener implements Listener {
    @EventHandler
    public void PlayerDamageEvent(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        e.setDamage(e.getDamage() * 2);
    }

    @EventHandler
    public void PlayerUseTotem(EntityResurrectEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                "bbroadcast {#801919}☠ [Aviso] ☠ {#cc5600}" + e.getEntity().getName() + " ha usado un totem");
    }

}
