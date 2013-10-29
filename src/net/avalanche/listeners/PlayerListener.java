package net.avalanche.listeners;

import net.avalanche.Main;
import org.bukkit.event.Listener;

public class PlayerListener implements Listener
{
    protected Main plugin;
    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e)
    {
    	Player p = e.getPlayer();
    	if(this.getConfig().getConfigurationSection("Chat").getString("ChatEnabled").equals("true"))
    	{
    	    if (p.hasPermission("avalanche.chat.priority.1"))
    	    {
    		    e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority1")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	    }
    		else if (p.hasPermission("avalanche.chat.priority.2"))
    		{
        	    e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority2")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	    }
    		else if (p.hasPermission("avalanche.chat.priority.3"))
    		{
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority3")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	    }
    		else if (p.hasPermission("avalanche.chat.priority.4"))
    		{
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority4")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	    }
    		else if (p.hasPermission("avalanche.chat.priority.5"))
    		{
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority5")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	    }
    		else if (p.hasPermission("avalanche.chat.priority.6"))
    		{
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority6")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	    }
    		else if (p.hasPermission("avalanche.chat.priority.7"))
    		{
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority7")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    		}
    		else if (p.hasPermission("avalanche.chat.priority.8"))
    		{
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority8")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	    }
    		else if (p.hasPermission("avalanche.chat.priority.9"))
    		{
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority9")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    		}
    		else if(p.hasPermission("avalanche.chat.priority.10"))
    		{
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority10")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	    }
    	}
    	
    	if (this.getConfig().getConfigurationSection("Chat").getString("AmIAwesome").equals("true"))
    	{
			if (p.getName().equalsIgnoreCase("freelix2000") || p.getName().equalsIgnoreCase("paldiu"))
			{
				e.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Dev" + ChatColor.DARK_GRAY + "]" + p.getDisplayName() + ChatColor.GRAY + ": " + ChatColor.AQUA + e.getMessage());
			}
			else
			{
			}
		}
    }
}
