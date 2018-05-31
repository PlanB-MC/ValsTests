package planB.mc.val;

import org.bukkit.plugin.java.JavaPlugin;
import planB.mc.val.pbUtils.*;

import java.security.SecureRandom;
import java.util.Random;

//version: 1.2.1.0
// Release.pluginCount.pluginsDone.permsDone
public class Main extends JavaPlugin {
    public static pbConfig pbConfigFile;
    public static pbListeners pbListenersEars;
    public static Random random;
    private pbUtils pbUtils;
    private planB.mc.val.pbUtils.pbCrafting pbCrafting;

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        //Register Commands
        this.getCommand("planb").setExecutor(new CommandList());
        this.getCommand("blame").setExecutor(new CommandList());

        //Setting up Internal Structure:
        pbUtils = new pbUtils(this);
        pbConfigFile = new pbConfig(this, "test.yml");
        pbConfigFile.addDefault("enablePlugin", true, "planB");
        if (!pbConfigFile.getBoolean("enablePlugin", "planB")) {
            pbUtils.log('C', "[PlanB-Utils]");
            return;
        }
        pbCrafting = new pbCrafting(this);
        pbListenersEars = new pbListeners(this);
        random = new SecureRandom();

        registerPlugins();
    }

    private void registerPlugins() {

    }
}
