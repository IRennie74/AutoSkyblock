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
    private static int hubLevel = 1;


    public WheatInHub() {
    }
    public static String getWheatHub(int wheatLevel,int count1, int level){
        if(wheatLevel == 1)return WheatHub.movement[count1][level];
        else if(wheatLevel == 2)return WheatHub2.movement2[count1][level];
        else if(wheatLevel == 3)return WheatHub3.movement2[count1][level];
        else if(wheatLevel == 4)return WheatHub4.movement2[count1][level];
        else if(wheatLevel == 5)return WheatHub5.movement2[count1][level];
        else if(wheatLevel == 6)return WheatHub6.movement2[count1][level];
        else if(wheatLevel == 7)return WheatHub7.movement2[count1][level];
        else if(wheatLevel == 8)return WheatHub8.movement2[count1][level];
        else if(wheatLevel == 9)return WheatHub9.movement2[count1][level];
        else if(wheatLevel == 10)return WheatHub10.movement2[count1][level];
        else if(wheatLevel == 11)return WheatHub11.movement2[count1][level];
        else if(wheatLevel == 13)return WheatHub12.movement2[count1][level];
        else if(wheatLevel == 14)return WheatHub13.movement2[count1][level];
        else if(wheatLevel == 15)return WheatHub14.movement2[count1][level];
        else if(wheatLevel == 16)return WheatHub15.movement2[count1][level];
        else if(wheatLevel == 17)return WheatHub16.movement2[count1][level];
        else if(wheatLevel == 18)return WheatHub17.movement2[count1][level];
        else if(wheatLevel == 19)return WheatHub18.movement2[count1][level];
        else if(wheatLevel == 20)return WheatHub19.movement2[count1][level];
        else if(wheatLevel == 21)return WheatHub20.movement2[count1][level];
        else if(wheatLevel == 22)return WheatHub21.movement2[count1][level];
        else if(wheatLevel == 23)return WheatHub22.movement2[count1][level];
        else if(wheatLevel == 24)return WheatHub23.movement2[count1][level];
        else if(wheatLevel == 25)return WheatHub24.movement2[count1][level];
        else if(wheatLevel == 26)return WheatHub26.movement2[count1][level];
        else if(wheatLevel == 27)return WheatHub27.movement2[count1][level];
        else if(wheatLevel == 28)return WheatHub28.movement2[count1][level];
        else if(wheatLevel == 29)return WheatHub29.movement2[count1][level];
        else if(wheatLevel == 30)return WheatHub30.movement2[count1][level];
        else if(wheatLevel == 31)return WheatHub31.movement2[count1][level];
        else if(wheatLevel == 32)return WheatHub32.movement2[count1][level];
        else if(wheatLevel == 33)return WheatHub33.movement2[count1][level];
        else if(wheatLevel == 34)return WheatHub34.movement2[count1][level];
        else if(wheatLevel == 35)return WheatHub35.movement2[count1][level];
        else if(wheatLevel == 36)return WheatHub36.movement2[count1][level];
        else if(wheatLevel == 37)return WheatHub37.movement2[count1][level];
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
    public void onTick(TickEvent.PlayerTickEvent event) throws InterruptedException {
            if(MacroManager.scriptIsOn) {
                if (delayNumber % delay == 0) {
                execute(hubLevel,count1);
                    if(count1 >= 908){
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLACK + "" + hubLevel));
                        count1 = 0;
                        hubLevel++;
                    }
                    count1++;
                }

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
        hubLevel = 1;
        count = 0;
        count1 = 0;
        count2 = 0;
        count3 = 0;
        count4 = 0;
        count5 = 0;
        count6 = 0;
        count7 = 0;
        count8 = 0;
        count9 = 0;
        count10 = 0;
        count11 = 0;
        count12 = 0;
        count13 = 0;
        count14 = 0;
        count15 = 0;
        count16 = 0;
        count17 = 0;
        count18 = 0;
        count19 = 0;
        count20 = 0;
        count21 = 0;
        count22 = 0;
        count23 = 0;
        count24 = 0;
        count25 = 0;
        count26 = 0;
        count27 = 0;
        count28 = 0;
        count29 = 0;
        count30 = 0;
        count31 = 0;
        count32 = 0;
        count33 = 0;
        count34 = 0;
        count35 = 0;
        count36 = 0;
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        canRunMath = true;
        gameStage = 1;
        timesAdded = 0;
        hubLevel = 1;
        count = 0;
        count1 = 0;
        count2 = 0;
        count3 = 0;
        count4 = 0;
        count5 = 0;
        count6 = 0;
        count7 = 0;
        count8 = 0;
        count9 = 0;
        count10 = 0;
        count11 = 0;
        count12 = 0;
        count13 = 0;
        count14 = 0;
        count15 = 0;
        count16 = 0;
        count17 = 0;
        count18 = 0;
        count19 = 0;
        count20 = 0;
        count21 = 0;
        count22 = 0;
        count23 = 0;
        count24 = 0;
        count25 = 0;
        count26 = 0;
        count27 = 0;
        count28 = 0;
        count29 = 0;
        count30 = 0;
        count31 = 0;
        count32 = 0;
        count33 = 0;
        count34 = 0;
        count35 = 0;
        count36 = 0;
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
