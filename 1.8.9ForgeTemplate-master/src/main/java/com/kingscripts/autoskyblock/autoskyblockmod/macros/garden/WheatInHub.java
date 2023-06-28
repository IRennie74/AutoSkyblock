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

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

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
    public static int delay = 2;
    private static int delayNumber;

    private static float lerp = 0.02f;
    private static int timesAdded = 0;


    public WheatInHub() {
    }
    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event) throws InterruptedException {
            if(MacroManager.scriptIsOn) {
                if (delayNumber % delay == 0) {
                //yaw,pitch,jump,sneak,sprint,left,right,back,forward,attack,useitem
                //11
                if (count1 <= 909) {//1
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count1));
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
                } else if (count <= 909) {//2
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub2.movement2[count][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub2.movement2[count][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count++;
                } else if (count2 <= 909) {//3
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub3.movement2[count2][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count3][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count2][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count2][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count2][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count2][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count2][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count2][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count2][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count2++;
                } else if (count3 <= 909) {//4
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub3.movement2[count3][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count3][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count3][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count3][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count3][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count3][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count3][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count3][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub3.movement2[count3][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count3++;
                } else if (count4 <= 909) {//5
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub4.movement2[count4][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub4.movement2[count4][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub4.movement2[count4][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub4.movement2[count4][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub4.movement2[count4][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub4.movement2[count4][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub4.movement2[count4][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub4.movement2[count4][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub4.movement2[count4][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count4++;
                } else if (count4 <= 909) {//5
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub5.movement2[count36][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub5.movement2[count36][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub5.movement2[count36][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub5.movement2[count36][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub5.movement2[count36][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub5.movement2[count36][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub5.movement2[count36][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub5.movement2[count36][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub5.movement2[count36][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count36++;
                } else if (count5 <= 909) {//6
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub6.movement2[count5][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub6.movement2[count5][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub6.movement2[count5][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub6.movement2[count5][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub6.movement2[count5][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub6.movement2[count5][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub6.movement2[count5][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub6.movement2[count5][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub6.movement2[count5][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count5++;
                } else if (count6 <= 909) {//7
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub7.movement2[count6][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub7.movement2[count6][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub7.movement2[count6][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub7.movement2[count6][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub7.movement2[count6][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub7.movement2[count6][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub7.movement2[count6][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub7.movement2[count6][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub7.movement2[count6][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count6++;
                } else if (count7 <= 909) {//8
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub8.movement2[count7][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub8.movement2[count7][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub8.movement2[count7][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub8.movement2[count7][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub8.movement2[count7][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub8.movement2[count7][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub8.movement2[count7][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub8.movement2[count7][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub8.movement2[count7][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count7++;
                } else if (count8 <= 909) {//9
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub9.movement2[count8][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub9.movement2[count8][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub9.movement2[count8][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub9.movement2[count8][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub9.movement2[count8][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub9.movement2[count8][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub9.movement2[count8][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub9.movement2[count8][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub9.movement2[count8][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count8++;
                } else if (count9 <= 909) {//10
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub10.movement2[count9][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub10.movement2[count9][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub10.movement2[count9][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub10.movement2[count9][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub10.movement2[count9][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub10.movement2[count9][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub10.movement2[count9][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub10.movement2[count9][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub10.movement2[count9][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count9++;
                } else if (count10 <= 909) {//11
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub11.movement2[count10][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub11.movement2[count10][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub11.movement2[count10][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub11.movement2[count10][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub11.movement2[count10][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub11.movement2[count10][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub11.movement2[count10][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub11.movement2[count10][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub11.movement2[count10][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count10++;
                } else if (count11 <= 909) {//12
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub12.movement2[count11][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub12.movement2[count11][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub12.movement2[count11][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub12.movement2[count11][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub12.movement2[count11][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub12.movement2[count11][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub12.movement2[count11][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub12.movement2[count11][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub12.movement2[count11][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count11++;
                } else if (count12 <= 909) {//13
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub13.movement2[count12][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub13.movement2[count12][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub13.movement2[count12][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub13.movement2[count12][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub13.movement2[count12][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub13.movement2[count12][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub13.movement2[count12][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub13.movement2[count12][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub13.movement2[count12][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count12++;
                } else if (count13 <= 909) {//14
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub14.movement2[count13][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub14.movement2[count13][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub14.movement2[count13][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub14.movement2[count13][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub14.movement2[count13][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub14.movement2[count13][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub14.movement2[count13][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub14.movement2[count13][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub14.movement2[count13][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count13++;
                } else if (count14 <= 909) {//15
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub15.movement2[count14][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub15.movement2[count14][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub15.movement2[count14][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub15.movement2[count14][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub15.movement2[count14][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub15.movement2[count14][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub15.movement2[count14][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub15.movement2[count14][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub15.movement2[count14][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count14++;
                } else if (count15 <= 909) {//16
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub16.movement2[count15][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub16.movement2[count15][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub16.movement2[count15][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub16.movement2[count15][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub16.movement2[count15][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub16.movement2[count15][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub16.movement2[count15][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub16.movement2[count15][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub16.movement2[count15][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count15++;
                } else if (count16 <= 909) {//17
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub17.movement2[count16][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub17.movement2[count16][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub17.movement2[count16][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub17.movement2[count16][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub17.movement2[count16][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub17.movement2[count16][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub17.movement2[count16][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub17.movement2[count16][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub17.movement2[count16][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count16++;
                } else if (count17 <= 909) {//18
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub18.movement2[count17][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub18.movement2[count17][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub18.movement2[count17][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub18.movement2[count17][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub18.movement2[count17][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub18.movement2[count17][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub18.movement2[count17][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub18.movement2[count17][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub18.movement2[count17][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count17++;
                } else if (count18 <= 909) {//19
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub19.movement2[count18][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub19.movement2[count18][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub19.movement2[count18][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub19.movement2[count18][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub19.movement2[count18][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub19.movement2[count18][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub19.movement2[count18][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub19.movement2[count18][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub19.movement2[count18][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count18++;
                } else if (count19 <= 909) {//20
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub20.movement2[count19][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub20.movement2[count19][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub20.movement2[count19][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub20.movement2[count19][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub20.movement2[count19][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub20.movement2[count19][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub20.movement2[count19][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub20.movement2[count19][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub20.movement2[count19][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count19++;
                } else if (count20 <= 909) {//21
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub21.movement2[count20][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub21.movement2[count20][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub21.movement2[count20][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub21.movement2[count20][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub21.movement2[count20][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub21.movement2[count20][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub21.movement2[count20][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub21.movement2[count20][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub21.movement2[count20][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count20++;
                } else if (count21 <= 909) {//22
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub22.movement2[count21][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub22.movement2[count21][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub22.movement2[count21][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub22.movement2[count21][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub22.movement2[count21][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub22.movement2[count21][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub22.movement2[count21][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub22.movement2[count21][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub22.movement2[count21][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count21++;
                } else if (count22 <= 909) {//23
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub23.movement2[count22][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub23.movement2[count22][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub23.movement2[count22][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub23.movement2[count22][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub23.movement2[count22][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub23.movement2[count22][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub23.movement2[count22][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub23.movement2[count22][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub23.movement2[count22][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count22++;
                } else if (count23 <= 909) {//24
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub24.movement2[count23][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub24.movement2[count23][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub24.movement2[count23][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub24.movement2[count23][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub24.movement2[count23][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub24.movement2[count23][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub24.movement2[count23][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub24.movement2[count23][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub24.movement2[count23][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count23++;
                } else if (count24 <= 909) {//26
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub26.movement2[count24][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub26.movement2[count24][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub26.movement2[count24][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub26.movement2[count24][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub26.movement2[count24][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub26.movement2[count24][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub26.movement2[count24][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub26.movement2[count24][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub26.movement2[count24][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count24++;
                } else if (count25 <= 909) {//27
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub27.movement2[count25][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub27.movement2[count25][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub27.movement2[count25][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub27.movement2[count25][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub27.movement2[count25][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub27.movement2[count25][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub27.movement2[count25][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub27.movement2[count25][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub27.movement2[count25][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count25++;
                } else if (count26 <= 909) {//28
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub28.movement2[count26][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub28.movement2[count26][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub28.movement2[count26][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub28.movement2[count26][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub28.movement2[count26][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub28.movement2[count26][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub28.movement2[count26][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub28.movement2[count26][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub28.movement2[count26][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count26++;
                } else if (count27 <= 909) {//29
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub29.movement2[count27][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub29.movement2[count27][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub29.movement2[count27][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub29.movement2[count27][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub29.movement2[count27][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub29.movement2[count27][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub29.movement2[count27][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub29.movement2[count27][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub29.movement2[count27][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count27++;
                } else if (count28 <= 909) {//30
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub30.movement2[count28][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub30.movement2[count28][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub30.movement2[count28][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub30.movement2[count28][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub30.movement2[count28][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub30.movement2[count28][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub30.movement2[count28][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub30.movement2[count28][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub30.movement2[count28][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count28++;
                } else if (count29 <= 909) {//31
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub31.movement2[count29][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub31.movement2[count29][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub31.movement2[count29][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub31.movement2[count29][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub31.movement2[count29][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub31.movement2[count29][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub31.movement2[count29][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub31.movement2[count29][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub31.movement2[count29][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count29++;
                } else if (count30 <= 909) {//32
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub32.movement2[count30][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub32.movement2[count30][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub32.movement2[count30][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub32.movement2[count30][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub32.movement2[count30][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub32.movement2[count30][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub32.movement2[count30][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub32.movement2[count30][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub32.movement2[count30][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count30++;
                } else if (count31 <= 909) {//33
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub33.movement2[count31][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub33.movement2[count31][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub33.movement2[count31][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub33.movement2[count31][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub33.movement2[count31][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub33.movement2[count31][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub33.movement2[count31][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub33.movement2[count31][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub33.movement2[count31][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count31++;
                } else if (count32 <= 909) {//8
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub34.movement2[count32][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub34.movement2[count32][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub34.movement2[count32][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub34.movement2[count32][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub34.movement2[count32][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub34.movement2[count32][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub34.movement2[count32][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub34.movement2[count32][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub34.movement2[count32][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count32++;
                } else if (count33 <= 909) {//8
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub35.movement2[count33][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub35.movement2[count33][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub35.movement2[count33][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub35.movement2[count33][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub35.movement2[count33][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub35.movement2[count33][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub35.movement2[count33][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub35.movement2[count33][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub35.movement2[count33][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count33++;
                } else if (count34 <= 909) {//8
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub36.movement2[count34][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub36.movement2[count34][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub36.movement2[count34][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub36.movement2[count34][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub36.movement2[count34][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub36.movement2[count34][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub36.movement2[count34][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub36.movement2[count34][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub36.movement2[count34][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count34++;
                } else if (count35 <= 909) {//8
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
                    if (WheatHub37.movement2[count35][2] == "t") {//jump
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
                    }
                    if (WheatHub37.movement2[count35][3] == "t") {//sneak
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
                    }
                    if (WheatHub37.movement2[count35][4] == "t") {//sprint
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
                    }
                    if (WheatHub37.movement2[count35][5] == "t") {//left
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
                    }
                    if (WheatHub37.movement2[count35][6] == "t") {//right
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
                    }
                    if (WheatHub37.movement2[count35][7] == "t") {//back
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
                    }
                    if (WheatHub37.movement2[count35][8] == "t") {//forward
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
                    }
                    if (WheatHub37.movement2[count35][9] == "t") {//attack
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
                    }
                    if (WheatHub37.movement2[count35][10] == "t") {//useitem
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    } else {
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                    }
                    count35++;
                } else {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
                    start();
                }

                count1++;


//                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + (count / 200)));
//                try {
//                    File myObj = new File("C:\\Mod\\hubWheat.txt");
//                    Scanner myReader = new Scanner(myObj);
//                    while (myReader.hasNextLine()) {
//                        data1 = myReader.nextLine();
//                    }
//                    myReader.close();
//                } catch (FileNotFoundException e) {
//                    System.out.println("An error occurred.");
//                    e.printStackTrace();
//                }
//                if (count % 100 == 0) {
//
//                        //yaw,pitch,jump,sneak,sprint,left,right,back,forward,attack,useitem
////                        Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(data.indexOf(0) + String.valueOf(data.indexOf(1)) + String.valueOf(data.indexOf(2)) + String.valueOf(data.indexOf(3)) + String.valueOf(data.indexOf(4)) + String.valueOf(data.indexOf(5)) + String.valueOf(data.indexOf(6)) + String.valueOf(data.indexOf(7)) + String.valueOf(data.indexOf(8)) + String.valueOf(data.indexOf(9)));
////                        Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(data.indexOf(10) + String.valueOf(data.indexOf(11)) + String.valueOf(data.indexOf(12)) + String.valueOf(data.indexOf(13)) + String.valueOf(data.indexOf(14)) + String.valueOf(data.indexOf(15)) + String.valueOf(data.indexOf(16)) + String.valueOf(data.indexOf(17)) + String.valueOf(data.indexOf(18)) + String.valueOf(data.indexOf(19)));
//                        if (data1.charAt(20) == 't')
//                            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
//                        else KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
//                        if (data1.charAt(21) == 't')
//                            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
//                        else KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
//                        if (data1.charAt(22) == 't')
//                            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
//                        else KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
//                        if (data1.charAt(23) == 't')
//                            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
//                        else KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
//                        if (data1.charAt(24) == 't')
//                            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
//                        else KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
//                        if (data1.charAt(25) == 't')
//                            KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
//                        else KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
//                        if (data1.charAt(26) == 't')
//                            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
//                        else KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
//                        if (data1.charAt(27) == 't')
//                            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
//                        else KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
//                        if (data1.charAt(28) == 't')
//                            KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
//                        else KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
//                    }
//                    count++;


//                    File log = new File("C:\\Mod\\hubWheat.txt");
//                    try{
//                        if(!log.exists()){
//                            System.out.println("We had to make a new file.");
//                            log.createNewFile();
//                        }
//                        PrintWriter out = new PrintWriter(new FileWriter(log, true));
////                        Yaw = String.valueOf(Minecraft.getMinecraft().thePlayer.rotationYaw);
////                        yawL = String.valueOf(Minecraft.getMinecraft().thePlayer.rotationYaw).length();
////                        if(yawL < 10) Yaw += '0';yawL++;
////                        if(yawL < 10) Yaw += '0';yawL++;
////                        if(yawL < 10) Yaw += '0';yawL++;
////                        if(yawL < 10) Yaw += '0';yawL++;
////                        if(yawL < 10) Yaw += '0';yawL++;
////                        if(yawL < 10) Yaw += '0';yawL++;
////                        if(yawL < 10) Yaw += '0';yawL++;
////                        if(yawL < 10) Yaw += '0';yawL++;
////                        Pitch = String.valueOf(Minecraft.getMinecraft().thePlayer.rotationPitch);
////                        pitchL = String.valueOf(Minecraft.getMinecraft().thePlayer.rotationPitch).length();
////                        if(pitchL < 10) Pitch += '0';pitchL++;
////                        if(pitchL < 10) Pitch += '0';pitchL++;
////                        if(pitchL < 10) Pitch += '0';pitchL++;
////                        if(pitchL < 10) Pitch += '0';pitchL++;
////                        if(pitchL < 10) Pitch += '0';pitchL++;
////                        if(pitchL < 10) Pitch += '0';pitchL++;
////                        if(pitchL < 10) Pitch += '0';pitchL++;
////                        if(pitchL < 10) Pitch += '0';pitchL++;
////                        out.append(Yaw);
////                        out.append(Pitch);
////                        if(Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown())out.append("t"); else out.append("f");
////                        if(Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown())out.append("t"); else out.append("f");
////                        if(Minecraft.getMinecraft().gameSettings.keyBindSprint.isKeyDown())out.append("t"); else out.append("f");
////                        if(Minecraft.getMinecraft().gameSettings.keyBindLeft.isKeyDown())out.append("t"); else out.append("f");
////                        if(Minecraft.getMinecraft().gameSettings.keyBindRight.isKeyDown())out.append("t"); else out.append("f");
////                        if(Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown())out.append("t"); else out.append("f");
////                        if(Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown())out.append("t"); else out.append("f");
////                        if(Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown())out.append("t"); else out.append("f");
////                        if(Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown())out.append("t\n"); else out.append("f\n");
//
//                        out.append("{");
//                        out.append("'").append(String.valueOf(Minecraft.getMinecraft().thePlayer.rotationYaw)).append("', ");
//                        out.append("'" + Minecraft.getMinecraft().thePlayer.rotationPitch + "', ");
//                        if(Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown())out.append("'t', "); else out.append("'f', ");
//                        if(Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown())out.append("'t', "); else out.append("'f', ");
//                        if(Minecraft.getMinecraft().gameSettings.keyBindSprint.isKeyDown())out.append("'t', "); else out.append("'f', ");
//                        if(Minecraft.getMinecraft().gameSettings.keyBindLeft.isKeyDown())out.append("'t', "); else out.append("'f', ");
//                        if(Minecraft.getMinecraft().gameSettings.keyBindRight.isKeyDown())out.append("'t', "); else out.append("'f', ");
//                        if(Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown())out.append("'t', "); else out.append("'f', ");
//                        if(Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown())out.append("'t', "); else out.append("'f', ");
//                        if(Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown())out.append("'t', "); else out.append("'f', ");
//                        if(Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown())out.append("'t'},\n"); else out.append("'f'},\n");
//                        out.close();
//                    }catch(IOException ignored){
//                    }
//                    count++;
            }
                delayNumber++;
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
        count = 0;
        count1 = 0;
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        canRunMath = true;
        gameStage = 1;
        timesAdded = 0;
        count = 0;
        count1 = 0;
        Utils.resetPositionIsSame();
        checkForStop = false;
        checkForCamera = false;
    }

    public static void main() {
//        if (MacroManager.scriptIsOn) {
//            convertScript = true;
//            useKeyStrokes = false;
//            if(convertScript){
//
//                //yaw,pitch,jump,sneak,sprint,left,right,back,forward,attack,useitem
//                //11
//                if(count1 <= 909) {
//                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count1));
//                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub.movement[count1][0]);
//                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub.movement[count1][1]);
//                    if (WheatHub.movement[count1][2] == "t") {//jump
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
//                    }
//                    if (WheatHub.movement[count1][3] == "t") {//sneak
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
//                    }
//                    if (WheatHub.movement[count1][4] == "t") {//sprint
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
//                    }
//                    if (WheatHub.movement[count1][5] == "t") {//left
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
//                    }
//                    if (WheatHub.movement[count1][6] == "t") {//right
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
//                    }
//                    if (WheatHub.movement[count1][7] == "t") {//back
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
//                    }
//                    if (WheatHub.movement[count1][8] == "t") {//forward
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
//                    }
//                    if (WheatHub.movement[count1][9] == "t") {//attack
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
//                    }
//                    if (WheatHub.movement[count1][10] == "t") {//useitem
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
//                    }
//                } else if(count <= 460){
//                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "" + count));
//                    Minecraft.getMinecraft().thePlayer.rotationYaw = Float.parseFloat(WheatHub2.movement2[count][0]);
//                    Minecraft.getMinecraft().thePlayer.rotationPitch = Float.parseFloat(WheatHub2.movement2[count][1]);
//                    if (WheatHub2.movement2[count][2] == "t") {//jump
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
//                    }
//                    if (WheatHub2.movement2[count][3] == "t") {//sneak
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
//                    }
//                    if (WheatHub2.movement2[count][4] == "t") {//sprint
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
//                    }
//                    if (WheatHub2.movement2[count][5] == "t") {//left
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
//                    }
//                    if (WheatHub2.movement2[count][6] == "t") {//right
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
//                    }
//                    if (WheatHub2.movement2[count][7] == "t") {//back
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
//                    }
//                    if (WheatHub2.movement2[count][8] == "t") {//forward
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
//                    }
//                    if (WheatHub2.movement2[count][9] == "t") {//attack
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
//                    }
//                    if (WheatHub2.movement2[count][10] == "t") {//useitem
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
//                    } else {
//                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
//                    }
//                    count++;
//                } else {
//                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
//                    start();
//                }
//
//                count1++;
//            }
//
//
//
//
//
//
//            if(useKeyStrokes){
//                File log = new File("D:\\Mod\\hubWheat.txt");
//                try{
//                    if(log.exists()==false){
//                        System.out.println("We had to make a new file.");
//                        log.createNewFile();
//                    }
//                    PrintWriter out = new PrintWriter(new FileWriter(log, true));
//                    out.append("{");
//                    out.append("'" + Minecraft.getMinecraft().thePlayer.rotationYaw + "', ");
//                    out.append("'" + Minecraft.getMinecraft().thePlayer.rotationPitch + "', ");
//                    if(Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown())out.append("'true', "); else out.append("'false', ");
//                    if(Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown())out.append("'true', "); else out.append("'false', ");
//                    if(Minecraft.getMinecraft().gameSettings.keyBindSprint.isKeyDown())out.append("'true', "); else out.append("'false', ");
//                    if(Minecraft.getMinecraft().gameSettings.keyBindLeft.isKeyDown())out.append("'true', "); else out.append("'false', ");
//                    if(Minecraft.getMinecraft().gameSettings.keyBindRight.isKeyDown())out.append("'true', "); else out.append("'false', ");
//                    if(Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown())out.append("'true', "); else out.append("'false', ");
//                    if(Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown())out.append("'true', "); else out.append("'false', ");
//                    if(Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown())out.append("'true', "); else out.append("'false', ");
//                    if(Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown())out.append("'true'},\n"); else out.append("'false'},\n");
//                    out.close();
//                }catch(IOException e){
//                    System.out.println("COULD NOT LOG!!");
//                }
//                count++;
//            }

//        }
    }

    public static void safetyRestart() {
        MacroManager.warpExpected = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
    }
}
