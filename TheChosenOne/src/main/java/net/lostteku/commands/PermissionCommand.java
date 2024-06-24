package net.lostteku.commands;

import com.google.protobuf.Message;
import net.lostteku.enums.Messages;
import net.lostteku.manager.ConfigManager;
import net.lostteku.manager.LoggingManager;
import net.lostteku.permissions.PermissionManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class PermissionCommand implements CommandExecutor {

    private ConfigManager configManager = new ConfigManager();
    private LoggingManager loggingManager = new LoggingManager();
    private PermissionManager permissionManager = new PermissionManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(args.length >= 3) {
                switch (args[0]) {
                    case "add":
                        if (loggingManager.getUser(args[1]) == null) {
                            sender.sendMessage(Messages.getCustomMessage(Messages.NO_PLAYER));
                            return false;
                        }

                        //if (configManager.getConfigFile("user-permissions").get(loggingManager.getUser(args[1]).getUuid()) == null) {
                        if(permissionManager.getPlayerPermissions(loggingManager.getUser(args[1]).getUuid()) == null){
                            configManager.setConfigurationToFile("user-permissions", loggingManager.getUser(args[1]).getUuid() + ".permissions",  List.of(args[2].split(" ")));
                            sender.sendMessage(Messages.getCustomMessage(Messages.ACTION_SUCESS));
                            return true;
                        }
                        Bukkit.getConsoleSender().sendMessage(List.of(args[2].split(" ")).toString());
                        ArrayList<String> permissionlist = permissionManager.getPlayerPermissions(loggingManager.getUser(args[1]).getUuid());
                        permissionlist.addAll(List.of(args[2].split(" ")));
                        configManager.setConfigurationToFile("user-permissions", loggingManager.getUser(args[1]).getUuid() + ".permissions",  permissionlist);
                        sender.sendMessage(Messages.getCustomMessage(Messages.ACTION_SUCESS));
                        return true;

                }
        }
        return true;
    }
}
