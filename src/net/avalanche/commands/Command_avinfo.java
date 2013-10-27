package net.avalanche.commands;

import org.bukkit.command.*;
import net.avalanche.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_avinfo implements CommandExecutor
{
    public Main plugin;
    public Command_avinfo(Main instance)
    {
        plugin = instance;
    }
    
    String[] messages =
    {
        "Version: " + Main.version,
        "Avalanche was created by Paldiu and freelix2000",
        "and is meant for overall fun."
    };
    ChatColor messageColor = ChatColor.GREEN;
    String lineTxt = "";
    String pattern = ChatColor.BLUE + "-" + ChatColor.AQUA + "=";
    int lineLength = 20;
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
    {
        if (lbl.equalsIgnoreCase("avinfo"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("avalanche.avinfo"))
                {
                    double length = 0;
                    for (int i = 0; i < lineLength; i++)
                    {
                        length += 0.5;
                    }
                    lineLength = (int) length;
                    for (int i = 0; i < lineLength; i++)
                    {
                        lineTxt += pattern;
                    }
                    sender.sendMessage(ChatColor.GREEN + lineTxt + ChatColor.GOLD + " AvalancheFreedom " + lineTxt);
                    for (int i = 0; i < messages.length; i++)
                    {
                        sender.sendMessage(messageColor + messages[i]);
                    }
                }
                else
                {
                    Main.noPermission(p);
                }
            }
            else
            {
                double length = 0;
                for (int i = 0; i < lineLength; i++)
                {
                    length += 0.5;
                }
                lineLength = (int) length;
                for (int i = 0; i < lineLength; i++)
                {
                    lineTxt += pattern;
                }
                sender.sendMessage(ChatColor.GREEN + lineTxt + ChatColor.GOLD + " AvalancheFreedom " + lineTxt);
                for (int i = 0; i < messages.length; i++)
                {
                    sender.sendMessage(messageColor + messages[i]);
                }
            }
            
            return true;
        }
        
        return false;
    }
}
