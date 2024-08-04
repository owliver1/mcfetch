package net.owlive.mcfetch.mcfetch;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.net.InetAddress;

public class McfetchCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        InetAddress ip;
        try {
            String sender_username = System.getProperty("user.name");
            String sender_os = System.getProperty("os.name");
            String sender_os_version = System.getProperty("os.version");
            String sender_jre_version = System.getProperty("java.version");
            ip = InetAddress.getLocalHost();
            String sender_host_name = ip.getHostName();
            String sender_processor = System.getenv("PROCESSOR_IDENTIFIER");
            String sender_processor_cores = String.valueOf(Runtime.getRuntime().availableProcessors());
            String[] osArt = null;

            // Decides which ASCII art to use:
            if (sender_os.equals("Linux") && sender_os_version.contains("arch")) {
                osArt = new String[]{
                        "        .         ",
                        "      /#\\       ",
                        "     /###\\      ",
                        "    /p^###\\     ",
                        "   /##P^q#,\\    ",
                        "  /##(    )##\\   ",
                        " /##P      q#,\\  ",
                        "/P^           ^q\\ "
                };
                Bukkit.broadcastMessage("WOW a Wild Arch Linux User! It's very hard too see them outside their man-caves! Truly a rare specimen!");
            }
            else if (sender_os.toLowerCase().contains("windows")) {
                osArt = new String[]{
                        "           _.-;;-._      ",
                        "      '-..-'|   ||   |      ",
                        "      '-..-'|_.-;;-._|     ",
                        "      '-..-'|   ||   |      ",
                        " jgs  '-..-'|_.-''-._|     "
                };
            }
            else if (sender_os.toLowerCase().contains("macos")) {
                osArt = new String[]{
                        "       .:'        ",
                        "      __ :'__     ",
                        "   .'`__`-'__``.  ",
                        "  :__________.-'  ",
                        "  :_________:     ",
                        "   :_________`-;  ",
                        "jgs `.__.-.__.'   "
                };
            }
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage(ChatColor.AQUA + osArt[0] + " User Name: " + ChatColor.WHITE + sender_username);
            Bukkit.broadcastMessage(ChatColor.AQUA + osArt[1] + " Host Name: " + ChatColor.WHITE + sender_host_name);
            Bukkit.broadcastMessage(ChatColor.AQUA + osArt[2] + " OS: " + ChatColor.WHITE + sender_os + " " + sender_os_version);
            Bukkit.broadcastMessage(ChatColor.AQUA + osArt[3] + " JRE Version: " + ChatColor.WHITE + sender_jre_version);
            Bukkit.broadcastMessage(ChatColor.AQUA + osArt[4] + " CPU: " + ChatColor.WHITE + sender_processor + " (" + sender_processor_cores + ")");
            for (int i = 4; i < osArt.length; i++) {
                Bukkit.broadcastMessage(ChatColor.AQUA + osArt[i]);
            }
        } catch (Exception e) {
            Bukkit.broadcastMessage("Something went wrong!");
        }
        return false;
    }
}
