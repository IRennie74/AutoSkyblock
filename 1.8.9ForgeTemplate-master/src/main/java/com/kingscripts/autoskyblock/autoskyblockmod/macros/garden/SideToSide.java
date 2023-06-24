//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.macros.garden;

import com.kingscripts.autoskyblock.autoskyblockmod.macros.MacroManager;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class SideToSide {
    static Minecraft mc = Minecraft.getMinecraft();
    private static int gameStage = 1;
    private static boolean canRun = true;

    public SideToSide() {
    }

    public static void start() {
        MacroManager.scriptIsOn = true;
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        gameStage = 1;
    }

    public static void main() {
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
                //Minecraft.getMinecraft().thePlayer.sendChatMessage("/sethome");
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                canRun = false;
            } else {
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
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
