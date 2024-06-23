package net.lostteku;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Test extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("Hallo Welt!"); //Sendet eine Nachricht in die Konsole
    }
}
