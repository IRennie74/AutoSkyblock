//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.macros;

import com.kingscripts.autoskyblock.autoskyblockmod.AutoSkyblock;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.GardenManager;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.WheatInHub;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.GardenUtils;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class MacroManager {
    Minecraft mc = Minecraft.getMinecraft();
    public static boolean startScriptPhase = false;
    public static int tickAmount = 1;
    public static int tickAmountV2 = 1;
    public static int tickAmountV3 = 1;
    public static int tickAmountV4 = 1;
    public static boolean safetyRestart = false;
    public static long startMilis;
    public static boolean scriptIsOn = false;
    public static boolean warpExpected = false;
    public static boolean scriptIsPaused = false;

    public MacroManager() {
    }

    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event) {
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        if (AutoSkyblock.keyBindings[0].isPressed()) {
            startScriptPhase = true;
            startMilis = System.currentTimeMillis();
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Starting Macro in..."));
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "10"));
        }

        if (AutoSkyblock.keyBindings[1].isPressed()) {
        }

        if (AutoSkyblock.keyBindings[2].isPressed()) {
            Utils.disableEverything();

        }

    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) throws InterruptedException {
        if (event.phase == Phase.START) {
            if (startScriptPhase) {
                ++tickAmount;
                if (tickAmount % 20 == 0) {
                    if (System.currentTimeMillis() - startMilis >= 1000L) {
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Starting Script"));
                        startScriptPhase = false;
                        GardenManager.initMacroRunner();
                    } else if (System.currentTimeMillis() - startMilis >= 9000L) {
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "1"));
                    } else if (System.currentTimeMillis() - startMilis >= 8000L) {
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "2"));
                    } else if (System.currentTimeMillis() - startMilis >= 7000L) {
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "3"));
                    } else if (System.currentTimeMillis() - startMilis >= 6000L) {
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "4"));
                    } else if (System.currentTimeMillis() - startMilis >= 5000L) {
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "5"));
                    } else if (System.currentTimeMillis() - startMilis >= 4000L) {
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "6"));
                    } else if (System.currentTimeMillis() - startMilis >= 3000L) {
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "7"));
                    } else if (System.currentTimeMillis() - startMilis >= 2000L) {
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "8"));
                    } else if (System.currentTimeMillis() - startMilis >= 1000L) {
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "9"));
                    }
                }
            }

            if (safetyRestart) {
                ++tickAmountV2;
                if (tickAmountV2 % 1000 == 0) {
                    safetyRestart = false;
                    scriptIsOn = true;
                    GardenUtils.safetyRestart();
                    GardenManager.initMacroRunner();
                    GardenManager.macroRunner();
                }
            }

            if (warpExpected) {
                ++tickAmountV3;
                if (tickAmountV3 % 100 == 0) {
                    warpExpected = false;
                }
            }

        }
    }

    @SubscribeEvent
    public void onWorldUnload(WorldEvent.Unload event) {
        if (!warpExpected) {
            if (scriptIsOn && Utils.inSkyblock) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Server Warped: Waiting 50 Seconds"));
                Utils.disableEverything();
                safetyRestart = true;
            }

        }
    }

    @SubscribeEvent
    public void onServerDisconnect(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
        if (scriptIsOn) {
            Utils.inSkyblock = false;
        }

    }
}