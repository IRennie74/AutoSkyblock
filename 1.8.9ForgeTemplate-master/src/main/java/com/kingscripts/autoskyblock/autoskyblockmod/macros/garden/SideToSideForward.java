//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.macros.garden;

import com.kingscripts.autoskyblock.autoskyblockmod.macros.MacroManager;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class SideToSideForward {
    static Minecraft mc = Minecraft.getMinecraft();
    private static int gameStage = 1;
    private static int count = 0;
    private static boolean canRun = true;

    public SideToSideForward() {
    }

    public static void start() {
        MacroManager.scriptIsOn = true;
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        gameStage = 1;
    }

    public static void main() {
        if (gameStage == 5) {
            gameStage = 1;
        }

        ++count;
        if (count < 20) {
            Utils.resetPositionIsSame();
        }

        if (gameStage != 2 && gameStage != 4) {
            if (gameStage == 1 || gameStage == 3) {
                if (GardenManager.north_South) {
                    if (Utils.zPositionIsSame) {
                        ++gameStage;
                        Utils.disableMovement();
                        Utils.zPositionIsSame = false;
                        canRun = true;
                        count = 0;
                    }
                } else if (Utils.xPositionIsSame) {
                    ++gameStage;
                    Utils.disableMovement();
                    Utils.xPositionIsSame = false;
                    canRun = true;
                    count = 0;
                }
            }
        } else if (GardenManager.north_South) {
            if (Utils.xPositionIsSame) {
                ++gameStage;
                Utils.disableMovement();
                Utils.xPositionIsSame = false;
                canRun = true;
                count = 0;
            }
        } else if (Utils.zPositionIsSame) {
            ++gameStage;
            Utils.disableMovement();
            Utils.zPositionIsSame = false;
            canRun = true;
            count = 0;
        }

        if (canRun) {
            if (gameStage == 5) {
                gameStage = 1;
            }

            if (gameStage != 1 && gameStage != 3) {
                if (gameStage == 4) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/sethome");
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    canRun = false;
                } else if (gameStage == 2) {
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    canRun = false;
                }
            } else {
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                canRun = false;
            }
        }

    }

    public static void safetyRestart() {
        MacroManager.warpExpected = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/is");
    }
}
