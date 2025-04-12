package dev.meltdown.pit;

import cn.charlotte.pit.ThePit;
import cn.charlotte.pit.mode.Mode;
import cn.charlotte.pit.scoreboard.Scoreboard;
import cn.charlotte.pit.util.chat.CC;
import cn.charlotte.pit.util.nametag.NametagHandler;
import cn.charlotte.pit.util.scoreboard.Assemble;
import dev.meltdown.pit.config.FileManager;
import dev.meltdown.pit.listener.DataListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

public class Meltdown {

    public static FileManager fileManager;
    public static YamlConfiguration config;

    public static final String prefix = "&c[Meltdown] &f";

    public static void init() {
        Bukkit.getConsoleSender().sendMessage(CC.translate(prefix + "Meltdown starting..."));
        //Meltdown Configuration
        Bukkit.getConsoleSender().sendMessage(CC.translate(prefix + "Starting load Meltdown configuration..."));
        fileManager = new FileManager(ThePit.getInstance());
        config = fileManager.getConfig();

        ThePit.mode = Mode.valueOf(config.getString("pit-mode"));
        Bukkit.getConsoleSender().sendMessage(CC.translate(prefix + "PitMode: " + ThePit.mode));

        Bukkit.getConsoleSender().sendMessage(CC.translate(prefix + "Configuration Done."));

        //Meltdown Listener
        Bukkit.getConsoleSender().sendMessage(CC.translate(prefix + "Starting load Meltdown listeners..."));
        Bukkit.getServer().getPluginManager().registerEvents(new DataListener(), ThePit.getInstance());
        Bukkit.getConsoleSender().sendMessage(CC.translate(prefix + "Listeners Done."));

        //End
        Bukkit.getConsoleSender().sendMessage(CC.translate(prefix + "Meltdown Done."));
    }
}
