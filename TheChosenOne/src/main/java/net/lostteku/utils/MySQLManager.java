package net.lostteku.utils;

import net.lostteku.enums.DefaultConf;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLManager {

    private Connection connection = null;

    public void connect(){
        if(DefaultConf.getCustomValue(DefaultConf.MYSQL_ENABLED) == "false") return;
        Bukkit.getConsoleSender().sendMessage("§cMySQL ist aktiviert! Versuche mich zu verbinden...");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + DefaultConf.getCustomValue(DefaultConf.MYSQL_HOST) + ":"
            + DefaultConf.getCustomValue(DefaultConf.MYSQL_PORT) + "/" + DefaultConf.getCustomValue(DefaultConf.MYSQL_DATABASE_NAME), DefaultConf.getCustomValue(DefaultConf.MYSQL_USERNAME), DefaultConf.getCustomValue(DefaultConf.MYSQL_PASSWORD));
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("§cMySQL-Verbindung konnte nicht hergestellt werden!");
        }

    }
}
