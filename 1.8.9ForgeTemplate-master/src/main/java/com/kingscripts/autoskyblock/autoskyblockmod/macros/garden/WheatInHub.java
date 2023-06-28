//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.macros.garden;

import com.kingscripts.autoskyblock.autoskyblockmod.macros.MacroManager;
//import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.savedscripts.WheatHub;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.savedscripts.*;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.commons.lang3.time.StopWatch;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.round;

public class WheatInHub {
    static Minecraft mc = Minecraft.getMinecraft();
    public static int gameStage = 1;
    private static boolean useKeyStrokes = false;
    private static int count = 0;
    private static int count1 = 0;
    private static int count2 = 0;
    private static int count3 = 0;
    private static int count4 = 0;
    private static int count5 = 0;
    private static int count6 = 0;
    private static int count7 = 0;
    private static int count8 = 0;
    private static int count9 = 0;
    private static int count10 = 0;
    private static int count11 = 0;
    private static int count12 = 0;
    private static int count13 = 0;
    private static int count14 = 0;
    private static int count15 = 0;
    private static int count16 = 0;
    private static int count17 = 0;
    private static int count18 = 0;
    private static int count19 = 0;
    private static int count20 = 0;
    private static int count21 = 0;
    private static int count22 = 0;
    private static int count23 = 0;
    private static int count24 = 0;
    private static int count25 = 0;
    private static int count26 = 0;
    private static int count27 = 0;
    private static int count28 = 0;
    private static int count29 = 0;
    private static int count30 = 0;
    private static int count31 = 0;
    private static int count32 = 0;
    private static int count33 = 0;
    private static int count34 = 0;
    private static int count35 = 0;
    private static int count36 = 0;
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
    private static String Yaw;
    private static String Pitch;
    private static char c;
    private static String d;
    private static int yawL;
    private static int pitchL;
    private static String data1;
    public static double delay = 2;
    private static double delayNumber;

    private static float lerp = 0.02f;
    private static int timesAdded = 0;
    private static int hubLevel = 1;
    private static long startMillis = 0;
    private static boolean hasSavedMillis = false;
    private static boolean thisScriptOn = false;
    public static boolean pasting = true;
    private static long lastSavedDivision;
    private static Instant watch1;
    private static Instant watch2;


    public WheatInHub() {
    }
    public static String getWheatHub(int wheatLevel,int count1, int level){
        if(wheatLevel == 1)return WheatHub.movement[count1][level];
        else if(wheatLevel == 2)return WheatHub2.movement2[count1][level];
        else return null;
    }
    public static void execute(int hubLevel,int count1) {
        Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(getWheatHub(hubLevel, count1, 0));
        Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(getWheatHub(hubLevel, count1, 1));
        if (getWheatHub(hubLevel, count1, 2) == "t") {//jump
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
        }
        if (getWheatHub(hubLevel, count1, 3) == "t") {//sneak
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
        }
        if (getWheatHub(hubLevel, count1, 4) == "t") {//sprint
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
        }
        if (getWheatHub(hubLevel, count1, 5) == "t") {//left
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
        }
        if (getWheatHub(hubLevel, count1, 6) == "t") {//right
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
        }
        if (getWheatHub(hubLevel, count1, 7) == "t") {//back
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
        }
        if (getWheatHub(hubLevel, count1, 8) == "t") {//forward
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
        }
        if (getWheatHub(hubLevel, count1, 9) == "t") {//attack
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
        }
        if (getWheatHub(hubLevel, count1, 10) == "t") {//useitem
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
        }
    }
    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event){
            if(MacroManager.scriptIsOn) {
                if(pasting) {
                    if (!hasSavedMillis) {
                        watch1 = Instant.now();
                        hasSavedMillis = true;
                    }
                    watch2 = Instant.now();
                    if ((Duration.between(watch1, watch2).toMillis()) >= 10) {
                        hasSavedMillis = false;
                        execute(hubLevel, count1);
                        if (count1 >= 909 && hubLevel == 1) {
                            count1 = 0;
                            hubLevel++;
                        }else if (count1 >= 809 && hubLevel == 2) {
                            count1 = 0;
                            hubLevel = 1;
                            Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
                        }
                        count1++;
                    }
                } else {
                if(!hasSavedMillis){
                    watch1 = Instant.now();
                    hasSavedMillis = true;
                }

                // call to the methods you want to benchmark
                watch2 = Instant.now();
                if((Duration.between(watch1, watch2).toMillis()) >= 10) {
                    hasSavedMillis = false;
//                    lastSavedDivision = (System.currentTimeMillis() - startMillis) / 25;
                    File log = new File("C:\\Mod\\hubWheat.txt");
                    try {
                        if (!log.exists()) {
                            System.out.println("We had to make a new file.");
                            log.createNewFile();
                        }
                        PrintWriter out = new PrintWriter(new FileWriter(log, true));
                        out.append("{");
                        out.append("'").append(String.valueOf(Minecraft.getMinecraft().thePlayer.rotationYaw)).append("', ");
                        out.append("'" + Minecraft.getMinecraft().thePlayer.rotationPitch + "', ");
                        if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) out.append("'t', ");
                        else out.append("'f', ");
                        if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown()) out.append("'t', ");
                        else out.append("'f', ");
                        if (Minecraft.getMinecraft().gameSettings.keyBindSprint.isKeyDown()) out.append("'t', ");
                        else out.append("'f', ");
                        if (Minecraft.getMinecraft().gameSettings.keyBindLeft.isKeyDown()) out.append("'t', ");
                        else out.append("'f', ");
                        if (Minecraft.getMinecraft().gameSettings.keyBindRight.isKeyDown()) out.append("'t', ");
                        else out.append("'f', ");
                        if (Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown()) out.append("'t', ");
                        else out.append("'f', ");
                        if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown()) out.append("'t', ");
                        else out.append("'f', ");
                        if (Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown()) out.append("'t', ");
                        else out.append("'f', ");
                        if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown()) out.append("'t'},\n");
                        else out.append("'f'},\n");
                        out.close();
                    } catch (IOException ignored) {
                    }
//                    count++;
//                    delayNumber++;
                }
                }
            }
    }

    public static void start() {
        MacroManager.scriptIsOn = true;
        Utils.resetPositionIsSame();
        checkForStop = false;
        checkForCamera = false;
        canRunMath = true;
        timesAdded = 0;
        gameStage = 1;
        hubLevel = 1;
        count = 0;
        count1 = 0;
        startMillis = 0;
        hasSavedMillis = false;
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        canRunMath = true;
        gameStage = 1;
        timesAdded = 0;
        hubLevel = 1;
        count = 0;
        count1 = 0;
        Utils.resetPositionIsSame();
        checkForStop = false;
        checkForCamera = false;
        startMillis = 0;
        hasSavedMillis = false;
    }
    public static void main(){
        thisScriptOn = true;
    }

    public static void safetyRestart() {
        MacroManager.warpExpected = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
    }
}
