package net.lostteku.permissions;

import net.lostteku.manager.ConfigManager;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.Arrays;

public class PermissionManager {


    private ConfigManager configManager = new ConfigManager();

    public ArrayList<String> getPlayerPermissions(String uuid) {
        return (ArrayList<String>) configManager.getConfigFile("user-permissions").getList(uuid + ".permissions");
    }
}
