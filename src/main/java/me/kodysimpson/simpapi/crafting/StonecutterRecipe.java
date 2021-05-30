package me.kodysimpson.simpapi.crafting;

import com.google.common.base.MoreObjects;
import me.kodysimpson.simpapi.SimpAPI;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.inventory.StonecuttingRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Recipe for a Stonecutter
 */
public class StonecutterRecipe extends Recipe {
    @Override
    public @NotNull String getType() { return "Stonecutter"; }

    @NotNull
    private final Material input;

    public StonecutterRecipe(@NotNull ItemStack result, @NotNull Material input, @NotNull ItemStack base, @NotNull ItemStack addition) {
        this.result = result;
        this.input = input;
    }

    /**
     * Creates a Bukkit recipe
     * @param id Recipe ID
     * @return Bukkit recipe
     */
    public StonecuttingRecipe getRecipe(String id) {
        NamespacedKey key = new NamespacedKey(SimpAPI.getInstance(), id);

        return new StonecuttingRecipe(key, result, input);
    }

    @NotNull
    public Material getInput() {
        return input;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StonecutterRecipe that = (StonecutterRecipe) o;
        return input == that.input;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), input);
    }

    @Override
    public @NotNull String toString() {
        return MoreObjects.toStringHelper(this)
                .add("input", input)
                .toString();
    }
}
