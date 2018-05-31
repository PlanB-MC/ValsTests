package planB.mc.val.pbHeadLights;

import org.bukkit.plugin.java.JavaPlugin;
import planB.mc.val.pbUtils.pbListeners;

public class HeadLight {

    public HeadLight(JavaPlugin plugin) {
        /*plugin.pbConfigFile.addDefault("enablePlugin", true, "pbHeadLights");
        if (!Main.pbConfigFile.getBoolean("enablePlugin", "pbHeadLights")) {
            pbUtils.log('C', "[pbHeadLights]");
            return;
        }*/

        pbListeners.addListener(new onHeadLights());
    }

}