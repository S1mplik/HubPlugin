package danix25.hubplugin;

import danix25.hubplugin.Commands.Gamemode;
import danix25.hubplugin.Commands.Vanish;
import danix25.hubplugin.Events.JoinVanish;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Hubplugin extends JavaPlugin {

    public static String prefix = "§7[§e§lServer§7]";
    public static String np = prefix + " §cNemas opravneni";
    public ArrayList<Player> invisible_list = new ArrayList<>();

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(prefix + "§7se uspesne zapnul");
        getCommand("vanish").setExecutor(new Vanish(this));
        getServer().getPluginManager().registerEvents(new JoinVanish(this), this);


        getCommand("gm").setExecutor(new Gamemode());

    }
    


}

