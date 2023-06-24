//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.macros.garden;

import com.kingscripts.autoskyblock.autoskyblockmod.macros.MacroManager;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class FlatCrops {
    static Minecraft mc = Minecraft.getMinecraft();
    private static int gameStage = 1;
    private static int count = 0;
    private static boolean canRun = true;
    private static boolean checkForStopTop = false;
    private static boolean checkForStopBottom = false;

    public FlatCrops() {
    }

    public static void start() {
        MacroManager.scriptIsOn = true;
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        gameStage = 1;
    }

    public static void main() {
        ++count;
        if (count < 20) {
            Utils.resetPositionIsSame();
        }

        if (checkForStopTop) {
            if ((double)Minecraft.getMinecraft().thePlayer.getPosition().getZ() <= -142.05) {
                Utils.disableMovementExceptSneak();
                KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(), true);
                ++gameStage;
                checkForStopTop = false;
            }
        } else if (checkForStopBottom && Minecraft.getMinecraft().thePlayer.getPosition().getZ() >= -50) {
            Utils.disableMovementExceptSneak();
            KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(), true);
            ++gameStage;
            checkForStopBottom = false;
        }

        if (gameStage == 1) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180.0F;
            Minecraft.getMinecraft().thePlayer.rotationPitch = 50.0F;
            ++gameStage;
        } else if (gameStage == 2) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/sethome");
            ++gameStage;
        } else if (gameStage == 3) {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        }

    }

    public static void safetyRestart() {
        MacroManager.warpExpected = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp garden");
        gameStage = 1;
    }
}
