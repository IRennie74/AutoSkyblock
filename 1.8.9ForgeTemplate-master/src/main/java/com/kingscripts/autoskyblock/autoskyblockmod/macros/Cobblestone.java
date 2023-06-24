//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.macros;

import com.kingscripts.autoskyblock.autoskyblockmod.handlers.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class Cobblestone {
    static Minecraft mc = Minecraft.getMinecraft();
    public static boolean sneakIsActive = ConfigHandler.getBoolean("toggles", "sneakToggled");
    public static int tickAmount = 1;

    public Cobblestone() {
    }

    public static void start() {
        MacroManager.scriptIsOn = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/sethome");
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
    }

    public static void main() {
        ++tickAmount;
        if (tickAmount % 100 == 0) {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            if (sneakIsActive) {
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            }
        }

    }

    public static void safetyRestart() {
        MacroManager.warpExpected = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/is");
    }
}
