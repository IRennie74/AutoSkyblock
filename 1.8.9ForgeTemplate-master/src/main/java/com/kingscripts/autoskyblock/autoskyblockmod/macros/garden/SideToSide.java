//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.macros.garden;

import com.kingscripts.autoskyblock.autoskyblockmod.macros.MacroManager;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class SideToSide {
    static Minecraft mc = Minecraft.getMinecraft();
    private static int gameStage = 1;
    private static boolean canRun = true;
    private static float Yaw;
    private static float Pitch;
    private static int initiatedMouseSafety = 0;

    public SideToSide() {
    }

    public static void start() {
        MacroManager.scriptIsOn = true;
        Yaw = Minecraft.getMinecraft().thePlayer.rotationYaw;
        Pitch = Minecraft.getMinecraft().thePlayer.rotationPitch;
        initiatedMouseSafety = 0;
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        initiatedMouseSafety = 0;
        gameStage = 1;
    }

    public static void main() {
        if(Minecraft.getMinecraft().thePlayer.rotationYaw != Yaw || Minecraft.getMinecraft().thePlayer.rotationPitch != Pitch ) {
            if(initiatedMouseSafety == 0) {//initiates mouse safety so that you do not get banned
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "WARNING--MACRO CHECK--WARNING"));
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Initiating mouse check safety"));
            } else if(initiatedMouseSafety == 20){
                //disabling movement
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Disabling Movement"));
                Utils.disableMovement();
            } else if (initiatedMouseSafety == 30){
                //waiting to give it some realistic time
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Waiting..."));
            } else if (initiatedMouseSafety == 80) {
                //move camera angle back to normal
                Minecraft.getMinecraft().thePlayer.rotationYaw = Yaw;
                Minecraft.getMinecraft().thePlayer.rotationPitch = Pitch;
                gameStage ++;
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Resuming Script"));
            }
            initiatedMouseSafety ++;

        } else {
            initiatedMouseSafety = 0;
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
    }

    public static void safetyRestart() {
        MacroManager.warpExpected = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp garden");
    }
}
