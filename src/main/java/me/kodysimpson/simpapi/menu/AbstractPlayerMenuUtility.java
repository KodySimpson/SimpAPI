package me.kodysimpson.simpapi.menu;

/*
Companion class to all menus. This is needed to pass information across the entire
 menu system no matter how many inventories are opened or closed.

 Each player has one of these objects, and only one.
 */

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractPlayerMenuUtility {

    @NotNull
    private final Player owner;

    public AbstractPlayerMenuUtility(@NotNull Player p) {
        this.owner = p;
    }

    @NotNull
    public Player getOwner() {
        return owner;
    }
}

