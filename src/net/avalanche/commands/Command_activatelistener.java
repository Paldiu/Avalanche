package net.avalanche.commands;

import net.avalanche.Main;
import net.avalanche.listeners.PlayerListener;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Command_activatelistener implements CommandExecutor
{
    public Main plugin;
    public Command_activatelistener(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args)
    {
        if (lbl.equalsIgnoreCase("atl") || lbl.equalsIgnoreCase("activatelistener"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("avalanche.atl"))
                {
                    Main.plugin.getServer().getPluginManager().registerEvents(new PlayerListener(), Main.plugin);
                    //
                    p.sendMessage(ChatColor.RED + "PlayerListener enabled. Will now log events.");
                }
                else
                {
                    Main.noPermission(p);
                }
            }
            else
            {
                Main.plugin.getServer().getPluginManager().registerEvents(new PlayerListener(), Main.plugin);
                sender.sendMessage("PlayerListener enabled. Will now log events.");
            }
            
            return true;
        }
        
        return false;
    }
}