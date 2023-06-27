//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.utils;

import com.kingscripts.autoskyblock.autoskyblockmod.macros.Cobblestone;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.MacroManager;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.FlatCrops;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.GardenManager;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.SideToSide;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.SideToSideForward;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.SideToSideRotatesCamera;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.WheatInHub;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class GardenUtils {
    public static boolean rotateCameraIsActive = false;
    public static boolean stopAttackSpinIsOn = false;
    public static boolean yawGoalMet = false;
    public static boolean pitchGoalMet = false;
    public static float plannedYaw;
    public static float plannedPitch;
    public static float startYaw;
    public static float startPitch;
    public static float yawAdd;
    public static float pitchAdd;
    private static int count = 0;
    private static int count2 = 1;
    private static int count3 = 0;
    private static int atttackStage = 1;
    private static final int rounds = 10;

    public GardenUtils() {
    }

    public static float lerp(float a, float b, float f) {
        return f * (b - a);
    }

    public static void rotateCameraTo(float yaw, float pitch) {
        if (!rotateCameraIsActive) {
            rotateCameraIsActive = true;
            yawAdd = lerp(startYaw, yaw, 0.1F);
            pitchAdd = lerp(startPitch, pitch, 0.1F);
            plannedYaw = yaw;
            plannedPitch = pitch;
        }

        ++count;
        if (count == 11) {
            ++WheatInHub.gameStage;
            rotateCameraIsActive = false;
            Minecraft.getMinecraft().thePlayer.rotationYaw = plannedYaw;
            Minecraft.getMinecraft().thePlayer.rotationPitch = plannedPitch;
            Utils.resetPositionIsSame();
            count = 0;
        } else {
            EntityPlayerSP var10000 = Minecraft.getMinecraft().thePlayer;
            var10000.rotationYaw += yawAdd;
            var10000 = Minecraft.getMinecraft().thePlayer;
            var10000.rotationPitch += pitchAdd;
        }

    }

    public static void safetyRestart() {
        if (GardenManager.chosenGardenMacro != 0) {
            if (GardenManager.chosenGardenMacro == 1) {
                SideToSide.safetyRestart();
            } else if (GardenManager.chosenGardenMacro == 2) {
                Cobblestone.safetyRestart();
            } else if (GardenManager.chosenGardenMacro == 3) {
                FlatCrops.safetyRestart();
            } else if (GardenManager.chosenGardenMacro == 4) {
                WheatInHub.safetyRestart();
            } else if (GardenManager.chosenGardenMacro == 5) {
                SideToSideForward.safetyRestart();
            } else if (GardenManager.chosenGardenMacro == 6) {
                SideToSideRotatesCamera.safetyRestart();
            }

        }
    }

    public static void stopAttackSpin() {
        if (MacroManager.scriptIsOn) {
            if (stopAttackSpinIsOn) {
                Utils.disableMovement();
                rotateCameraTo(0.0F, 52.0F);
                stopAttackSpinIsOn = true;
            }

        }
    }

    public static void stopAttackSpinOnTick() {
        if (MacroManager.scriptIsOn) {
            if (atttackStage == 1) {
                ++count3;
                if (count3 != 361) {
                    ++Minecraft.getMinecraft().thePlayer.rotationYaw;
                    count3 = 0;
                    ++atttackStage;
                }
            } else if (atttackStage == 2) {
                Minecraft.getMinecraft().thePlayer.rotationPitch = 20.0F;
                ++atttackStage;
            } else if (atttackStage == 3) {
                ++count3;
                if (count3 != 361) {
                    ++Minecraft.getMinecraft().thePlayer.rotationYaw;
                    count3 = 0;
                    atttackStage = 0;
                    stopAttackSpinIsOn = false;
                    ++WheatInHub.gameStage;
                }
            }

        }
    }
}
