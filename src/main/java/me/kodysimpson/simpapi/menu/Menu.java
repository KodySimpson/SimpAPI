package me.kodysimpson.simpapi.menu;

import me.kodysimpson.simpapi.exceptions.MenuManagerException;
import me.kodysimpson.simpapi.exceptions.MenuManagerNotSetupException;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/*
    Defines the behavior and attributes of all menus in our plugin
 */
public abstract class Menu implements InventoryHolder {

    //Protected values that can be accessed in the menus
    @NotNull
    protected AbstractPlayerMenuUtility pmu;
    protected Inventory inventory;
    @NotNull
    protected ItemStack FILLER_GLASS = makeItem(Material.GRAY_STAINED_GLASS_PANE, " ");

    //Constructor for Menu. Pass in a PlayerMenuUtility so that
    // we have information on who's menu this is and
    // what info is to be transferred
    public Menu(@NotNull AbstractPlayerMenuUtility pmu) {
        this.pmu = pmu;
    }

    //let each menu decide their name
    @NotNull
    public abstract String getMenuName();

    //let each menu decide their slot amount
    public abstract int getSlots();

    public abstract boolean cancelAllClicks();

    //let each menu decide how the items in the menu will be handled when clicked
    public abstract void handleMenu(@NotNull InventoryClickEvent e) throws MenuManagerNotSetupException, MenuManagerException;

    //let each menu decide what items are to be placed in the inventory menu
    public abstract void setMenuItems();

    //When called, an inventory is created and opened for the player
    public void open() {
        //The owner of the inventory created is the Menu itself,
        // so we are able to reverse engineer the Menu object from the
        // inventoryHolder in the MenuListener class when handling clicks
        inventory = Bukkit.createInventory(this, getSlots(), getMenuName());

        //grab all the items specified to be used for this menu and add to inventory
        this.setMenuItems();

        //open the inventory for the player
        pmu.getOwner().openInventory(inventory);
    }

    //Overridden method from the InventoryHolder interface
    @Override
    @NotNull
    public Inventory getInventory() {
        return inventory;
    }

    //Helpful utility method to fill all remaining slots with "filler glass"
    public void setFillerGlass(){
        for (int i = 0; i < getSlots(); i++) {
            if (inventory.getItem(i) == null){
                inventory.setItem(i, FILLER_GLASS);
            }
        }
    }

    @NotNull
    public ItemStack makeItem(@NotNull Material material, @NotNull String displayName, String... lore) {

        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(displayName);

        itemMeta.setLore(Arrays.asList(lore));
        item.setItemMeta(itemMeta);

        return item;
    }

    @NotNull
    public <T> T PMUCaster(@NotNull AbstractPlayerMenuUtility abstractPlayerMenuUtility, @NotNull Class<T> t) {
        return t.cast(abstractPlayerMenuUtility);
    }

}

