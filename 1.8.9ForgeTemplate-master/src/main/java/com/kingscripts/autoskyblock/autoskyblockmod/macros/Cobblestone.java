//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.macros;

import com.kingscripts.autoskyblock.autoskyblockmod.handlers.ConfigHandler;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class Cobblestone {
    static Minecraft mc = Minecraft.getMinecraft();
    public static boolean sneakIsActive = ConfigHandler.getBoolean("toggles", "sneakToggled");
    public static int tickAmount = 1;
    private static int initiatedMouseSafety = 0;
    private static float Yaw;
    private static float Pitch;
    private static float lerp = 0.1f;

    public Cobblestone() {
    }

    public static void start() {
        MacroManager.scriptIsOn = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/sethome");
        Yaw =Minecraft.getMinecraft().thePlayer.rotationYaw;
        Pitch = Minecraft.getMinecraft().thePlayer.rotationPitch;
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
    }

    public static void main() {

        if(Minecraft.getMinecraft().thePlayer.rotationYaw != Yaw || Minecraft.getMinecraft().thePlayer.rotationPitch != Pitch) {
        if(initiatedMouseSafety == 0) {//initiates mouse safety so that you do not get banned
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "WARNING--MACRO CHECK--WARNING"));
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Initiating mouse check safety"));
        } else if(initiatedMouseSafety == 100){
            //disabling movement
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Disabling Movement"));
            Utils.disableMovement();
        } else if (initiatedMouseSafety == 170){
            //waiting to give it some realistic time
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Waiting..."));
        } else if (initiatedMouseSafety >= 301) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/is");
        }
        initiatedMouseSafety ++;

    } else {
        initiatedMouseSafety = 0;

        ++tickAmount;
        if (tickAmount % 100 == 0) {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            if (sneakIsActive) {
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            }
        }
    }
    }

    public static void safetyRestart() {
        MacroManager.warpExpected = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/is");
    }
}
