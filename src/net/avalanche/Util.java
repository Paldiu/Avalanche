package net.avalanche;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Util
{
    protected Main plugin;
    public static final List<String> STOP_COMMANDS = Arrays.asList("stop", "off", "end", "halt", "die");
    
    public static void bcastMsg(String message, ChatColor color)
    {
        Main.logger.info(message);
        for (Player p : Bukkit.getOnlinePlayers())
        {
            p.sendMessage((color == null ? "" : color) + message);
        }
    }

    public static void bcastMsg(String message)
    {
        Util.bcastMsg(message, null);
    }
    
    public static boolean isStopCommand(String command)
    {
        return STOP_COMMANDS.contains(command.toLowerCase());
    }
    
    public static String colorise(String string)
    {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
