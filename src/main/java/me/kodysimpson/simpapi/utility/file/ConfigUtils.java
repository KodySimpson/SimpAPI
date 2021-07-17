package me.kodysimpson.simpapi.utility.file;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Config Utils
 * @author Negative
 *
 * This is used for ease of access to configuration files
 *
 * Example:
 * FileConfiguration config = new ConfigUtils(plugin, "messages"); will grab the messages.yml file
 * to be used in the code!
 */
public class ConfigUtils {

    private final String name;
    private final String path;

    /**
     * Config Utils Constructor
     * @param plugin Instance of your plugin, which grabs your plugin's datafolder path
     * @param file File name (without .yml)
     */
    public ConfigUtils(JavaPlugin plugin, String file) {
        this(plugin.getDataFolder().getPath(), file);
    }

    /**
     * Config Utils Constructor
     * @param path Path of which you want to access
     * @param file File name (without .yml)
     */
    public ConfigUtils(String path, String file) {
        this.name = file;
        this.path = path;
    }

    /**
     * @return  FileConfiguration
     */
    public FileConfiguration getConfig() {
        File file = new File(path, this.name + ".yml");
        return YamlConfiguration.loadConfiguration(file);
    }
}
