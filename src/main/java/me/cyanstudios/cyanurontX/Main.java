package me.cyanstudios.cyanurontX;

import me.cyanstudios.cyanurontX.commands.CommandCyanurontX;
import me.cyanstudios.cyanurontX.events.DamageListener;
import me.cyanstudios.cyanurontX.events.PlayerDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("CyanurontX habilitado");
        this.getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        this.getServer().getPluginManager().registerEvents(new DamageListener(), this);
        Objects.requireNonNull(this.getCommand("cyanurontx")).setExecutor(new CommandCyanurontX());

        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin deshabilitado");
    }

    private void showPluginInfo() {
        getLogger().info("§bCyanurontX v1.0");
        getLogger().info("§3Plugin creado por CyanStudios");
        getLogger().info("§3   ■■■■■■■■   ");
        getLogger().info("§3 ■■        ■■  ");
        getLogger().info("§3■              ■  ");
        getLogger().info("§3■                ");
        getLogger().info("§3■                ");
        getLogger().info("§3■                ");
        getLogger().info("§3■                ");
        getLogger().info("§3■              ■  ");
        getLogger().info("§3 ■■        ■■  ");
        getLogger().info("§3   ■■■■■■■■   ");

    }

}
