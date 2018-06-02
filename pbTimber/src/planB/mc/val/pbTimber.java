package planB.mc.val;

import org.bukkit.plugin.java.JavaPlugin;
import planB.mc.val.pbUtils.pbListeners;

//TODO: Not staged to final
public class pbTimber {
    public pbTimber(JavaPlugin main) {
        pbListeners.addListener(new onTimber(main));

    }
}
