package me.kodysimpson.simpapi.crafting;

import com.google.common.base.MoreObjects;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class Recipe {
    @NotNull
    protected ItemStack result;

    protected Recipe() {
        result = new ItemStack(Material.AIR);
    }

    @NotNull
    public ItemStack getResult() { return result.clone(); }
    @NotNull
    abstract public String getType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return getResult().equals(recipe.getResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResult());
    }

    @Override
    @NotNull
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("result", result)
                .toString();
    }
}
