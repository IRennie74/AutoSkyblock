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

        }
    }

    public static void safetyRestart() {
        MacroManager.warpExpected = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
    }
}
