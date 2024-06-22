package net.lostteku;

import net.lostteku.commands.FeedCommand;
import net.lostteku.commands.HealCommand;
import net.lostteku.events.PlayerChatListener;
import net.lostteku.events.PlayerCommandListener;
import net.lostteku.utils.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TheChosenOne extends JavaPlugin {

    private static TheChosenOne one;
    private ConfigManager configManager = new ConfigManager();
    @Override
    public void onEnable() {
        one = this;
        configManager.loadFiles();

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerChatListener(), this);
        pm.registerEvents(new PlayerCommandListener(), this);

        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());

        Bukkit.getConsoleSender().sendMessage("§aTheChosenOne has loaded!");
    }

    public static TheChosenOne getChosenOne(){
        return one;
    }
}
