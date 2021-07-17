package me.kodysimpson.simpapi.utility.builders;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.entity.Player;

/**
 * Text Component Utility
 *
 * @author Negative
 * June 2021
 */
// TODO: TEST
public class TextComponentBuilder {

    private final TextComponent textComponent;

    /**
     * Create a new Text Component
     *
     * @param text Chat message
     */
    public TextComponentBuilder(String text) {
        this.textComponent = new TextComponent(ChatColor.translateAlternateColorCodes('&', text));
    }

    /**
     * Set a click event for the text component
     *
     * @param action Click Action such as RUN_COMMAND, OPEN_URL, SUGGEST_COMMAND, etc.
     * @param value Value of the given action
     * @return Returns component
     */
    public TextComponentBuilder setClickEvent(ClickEvent.Action action, String value) {
        textComponent.setClickEvent(new ClickEvent(action, value));
        return this;
    }

    /**
     * Set a hover text for the text component
     *
     * @param text Display of the text
     * @return Returns component
     * @apiNote Use "\n" for a new line!
     */
    public TextComponentBuilder setHoverText(String text) {
        Text t = new Text(ChatColor.translateAlternateColorCodes('&', text));
        textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, t));
        return this;
    }

    /**
     * Finally, returns the text component for later use.
     *
     * @return Returns TextComponent
     */
    public TextComponent getTextComponent() {
        return textComponent;
    }

    /**
     * Sends the Text Component to a player
     *
     * @param player The player
     */
    public void send(Player player) {
        player.spigot().sendMessage(getTextComponent());
    }

    /**
     * Sends the Text Component to a list of players
     *
     * @param players The players
     */
    public void send(Player... players) {
        for (Player player : players) {
            player.spigot().sendMessage(getTextComponent());
        }
    }
}
