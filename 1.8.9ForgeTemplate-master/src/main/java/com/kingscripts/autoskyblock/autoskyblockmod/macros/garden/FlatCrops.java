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
                if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getZ() <= -138) {
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    sneakEnabled = false;
                }
            } else {
                if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getZ() <= -142.3) {
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
                if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getZ() >= -49.7) {
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
        else if (gameStage == 12) {//first row
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
        }else if (gameStage == 40) {
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
    }

    public static void safetyRestart() {
        MacroManager.warpExpected = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp garden");
        gameStage = 1;
    }
    public static double getCurrentSideStop() {
        if (sideNumber == 1) {//2nd row stop (top)
            return -43.5;
        } else if (sideNumber == 2) {//3rd row stop (bottom)
            return -42.5;
        } else if (sideNumber == 3) {//4th row stop (top)
            return -41.5;
        }else if (sideNumber == 4) {//when to stop jumping
            return -38;
        }else if (sideNumber == 5) {//where to reposition to
            return -39.1;
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
        }else if (sideNumber == 21) {//where to reposition to
            return -24.5;
        }else if (sideNumber == 22) {//where to reposition to
            return -23.5;
        }else if (sideNumber == 23) {//where to reposition to
            return -22.5;
        }else if (sideNumber == 24) {//starts the log jumping
            return -18;
        }else if (sideNumber == 25) {//starts the log jumping
            return -19.1;
        }

        return 0;
    }
}
