package me.kodysimpson.simpapi.crafting;

import com.google.common.base.MoreObjects;
import me.kodysimpson.simpapi.SimpAPI;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.inventory.SmokingRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Recipe for a Smithing Table
 */
public class SmithingTableRecipe extends Recipe {
    @Override
    @NotNull
    public String getType() { return "SmithingTable"; }

    @NotNull
    private final ItemStack base;
    @NotNull
    private final ItemStack addition;

    public SmithingTableRecipe(@NotNull ItemStack result, @NotNull ItemStack base, @NotNull ItemStack addition) {
        this.result = result;
        this.base = base;
        this.addition = addition;
    }

    /**
     * Creates a Bukkit recipe
     * @param id Recipe ID
     * @return Bukkit recipe
     */
    @NotNull
    public SmithingRecipe getRecipe(@NotNull String id) {
        NamespacedKey key = new NamespacedKey(SimpAPI.getInstance(), id);

        return new SmithingRecipe(key, result, new RecipeChoice.ExactChoice(base), new RecipeChoice.ExactChoice(addition));
    }

    @NotNull
    public ItemStack getBase() {
        return base;
    }

    @NotNull
    public ItemStack getAddition() {
        return addition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmithingTableRecipe that = (SmithingTableRecipe) o;
        return base.equals(that.base) && addition.equals(that.addition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), base, addition);
    }

    @Override
    @NotNull
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("base", base)
                .add("addition", addition)
                .toString();
    }
}
