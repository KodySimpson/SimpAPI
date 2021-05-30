package me.kodysimpson.simpapi;

import me.kodysimpson.simpapi.crafting.CraftingManager;
import me.kodysimpson.simpapi.crafting.CraftingTableRecipe;
import me.kodysimpson.simpapi.exceptions.CraftingTypeNotFound;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpAPI extends JavaPlugin {

    private static SimpAPI instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SimpAPI getInstance() { return instance; }
}
