package planB.mc.val.BAB;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import planB.mc.val.pbUtils.pbUtils;

public class onBAB implements Listener {


    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
     /*   try {
            pbUtils.log("[pbBAB]", "trying block Armour Stand");


        } catch (NullPointerException e) {
            pbUtils.log("[pbBAB]", "oopsie ");
            System.out.println(e.getCause());
        }*/
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked(); // The player that clicked the item
        ItemStack clicked = event.getCurrentItem(); // The item that was clicked
        Inventory inventory = event.getInventory(); // The inventory that was clicked in
        if (inventory.getName().equals(pbBAB.blockMenu.getName())) { // The inventory is our custom Inventory
            if (clicked.getType() == Material.DIRT) { // The item that the player clicked it dirt
                event.setCancelled(true); // Make it so the dirt is back in its original spot
                player.closeInventory(); // Closes there inventory
                player.getInventory().addItem(new ItemStack(Material.DIRT, 1)); // Adds dirt
            }
        }
    }
}
