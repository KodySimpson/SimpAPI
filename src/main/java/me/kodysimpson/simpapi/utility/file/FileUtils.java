package me.kodysimpson.simpapi.utility.file;

import com.google.common.io.ByteStreams;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * File Utilities
 *
 * @author Negative
 */
public class FileUtils {

    public static File loadResource(Plugin plugin, String resource) {
        File folder = plugin.getDataFolder();
        if (!folder.exists())
            folder.mkdir();
        File resourceFile = new File(folder, resource);
        try {
            if (!resourceFile.exists()) {
                resourceFile.createNewFile();
                try (InputStream in = plugin.getResource(resource);
                     OutputStream out = new FileOutputStream(resourceFile)) {
                    ByteStreams.copy(in, out);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resourceFile;
    }

    /**
     * Load File Function
     * @param plugin Instance of JavaPlugin
     * @param name File name
     * @apiNote This must be a part of your onEnable method to load any custom files!
     */
    // TODO: TEST
    public static void loadFile(JavaPlugin plugin, String name) {
        File file = new File(plugin.getDataFolder(), name);
        FileConfiguration fileConfig = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            loadResource(plugin, name);
        }

        try {
            fileConfig.load(file);
        } catch (Exception e3) {
            e3.printStackTrace();
        }

        for (String priceString : fileConfig.getKeys(false)) {
            fileConfig.set(priceString, fileConfig.getString(priceString));
        }
    }

}
