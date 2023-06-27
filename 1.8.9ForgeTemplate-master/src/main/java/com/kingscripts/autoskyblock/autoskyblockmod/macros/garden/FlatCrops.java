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
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class FlatCrops {
    static Minecraft mc = Minecraft.getMinecraft();
    private static int gameStage = 1;
    private static int count = 0;
    private static int sideNumber = 1;
    private static double currentSideStop;
    private static boolean sneakEnabled = true;
    private static boolean canRun = true;
    private static boolean checkForStopTop = false;
    private static boolean checkForStopBottom = false;
    private static boolean checkForStopSide = false;
    private static boolean checkForStopSideLeft = false;

    public FlatCrops() {
    }

    public static void start() {
        MacroManager.scriptIsOn = true;
        checkForStopSide = false;
        checkForStopSideLeft = false;
        checkForStopBottom = false;
        checkForStopTop = false;
        sneakEnabled = true;
        sideNumber = 1;
        gameStage = 1;
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        checkForStopSide = false;
        checkForStopSideLeft = false;
        checkForStopBottom = false;
        checkForStopTop = false;
        gameStage = 1;
        sneakEnabled = true;
        sideNumber = 1;
    }

    public static void main() {
        ++count;
        if (count < 20) {
            Utils.resetPositionIsSame();
        }

        if (checkForStopTop) {//checks if the player is running up and should stop
            if(sneakEnabled) {
                if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getZ() <= -139) {
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    sneakEnabled = false;
                }
            } else {
                if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getZ() <= -142.2) {
                    Utils.disableMovementExceptSneak();
                    ++gameStage;
                    checkForStopTop = false;
                    sneakEnabled = true;
                }
            }
        } else if(checkForStopBottom) {//checks if the player is running down and should stop
            if(sneakEnabled) {
                if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getZ() >= -53) {
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    sneakEnabled = false;
                }
            } else {
                if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getZ() >= -49.9) {
                    Utils.disableMovementExceptSneak();
                    ++gameStage;
                    checkForStopBottom = false;
                    sneakEnabled = true;
                }
            }
        } else if(checkForStopSide) {
            if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getX() >= getCurrentSideStop()) {
                Utils.disableMovement();
                ++gameStage;
                checkForStopSide = false;
                sideNumber++;
            }
        } else if(checkForStopSideLeft) {
            if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getX() <= getCurrentSideStop()) {
                Utils.disableMovement();
                ++gameStage;
                checkForStopSideLeft = false;
                sideNumber++;
            }
        } else if (gameStage == 1) {//if check for stop is active then this won't run
            Utils.disableMovement();
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180.0F;
            Minecraft.getMinecraft().thePlayer.rotationPitch = 50.0F;
            ++gameStage;
        } else if (gameStage == 2) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/sethome");
            ++gameStage;
        } else if (gameStage == 3) {//first row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 4) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 5) {//second row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if (gameStage == 6) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 7) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 8) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }else if (gameStage == 9) {//fourth row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if(gameStage == 10) {//jumping over the wooden railing
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 11){//repositioning in first column
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSideLeft = true;
        }
        //second row
        //second group
        //
        else if (gameStage == 12) {//2nd group
            sneakEnabled = true;
            Utils.disableMovement();
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 13) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 14) {//second row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if (gameStage == 15) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 16) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 17) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }else if (gameStage == 18) {//fourth row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }  else if (gameStage == 19) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 20) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 21) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 22) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }else if (gameStage == 23) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 24) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 25) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 26) {//fourth row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if(gameStage == 27) {//jumping over the wooden railing
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 28) {//repositioning in first column
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSideLeft = true;
        }

            //3rd row
        //3rd group
        //
        else if (gameStage == 29) {//first row
            sneakEnabled = true;
            Utils.disableMovement();
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 30) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 31) {//second row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if (gameStage == 32) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 33) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 34) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }else if (gameStage == 35) {//fourth row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }  else if (gameStage == 36) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 37) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 38) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 39) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }else if (gameStage == 40) {//doesnt work
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 41) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 42) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 43) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if(gameStage == 44) {//jumping over the wooden railing
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 45){//repositioning in first column
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSideLeft = true;
        }
        //4th group
        //
        else if (gameStage == 46) {//first row
            sneakEnabled = true;
            Utils.disableMovement();
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 47) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 48) {//second row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if (gameStage == 49) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 50) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 51) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }else if (gameStage == 52) {//fourth row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }  else if (gameStage == 53) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 54) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 55) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 56) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }else if (gameStage == 57) {//doesnt work
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 58) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 59) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 60) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if(gameStage == 61) {//jumping over the wooden railing
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 62){//repositioning in first column
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSideLeft = true;
        }
        //5th group
        //
        else if (gameStage == 63) {//first row
            sneakEnabled = true;
            Utils.disableMovement();
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 64) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 65) {//second row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if (gameStage == 66) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 67) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 68) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }else if (gameStage == 69) {//fourth row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }  else if (gameStage == 70) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 71) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 72) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 73) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }else if (gameStage == 74) {//doesnt work
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 75) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 76) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 77) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if(gameStage == 78) {//jumping over the wooden railing
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 79){//repositioning in first column
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSideLeft = true;
        }
        //6th group
        //
        else if (gameStage == 80) {//first row
            sneakEnabled = true;
            Utils.disableMovement();
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 81) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 82) {//second row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if (gameStage == 83) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 84) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 85) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }else if (gameStage == 86) {//fourth row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }  else if (gameStage == 87) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 88) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 89) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 90) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }else if (gameStage == 91) {//doesnt work
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 92) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 93) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 94) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if(gameStage == 95) {//jumping over the wooden railing
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 96){//repositioning in first column
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSideLeft = true;
        }
        //7th group
        //
        else if (gameStage == 97) {//first row
            sneakEnabled = true;
            Utils.disableMovement();
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 98) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 99) {//second row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if (gameStage == 100) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 101) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 102) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }else if (gameStage == 103) {//fourth row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }  else if (gameStage == 104) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 105) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 106) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 107) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }else if (gameStage == 108) {//doesnt work
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 109) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 110) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 111) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if(gameStage == 112) {//jumping over the wooden railing
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 113){//repositioning in first column
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSideLeft = true;
        }
        //8th group
        //
        else if (gameStage == 114) {//first row
            sneakEnabled = true;
            Utils.disableMovement();
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 115) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 116) {//second row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if (gameStage == 117) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 118) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 119) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }else if (gameStage == 120) {//fourth row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }  else if (gameStage == 121) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 122) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 123) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 124) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }else if (gameStage == 125) {//doesnt work
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 126) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 127) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 128) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if(gameStage == 129) {//jumping over the wooden railing
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 130){//repositioning in first column
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSideLeft = true;
        }
        //9th group
        else if (gameStage == 131) {//first row
            sneakEnabled = true;
            Utils.disableMovement();
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 132) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 133) {//second row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if (gameStage == 134) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 135) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 136) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }else if (gameStage == 137) {//fourth row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }  else if (gameStage == 138) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 139) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 140) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 141) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }else if (gameStage == 142) {//doesnt work
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 143) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 144) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 145) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if(gameStage == 146) {//jumping over the wooden railing
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 147){//repositioning in first column
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSideLeft = true;
        }
        //10th group
        //
        else if (gameStage == 148) {//first row
            sneakEnabled = true;
            Utils.disableMovement();
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 149) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 150) {//second row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if (gameStage == 151) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 152) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 153) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }else if (gameStage == 154) {//fourth row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }  else if (gameStage == 155) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 156) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 157) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 158) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        }else if (gameStage == 159) {//doesnt work
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 160) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 161) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 162) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if(gameStage == 163) {//jumping over the wooden railing
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
            checkForStopSide = true;
        }  else if (gameStage == 164){//repositioning in first column
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSideLeft = true;
        }
        //11th group
        //
        else if (gameStage == 165) {//first row
            sneakEnabled = true;
            Utils.disableMovement();
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 166) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 167) {//second row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if (gameStage == 168) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 180F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
            checkForStopSide = true;
        } else if (gameStage == 169) {//third row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopTop = true;
        } else if (gameStage == 170) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = 0F;
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
            checkForStopSide = true;
        }else if (gameStage == 171) {//fourth row
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
            checkForStopBottom = true;
        } else if (gameStage == 172) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp garden");
            checkForStopSide = false;
            checkForStopSideLeft = false;
            checkForStopBottom = false;
            checkForStopTop = false;
            sneakEnabled = true;
            sideNumber = 1;
            gameStage = 1;
        }
    }

    public static void safetyRestart() {
        MacroManager.warpExpected = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp garden");
        gameStage = 1;
    }
    public static double getCurrentSideStop() {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "" + sideNumber + ""));
        if (sideNumber == 1) {//2nd row stop (top)
            return -43.5;
        } else if (sideNumber == 2) {//3rd row stop (bottom)
            return -42.5;
        } else if (sideNumber == 3) {//4th row stop (top)
            return -41.5;
        }else if (sideNumber == 4) {//when to stop jumping
            return -38;
        }else if (sideNumber == 5) {//where to reposition to
            return -39;
            //changes to forward on the 2nd group

        }else if (sideNumber == 6) {//where to reposition to
            return -38.5;
        }else if (sideNumber == 7) {//where to reposition to
            return -37.5;
        }else if (sideNumber == 8) {//where to reposition to
            return -36.5;
        }else if (sideNumber == 9) {//where to reposition to
            return -35.5;
        }else if (sideNumber == 10) {//where to reposition to
            return -34.5;
        }else if (sideNumber == 11) {//where to reposition to
            return -33.5;
        }else if (sideNumber == 12) {//where to reposition to
            return -32.5;
        } else if (sideNumber == 13) {//starts the log jumping
            return -28;
        }else if (sideNumber == 14) {//starts the log jumping
            return -30.1;
        }
        // changes 3rd group
        else if (sideNumber == 15) {//where to reposition to
            return -29.5;
        } else if (sideNumber == 16) {//where to reposition to
            return -28.5;
        }else if (sideNumber == 17) {//where to reposition to
            return -27.5;
        }else if (sideNumber == 18) {//where to reposition to
            return -26.5;
        }else if (sideNumber == 19) {//where to reposition to
            return -25.5;
        }else if (sideNumber == 20) {//where to reposition to  //doesn't work
            return -24.5;
        }else if (sideNumber == 21) {//where to reposition to
            return -23.5;
        }else if (sideNumber == 22) {//starts the log jumping
            return -18;
        }else if (sideNumber == 23) {//starts the log jumping
            return -21;
        }
        //4th group
        //
        else if (sideNumber == 24) {//where to reposition to
            return -20.5;
        }else if (sideNumber == 25) {//where to reposition to
            return -19.5;
        }else if (sideNumber == 26) {//where to reposition to
            return -18.5;
        }else if (sideNumber == 27) {//where to reposition to
            return -17.5;
        }else if (sideNumber == 28) {//where to reposition to
            return -16.5;
        }else if (sideNumber == 29) {//where to reposition to
            return -15.5;
        }else if (sideNumber == 30) {//where to reposition to
            return -14.5;
        } else if (sideNumber == 31) {//mid-air stop
            return -12;
        }else if (sideNumber == 32) {//re alignment/ where the next group starts
            return -12.5;
        }
        //5th group (not done) (not done) (not done) (not done) (not done)
        //
        else if (sideNumber == 33) {//where to reposition to
            return -11.5;
        }else if (sideNumber == 34) {//where to reposition to
            return -10.5;
        }else if (sideNumber == 35) {//where to reposition to
            return -9.5;
        }else if (sideNumber == 36) {//where to reposition to
            return -8.5;
        }else if (sideNumber == 37) {//where to reposition to
            return -7.5;
        }else if (sideNumber == 38) {//where to reposition to
            return -6.5;
        }else if (sideNumber == 39) {//where to reposition to
            return -5.5;
        } else if (sideNumber == 40) {//mid-air stop
            return -3;
        }else if (sideNumber == 41) {//re alignment/ where the next group starts
            return -3.5;
        }
        //6th group
        //
        else if (sideNumber == 42) {//where to reposition to
            return -2.5;
        }else if (sideNumber == 43) {//where to reposition to
            return -1.5;
        }else if (sideNumber == 44) {//where to reposition to
            return -0.5;
        }else if (sideNumber == 45) {//where to reposition to
            return 0.5;
        }else if (sideNumber == 46) {//where to reposition to
            return 1.5;
        }else if (sideNumber == 47) {//where to reposition to
            return 2.5;
        }else if (sideNumber == 48) {//where to reposition to
            return 3.5;
        } else if (sideNumber == 49) {//mid-air stop
            return 6;
        }else if (sideNumber == 50) {//re alignment/ where the next group starts
            return 5.5;
        }
        //7th group
        //
        else if (sideNumber == 51) {//where to reposition to
            return 6.5;
        }else if (sideNumber == 52) {//where to reposition to
            return 7.5;
        }else if (sideNumber == 53) {//where to reposition to
            return 8.5;
        }else if (sideNumber == 54) {//where to reposition to
            return 9.5;
        }else if (sideNumber == 55) {//where to reposition to
            return 10.5;
        }else if (sideNumber == 56) {//where to reposition to
            return 11.5;
        }else if (sideNumber == 57) {//where to reposition to
            return 12.5;
        } else if (sideNumber == 58) {//mid-air stop
            return 15;
        }else if (sideNumber == 59) {//re alignment/ where the next group starts
            return 14.5;
        }
        //8th group
        //
        else if (sideNumber == 60) {//where to reposition to
            return 15.5;
        }else if (sideNumber == 61) {//where to reposition to
            return 16.5;
        }else if (sideNumber == 62) {//where to reposition to
            return 17.5;
        }else if (sideNumber == 63) {//where to reposition to
            return 18.5;
        }else if (sideNumber == 64) {//where to reposition to
            return 19.5;
        }else if (sideNumber == 65) {//where to reposition to
            return 20.5;
        }else if (sideNumber == 66) {//where to reposition to
            return 21.5;
        } else if (sideNumber == 67) {//mid-air stop
            return 24;
        }else if (sideNumber == 68) {//re alignment/ where the next group starts
            return 23.5;
        }
        //9th group
        //
        else if (sideNumber == 69) {//where to reposition to
            return 24.5;
        }else if (sideNumber == 70) {//where to reposition to
            return 25.5;
        }else if (sideNumber == 71) {//where to reposition to
            return 26.5;
        }else if (sideNumber == 72) {//where to reposition to
            return 27.5;
        }else if (sideNumber == 73) {//where to reposition to
            return 28.5;
        }else if (sideNumber == 74) {//where to reposition to
            return 29.5;
        }else if (sideNumber == 75) {//where to reposition to
            return 30.5;
        } else if (sideNumber == 76) {//mid-air stop
            return 33;
        }else if (sideNumber == 77) {//re alignment/ where the next group starts
            return 32.5;
        }
        //10th group
        //
        else if (sideNumber == 78) {//where to reposition to
            return 33.5;
        }else if (sideNumber == 79) {//where to reposition to
            return 34.5;
        }else if (sideNumber == 80) {//where to reposition to
            return 35.5;
        }else if (sideNumber == 81) {//where to reposition to
            return 36.5;
        }else if (sideNumber == 82) {//where to reposition to
            return 37.5;
        }else if (sideNumber == 83) {//where to reposition to
            return 38.5;
        }else if (sideNumber == 84) {//where to reposition to
            return 39.5;
        } else if (sideNumber == 85) {//mid-air stop
            return 42;
        }else if (sideNumber == 86) {//re alignment/ where the next group starts
            return 41.5;
        }
        //11th group
        //
        else if (sideNumber == 87) {//where to reposition to
            return 42.5;
        }else if (sideNumber == 88) {//where to reposition to
            return 43.5;
        }else if (sideNumber == 89) {//where to reposition to
            return 44.5;
        } else if (sideNumber == 90) {//mid-air stop
            return 45.5;
        }else if (sideNumber == 91) {//re alignment/ where the next group starts
            return 46.5;
        }

        return 0;
    }
}
