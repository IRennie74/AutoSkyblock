//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.macros.garden;

import com.kingscripts.autoskyblock.autoskyblockmod.handlers.ConfigHandler;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.Cobblestone;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.MacroManager;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.GardenUtils;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

public class GardenManager {
    Minecraft mc = Minecraft.getMinecraft();
    public static int tickAmount = 1;
    public static int tickPerCount;
    public static int tickAmountStage = 1;
    public static float coolDownTimeHours = 0.004F;
    public static float runTimeHours = 0.004F;
    public static long savedStartMillis;
    public static boolean north_South = ConfigHandler.getBoolean("toggles", "north_south");
    public static boolean coolDown = false;
    public static boolean coolDownInit = false;
    public static boolean expectedPause = false;
    public static boolean scriptIsActuallyOn = false;
    public static int chosenGardenMacro = ConfigHandler.getInt("macro", "chosenGardenMacro");
    public static int gardenGameStage = 0;

    public GardenManager() {
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == Phase.START) {

            if (MacroManager.scriptIsOn) {
                if (!Utils.inSkyblock) {
                    ++tickAmountStage;
                    if (tickAmountStage == 200) {
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Going To Lobby"));
                        Minecraft.getMinecraft().thePlayer.sendChatMessage("/lobby");
                    } else if (tickAmountStage == 400) {
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Going To Skyblock"));
                        Minecraft.getMinecraft().thePlayer.sendChatMessage("/skyblock");
                    } else if (tickAmountStage == 800) {
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Starting Macro"));
                        Utils.disableMovement();
                        GardenUtils.safetyRestart();
                        tickAmountStage = 1;
                    }
                } else {
                    ++tickAmount;
                    if (chosenGardenMacro == 4) {
                        tickPerCount = 7;
                    } else {
                        tickPerCount = 10;
                    }

                    if (tickAmount % tickPerCount == 0) {
                        Utils.positionIsSame();
                        Utils.xPosition = (float)this.mc.thePlayer.getPosition().getX();
                        Utils.yPosition = (float)this.mc.thePlayer.getPosition().getY();
                        Utils.zPosition = (float)this.mc.thePlayer.getPosition().getZ();
                    }

                    macroRunner();
                    if (GardenUtils.rotateCameraIsActive) {
                        GardenUtils.rotateCameraTo(GardenUtils.startYaw, GardenUtils.startPitch);
                    }
                }

                if (GardenUtils.stopAttackSpinIsOn) {
                    GardenUtils.stopAttackSpinOnTick();
                }

            }
        }
    }

    public static void initMacroRunner() {
        if (chosenGardenMacro != 0) {
            if (chosenGardenMacro == 1) {
                SideToSide.start();
            } else if (chosenGardenMacro == 2) {
                Cobblestone.start();
            } else if (chosenGardenMacro == 3) {
                FlatCrops.start();
            } else if (chosenGardenMacro == 4) {
                WheatInHub.start();
            } else if (chosenGardenMacro == 5) {
                SideToSideForward.start();
            } else if (chosenGardenMacro == 6) {
                SideToSideRotatesCamera.start();
            }

        }
    }

    public static void macroRunner() {
        if (chosenGardenMacro != 0) {
            if (chosenGardenMacro == 1) {
                SideToSide.main();
            } else if (chosenGardenMacro == 2) {
                Cobblestone.main();
            } else if (chosenGardenMacro == 3) {
                FlatCrops.main();
            } else if (chosenGardenMacro == 4) {
                WheatInHub.main();
            } else if (chosenGardenMacro == 5) {
                SideToSideForward.main();
            } else if (chosenGardenMacro == 6) {
                SideToSideRotatesCamera.main();
            }

        }
    }
}
