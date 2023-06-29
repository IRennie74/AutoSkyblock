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
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
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
    private static int count2 = 0;
    private static int hubLevel = 1;
    private static boolean hasSavedMillis = false;
    private static boolean thisScriptOn = false;
    private static boolean inventoryFull = false;
    public static boolean pasting = true;
    public static boolean canOpen = false;
    public static boolean isOpen = false;
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
        } else if (whichFarm == 4) {//
            return HubChooser.movement2[count1][level];
        }
        return null;
    }
    public static void execute(int whichFarm, int hubLevel,int count1) {
        //Yaw, float, jump, sneak, sprint, left, right, back, forward, attack, use item
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
    public void onOpen(GuiOpenEvent event){
        if(MacroManager.scriptIsOn) {
            if (canOpen) {
                isOpen = true;
            }
        }
    }
    @SubscribeEvent
    public void inventoryFull(ClientChatReceivedEvent event) {
        String message2 = event.message.getUnformattedText();
        if(message2.contains("Inventory full?") && gameStage == 1) {
            inventoryFull = true;
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
                        if(inventoryFull){
                            inventoryFull = false;
                            count1 = 0;
                            hubLevel++;
                        }
                        canOpen = true;
                        hasSavedMillis = false;
                        if(gameStage == 1) {//farms crops and brings you back to hub spawn
                            if(count2 >= 150){
                            execute(1, hubLevel, count1);
                            if (count1 >= 909 && hubLevel == 1) {
                                count1 = 0;
                                hubLevel++;
                            } else if (count1 >= 809 && hubLevel == 2) {
                                count1 = 0;
                                count2 = 0;
                                hubLevel = 1;
                                gameStage++;
                                Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
                            }
                            count1++;
                        }
                            count2++;
                        } else if(gameStage == 2){//Brings you to npc
                            if (count1 <= 158) {//runs script
                                execute(2,1,count1);
                            } else  {
                                count1 = 0;
                                gameStage++;
                            }
                            count1++;
                        } else if(gameStage == 3){//sells inventory and brings you back to hub spawn
                            //Minecraft.getMinecraft().thePlayer.inventory.closeInventory(mc.thePlayer);//closes inventory
                            //Minecraft.getMinecraft().thePlayer.inventory.openInventory(mc.thePlayer);//opens inventory
                            if(isOpen) {
                                canOpen = false;
                                if (count1 <= 10) {//skip 81 and 89
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 54, 0, 0, mc.thePlayer);
                                } else if (count1 > 10 && count1 <= 20) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 55, 0, 0, mc.thePlayer);
                                } else if (count1 > 20 && count1 <= 30) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 56, 0, 0, mc.thePlayer);
                                } else if (count1 > 30 && count1 <= 40) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 57, 0, 0, mc.thePlayer);
                                } else if (count1 > 40 && count1 <= 50) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 58, 0, 0, mc.thePlayer);
                                } else if (count1 > 50 && count1 <= 60) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 59, 0, 0, mc.thePlayer);
                                } else if (count1 > 60 && count1 <= 70) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 60, 0, 0, mc.thePlayer);
                                } else if (count1 > 70 && count1 <= 80) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 61, 0, 0, mc.thePlayer);
                                } else if (count1 > 80 && count1 <= 90) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 62, 0, 0, mc.thePlayer);
                                } else if (count1 > 90 && count1 <= 100) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 63, 0, 0, mc.thePlayer);
                                } else if (count1 > 100 && count1 <= 110) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 64, 0, 0, mc.thePlayer);
                                } else if (count1 > 110 && count1 <= 120) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 65, 0, 0, mc.thePlayer);
                                } else if (count1 > 120 && count1 <= 130) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 66, 0, 0, mc.thePlayer);
                                } else if (count1 > 130 && count1 <= 140) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 67, 0, 0, mc.thePlayer);
                                } else if (count1 > 140 && count1 <= 150) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 68, 0, 0, mc.thePlayer);
                                } else if (count1 > 150 && count1 <= 160) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 69, 0, 0, mc.thePlayer);
                                } else if (count1 > 160 && count1 <= 170) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 70, 0, 0, mc.thePlayer);
                                } else if (count1 > 170 && count1 <= 180) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 71, 0, 0, mc.thePlayer);
                                } else if (count1 > 180 && count1 <= 190) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 72, 0, 0, mc.thePlayer);
                                } else if (count1 > 190 && count1 <= 200) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 73, 0, 0, mc.thePlayer);
                                } else if (count1 > 200 && count1 <= 210) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 74, 0, 0, mc.thePlayer);
                                } else if (count1 > 210 && count1 <= 220) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 75, 0, 0, mc.thePlayer);
                                } else if (count1 > 220 && count1 <= 230) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 76, 0, 0, mc.thePlayer);
                                } else if (count1 > 230 && count1 <= 240) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 77, 0, 0, mc.thePlayer);
                                } else if (count1 > 240 && count1 <= 250) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 78, 0, 0, mc.thePlayer);
                                } else if (count1 > 250 && count1 <= 260) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 79, 0, 0, mc.thePlayer);
                                } else if (count1 > 260 && count1 <= 270) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 80, 0, 0, mc.thePlayer);
                                } else if (count1 > 270 && count1 <= 280) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 82, 0, 0, mc.thePlayer);
                                } else if (count1 > 280 && count1 <= 290) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 83, 0, 0, mc.thePlayer);
                                } else if (count1 > 290 && count1 <= 300) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 84, 0, 0, mc.thePlayer);
                                } else if (count1 > 300 && count1 <= 310) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 85, 0, 0, mc.thePlayer);
                                } else if (count1 > 310 && count1 <= 320) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 86, 0, 0, mc.thePlayer);
                                } else if (count1 > 320 && count1 <= 330) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 87, 0, 0, mc.thePlayer);
                                } else if (count1 > 330 && count1 <= 340) {
                                    mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 88, 0, 0, mc.thePlayer);
                                    gameStage++;
                                    count1 = 0;
                                    isOpen = false;
                                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
                                }
                                count1++;
                            } else {
                                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
                                    gameStage--;
                                    count1 = 0;
                            }
                        } else if (gameStage == 4){
                            if (count1 <= 70) {//runs script
                                execute(4,1,count1);
                            } else  {
                                count1 = 0;
                                gameStage++;
                            }
                            count1++;
                        } else if (gameStage == 5){
                            if(isOpen) {
                                canOpen = false;
                                mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 50, 0, 0, mc.thePlayer);
                                    gameStage = 1;
                                    isOpen = false;
                                    count1 = 0;
                                    MacroManager.warpExpected = true;
                            } else {
                                Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
                                gameStage--;
                                count1 = 0;
                                start();
                            }
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
        canOpen = false;
        isOpen = false;
        inventoryFull = false;
    }

    public static void reset() {
        MacroManager.scriptIsOn = false;
        gameStage = 1;
        hubLevel = 1;
        count1 = 0;
        Utils.resetPositionIsSame();
        hasSavedMillis = false;
        canOpen = false;
        isOpen = false;
        inventoryFull = false;
    }
    public static void main(){
        thisScriptOn = true;
    }

    public static void safetyRestart() {
        MacroManager.warpExpected = true;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
    }
}
