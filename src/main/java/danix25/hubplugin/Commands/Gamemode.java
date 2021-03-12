package danix25.hubplugin.Commands;


import danix25.hubplugin.Hubplugin;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

            if(!(sender instanceof Player)){
                sender.sendMessage(Hubplugin.prefix + "§7Nejsi hrac");
            }else{
                final Player player = ((Player)sender);

                if(player.hasPermission("hubplugin.gm.use")){
                    if(args.length == 1){

                        if(args[0].equalsIgnoreCase("s")){
                            player.setGameMode(GameMode.SURVIVAL);
                            player.sendMessage(Hubplugin.prefix + " §r§7 Nastavil sis herni rezim §aSurvival");

                        }else if(args[0].equalsIgnoreCase("c")){
                            player.setGameMode(GameMode.CREATIVE);
                            player.sendMessage(Hubplugin.prefix + " §r§7 Nastavil sis herni rezim §aCreative");

                        }else if(args[0].equalsIgnoreCase("a")){
                            player.setGameMode(GameMode.ADVENTURE);
                            player.sendMessage(Hubplugin.prefix + " §r§7 Nastavil sis herni rezim §aAdventure");

                        } else if (args[0].equalsIgnoreCase("sp")){
                            player.setGameMode(GameMode.SPECTATOR);
                            player.sendMessage(Hubplugin.prefix + " §r§7 Nastavil sis herni rezim §aSpectator");
                        }

                    }else if(args.length == 2){
                        if(player.hasPermission("hubplugin.gm.use.other")){

                            final Player target = Bukkit.getPlayer(args[0]);

                            if(args[1].equalsIgnoreCase("0")){
                                target.setGameMode(GameMode.SURVIVAL);
                                target.sendMessage(Hubplugin.prefix + " §r§7 Nastavil sis herni rezim §aSurvival");
                                player.sendMessage(Hubplugin.prefix + " §r§7" + target.getName() +  " §7dostal herni rezim §aSurvival");

                            }else if(args[1].equalsIgnoreCase("1")){
                                target.setGameMode(GameMode.CREATIVE);
                                target.sendMessage(Hubplugin.prefix + " §r§7 Nastavil sis herni rezim §aCreative");
                                player.sendMessage(Hubplugin.prefix + " §r§7" + target.getName() +  " §7dostal herni rezim §aCreative");

                            }else if(args[1].equalsIgnoreCase("2")){
                                target.setGameMode(GameMode.ADVENTURE);
                                target.sendMessage(Hubplugin.prefix + " §r§7 Nastavil sis herni rezim §aAdventure");
                                player.sendMessage(Hubplugin.prefix + " §r§7" + target.getName() +  " §7dostal herni rezim §aAdventure");

                            }else if(args[1].equalsIgnoreCase("3")){
                                target.setGameMode(GameMode.SPECTATOR);
                                target.sendMessage(Hubplugin.prefix + " §r§7 Nastavil sis herni rezim §aSpectator");
                                player.sendMessage(Hubplugin.prefix + " §r§7" + target.getName() +  " §7dostal herni rezim §aSpectator");

                            }

                        }else{
                            player.sendMessage(Hubplugin.np);
                        }
                    }else{
                        player.sendMessage("§7[§e§lServer§7] §cPouzij: /gm c, gm s, gm a, gm sp");
                    }
                }else{
                    player.sendMessage(Hubplugin.np);
                }

            }

            return false;
        }

}
