package planB.mc.val.pbCraftingHead;

import org.bukkit.plugin.java.JavaPlugin;
import planB.mc.val.pbUtils.pbListeners;
//TODO: Not staged to final
public class pbCraftingHead {
    public pbCraftingHead(JavaPlugin main) {
        pbListeners.addListener(new onHeadUse());
    }
}
