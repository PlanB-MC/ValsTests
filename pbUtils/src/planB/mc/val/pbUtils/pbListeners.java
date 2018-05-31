package planB.mc.val.pbUtils;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class pbListeners {
    private static JavaPlugin plugin;

    public pbListeners(JavaPlugin main) {
        plugin = main;
    }

    public static void addListener(Listener newEvent) {
        plugin.getServer().getPluginManager().registerEvents(newEvent, plugin);
        pbUtils.log("[pbListener]", "Event Added!", newEvent.toString());
    }

    public static void removeListener(Listener newEvent) {
        HandlerList.unregisterAll(newEvent);
        pbUtils.log("[pbListener]", "Event Removed!", newEvent.toString());
    }

    public static void removeAllListener() {
        HandlerList.unregisterAll();
        pbUtils.log("[pbListener]", "All Events Removed!");
    }
}
