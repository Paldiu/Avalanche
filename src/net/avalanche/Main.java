package net.avalanche;

import java.io.File;
import java.util.logging.Logger;
import net.avalanche.commands.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    public static final Logger logger = Logger.getLogger("minecraft");
    public static Main plugin;
    public static String pluginName = "";
    public static File pluginFile = null;
    public static String NOT_FROM_CONSOLE = "This command can not be used from the console!";
    public static Server server;
    public static String commandPrefix = "Command_";
    public static final double version = 0.1;
    //
    public Command_avinfo avinfo = new Command_avinfo(this);
    
    @Override
    public void onEnable()
    {
        File file = new File(getDataFolder() + File.separator + "config.yml");
		if(!file.exists()){
			String n = System.getProperty("line.separator");
			this.getConfig().options().header("Avalanche Configuration File" + n + "Visit our Bukkit page for help" + n + "Copy and paste the chat groups to make your own" + n + "You can make up to 20 chat groups." + n + "Just copy the format of the premade groups below. Give the avalanche.chat.priority.<number> to players to give them chat formats." + n + "Sincerely, Freelix2000 :)" + n + n + n + "The AmIAwesome: Default will give the developers of this plugin a [Dev] prefix if left true." + n +"We allow you to change it, but PWEASE BE NICE AND LEAVE IT. :)" + n + n + "The AvalancheChatEnabled plugin allows you to completely disable our chat feature in case you use a different plugin.");
    		this.getConfig().createSection("Chat");
    		this.getConfig().getConfigurationSection("Chat").set("AmIAwesome", "true");
    		this.getConfig().getConfigurationSection("Chat").set("ChatEnabled", "false");
    		this.getConfig().getConfigurationSection("Chat").set("Priority1", "&4[&cOwner&4]%displayname%&7:&e %message%");
    		this.getConfig().getConfigurationSection("Chat").set("Priority2", "&4[&cAdmin&4]%displayname%&7:&e %message%");
    		this.getConfig().getConfigurationSection("Chat").set("Priority3", "&3[&bMod&3]%displayname%&7:&b %message%");
			this.getConfig().options().copyDefaults(true);
			saveConfig();
			getLogger().info("Done!");
		}else{
			getLogger().info("Found config.yml");
		}
        Main.plugin = this;
        Main.pluginFile = getFile();
        Main.pluginName = plugin.getDescription().getName();
        getCommand("avinfo").setExecutor(avinfo);
        
        this.getServer().getPluginManager().registerEvents(new DevListener(), this);
        logger.info(String.format("[%s] Version: %s by %s has been Enabled!", getDescription().getName(), getDescription().getVersion(), getDescription().getAuthors()));
    }
    
    @Override
    public void onDisable()
    {
        logger.info("Avalanche has been disabled.");
    }
    
    public static void noPermission(Player p)
    {
        Location location = p.getLocation();
        World world = p.getWorld();
        for (int x = -1; x <= 1; x++)
        {
            for (int z = -1; z <= 1; z++)
            {
                Location strike = new Location(world, location.getBlockX() + x, location.getBlockY(), location.getBlockZ() + z);
                world.strikeLightning(strike);
            }
        }
        p.sendMessage(ChatColor.RED + "You don't have permission!");
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
    	Player p = e.getPlayer();
    	if(this.getConfig().getConfigurationSection("Chat").getString("ChatEnabled").equals("true")){
    	if(p.hasPermission("avalanche.chat.priority.1")){
    		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority1")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.2")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority2")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.3")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority3")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.4")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority4")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.5")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority5")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.6")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority6")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.7")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority7")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.8")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority8")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.9")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority9")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.10")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority10")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.11")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority11")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.12")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority12")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.13")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority13")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.14")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority14")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.15")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority15")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.16")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority16")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.17")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority17")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.18")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority18")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.19")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority19")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}else{
    		if(p.hasPermission("avalanche.chat.priority.20")){
        		e.setFormat(ChatColor.translateAlternateColorCodes('&', this.getConfig().getConfigurationSection("Chat").getString("Priority20")).replaceAll("%displayname%", p.getDisplayName()).replaceAll("%message%", e.getMessage()));
    	}
    	}
    	}
    	}
    	}
    	}
    	}
    	}
    	}
    	}
    	}
    	}
    	}
    	}
    	}
    	}
    	}
    	}
    	}
    	}
    	}
    	if(this.getConfig().getConfigurationSection("Chat").getString("AmIAwesome").equals("true")){
			if(p.getName().equals("Freelix2000")){
				e.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Dev" + ChatColor.DARK_GRAY + "]" + p.getDisplayName() + ChatColor.GRAY + ": " + ChatColor.AQUA + e.getMessage());
			}
			if(p.getName().equals("Paldiu")){
				e.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Dev" + ChatColor.DARK_GRAY + "]" + p.getDisplayName() + ChatColor.GRAY + ": " + ChatColor.AQUA + e.getMessage());
			}
		}
    }
}
