package net.avalanche.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.avalanche.Main;
import net.avalanche.Util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.RegisteredListener;

public class Command_trail implements CommandExecutor
{
    public static Main plugin;
    private static Listener movementListener = null;
    private static final List<Player> trailPlayers = new ArrayList<Player>();
    private static final Random RANDOM = new Random();
    public Command_trail(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("trail"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("avalanche.trail"))
                {
                    if (args.length > 0 && Util.isStopCommand(args[0]))
                    {
                        trailPlayers.remove(p);
                        
                        p.sendMessage("Trail disabled.");
                    }
                    else
                    {
                        if (!trailPlayers.contains(p))
                        {
                            trailPlayers.add(p);
                        }

                        p.sendMessage("Trail enabled. Use \"/trail off\" to disable.");
                    }

                    if (!trailPlayers.isEmpty())
                    {
                        registerMovementHandler();
                    }
                    else
                    {
                        unregisterMovementHandler();
                    }
                }
                else
                {
                    Main.noPermission(p);
                }
            }
            else
            {
                sender.sendMessage(Main.NOT_FROM_CONSOLE);
            }
        }
        
        return false;
    }
    
    private static void registerMovementHandler()
    {
        if (getRegisteredListener(movementListener) == null)
        {
            Bukkit.getPluginManager().registerEvents(movementListener = new Listener()
            {
                @EventHandler(priority = EventPriority.NORMAL)
                public void onPlayerMove(PlayerMoveEvent event)
                {
                    Player player = event.getPlayer();
                    if (trailPlayers.contains(player))
                    {
                        Block fromBlock = event.getFrom().getBlock();
                        if (fromBlock.isEmpty())
                        {
                            Block toBlock = event.getTo().getBlock();
                            if (!fromBlock.equals(toBlock))
                            {
                                fromBlock.setType(Material.WOOL);
                                fromBlock.setData((byte) RANDOM.nextInt(16));
                            }
                        }
                    }
                }
            }, plugin);
        }
    }

    private static void unregisterMovementHandler()
    {
        Listener registeredListener = getRegisteredListener(movementListener);
        if (registeredListener != null)
        {
            PlayerMoveEvent.getHandlerList().unregister(registeredListener);
        }
    }

    private static Listener getRegisteredListener(Listener listener)
    {
        RegisteredListener[] registeredListeners = PlayerMoveEvent.getHandlerList().getRegisteredListeners();
        for (RegisteredListener registeredListener : registeredListeners)
        {
            if (registeredListener.getListener() == listener)
            {
                return listener;
            }
        }
        return null;
    }
    
        public static void startTrail(Player player)
    {
        if (!trailPlayers.contains(player))
        {
            trailPlayers.add(player);
        }

        if (!trailPlayers.isEmpty())
        {
            registerMovementHandler();
        }
    }

    public static void stopTrail(Player player)
    {
        trailPlayers.remove(player);

        if (trailPlayers.isEmpty())
        {
            unregisterMovementHandler();
        }
    }
}
