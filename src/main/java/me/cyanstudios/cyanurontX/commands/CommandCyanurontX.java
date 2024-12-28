package me.cyanstudios.cyanurontX.commands;

import me.cyanstudios.cyanurontX.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandCyanurontX implements CommandExecutor {

    private final Main main = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!sender.hasPermission("cyanurontx.admin")) {
            sender.sendMessage("No tienes permisos para ejecutar este comando");
            return true;
        }
        if (label.equalsIgnoreCase("cyanurontx") && args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            switch (args[0]) {
                case "reload" -> {
                    sender.sendMessage(" Recargando configuracion");
                    main.reloadConfig();
                    return true;
                }
                default -> {
                    sender.sendMessage("Comando no encontrado");
                    return false;
                }
            }
        }
        return false;
    }
}
