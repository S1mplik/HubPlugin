package danix25.hubplugin.Events;

import danix25.hubplugin.Hubplugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinVanish implements Listener {

    Hubplugin plugin;

    public JoinVanish(Hubplugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        for (int i = 0; i < plugin.invisible_list.size(); i++){
            player.hidePlayer(plugin, plugin.invisible_list.get(i));
        }
    }

}

