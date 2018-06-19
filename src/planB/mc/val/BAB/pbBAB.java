package planB.mc.val.BAB;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import planB.mc.val.Main;
import planB.mc.val.pbUtils.pbUtils;

import java.util.HashMap;

public class pbBAB {
    public static Inventory blockMenu = Bukkit.createInventory(null, 9, "Build A Block");
    public static HashMap<ItemStack, String> blockMap;

    static {
        ItemStack isClay = new ItemStack(Material.CLAY, 1);
        ItemStack isDiamond = new ItemStack(Material.DIAMOND_BLOCK, 1);
        ItemStack isDirt = new ItemStack(Material.DIRT, 1);
        ItemStack isEndstone = new ItemStack(Material.ENDER_STONE, 1);
        ItemStack isGrass = new ItemStack(Material.GRASS, 1);
        ItemStack isHardClay = new ItemStack(Material.HARD_CLAY, 1);
        ItemStack isLogSide = new ItemStack(Material.LOG, 1);
        ItemStack isLogUp = new ItemStack(Material.LOG_2, 1);
        ItemStack isCobble = new ItemStack(Material.COBBLESTONE, 1);
        ItemStack isSand = new ItemStack(Material.SAND, 1);
        ItemStack isSandStone = new ItemStack(Material.SANDSTONE, 1);
        ItemStack isStone = new ItemStack(Material.STONE, 1);
        ItemStack isAndersite = new ItemStack(Material.STONE, 1, (short) 5);

        blockMenu.addItem(new ItemStack(Material.AIR),isClay,isDiamond,isDirt,isEndstone,isGrass,isHardClay,isLogSide,isLogUp,isCobble,
                isSand,isSandStone, isStone, isAndersite);

        blockMap.put(isClay)
        //The first parameter, is the slot that is assigned to. Starts counting at 0
    }

    public pbBAB() {
        Main.pbConfigFile.addDefault("enablePlugin", true, "pbBAB");
        if (!Main.pbConfigFile.getBoolean("enablePlugin", "pbBAB")) {
            pbUtils.log('C', "[pbBAB]");
            return;
        }

        Main.pbListenersEars.addListener(new onBAB());


    }
}
