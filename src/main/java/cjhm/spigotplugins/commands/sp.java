package cjhm.spigotplugins.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class sp implements CommandExecutor {
    private final String spigotMCUrl = "https://www.spigotmc.org/resources/";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("spigotplugins")) {
            sender.sendMessage(ChatColor.YELLOW + "Top 10 SpigotMC plugins:");
            try {
                Document doc = Jsoup.connect(spigotMCUrl).get();
                Elements pluginLinks = doc.select("a[href^=/resources/]");
                int count = 0;
                for (int i = 0; i < pluginLinks.size() && count < 10; i++) {
                    String pluginPageUrl = spigotMCUrl + pluginLinks.get(i).attr("href");
                    Document pluginDoc = Jsoup.connect(pluginPageUrl).get();
                    String pluginName = pluginDoc.select("h1.p-title-value").text();
                    String pluginAuthor = pluginDoc.select("a.username").text();
                    String pluginDescription = pluginDoc.select("div.p-description").text();
                    String pluginDownloads = pluginDoc.select("abbr[title$=Downloads]").text();
                    String message = String.format("%d. %s by %s | %s downloads | %s",
                            ++count, pluginName, pluginAuthor, pluginDownloads, pluginDescription);
                    sender.sendMessage(ChatColor.GREEN + message);
                }
            } catch (IOException ex) {
                sender.sendMessage(ChatColor.RED + "Failed to fetch plugin data from SpigotMC.");
                ex.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
