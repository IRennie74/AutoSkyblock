//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.macros.garden;

import com.kingscripts.autoskyblock.autoskyblockmod.macros.MacroManager;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.GardenUtils;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class WheatInHub {
    static Minecraft mc = Minecraft.getMinecraft();
    public static int gameStage = 1;
    private static int count = 0;
    private static boolean canRun = true;

    public WheatInHub() {
    }

    public static void start() {
        MacroManager.scriptIsOn = true;
        Utils.resetPositionIsSame();
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        gameStage = 1;
        count = 1;
        Utils.resetPositionIsSame();
    }

    public static void main() {
        if (MacroManager.scriptIsOn) {
            if (gameStage == 1) {
                GardenUtils.rotateCameraTo(-138.5F, 0.0F);
            } else if (gameStage == 2) {
                ++count;
                if (count < 20) {
                    Utils.resetPositionIsSame();
                }

                KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                if (Utils.xPositionIsSame) {
                    Utils.resetPositionIsSame();
                    ++gameStage;
                    count = 0;
                    Utils.disableMovement();
                }
            } else if (gameStage == 3) {
                GardenUtils.rotateCameraTo(-177.5F, 0.0F);
            } else if (gameStage == 4) {
                ++count;
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                if (Utils.zPositionIsSame) {
                    Utils.resetPositionIsSame();
                    ++gameStage;
                    count = 0;
                    Utils.disableMovement();
                }
            } else if (gameStage == 5) {
                GardenUtils.stopAttackSpin();
                Utils.resetPositionIsSame();
            } else if (gameStage == 6) {
                GardenUtils.rotateCameraTo(-73.5F, 0.0F);
                Utils.resetPositionIsSame();
            } else if (gameStage == 7) {
                ++count;
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                if (Utils.xPositionIsSame && Utils.zPositionIsSame) {
                    Utils.resetPositionIsSame();
                    ++gameStage;
                    count = 0;
                    Utils.disableMovement();
                }
            } else if (gameStage == 8) {
                GardenUtils.rotateCameraTo(-169.0F, 0.0F);
                Utils.resetPositionIsSame();
            } else if (gameStage == 9) {
                ++count;
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                if (Utils.xPositionIsSame && Utils.zPositionIsSame) {
                    Utils.resetPositionIsSame();
                    ++gameStage;
                    count = 0;
                    Utils.disableMovement();
                }
            } else if (gameStage == 10) {
                GardenUtils.stopAttackSpin();
                Utils.resetPositionIsSame();
            } else if (gameStage == 11) {
                GardenUtils.rotateCameraTo(90.0F, 0.0F);
                Utils.resetPositionIsSame();
            } else if (gameStage == 12) {
                ++count;
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                if (Utils.xPositionIsSame) {
                    Utils.resetPositionIsSame();
                    ++gameStage;
                    count = 0;
                    Utils.disableMovement();
                }
            } else if (gameStage == 13) {
                GardenUtils.stopAttackSpin();
                Utils.resetPositionIsSame();
            } else if (gameStage == 14) {
                GardenUtils.rotateCameraTo(-115.0F, 0.0F);
                Utils.resetPositionIsSame();
            } else if (gameStage == 15) {
                ++count;
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                if (Utils.xPositionIsSame && Utils.zPositionIsSame) {
                    ++gameStage;
                    count = 0;
                    Utils.disableMovement();
                    Utils.resetPositionIsSame();
                }
            } else if (gameStage == 16) {
                GardenUtils.stopAttackSpin();
                Utils.resetPositionIsSame();
            } else if (gameStage == 17) {
                GardenUtils.rotateCameraTo(103.0F, 0.0F);
                Utils.resetPositionIsSame();
            } else if (gameStage == 18) {
                ++count;
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                if (Utils.xPositionIsSame) {
                    Utils.resetPositionIsSame();
                    ++gameStage;
                    count = 0;
                    Utils.disableMovement();
                }
            } else if (gameStage == 19) {
                GardenUtils.stopAttackSpin();
                Utils.resetPositionIsSame();
            }

        }
    }

    public static void safetyRestart() {
        MacroManager.warpExpected = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
    }
}
