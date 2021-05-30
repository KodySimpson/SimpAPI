package me.kodysimpson.simpapi.crafting;

import me.kodysimpson.simpapi.SimpAPI;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.*;

/**
 * Recipe for a Crafting Table
 */
public class CraftingTableRecipe extends Recipe {
    @Override
    public String getType() { return "CraftingTable"; }

    private final List<Material> items;

    private final Map<Material, Character> itemMappings = new HashMap<>();

    public CraftingTableRecipe(ItemStack result, Material... items) {
        this.result = result;
        this.items = Arrays.asList(items);
        int index = 0;
        for (Material item : this.items) {
            if (item == null) continue;
            if (itemMappings.containsKey(item)) continue;
            itemMappings.put(item, String.valueOf(index++).charAt(0));
        }
    }

    /**
     * Returns a Bukkit recipe
     * @param id Recipe ID
     * @return Bukkit recipe
     */
    public ShapedRecipe getRecipe(String id) {
        NamespacedKey key = new NamespacedKey(SimpAPI.getInstance(), id);

        ShapedRecipe recipe = new ShapedRecipe(key, result);

        int startIndex = 0;
        String[] rows = new String[]{"", "", ""};

        List<Material> list1 = items.subList(0, 3);
        List<Material> list2 = items.subList(3, 6);
        List<Material> list3 = items.subList(6, 9);

        for (Material it : list1) {
            if (it == null) rows[0] += " ";
            else rows[0] += itemMappings.get(it);
        }

        for (Material it : list2) {
            if (it == null) rows[1] += " ";
            else rows[1] += itemMappings.get(it);
        }

        for (Material it : list3) {
            if (it == null) rows[2] += " ";
            else rows[2] += itemMappings.get(it);
        }

        recipe.shape(rows[0], rows[1], rows[2]);

        for (Material material : itemMappings.keySet()) {
            recipe.setIngredient(itemMappings.get(material), material);
        }

        return recipe;
    }

    public List<Material> getItems() {
        return new ArrayList<>(items);
    }
}
