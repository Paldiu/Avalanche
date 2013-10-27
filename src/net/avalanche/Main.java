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
}
