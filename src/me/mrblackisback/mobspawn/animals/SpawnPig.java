package me.mrblackisback.mobspawn.animals;

import me.mrblackisback.mobspawn.MobSpawn;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SpawnPig implements CommandExecutor {

    public MobSpawn plugin;

    public SpawnPig(MobSpawn instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to preform this command!");
            return true;
        }

        if (sender.hasPermission("mobspawn.pig")) {
            if (label.equalsIgnoreCase("spawnpig")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.GREEN + "Pig spawned!");
                    Player p = (Player) sender;
                    plugin.spawnPig(p, "Jeff");
                    if (p.getInventory().contains(Material.CARROT_STICK)) {
                        return true;
                    } else {
                        p.getInventory().addItem(new ItemStack(Material.CARROT_STICK, 1));
                    }
                } else {
                    sender.sendMessage(ChatColor.GREEN + "Pigs spawned!");

                    Player p = (Player) sender;

                    int amount = Integer.parseInt(args[0]);

                    for (int x = 0; x < amount; x++) {
                        plugin.spawnPig(p, "Jeff");
                    }
                }
            }


        } else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to preform this command :(");
        }
        return true;
    }
}
