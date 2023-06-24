//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.handlers;

import com.kingscripts.autoskyblock.autoskyblockmod.macros.Cobblestone;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.GardenManager;
import java.io.File;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
    public static Configuration config;
    private static final String file = "config/DungeonRooms.cfg";

    public ConfigHandler() {
    }

    public static void init() {
        config = new Configuration(new File("config/DungeonRooms.cfg"));

        try {
            config.load();
        } catch (Exception var4) {
            var4.printStackTrace();
        } finally {
            config.save();
        }

    }

    public static int getInt(String category, String key) {
        config = new Configuration(new File("config/DungeonRooms.cfg"));

        int var2;
        try {
            config.load();
            if (!config.getCategory(category).containsKey(key)) {
                return 0;
            }

            var2 = config.get(category, key, 0).getInt();
        } catch (Exception var6) {
            var6.printStackTrace();
            return 0;
        } finally {
            config.save();
        }

        return var2;
    }

    public static double getDouble(String category, String key) {
        config = new Configuration(new File("config/DungeonRooms.cfg"));

        double var2;
        try {
            config.load();
            if (!config.getCategory(category).containsKey(key)) {
                return 0.0;
            }

            var2 = config.get(category, key, 0.0).getDouble();
        } catch (Exception var7) {
            var7.printStackTrace();
            return 0.0;
        } finally {
            config.save();
        }

        return var2;
    }

    public static String getString(String category, String key) {
        config = new Configuration(new File("config/DungeonRooms.cfg"));

        String var2;
        try {
            config.load();
            if (!config.getCategory(category).containsKey(key)) {
                return "";
            }

            var2 = config.get(category, key, "").getString();
        } catch (Exception var6) {
            var6.printStackTrace();
            return "";
        } finally {
            config.save();
        }

        return var2;
    }

    public static boolean getBoolean(String category, String key) {
        config = new Configuration(new File("config/DungeonRooms.cfg"));

        boolean var2;
        try {
            config.load();
            if (!config.getCategory(category).containsKey(key)) {
                return true;
            }

            var2 = config.get(category, key, false).getBoolean();
        } catch (Exception var6) {
            var6.printStackTrace();
            return true;
        } finally {
            config.save();
        }

        return var2;
    }

    public static void writeIntConfig(String category, String key, int value) {
        config = new Configuration(new File("config/DungeonRooms.cfg"));

        try {
            config.load();
            int set = config.get(category, key, value).getInt();
            config.getCategory(category).get(key).set(value);
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            config.save();
        }

    }

    public static void writeDoubleConfig(String category, String key, double value) {
        config = new Configuration(new File("config/DungeonRooms.cfg"));

        try {
            config.load();
            double set = config.get(category, key, value).getDouble();
            config.getCategory(category).get(key).set(value);
        } catch (Exception var9) {
            var9.printStackTrace();
        } finally {
            config.save();
        }

    }

    public static void writeStringConfig(String category, String key, String value) {
        config = new Configuration(new File("config/DungeonRooms.cfg"));

        try {
            config.load();
            String set = config.get(category, key, value).getString();
            config.getCategory(category).get(key).set(value);
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            config.save();
        }

    }

    public static void writeBooleanConfig(String category, String key, boolean value) {
        config = new Configuration(new File("config/DungeonRooms.cfg"));

        try {
            config.load();
            boolean set = config.get(category, key, value).getBoolean();
            config.getCategory(category).get(key).set(value);
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            config.save();
        }

    }

    public static boolean hasKey(String category, String key) {
        config = new Configuration(new File("config/DungeonRooms.cfg"));

        boolean var2;
        try {
            config.load();
            if (!config.hasCategory(category)) {
                var2 = false;
                return var2;
            }

            var2 = config.getCategory(category).containsKey(key);
        } catch (Exception var6) {
            var6.printStackTrace();
            return false;
        } finally {
            config.save();
        }

        return var2;
    }

    public static void deleteCategory(String category) {
        config = new Configuration(new File("config/DungeonRooms.cfg"));

        try {
            config.load();
            if (config.hasCategory(category)) {
                config.removeCategory(new ConfigCategory(category));
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            config.save();
        }

    }

    public static void reloadConfig() {
        if (!hasKey("toggles", "guiToggled")) {
            writeBooleanConfig("toggles", "guiToggled", true);
        }

        if (!hasKey("toggles", "motdToggled")) {
            writeBooleanConfig("toggles", "motdToggled", true);
        }

        if (!hasKey("toggles", "waypointsToggled")) {
            writeBooleanConfig("toggles", "waypointsToggled", true);
        }

        if (!hasKey("waypoint", "showEntrance")) {
            writeBooleanConfig("waypoint", "showEntrance", true);
        }

        if (!hasKey("waypoint", "showSuperboom")) {
            writeBooleanConfig("waypoint", "showSuperboom", true);
        }

        if (!hasKey("waypoint", "showSecrets")) {
            writeBooleanConfig("waypoint", "showSecrets", true);
        }

        if (!hasKey("waypoint", "showFairySouls")) {
            writeBooleanConfig("waypoint", "showFairySouls", true);
        }

        if (!hasKey("waypoint", "showStonk")) {
            writeBooleanConfig("waypoint", "showStonk", true);
        }

        if (!hasKey("waypoint", "sneakToDisable")) {
            writeBooleanConfig("waypoint", "sneakToDisable", true);
        }

        if (!hasKey("waypoint", "disableWhenAllFound")) {
            writeBooleanConfig("waypoint", "disableWhenAllFound", true);
        }

        if (!hasKey("waypoint", "showWaypointText")) {
            writeBooleanConfig("waypoint", "showWaypointText", true);
        }

        if (!hasKey("waypoint", "showBoundingBox")) {
            writeBooleanConfig("waypoint", "showBoundingBox", true);
        }

        if (!hasKey("waypoint", "showBeacon")) {
            writeBooleanConfig("waypoint", "showBeacon", true);
        }

        if (!hasKey("waypoint", "practiceModeOn")) {
            writeBooleanConfig("waypoint", "practiceModeOn", false);
        }

        if (!hasKey("gui", "scaleX")) {
            writeIntConfig("gui", "scaleX", 50);
        }

        if (!hasKey("gui", "scaleY")) {
            writeIntConfig("gui", "scaleY", 5);
        }

        if (!hasKey("gui", "hotkeyOpen")) {
            writeStringConfig("gui", "hotkeyOpen", "gui");
        }

        if (!hasKey("macro", "chosenGardenMacro")) {
            writeIntConfig("macro", "chosenGardenMacro", GardenManager.chosenGardenMacro);
        }

        if (!hasKey("toggles", "sneakToggled")) {
            writeBooleanConfig("toggles", "sneakToggled", Cobblestone.sneakIsActive);
        }

        if (!hasKey("toggles", "northSouth")) {
            writeBooleanConfig("toggles", "northSouth", GardenManager.north_South);
        }

    }
}
