////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package com.kingscripts.autoskyblock.autoskyblockmod.macros.dungeons.catacombs;
//
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.kingscripts.autoskyblock.autoskyblockmod.AutoSkyblock;
//import com.kingscripts.autoskyblock.autoskyblockmod.events.PacketEvent;
//import com.kingscripts.autoskyblock.autoskyblockmod.utils.MapUtils;
//import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
//import com.kingscripts.autoskyblock.autoskyblockmod.utils.WaypointUtils;
//import java.awt.Color;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import net.minecraft.block.Block;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.entity.EntityPlayerSP;
//import net.minecraft.client.renderer.GlStateManager;
//import net.minecraft.client.renderer.culling.Frustum;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.item.EntityItem;
//import net.minecraft.init.Blocks;
//import net.minecraft.network.play.server.S0DPacketCollectItem;
//import net.minecraft.util.AxisAlignedBB;
//import net.minecraft.util.BlockPos;
//import net.minecraft.util.StringUtils;
//import net.minecraftforge.client.event.ClientChatReceivedEvent;
//import net.minecraftforge.client.event.RenderWorldLastEvent;
//import net.minecraftforge.event.entity.player.PlayerInteractEvent;
//import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
//import net.minecraftforge.fml.client.FMLClientHandler;
//import net.minecraftforge.fml.common.eventhandler.EventPriority;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.common.gameevent.InputEvent;
//
//public class Waypoints {
//    public static boolean enabled = true;
//    public static boolean showEntrance = true;
//    public static boolean showSuperboom = true;
//    public static boolean showSecrets = true;
//    public static boolean showFairySouls = true;
//    public static boolean showStonk = true;
//    public static boolean sneakToDisable = true;
//    public static boolean disableWhenAllFound = true;
//    public static boolean allFound = false;
//    public static boolean showWaypointText = true;
//    public static boolean showBoundingBox = true;
//    public static boolean showBeacon = true;
//    public static boolean practiceModeOn = false;
//    public static int secretNum = 0;
//    public static int completedSecrets = 0;
//    public static Map<String, List<Boolean>> allSecretsMap = new HashMap();
//    public static List<Boolean> secretsList = new ArrayList(Arrays.asList());
//    static long lastSneakTime = 0L;
//    Frustum frustum = new Frustum();
//
//    public Waypoints() {
//    }
//
//    @SubscribeEvent
//    public void onWorldRender(RenderWorldLastEvent event) {
//        if (enabled) {
//            if (!practiceModeOn || AutoSkyblock.keyBindings[2].isKeyDown()) {
//                String roomName = RoomDetection.roomName;
//                if (!roomName.equals("undefined") && AutoSkyblock.roomsJson.get(roomName) != null && secretsList != null) {
//                    if (AutoSkyblock.waypointsJson.get(roomName) != null) {
//                        JsonArray secretsArray = AutoSkyblock.waypointsJson.get(roomName).getAsJsonArray();
//                        int arraySize = secretsArray.size();
//
//                        for(int i = 0; i < arraySize; ++i) {
//                            JsonObject secretsObject = secretsArray.get(i).getAsJsonObject();
//                            boolean display = true;
//
//                            for(int j = 1; j <= secretNum; ++j) {
//                                if (!(Boolean)secretsList.get(j - 1) && secretsObject.get("secretName").getAsString().substring(0, 2).replaceAll("[\\D]", "").equals(String.valueOf(j))) {
//                                    display = false;
//                                    break;
//                                }
//                            }
//
//                            if (display && (!disableWhenAllFound || !allFound || secretsObject.get("category").getAsString().equals("fairysoul"))) {
//                                BlockPos relative = new BlockPos(secretsObject.get("x").getAsInt(), secretsObject.get("y").getAsInt(), secretsObject.get("z").getAsInt());
//                                BlockPos pos = MapUtils.relativeToActual(relative, RoomDetection.roomDirection, RoomDetection.roomCorner);
//                                Entity viewer = Minecraft.getMinecraft().getRenderViewEntity();
//                                this.frustum.setPosition(viewer.posX, viewer.posY, viewer.posZ);
//                                if (this.frustum.isBoxInFrustum((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (double)(pos.getX() + 1), 255.0, (double)(pos.getZ() + 1))) {
//                                    Color color;
//                                    switch (secretsObject.get("category").getAsString()) {
//                                        case "entrance":
//                                            if (!showEntrance) {
//                                                continue;
//                                            }
//
//                                            color = new Color(0, 255, 0);
//                                            break;
//                                        case "superboom":
//                                            if (!showSuperboom) {
//                                                continue;
//                                            }
//
//                                            color = new Color(255, 0, 0);
//                                            break;
//                                        case "chest":
//                                            if (!showSecrets) {
//                                                continue;
//                                            }
//
//                                            color = new Color(2, 213, 250);
//                                            break;
//                                        case "item":
//                                            if (!showSecrets) {
//                                                continue;
//                                            }
//
//                                            color = new Color(2, 64, 250);
//                                            break;
//                                        case "bat":
//                                            if (!showSecrets) {
//                                                continue;
//                                            }
//
//                                            color = new Color(142, 66, 0);
//                                            break;
//                                        case "wither":
//                                            if (!showSecrets) {
//                                                continue;
//                                            }
//
//                                            color = new Color(30, 30, 30);
//                                            break;
//                                        case "lever":
//                                            if (!showSecrets) {
//                                                continue;
//                                            }
//
//                                            color = new Color(250, 217, 2);
//                                            break;
//                                        case "fairysoul":
//                                            if (!showFairySouls) {
//                                                continue;
//                                            }
//
//                                            color = new Color(255, 85, 255);
//                                            break;
//                                        case "stonk":
//                                            if (!showStonk) {
//                                                continue;
//                                            }
//
//                                            color = new Color(146, 52, 235);
//                                            break;
//                                        default:
//                                            color = new Color(190, 255, 252);
//                                    }
//
//                                    double viewerX = viewer.lastTickPosX + (viewer.posX - viewer.lastTickPosX) * (double)event.partialTicks;
//                                    double viewerY = viewer.lastTickPosY + (viewer.posY - viewer.lastTickPosY) * (double)event.partialTicks;
//                                    double viewerZ = viewer.lastTickPosZ + (viewer.posZ - viewer.lastTickPosZ) * (double)event.partialTicks;
//                                    double x = (double)pos.getX() - viewerX;
//                                    double y = (double)pos.getY() - viewerY;
//                                    double z = (double)pos.getZ() - viewerZ;
//                                    double distSq = x * x + y * y + z * z;
//                                    GlStateManager.disableDepth();
//                                    GlStateManager.disableCull();
//                                    if (showBoundingBox && this.frustum.isBoxInFrustum((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (double)(pos.getX() + 1), (double)(pos.getY() + 1), (double)(pos.getZ() + 1))) {
//                                        WaypointUtils.drawFilledBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0), color, 0.4F);
//                                    }
//
//                                    GlStateManager.disableTexture2D();
//                                    if (showBeacon && distSq > 25.0) {
//                                        WaypointUtils.renderBeaconBeam(x, y + 1.0, z, color.getRGB(), 0.25F, event.partialTicks);
//                                    }
//
//                                    if (showWaypointText) {
//                                        WaypointUtils.renderWaypointText(secretsObject.get("secretName").getAsString(), pos.up(2), event.partialTicks);
//                                    }
//
//                                    GlStateManager.disableLighting();
//                                    GlStateManager.enableTexture2D();
//                                    GlStateManager.enableDepth();
//                                    GlStateManager.enableCull();
//                                }
//                            }
//                        }
//                    }
//
//                }
//            }
//        }
//    }
//
//    @SubscribeEvent(
//            priority = EventPriority.HIGHEST
//    )
//    public void onChat(ClientChatReceivedEvent event) {
//        if (Utils.inCatacombs && enabled) {
//            if (event.type == 2) {
//                String[] actionBarSections = event.message.getUnformattedText().split(" {3,}");
//                String[] var3 = actionBarSections;
//                int var4 = actionBarSections.length;
//
//                for(int var5 = 0; var5 < var4; ++var5) {
//                    String section = var3[var5];
//                    if (section.contains("Secrets") && section.contains("/")) {
//                        String cleanedSection = StringUtils.stripControlCodes(section);
//                        String[] splitSecrets = cleanedSection.split("/");
//                        completedSecrets = Integer.parseInt(splitSecrets[0].replaceAll("[^0-9]", ""));
//                        int totalSecrets = Integer.parseInt(splitSecrets[1].replaceAll("[^0-9]", ""));
//                        allFound = totalSecrets == secretNum && completedSecrets == secretNum;
//                        break;
//                    }
//                }
//            }
//
//        }
//    }
//
//    @SubscribeEvent
//    public void onInteract(PlayerInteractEvent event) {
//        if (Utils.inCatacombs && enabled) {
//            if (!disableWhenAllFound || !allFound) {
//                if (event.action == Action.RIGHT_CLICK_BLOCK) {
//                    Block block = event.world.getBlockState(event.pos).getBlock();
//                    if (block != Blocks.chest && block != Blocks.skull) {
//                        return;
//                    }
//
//                    String roomName = RoomDetection.roomName;
//                    if (roomName.equals("undefined") || AutoSkyblock.roomsJson.get(roomName) == null || secretsList == null) {
//                        return;
//                    }
//
//                    if (AutoSkyblock.waypointsJson.get(roomName) != null) {
//                        JsonArray secretsArray = AutoSkyblock.waypointsJson.get(roomName).getAsJsonArray();
//                        int arraySize = secretsArray.size();
//
//                        for(int i = 0; i < arraySize; ++i) {
//                            JsonObject secretsObject = secretsArray.get(i).getAsJsonObject();
//                            if (secretsObject.get("category").getAsString().equals("chest") || secretsObject.get("category").getAsString().equals("wither")) {
//                                BlockPos relative = new BlockPos(secretsObject.get("x").getAsInt(), secretsObject.get("y").getAsInt(), secretsObject.get("z").getAsInt());
//                                BlockPos pos = MapUtils.relativeToActual(relative, RoomDetection.roomDirection, RoomDetection.roomCorner);
//                                if (pos.equals(event.pos)) {
//                                    for(int j = 1; j <= secretNum; ++j) {
//                                        if (secretsObject.get("secretName").getAsString().substring(0, 2).replaceAll("[\\D]", "").equals(String.valueOf(j))) {
//                                            secretsList.set(j - 1, false);
//                                            allSecretsMap.replace(roomName, secretsList);
//                                            AutoSkyblock.logger.info("DungeonRooms: Detected " + secretsObject.get("category").getAsString() + " click, turning off waypoint for secret #" + j);
//                                            break;
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//
//            }
//        }
//    }
//
//    @SubscribeEvent
//    public void onReceivePacket(PacketEvent.ReceiveEvent event) {
//        if (Utils.inCatacombs && enabled) {
//            if (!disableWhenAllFound || !allFound) {
//                Minecraft mc = Minecraft.getMinecraft();
//                if (event.packet instanceof S0DPacketCollectItem) {
//                    S0DPacketCollectItem packet = (S0DPacketCollectItem)event.packet;
//                    Entity entity = mc.theWorld.getEntityByID(packet.getCollectedItemEntityID());
//                    if (entity instanceof EntityItem) {
//                        EntityItem item = (EntityItem)entity;
//                        entity = mc.theWorld.getEntityByID(packet.getEntityID());
//                        if (entity == null) {
//                            return;
//                        }
//
//                        String name = item.getEntityItem().getDisplayName();
//                        if (name.contains("Decoy") || name.contains("Defuse Kit") || name.contains("Dungeon Chest Key") || name.contains("Healing VIII") || name.contains("Inflatable Jerry") || name.contains("Spirit Leap") || name.contains("Training Weights") || name.contains("Trap") || name.contains("Treasure Talisman")) {
//                            if (!entity.getCommandSenderEntity().getName().equals(mc.thePlayer.getName())) {
//                                return;
//                            }
//
//                            String roomName = RoomDetection.roomName;
//                            if (roomName.equals("undefined") || AutoSkyblock.roomsJson.get(roomName) == null || secretsList == null) {
//                                return;
//                            }
//
//                            if (AutoSkyblock.waypointsJson.get(roomName) != null) {
//                                JsonArray secretsArray = AutoSkyblock.waypointsJson.get(roomName).getAsJsonArray();
//                                int arraySize = secretsArray.size();
//
//                                for(int i = 0; i < arraySize; ++i) {
//                                    JsonObject secretsObject = secretsArray.get(i).getAsJsonObject();
//                                    if (secretsObject.get("category").getAsString().equals("item") || secretsObject.get("category").getAsString().equals("bat")) {
//                                        BlockPos relative = new BlockPos(secretsObject.get("x").getAsInt(), secretsObject.get("y").getAsInt(), secretsObject.get("z").getAsInt());
//                                        BlockPos pos = MapUtils.relativeToActual(relative, RoomDetection.roomDirection, RoomDetection.roomCorner);
//                                        if (entity.getDistanceSq(pos) <= 36.0) {
//                                            for(int j = 1; j <= secretNum; ++j) {
//                                                if (secretsObject.get("secretName").getAsString().substring(0, 2).replaceAll("[\\D]", "").equals(String.valueOf(j)) && (Boolean)secretsList.get(j - 1)) {
//                                                    secretsList.set(j - 1, false);
//                                                    allSecretsMap.replace(roomName, secretsList);
//                                                    AutoSkyblock.logger.info("DungeonRooms: " + entity.getCommandSenderEntity().getName() + " picked up " + StringUtils.stripControlCodes(name) + " from a " + secretsObject.get("category").getAsString() + " secret, turning off waypoint for secret #" + j);
//                                                    return;
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//
//            }
//        }
//    }
//
//    @SubscribeEvent
//    public void onKey(InputEvent.KeyInputEvent event) {
//        if (Utils.inCatacombs && enabled && sneakToDisable) {
//            EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
//            if (FMLClientHandler.instance().getClient().gameSettings.keyBindSneak.isPressed()) {
//                if (System.currentTimeMillis() - lastSneakTime < 500L) {
//                    String roomName = RoomDetection.roomName;
//                    if (roomName.equals("undefined") || AutoSkyblock.roomsJson.get(roomName) == null || secretsList == null) {
//                        return;
//                    }
//
//                    if (AutoSkyblock.waypointsJson.get(roomName) != null) {
//                        JsonArray secretsArray = AutoSkyblock.waypointsJson.get(roomName).getAsJsonArray();
//                        int arraySize = secretsArray.size();
//
//                        for(int i = 0; i < arraySize; ++i) {
//                            JsonObject secretsObject = secretsArray.get(i).getAsJsonObject();
//                            if (secretsObject.get("category").getAsString().equals("chest") || secretsObject.get("category").getAsString().equals("wither") || secretsObject.get("category").getAsString().equals("item") || secretsObject.get("category").getAsString().equals("bat")) {
//                                BlockPos relative = new BlockPos(secretsObject.get("x").getAsInt(), secretsObject.get("y").getAsInt(), secretsObject.get("z").getAsInt());
//                                BlockPos pos = MapUtils.relativeToActual(relative, RoomDetection.roomDirection, RoomDetection.roomCorner);
//                                if (player.getDistanceSq(pos) <= 16.0) {
//                                    for(int j = 1; j <= secretNum; ++j) {
//                                        if (secretsObject.get("secretName").getAsString().substring(0, 2).replaceAll("[\\D]", "").equals(String.valueOf(j)) && (Boolean)secretsList.get(j - 1)) {
//                                            secretsList.set(j - 1, false);
//                                            allSecretsMap.replace(roomName, secretsList);
//                                            AutoSkyblock.logger.info("DungeonRooms: Player sneaked near " + secretsObject.get("category").getAsString() + " secret, turning off waypoint for secret #" + j);
//                                            return;
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//
//                lastSneakTime = System.currentTimeMillis();
//            }
//
//        }
//    }
//}
