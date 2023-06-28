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
    private static int count1 = 0;

    private static int hubLevel = 1;
    private static boolean hasSavedMillis = false;
    private static boolean thisScriptOn = false;
    public static boolean pasting = true;
    private static Instant watch1;
    private static Instant watch2;


    public WheatInHub() {
    }
    public static String getWheatHub(int whichFarm,int wheatLevel,int count1, int level){
        if(whichFarm == 1) {//runs farming
            if (wheatLevel == 1) return WheatHub.movement[count1][level];
            else if (wheatLevel == 2) return WheatHub2.movement2[count1][level];
        } else if (whichFarm == 2) {//runs getting to npc and opening
            return NPC.movement2[count1][level];
        } else if (whichFarm == 3) {//runs going to bazaar and opening
            return Bazaar.movement2[count1][level];
        }
        return null;
    }
    public static void execute(int whichFarm, int hubLevel,int count1) {
        Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(getWheatHub(whichFarm, hubLevel, count1, 0));
        Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(getWheatHub(whichFarm,hubLevel, count1, 1));
        if (getWheatHub(whichFarm, hubLevel, count1, 2) == "t") {//jump
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
        }
        if (getWheatHub(whichFarm, hubLevel, count1, 3) == "t") {//sneak
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
        }
        if (getWheatHub(whichFarm, hubLevel, count1, 4) == "t") {//sprint
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
        }
        if (getWheatHub(whichFarm, hubLevel, count1, 5) == "t") {//left
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
        }
        if (getWheatHub(whichFarm, hubLevel, count1, 6) == "t") {//right
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
        }
        if (getWheatHub(whichFarm, hubLevel, count1, 7) == "t") {//back
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
        }
        if (getWheatHub(whichFarm, hubLevel, count1, 8) == "t") {//forward
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
        }
        if (getWheatHub(whichFarm, hubLevel, count1, 9) == "t") {//attack
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
        }
        if (getWheatHub(whichFarm, hubLevel, count1, 10) == "t") {//useitem
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
                        if(gameStage == 1) {//farms crops and brings you back to hub spawn
                            execute(1,hubLevel, count1);
                            if (count1 >= 909 && hubLevel == 1) {
                                count1 = 0;
                                hubLevel++;
                            } else if (count1 >= 809 && hubLevel == 2) {
                                count1 = 0;
                                hubLevel = 1;
                                gameStage++;
                                Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
                            }
                            count1++;
                        } else if(gameStage == 2){//Brings you to npc
                            if (count1 <= 159 && hubLevel == 1) {//runs script
                                execute(2,1,count1);
                            } else  {
                                count1 = 0;
                                gameStage++;
                            }
                            count1++;
                        } else if(gameStage == 3){//sells inventory and brings you back to hub spawn

                        }
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
                }
                }
            }
    }

    public static void start() {
        MacroManager.scriptIsOn = true;
        Utils.resetPositionIsSame();
        gameStage = 1;
        hubLevel = 1;
        count1 = 0;
        hasSavedMillis = false;
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        gameStage = 1;
        hubLevel = 1;
        count1 = 0;
        Utils.resetPositionIsSame();
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
