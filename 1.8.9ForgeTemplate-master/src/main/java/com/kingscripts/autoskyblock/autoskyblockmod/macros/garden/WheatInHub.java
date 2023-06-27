//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.macros.garden;

import com.kingscripts.autoskyblock.autoskyblockmod.macros.MacroManager;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.savedscripts.WheatHub;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.savedscripts.WheatHub2;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import java.io.*;

public class WheatInHub {
    static Minecraft mc = Minecraft.getMinecraft();
    public static int gameStage = 1;
    private static boolean useKeyStrokes = false;
    private static int count = 0;
    private static int count1 = 0;
    private static boolean convertScript = false;
    private static boolean checkForStop = false;
    private static boolean checkForCamera = false;
    private static boolean canRunMath = true;
    private static boolean useLerp2;
    private static double currentStopX;
    private static double currentStopZ;
    private static int xStopDirection;
    private static int zStopDirection;
    private static float yawAdd;
    private static float pitchAdd;
    private static float Yaw;
    private static float Pitch;

    private static float lerp = 0.02f;
    private static int timesAdded = 0;


    public WheatInHub() {
    }

    public static void start() {
        File log = new File("D:\\Mod\\hubWheat.txt");
        try{
            if(log.exists()==false){
                System.out.println("We had to make a new file.");
                log.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.close();
        }catch(IOException e){
            System.out.println("COULD NOT LOG!!");
        }

        MacroManager.scriptIsOn = true;
        Utils.resetPositionIsSame();
        checkForStop = false;
        checkForCamera = false;
        canRunMath = true;
        timesAdded = 0;
        gameStage = 1;
        count = 1;
        count1 = 0;
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        canRunMath = true;
        gameStage = 1;
        timesAdded = 0;
        count = 1;
        count1 = 0;
        Utils.resetPositionIsSame();
        checkForStop = false;
        checkForCamera = false;
    }

    public static void main() {
        if (MacroManager.scriptIsOn) {
            convertScript = true;
            useKeyStrokes = false;
            if(convertScript){

                //yaw,pitch,jump,sneak,sprint,left,right,back,forward,attack,useitem
                //11
                if(count1 <= 914) {
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub.movement[count1][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub.movement[count1][1]);
                    if (WheatHub.movement[count1][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub.movement[count1][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub.movement[count1][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub.movement[count1][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub.movement[count1][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub.movement[count1][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub.movement[count1][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub.movement[count1][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub.movement[count1][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                } else {
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count1][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count1][1]);
                    if (WheatHub2.movement2[count1][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count1][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count1][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count1][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count1][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count1][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count1][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count1][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count1][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                }

                count1++;
            }






            if(useKeyStrokes){
                File log = new File("D:\\Mod\\hubWheat.txt");
                try{
                    if(log.exists()==false){
                        System.out.println("We had to make a new file.");
                        log.createNewFile();
                    }
                    PrintWriter out = new PrintWriter(new FileWriter(log, true));
                    out.append("{");
                    out.append("'" + Minecraft.getMinecraft().thePlayer.rotationYaw + "', ");
                    out.append("'" + Minecraft.getMinecraft().thePlayer.rotationPitch + "', ");
                    if(Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown())out.append("'true', "); else out.append("'false', ");
                    if(Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown())out.append("'true', "); else out.append("'false', ");
                    if(Minecraft.getMinecraft().gameSettings.keyBindSprint.isKeyDown())out.append("'true', "); else out.append("'false', ");
                    if(Minecraft.getMinecraft().gameSettings.keyBindLeft.isKeyDown())out.append("'true', "); else out.append("'false', ");
                    if(Minecraft.getMinecraft().gameSettings.keyBindRight.isKeyDown())out.append("'true', "); else out.append("'false', ");
                    if(Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown())out.append("'true', "); else out.append("'false', ");
                    if(Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown())out.append("'true', "); else out.append("'false', ");
                    if(Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown())out.append("'true', "); else out.append("'false', ");
                    if(Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown())out.append("'true'},\n"); else out.append("'false'},\n");
                    out.close();
                }catch(IOException e){
                    System.out.println("COULD NOT LOG!!");
                }
                count++;
            }

        }
    }

    public static void safetyRestart() {
        MacroManager.warpExpected = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
    }
}
