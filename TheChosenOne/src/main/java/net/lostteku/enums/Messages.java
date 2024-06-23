package net.lostteku.enums;

import net.lostteku.manager.ConfigManager;
import org.bukkit.ChatColor;

public enum Messages {


    PREFIX("prefix", "&a&l-> &e"),
    NO_PERMISSION("noPermissionMessage", "&cDu hast keine Berechtigungen, diese Aktion zu tätigen!"),
    WRONG_COMMAND_ARGUMENTS("wrongCommandArguments", "&cFalscher Command-Syntax! Benutzung:"),
    BLOCKED_COMMAND("blockedCommandMessage", "&aDu hast dich erfolgreich geheilt!"),
    NO_PLAYER("noPlayerFound", "&cSpieler nicht gefunden!"),
    OFFLINE_PLAYER("offlinePlayerMessage", "&cDer gesuchte Spieler ist offline!"),
    ACTION_SUCESS("actionSuccess", "&aAktion erfolgreich ausgeführt!"),
    HEAL("healMessage", "&aDu hast dich erfolgreich geheilt!"),
    FOOD("foodMessage", "&aDu hast dich erfolgreich gefüttert!");

    private String path;
    private String msg;
    private static ConfigManager manager = new ConfigManager();


    Messages(String path, String msg) {
        this.path = path;
        this.msg = msg;
    }

    public String getPath() {
        return path;
    }

    public String getStandardMessage() {
        return msg;
    }

    public static String getCustomMessage(Messages message) {
        return ChatColor.translateAlternateColorCodes('&', manager.getConfigFile("messages").getString("prefix") + " " + ChatColor.translateAlternateColorCodes('&', manager.getConfigFile("messages").getString(message.getPath()).replace('\n', '\n')));
    }
}



