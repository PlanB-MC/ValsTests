package planB.mc.val.pbHeadLights;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import net.minecraft.server.v1_12_R1.Chunk;
import net.minecraft.server.v1_12_R1.EntityArmorStand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.CraftChunk;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftArmorStand;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import planB.mc.val.pbUtils.pbUtils;

import java.lang.reflect.InvocationTargetException;

public class onHeadLights implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        //Checking if the item held in has is the correct head
        HeadDatabaseAPI api = new HeadDatabaseAPI();
        ItemStack itemHead = event.getItemInHand();
        pbUtils.log("[onHeadLights]", api.getItemID(itemHead));
        try {
            if (api.getItemID(itemHead).equals("1776")) {
                pbUtils.log("[onHeadsLights]", "light placed");
                Location loc = event.getBlockPlaced().getLocation();

                ArmorStand as = loc.getWorld().spawn(loc.subtract(-0.5,1.5,-0.5), ArmorStand.class);

                as.setBasePlate(false);
                as.setArms(false);
                as.setVisible(false);
                as.setInvulnerable(true);
                as.setCanPickupItems(false);
                as.setGravity(false);
                as.setSmall(false);
                as.setHelmet(api.getItemHead("1776"));

                //pbUtils.log("[onHeadsLights]", api.getItemHead("1776").getItemMeta().toString());
                event.getBlockPlaced().setType(Material.TORCH);
                event.getBlockPlaced().getState().update();
                //event.setCancelled(true);

                pbUtils.log("[onHeadLights]", "added head light to block");
            }
        } catch (NullPointerException e) {
            pbUtils.log("[onHeadLights]", "2");
        }
    }

    @EventHandler
    public void onPlayerArmorStandManipulateEvent(PlayerArmorStandManipulateEvent event) {
        final Entity damaged = event.getRightClicked();
       // pbUtils.log("[onHeadLights]", damaged.toString());
        //if (!(damaged instanceof ArmorStand)) return;
        damaged.getLocation().add(0,1.5,0).getBlock().setType(Material.AIR);
        damaged.remove();
        HeadDatabaseAPI api = new HeadDatabaseAPI();
        damaged.getWorld().dropItem(damaged.getLocation(),api.getItemHead("1776"));
    }
}
