package planB.mc.val.pbCraftingHead;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import planB.mc.val.pbUtils.pbUtils;

//TODO: Not staged to final
public class onHeadUse implements Listener {
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        try {
            HeadDatabaseAPI api = new HeadDatabaseAPI();
            ItemStack itemHand = event.getPlayer().getInventory().getItemInMainHand();
            if (api.getItemID(itemHand).equals("219")) {
                event.setCancelled(true);
                event.getPlayer().openWorkbench(null, true);
                pbUtils.log("[onHeadUse]", "[pbCraftingHead]", event.getPlayer().getName() + " is Crafting on the GO");
            }
        } catch (NullPointerException e) {
        }
    }
}
