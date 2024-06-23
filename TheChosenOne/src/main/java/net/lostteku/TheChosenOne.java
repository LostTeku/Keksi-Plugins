package net.lostteku;

import net.lostteku.commands.FeedCommand;
import net.lostteku.commands.HealCommand;
import net.lostteku.events.PlayerChatListener;
import net.lostteku.events.PlayerCommandListener;
import net.lostteku.manager.BanManager;
import net.lostteku.manager.ConfigManager;
import net.lostteku.manager.MySQLManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TheChosenOne extends JavaPlugin {

    private static TheChosenOne one;
    private ConfigManager configManager = new ConfigManager();
    private MySQLManager mySQLManager = new MySQLManager();
    private BanManager banManager = new BanManager();

    @Override
    public void onLoad() {
        one = this;
        configManager.loadFiles();
        mySQLManager.connect();
        banManager.init();
    }

    //String, Integer, Float, void

    @Override
    public void onEnable() {

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
