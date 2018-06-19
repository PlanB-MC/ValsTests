package planB.mc.val;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import planB.mc.val.pbUtils.pbUtils;

import java.util.Stack;

//TODO: Not staged to final
public class onTimber implements Listener {
    private boolean cooldown = false;
    private JavaPlugin plugin;

    public onTimber(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        Block baseBlock = event.getBlock();
        if (baseBlock.getType().equals(Material.LOG) || baseBlock.getType().equals(Material.LOG_2)) {
            if (cooldown) return;
            getWood(baseBlock, event.getPlayer());
            cooldown = true;
            pbUtils.log("[onTimber]", "COOLDOWN ON");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                pbUtils.log("[onTimber]", "COOLDOWN OFF");
                cooldown = false;
            }, 80L);
            pbUtils.log("[onTimber]", event.getPlayer().getName() + " is Chopping wood");

        }
    }

    private void getWood(Block baseBlock, Player player) {
        Stack<Block> blockStack = new Stack<>();
        blockStack.push(baseBlock);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (blockStack.empty()) this.cancel();
                Block curBlock = blockStack.pop();
                curBlock.getWorld().dropItem(curBlock.getLocation(), new ItemStack(curBlock.getType(), 1));
                Location loc = new Location(curBlock.getWorld(), curBlock.getLocation().getX() + 0.5, curBlock.getLocation().getY(), curBlock.getLocation().getZ() + 0.5);
                player.spawnParticle(
                        Particle.BLOCK_DUST, loc, 0, 96 / 256, 52 / 256, 13 / 256, 1
                );
                player.playSound(loc, Sound.BLOCK_WOOD_BREAK, 1, 1);
                curBlock.setType(Material.AIR);
                for (int x = -1; x <= 1; x++)
                    for (int y = -1; y <= 1; y++)
                        for (int z = -1; z <= 1; z++) {
                            Location comp = curBlock.getLocation().add(x, y, z);
                            if (comp.getBlock().getType().equals(Material.LOG) || comp.getBlock().getType().equals(Material.LOG_2)) {
                                blockStack.push(comp.getBlock());
                            }
                        }
            }
        }.runTaskTimer(plugin, 0, 20L);


    }


}
