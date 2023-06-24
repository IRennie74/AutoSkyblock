////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package com.kingscripts.autoskyblock.autoskyblockmod.macros.dungeons.catacombs;
//
//import com.kingscripts.autoskyblock.autoskyblockmod.AutoSkyblock;
//import com.kingscripts.autoskyblock.autoskyblockmod.utils.MapUtils;
//import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
//import java.awt.Point;
//import java.util.ArrayList;
//import java.util.Arrays;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.entity.EntityPlayerSP;
//import net.minecraft.client.settings.GameSettings;
//import net.minecraft.util.ChatComponentText;
//import net.minecraft.util.EnumChatFormatting;
//import net.minecraft.util.Vec3;
//import net.minecraftforge.client.event.ClientChatReceivedEvent;
//import net.minecraftforge.event.world.WorldEvent;
//import net.minecraftforge.fml.common.eventhandler.EventPriority;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.common.gameevent.TickEvent;
//import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
//
//public class DungeonManager {
//    Minecraft mc = Minecraft.getMinecraft();
//    public static int gameStage = 0;
//    public static boolean guiToggled = true;
//    public static boolean motdToggled = true;
//    public static Integer[][] map;
//    public static Point[] entranceMapCorners;
//    public static Point entrancePhysicalNWCorner;
//    public static int tickAmount = 0;
//    long bloodTime = Long.MAX_VALUE;
//    boolean oddRun = true;
//
//    public DungeonManager() {
//    }
//
//    @SubscribeEvent(
//            priority = EventPriority.HIGHEST,
//            receiveCanceled = true
//    )
//    public void onChat(ClientChatReceivedEvent event) {
//        if (Utils.inCatacombs) {
//            String message = event.message.getFormattedText();
//            if (message.startsWith("§e[NPC] §bMort§f: §rHere, I found this map when I first entered the dungeon.§r")) {
//                gameStage = 2;
//                AutoSkyblock.logger.info("DungeonRooms: gameStage set to " + gameStage);
//            } else if (message.startsWith("§r§c[BOSS] The Watcher§r§f: You have proven yourself. You may pass.§r")) {
//                this.bloodTime = System.currentTimeMillis() + 5000L;
//                AutoSkyblock.logger.info("DungeonRooms: bloodDone has been set to True");
//            } else if (System.currentTimeMillis() > this.bloodTime && (message.startsWith("§r§c[BOSS] ") && !message.contains(" The Watcher§r§f:") || message.startsWith("§r§4[BOSS] "))) {
//                if (gameStage != 3) {
//                    gameStage = 3;
//                    AutoSkyblock.logger.info("DungeonRooms: gameStage set to " + gameStage);
//                    RoomDetection.resetCurrentRoom();
//                    RoomDetection.roomName = "Boss Room";
//                    RoomDetection.roomCategory = "General";
//                }
//            } else if (message.contains("§r§c☠ §r§eDefeated §r")) {
//                gameStage = 4;
//                AutoSkyblock.logger.info("DungeonRooms: gameStage set to " + gameStage);
//                RoomDetection.resetCurrentRoom();
//            }
//
//        }
//    }
//
//    @SubscribeEvent
//    public void onTick(TickEvent.ClientTickEvent event) {
//        if (event.phase == Phase.START) {
//            EntityPlayerSP player = this.mc.thePlayer;
//            if (Utils.inCatacombs) {
//                ++tickAmount;
//                if ((gameStage == 0 || gameStage == 1) && tickAmount % 20 == 0) {
//                    if (AutoSkyblock.firstLogin) {
//                        AutoSkyblock.firstLogin = false;
//                        this.mc.thePlayer.addChatMessage(new ChatComponentText("§d§l--- Dungeon Rooms Mod ---\n§e This appears to be your first time using DRM v1.0.\n§e Press \"" + GameSettings.getKeyDisplayString(AutoSkyblock.keyBindings[1].getKeyCode()) + "\" to configure Secret Waypoint settings, If you do not wish to use Waypoints, you can instead press \"" + GameSettings.getKeyDisplayString(AutoSkyblock.keyBindings[0].getKeyCode()) + "\" while inside a dungeon room to view images of the secrets for that room.\n§r (If you need help, join the Discord! Run \"/room discord\" to open the Discord invite.)\n§d§l------------------------"));
//                    }
//
//                    if (gameStage == 0) {
//                        Utils.checkForConflictingHotkeys();
//                        gameStage = 1;
//                        AutoSkyblock.logger.info("DungeonRooms: gameStage set to " + gameStage);
//                    }
//
//                    Integer[][] map = MapUtils.updatedMap();
//                    if (map != null) {
//                        AutoSkyblock.logger.warn("DungeonRooms: Run started but gameStage is not on 2");
//                        gameStage = 2;
//                        AutoSkyblock.logger.info("DungeonRooms: gameStage set to " + gameStage);
//                        return;
//                    }
//
//                    if (gameStage == 1 && entrancePhysicalNWCorner == null && !player.getPositionVector().equals(new Vec3(0.0, 0.0, 0.0))) {
//                        entrancePhysicalNWCorner = MapUtils.getClosestNWPhysicalCorner(player.getPositionVector());
//                        AutoSkyblock.logger.info("DungeonRooms: entrancePhysicalNWCorner has been set to " + entrancePhysicalNWCorner);
//                    }
//
//                    if (AutoSkyblock.textToDisplay == null && motdToggled) {
//                        AutoSkyblock.logger.info("DungeonRooms: Updating MOTD on screen");
//                        if ((this.oddRun || !guiToggled) && AutoSkyblock.motd != null && !AutoSkyblock.motd.isEmpty()) {
//                            AutoSkyblock.textToDisplay = AutoSkyblock.motd;
//                        }
//
//                        if (AutoSkyblock.textToDisplay == null && guiToggled) {
//                            AutoSkyblock.textToDisplay = new ArrayList(Arrays.asList("Dungeon Rooms: " + EnumChatFormatting.GREEN + "Press the hotkey \"" + GameSettings.getKeyDisplayString(AutoSkyblock.keyBindings[1].getKeyCode()) + "\" to configure", EnumChatFormatting.GREEN + " waypoint settings. Alternatively, press \"" + GameSettings.getKeyDisplayString(AutoSkyblock.keyBindings[0].getKeyCode()) + "\" while in a room", EnumChatFormatting.GREEN + "to view images of secret locations for that room.", "(You can change the keybinds in Minecraft controls menu)"));
//                        }
//
//                        this.oddRun = !this.oddRun;
//                    }
//
//                    tickAmount = 0;
//                }
//
//            }
//        }
//    }
//
//    @SubscribeEvent
//    public void onWorldUnload(WorldEvent.Unload event) {
//        Utils.inCatacombs = false;
//        tickAmount = 0;
//        gameStage = 0;
//        map = (Integer[][])null;
//        entranceMapCorners = null;
//        entrancePhysicalNWCorner = null;
//        RoomDetection.entranceMapNullCount = 0;
//        this.bloodTime = Long.MAX_VALUE;
//        if (RoomDetection.stage2Executor != null) {
//            RoomDetection.stage2Executor.shutdown();
//        }
//
//        Waypoints.allSecretsMap.clear();
//        RoomDetection.resetCurrentRoom();
//    }
//}
