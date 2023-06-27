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
    private static boolean checkForStop = false;
    private static double currentStopX;
    private static double currentStopZ;
    private static int xStopDirection;
    private static int zStopDirection;


    public WheatInHub() {
    }

    public static void start() {
        MacroManager.scriptIsOn = true;
        Utils.resetPositionIsSame();
        checkForStop = false;
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        gameStage = 1;
        count = 1;
        Utils.resetPositionIsSame();
        checkForStop = false;
    }

    public static void main() {
        if (MacroManager.scriptIsOn) {
            if(checkForStop){//if check for stop is active then only check for stops runs because it is constantly
                // checking to see if the player has passed a set of coordinates
                //Check X first
                if(xStopDirection != 0){//checks if X is inactive
                    if(xStopDirection > 0){//checks to see which direction we are checking in
                        if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getX() >= currentStopX) {
                            //the player has passed the checkpoint
                            gameStage++;
                            checkForStop = false;
                            xStopDirection = 0;
                        }
                    } else {//has to be smaller if it's not bigger
                        if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getX() <= currentStopX) {
                            //the player has passed the checkpoint
                            gameStage++;
                            checkForStop = false;
                            xStopDirection = 0;
                        }
                    }

                } else {//it checks if stop is active and if X is inactive then Z has to be active
                    if(zStopDirection > 0){//checks to see which direction we are checking in
                        if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getZ() >= currentStopZ) {
                            //the player has passed the checkpoint
                            gameStage++;
                            checkForStop = false;
                            zStopDirection = 0;
                        }
                    } else {//has to be smaller if it's not bigger
                        if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getZ() <= currentStopZ) {
                            //the player has passed the checkpoint
                            gameStage++;
                            checkForStop = false;
                            zStopDirection = 0;
                        }
                    }
                }
            }else{//not checking for stop so the rest of the script can be executed

                if (gameStage == 1) {
                    //look at -137.5/1.2

                } else if (gameStage == 2) {
                    //run jump until 19/ /-93
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    //makes the program start checking if the player has reached the coordinates 19
                    currentStopX = 19;
                    xStopDirection = 1;
                    checkForStop = true;
                } else if (gameStage == 3) {
                    //run jump
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                }
            }
        }
    }

    public static void safetyRestart() {
        MacroManager.warpExpected = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
    }
}
