package me.kodysimpson.simpapi.crafting;

import me.kodysimpson.simpapi.SimpAPI;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

/**
 * Recipe for a Furnace
 */
public class FurnaceRecipe extends Recipe {
    @Override
    public String getType() { return "Furnace"; }

    private final Material input;
    private final float experience;
    private final int cookingTime;

    public FurnaceRecipe(ItemStack result, Material input, float experience, int cookingTime) {
        this.result = result;
        this.input = input;
        this.experience = experience;
        this.cookingTime = cookingTime;
    }

    /**
     * Creates a Bukkit recipe
     * @param id Recipe ID
     * @return Bukkit recipe
     */
    public org.bukkit.inventory.FurnaceRecipe getRecipe(String id) {
        NamespacedKey key = new NamespacedKey(SimpAPI.getInstance(), id);

        return new org.bukkit.inventory.FurnaceRecipe(key, result, input, experience, cookingTime);
    }

    public Material getInput() {
        return input;
    }

    public float getExperience() {
        return experience;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FurnaceRecipe that = (FurnaceRecipe) o;
        return Float.compare(that.experience, experience) == 0 && cookingTime == that.cookingTime && input == that.input;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), input, experience, cookingTime);
    }

    @Override
    public String toString() {
        return "FurnaceRecipe{" +
                "input=" + input +
                ", experience=" + experience +
                ", cookingTime=" + cookingTime +
                "} " + super.toString();
    }
}
