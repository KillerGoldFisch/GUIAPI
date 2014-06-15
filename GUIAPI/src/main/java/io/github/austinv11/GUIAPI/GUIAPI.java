package io.github.austinv11.GUIAPI;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class GUIAPI extends JavaPlugin{
	private static boolean debug = false;
	@Override
    public void onEnable() {
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
