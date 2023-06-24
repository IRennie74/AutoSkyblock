
package com.kingscripts.autoskyblock.autoskyblockmod.utils;

import com.kingscripts.autoskyblock.autoskyblockmod.AutoSkyblock;
import com.kingscripts.autoskyblock.autoskyblockmod.handlers.ScoreboardHandler;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.Cobblestone;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.MacroManager;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.BaseConfiguration;
import org.apache.logging.log4j.core.config.LoggerConfig;

import javax.crypto.Mac;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;
import java.util.zip.InflaterInputStream;

public class Utils {
    Minecraft mc = Minecraft.getMinecraft();
    public static boolean inSkyblock = false;
    public static boolean inGarden = false;
    public static boolean inPrivateIsland = false;
    public static boolean inCatacombs = false;
    public static boolean inHub = false;
    public static boolean dungeonOverride = false;
    public static float xPosition;
    public static float yPosition;
    public static float zPosition;
    public static boolean xPositionIsSame = false;
    public static boolean yPositionIsSame = false;
    public static boolean zPositionIsSame = false;
    public static float lerp(float a, float b, float f) {
        return f * (b - a);
    }
    public static int randomWithRange(int min, int max){   //defining method for a random number generator

        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }
    public static void disableMovement(){
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindLeft.getKeyCode(), false);
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindRight.getKeyCode(), false);
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindAttack.getKeyCode(), false);
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindForward.getKeyCode(), false);
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindJump.getKeyCode(), false);
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(), false);
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindBack.getKeyCode(), false);
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode(), false);
    }
    public static void disableMovementExceptSneak(){
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindLeft.getKeyCode(), false);
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindRight.getKeyCode(), false);
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindAttack.getKeyCode(), false);
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindForward.getKeyCode(), false);
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindJump.getKeyCode(), false);
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindBack.getKeyCode(), false);
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode(), false);
    }
    public static void disableEverything(){
        MacroManager.scriptIsOn = false;
        xPositionIsSame = false;
        yPositionIsSame = false;
        zPositionIsSame = false;
        MacroManager.startScriptPhase = false;
        MacroManager.tickAmount = 0;
        disableMovement();
        SideToSide.reset();
        Cobblestone.reset();
        FlatCrops.reset();
        WheatInHub.reset();
        SideToSideForward.reset();
        SideToSideRotatesCamera.reset();
    }
    public static void positionIsSame(){
        if(xPosition == Minecraft.getMinecraft().thePlayer.getPosition().getX()) {
            xPositionIsSame = true;
        } else xPositionIsSame = false;

        if(yPosition == Minecraft.getMinecraft().thePlayer.getPosition().getY()){
            yPositionIsSame = true;
        } else yPositionIsSame = false;

        if(zPosition == Minecraft.getMinecraft().thePlayer.getPosition().getZ()){
            zPositionIsSame = true;
        } else zPositionIsSame = false;
    }
    public static void resetPositionIsSame(){
        xPositionIsSame = false;
        yPositionIsSame = false;
        zPositionIsSame = false;
    }

    public static void checkForSkyblock() {
        if (dungeonOverride) {
            inSkyblock = true;
            return;
        }
        Minecraft mc = Minecraft.getMinecraft();
        if (mc != null && mc.theWorld != null && !mc.isSingleplayer()) {
            ScoreObjective scoreboardObj = mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
            if (scoreboardObj != null) {
                String scObjName = ScoreboardHandler.cleanSB(scoreboardObj.getDisplayName());
                if (scObjName.contains("SKYBLOCK")) {
                    inSkyblock = true;
                    return;
                }
            }
        }
        inSkyblock = false;
    }

    public static void checkForCatacombs() {
        if (dungeonOverride) {
            inCatacombs = true;
            return;
        }
        if (inSkyblock) {
            List<String> scoreboard = ScoreboardHandler.getSidebarLines();
            for (String s : scoreboard) {
                String sCleaned = ScoreboardHandler.cleanSB(s);
                if (sCleaned.contains("The Catacombs")) {
                    inCatacombs = true;
                    return;
                }
            }
        }
        inCatacombs = false;
    }

    public static void checkForHub() {
//        if (dungeonOverride) {
//            inHub = true;
//            return;
//        }
        if (inSkyblock) {
            List<String> scoreboard = ScoreboardHandler.getSidebarLines();
            for (String s : scoreboard) {
                String sCleaned = ScoreboardHandler.cleanSB(s);
                if (sCleaned.contains("Village")) {
                    inHub = true;
                    return;
                }
            }
        }
        inHub = false;
    }

    public static void checkForPrivateIsland() {
//        if (dungeonOverride) {
//            inPrivateIsland = true;
//            return;
//        }
        if (inSkyblock) {
            List<String> scoreboard = ScoreboardHandler.getSidebarLines();
            for (String s : scoreboard) {
                String sCleaned = ScoreboardHandler.cleanSB(s);
                if (sCleaned.contains("Your Island")) {
                    inPrivateIsland = true;
                    //Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Private Island"));
                    return;
                }
            }
        }
        inPrivateIsland = false;
    }

    public static void checkForGarden() {
//        if (dungeonOverride) {
//            inPrivateIsland = true;
//            return;
//        }
        if (inSkyblock) {
            List<String> scoreboard = ScoreboardHandler.getSidebarLines();
            for (String s : scoreboard) {
                String sCleaned = ScoreboardHandler.cleanSB(s);
                if (sCleaned.contains("The Garden") || sCleaned.contains("Plot")) {
                    inGarden = true;
                    return;
                }
            }
        }
        inGarden = false;
    }

    public static void checkForConflictingHotkeys() {
        Minecraft mc = Minecraft.getMinecraft();
        for (KeyBinding drmKeybind : AutoSkyblock.keyBindings) {
            for (KeyBinding keybinding : mc.gameSettings.keyBindings) {
                if (drmKeybind.getKeyCode() != 0 && drmKeybind != keybinding && drmKeybind.getKeyCode() == keybinding.getKeyCode()) {
                    mc.thePlayer.addChatMessage(new ChatComponentText("§d§l--- Dungeon Rooms Mod ---\n"
                            + " §r§cThe hotkey \"" + GameSettings.getKeyDisplayString(drmKeybind.getKeyCode())
                            + "\", which is used to " + drmKeybind.getKeyDescription() + ", has a conflict with a "
                            + "keybinding from \"" + keybinding.getKeyCategory() + "\".\n §c§lPlease go into the "
                            + "Minecraft Controls menu and change one of the keybindings.\n"
                            + "§d§l------------------------"
                    ));
                }
            }
        }

    }

    /**
     * @return List of the paths to every .skeleton room data file
     */
    public static List<Path> getAllPaths (String folderName) {
        List<Path> paths = new ArrayList<>();
        try {
            URI uri = AutoSkyblock.class.getResource("/assets/dungeonrooms/" + folderName).toURI();
            Path Path;
            FileSystem fileSystem = null;
            if (uri.getScheme().equals("jar")) {
                fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap());
                Path = fileSystem.getPath("/assets/dungeonrooms/" + folderName);
            } else {
                Path = Paths.get(uri);
            }
            Stream<Path> walk = Files.walk(Path, 3);
            for (Iterator<Path> it = walk.iterator(); it.hasNext();) {
                Path path = it.next();
                String name = path.getFileName().toString();
                if (name.endsWith(".skeleton")) paths.add(path);
            }
            if (fileSystem != null) fileSystem.close();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return paths;
    }

    /**
     * Converts the .skeleton files into a readable format.
     * @return room data as a hashmap
     */
    public static HashMap<String, long[]> pathsToRoomData (String parentFolder, List<Path> allPaths) {
        HashMap<String, long[]> allRoomData = new HashMap<>();
        try {
            for (Path path : allPaths) {
                if (!path.getParent().getFileName().toString().equals(parentFolder)) continue;
                String name = path.getFileName().toString();
                InputStream input = AutoSkyblock.class.getResourceAsStream(path.toString());
                ObjectInputStream data = new ObjectInputStream(new InflaterInputStream(input));
                long[] roomData = (long[]) data.readObject();
                allRoomData.put(name.substring(0, name.length() - 9), roomData);
                AutoSkyblock.logger.debug("DungeonRooms: Loaded " + name);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        AutoSkyblock.logger.info("DungeonRooms: Loaded " + allRoomData.size() + " " + parentFolder + " rooms");
        return allRoomData;
    }

    /**
     * Used to set the log level of just this mod
     */
    public static void setLogLevel(Logger logger, Level level) {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        BaseConfiguration config = (BaseConfiguration) ctx.getConfiguration();

        LoggerConfig loggerConfig = config.getLoggerConfig(logger.getName());
        LoggerConfig specificConfig = loggerConfig;

        if (!loggerConfig.getName().equals(logger.getName())) {
            specificConfig = new LoggerConfig(logger.getName(), level, true);
            specificConfig.setParent(loggerConfig);
            config.addLogger(logger.getName(), specificConfig);
        }
        specificConfig.setLevel(level);
        ctx.updateLoggers();
    }

    /**
     * Packs block info into a single 8 byte primitive long. Normally, first pair of bytes will be x coordinate, second
     * pair will be y coordinate, third pair will be z coordinate, and last pair will be block id and metadata.
     * @return primitive long containing block info
     */
    public static long shortToLong(short a, short b, short c, short d) {
        return ((long)((a << 16) | (b & 0xFFFF)) << 32) | (((c << 16) | (d & 0xFFFF)) & 0xFFFFFFFFL);
    }

    /**
     * @return Array of four shorts containing the values stored in the long
     */
    public static short[] longToShort(long l) {
        return new short[]{(short) (l >> 48), (short) (l >> 32), (short) (l >> 16), (short) (l)};
    }
}
