//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.macros.garden;

import com.kingscripts.autoskyblock.autoskyblockmod.AutoSkyblock;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.MacroManager;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.GardenUtils;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
import net.java.games.input.Component;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import scala.swing.event.ButtonClicked;

import java.io.*;

import java.awt.*;
import java.util.Scanner;

public class WheatInHub {
    static Minecraft mc = Minecraft.getMinecraft();
    public static int gameStage = 1;
    private static boolean useKeyStrokes = false;
    private static int count = 1;
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
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        canRunMath = true;
        gameStage = 1;
        timesAdded = 0;
        count = 1;
        Utils.resetPositionIsSame();
        checkForStop = false;
        checkForCamera = false;
    }

    public static void main() {
        if (MacroManager.scriptIsOn) {
            convertScript = false;
            useKeyStrokes = true;
            if(convertScript){


//                try {
//                    File myObj = new File("D:\\Mod\\hubWheat.txt");
//                    Scanner myReader = new Scanner(myObj);
//                    while (myReader.hasNextLine()) {
//                        String data = myReader.nextLine();
//                        System.out.println(data);
//                    }
//                    myReader.close();
//                } catch (FileNotFoundException e) {
//                    System.out.println("An error occurred.");
//                    e.printStackTrace();
//                }
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
