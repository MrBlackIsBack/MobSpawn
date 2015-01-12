package me.mrblackisback.mobspawn;

import me.mrblackisback.mobspawn.animals.SpawnPig;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MobSpawn extends JavaPlugin {

    public void onEnable() {
        // TODO: Register commands //
        getCommand("spawnpig").setExecutor(new SpawnPig(this));

        // TODO: Register events //
    }

    public void onDisable() {

    }

    // Register Methods //

    /**
     *  Spawn pig
     */
    public void spawnPig(Player p, String name) {
        Pig pig = p.getLocation().getWorld().spawn(p.getLocation(), Pig.class);
        pig.setCustomName(name);
        pig.setCustomNameVisible(true);
    }
}
