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
    private static float yawAdd;
    private static float pitchAdd;
    private static int initiatedMouseSafety = 0;
    private static int savedGameStage;
    private static int randomMessage = 0;
    private static float lerp = 0.1f;
    private static int timesAdded = 0;

    public SideToSide() {
    }

    public static void start() {
        MacroManager.scriptIsOn = true;
        Yaw = Minecraft.getMinecraft().thePlayer.rotationYaw;
        Pitch = Minecraft.getMinecraft().thePlayer.rotationPitch;
        initiatedMouseSafety = 0;
        timesAdded = 0;
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        initiatedMouseSafety = 0;
        gameStage = 1;
        timesAdded = 0;
    }

    public static void main() {
        if(Minecraft.getMinecraft().thePlayer.rotationYaw != Yaw || Minecraft.getMinecraft().thePlayer.rotationPitch != Pitch) {
            if(initiatedMouseSafety == 0) {//initiates mouse safety so that you do not get banned
                savedGameStage = gameStage;
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "WARNING--MACRO CHECK--WARNING"));
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Initiating mouse check safety"));
            } else if(initiatedMouseSafety == 20){
                //disabling movement
                randomMessage = Utils.randomWithRange(1,10);
                if(randomMessage == 1) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("LOL");
                } else if(randomMessage == 2) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("WTH");
                } else if(randomMessage == 3) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("STFU");
                } else if(randomMessage == 4) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("bruh");
                } else if(randomMessage == 5) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("WTF");
                } else if(randomMessage == 6) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("WOW");
                } else if(randomMessage == 7) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("whoa");
                }else if(randomMessage == 8) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("lol");
                }else if(randomMessage == 9) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("wow");
                }else {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("LMAO");
                }
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Disabling Movement"));
                Utils.disableMovement();
            } else if (initiatedMouseSafety == 30){
                //waiting to give it some realistic time
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Waiting..."));
            } else if (initiatedMouseSafety == 100) {
                yawAdd = Utils.lerp(Minecraft.getMinecraft().thePlayer.rotationYaw, Yaw, lerp);//initial yaw math
                pitchAdd = Utils.lerp(Minecraft.getMinecraft().thePlayer.rotationPitch, Pitch, lerp);//initial yaw math
            } else if (initiatedMouseSafety >= 101) {
                //move camera angle back to normal
                if(1 / lerp >= timesAdded){//looped adding yaw
                    Minecraft.getMinecraft().thePlayer.rotationYaw += yawAdd;
                    Minecraft.getMinecraft().thePlayer.rotationPitch += pitchAdd;
                } else{//good to run script
                    gameStage = savedGameStage + 1;
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Resuming Script"));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Yaw;
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Pitch;
                }
                timesAdded++;// end of looped adding yaw
            }
            initiatedMouseSafety ++;

        } else {
            initiatedMouseSafety = 0;
            timesAdded = 0;
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