package danix25.hubplugin.Commands;

import danix25.hubplugin.Hubplugin;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {

    Hubplugin plugin;

    public Vanish(Hubplugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (plugin.invisible_list.contains(player)){
                for (Player people : Bukkit.getOnlinePlayers()){
                    people.showPlayer(plugin, player);
                }
                plugin.invisible_list.remove(player);
                String message = "§c§lJsi neviditelny pro ostatni hrace";
                Player p = Bukkit.getPlayer("Player");
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
            }else if(!plugin.invisible_list.contains(player)){
                for (Player people : Bukkit.getOnlinePlayers()){
                    people.hidePlayer(plugin, player);
                }
                plugin.invisible_list.add(player);
                String message = "§a§lJsi viditelny pro ostatni hrace";
                Player p = Bukkit.getPlayer("Player");
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
            }
        }

        return true;
    }

}
