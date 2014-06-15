package io.github.austinv11.GUIAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
/**
 * <b>
 * GUIAPI Object:
 * </b>
 * Main object for this API's actual plugin features.
 */

public class GUIAPI extends JavaPlugin implements Listener{
	private static boolean debug = false;
	private Server server = Bukkit.getServer();
	@Override
    public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("GUIAPI v"+Menu.getAPIVersion()+" has been enabled. Remember, it does nothing on its own.");
    }
 
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }
    public static boolean getDebugStatus(){
    	return debug;
    }
    public static void setDebugStatus(boolean isDebug){
    	debug = isDebug;
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMenuInteract(MenuInteractEvent event){
    	if (debug){
    		server.broadcastMessage("Menu"+event.getMenuName());
    		server.broadcastMessage("Is Menu Open: "+event.getMenu().isMenuOpen());
    		server.broadcastMessage("Button: "+event.getButtonName());
    		server.broadcastMessage("Button Item: "+event.getButtonItem().getType().toString());
    		server.broadcastMessage("Did Button Toggle: "+event.getMenu().isButtonToggled(event.getSlot()));
    		server.broadcastMessage("Slot: "+event.getSlot());
    		server.broadcastMessage("ClickType: "+event.getClickType().toString());
    		server.broadcastMessage("Player: "+event.getPlayer().getDisplayName());
    		server.broadcastMessage("Is Cancelled: "+event.isCancelled());
    	}
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("toggleTestMode")){
    		Menu.setDebugStatus(!debug);
    		if (debug == false){
    			sender.sendMessage("[GUIAPI] Debug mode has been set to "+ChatColor.RED+debug);
    		}else{
    			sender.sendMessage("[GUIAPI] Debug mode has been set to "+ChatColor.GREEN+debug);
    		}
    		return true;
    	}
    	return false; 
    }
}
