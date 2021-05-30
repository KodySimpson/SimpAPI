package me.kodysimpson.simpapi.exceptions;

import org.jetbrains.annotations.NotNull;

public class CraftingTypeNotFound extends Exception {
    public CraftingTypeNotFound(@NotNull String message) {
        super(message);
    }
}
