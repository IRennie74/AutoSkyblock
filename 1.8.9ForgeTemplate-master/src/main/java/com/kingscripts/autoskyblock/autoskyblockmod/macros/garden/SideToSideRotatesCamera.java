//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.macros.garden;

import com.kingscripts.autoskyblock.autoskyblockmod.macros.Cobblestone;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.MacroManager;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class SideToSideRotatesCamera {
    static Minecraft mc = Minecraft.getMinecraft();
    private static int gameStage = 1;
    private static float lastSavedY;
    private static float yaw;
    private static float pitch = 5.0F;
    private static boolean canRun = true;
    private static boolean initAngle = true;
    private static boolean canRunMath = true;

    public SideToSideRotatesCamera() {
    }

    public static void start() {
        MacroManager.scriptIsOn = true;
        canRunMath = true;
        gameStage = 1;
        lastSavedY = (float)Minecraft.getMinecraft().thePlayer.getPosition().getY();
        if (GardenManager.north_South) {
            if (initAngle) {
                yaw = 0.0F;
                initAngle = false;
            } else {
                yaw = 180.0F;
                initAngle = true;
            }
        } else if (initAngle) {
            yaw = 90.0F;
            initAngle = false;
        } else {
            yaw = -90.0F;
            initAngle = true;
        }

    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        canRunMath = true;
        lastSavedY = (float)Minecraft.getMinecraft().thePlayer.getPosition().getY();
        gameStage = 1;
        if (GardenManager.north_South) {
            if (initAngle) {
                yaw = 0.0F;
                initAngle = false;
            } else {
                yaw = 180.0F;
                initAngle = true;
            }
        } else if (initAngle) {
            yaw = 90.0F;
            initAngle = false;
        } else {
            yaw = -90.0F;
            initAngle = true;
        }

    }

    public static void main() {
        if (canRunMath && (float)Minecraft.getMinecraft().thePlayer.getPosition().getY() >= lastSavedY) {
            lastSavedY = (float)Minecraft.getMinecraft().thePlayer.getPosition().getY();
            canRunMath = false;
            if (GardenManager.north_South) {
                if (initAngle) {
                    yaw = 0.0F;
                    Minecraft.getMinecraft().thePlayer.rotationYaw = 0.0F;
                    Minecraft.getMinecraft().thePlayer.rotationPitch = pitch;
                    initAngle = false;
                } else {
                    yaw = 180.0F;
                    Minecraft.getMinecraft().thePlayer.rotationYaw = 180.0F;
                    Minecraft.getMinecraft().thePlayer.rotationPitch = pitch;
                    initAngle = true;
                }
            } else if (initAngle) {
                yaw = 90.0F;
                Minecraft.getMinecraft().thePlayer.rotationYaw = 90.0F;
                Minecraft.getMinecraft().thePlayer.rotationPitch = pitch;
                initAngle = false;
            } else {
                yaw = -90.0F;
                Minecraft.getMinecraft().thePlayer.rotationYaw = -90.0F;
                Minecraft.getMinecraft().thePlayer.rotationPitch = pitch;
                initAngle = true;
            }
        }

        if ((float)Minecraft.getMinecraft().thePlayer.getPosition().getY() <= lastSavedY - 1.0F) {
            canRunMath = true;
        }

        if (GardenManager.north_South) {
            if (Utils.xPositionIsSame) {
                ++gameStage;
                Utils.disableMovement();
                Utils.xPositionIsSame = false;
                canRun = true;
            }
        } else if (Utils.zPositionIsSame) {
            ++gameStage;
            Utils.disableMovement();
            Utils.zPositionIsSame = false;
            canRun = true;
        }

        if (canRun) {
            if (gameStage % 2 != 0) {
                Minecraft.getMinecraft().thePlayer.rotationYaw = yaw;
                Minecraft.getMinecraft().thePlayer.rotationPitch = pitch;
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                if (Cobblestone.sneakIsActive) {
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                }

                KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                canRun = false;
            } else {
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                if (Cobblestone.sneakIsActive) {
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                }

                KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                canRun = false;
            }
        }

    }

    public static void safetyRestart() {
        MacroManager.warpExpected = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp garden");
    }
}
