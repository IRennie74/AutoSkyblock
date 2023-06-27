////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package com.kingscripts.autoskyblock.autoskyblockmod.macros.garden;
//
//import com.kingscripts.autoskyblock.autoskyblockmod.macros.MacroManager;
//import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.settings.KeyBinding;
//import net.minecraft.util.ChatComponentText;
//import net.minecraft.util.EnumChatFormatting;
//
//public class WheatInHub1 {
//    static Minecraft mc = Minecraft.getMinecraft();
//    public static int gameStage = 1;
//    private static int count = 0;
//    private static boolean checkForStop = false;
//    private static boolean checkForCamera = false;
//    private static boolean canRunMath = true;
//    private static boolean useLerp2;
//    private static double currentStopX;
//    private static double currentStopZ;
//    private static int xStopDirection;
//    private static int zStopDirection;
//    private static float yawAdd;
//    private static float pitchAdd;
//    private static float Yaw;
//    private static float Pitch;
//
//    private static float lerp = 0.02f;
//    private static int timesAdded = 0;
//
//
//    public WheatInHub1() {
//    }
//
//    public static void start() {
//        MacroManager.scriptIsOn = true;
//        Utils.resetPositionIsSame();
//        checkForStop = false;
//        checkForCamera = false;
//        canRunMath = true;
//        timesAdded = 0;
//        gameStage = 1;
//    }
//
//    public static void reset() {
//        MacroManager.scriptIsOn = false;
//        canRunMath = true;
//        gameStage = 1;
//        timesAdded = 0;
//        count = 1;
//        Utils.resetPositionIsSame();
//        checkForStop = false;
//        checkForCamera = false;
//    }
//
//    public static void main() {
//        if (MacroManager.scriptIsOn) {
//
//            if(checkForStop){//if check for stop is active then only check for stops runs because it is constantly
//                // checking to see if the player has passed a set of coordinates
//                //Check X first
//                if(xStopDirection != 0){//checks if X is inactive
//                    if(xStopDirection > 0){//checks to see which direction we are checking in
//                        if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getX() >= currentStopX) {
//                            //the player has passed the checkpoint
//                            gameStage++;
//                            checkForStop = false;
//                            xStopDirection = 0;
//                            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Passed Coords: player > X"));
//                        }
//                    } else {//has to be smaller if it's not bigger
//                        if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getX() <= currentStopX) {
//                            //the player has passed the checkpoint
//                            gameStage++;
//                            checkForStop = false;
//                            xStopDirection = 0;
//                            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Passed Coords: player < X"));
//                        }
//                    }
//
//                } else {//it checks if stop is active and if X is inactive then Z has to be active
//                    if(zStopDirection > 0){//checks to see which direction we are checking in
//                        if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getZ() >= currentStopZ) {
//                            //the player has passed the checkpoint
//                            gameStage++;
//                            checkForStop = false;
//                            zStopDirection = 0;
//                            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Passed Coords: player > Z"));
//                        }
//                    } else {//has to be smaller if it's not bigger
//                        if ((double) Minecraft.getMinecraft().thePlayer.getPosition().getZ() <= currentStopZ) {
//                            //the player has passed the checkpoint
//                            gameStage++;
//                            checkForStop = false;
//                            zStopDirection = 0;
//                            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Passed Coords: player < Z"));
//                        }
//                    }
//                }
//
//            } else if(checkForCamera){//moves the camera to the position set then adds one to the stage and resumes the script
//                //runs once
//                if(canRunMath) {
//                    if(!useLerp2){
//                        //add is shorter (left)
//                        yawAdd = Utils.lerp(Minecraft.getMinecraft().thePlayer.rotationYaw, Yaw, lerp);//initial yaw math
//                    } else {//subtract is shorter (right)
//                        yawAdd = Utils.lerp2(Minecraft.getMinecraft().thePlayer.rotationYaw, Yaw, lerp);//initial yaw math
//                    }
//
//                    pitchAdd = Utils.lerp(Minecraft.getMinecraft().thePlayer.rotationPitch, Pitch, lerp);//initial yaw math
//                    canRunMath = false;
//                }
//
//                //runs constant
//                //move camera angle back to normal
//                if(1 / lerp >= timesAdded){//looped adding yaw
//                    Minecraft.getMinecraft().thePlayer.rotationYaw += yawAdd;
//                    Minecraft.getMinecraft().thePlayer.rotationPitch += pitchAdd;
//                } else{//good to run script
//                    Minecraft.getMinecraft().thePlayer.rotationYaw = Yaw;
//                    Minecraft.getMinecraft().thePlayer.rotationPitch = Pitch;
//                    gameStage++;
//                    timesAdded = 0;
//                    canRunMath = true;
//                    checkForCamera = false;
//                }
//                timesAdded++;// end of looped adding yaw
//            }
//
//            else{//not checking for stop or moving the camera so the rest of the script can be executed
//
//                if (gameStage == 1) {
//                    //look at -137.5/1.2
//                    Yaw =  -137.5f;
//                    Pitch = 1.2f;
//                    lerp = 0.05f;
//                    useLerp2 = true;
//                    checkForCamera = true;
//                } else if (gameStage == 2) {
//                    //run jump until 19/ /-93
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
//                    //makes the program start checking if the player has reached the coordinates 19
//                    currentStopX = 17;
//                    xStopDirection = 1;
//                    checkForStop = true;
//                }
//                else if (gameStage == 3) {
//                    //look at -173/1.2
//                    Yaw =  -177.7f;
//                    Pitch = 1.2f;
//                    lerp = 0.02f;
//                    useLerp2 = false;
//                    checkForCamera = true;
//                }
//                else if (gameStage == 4) {
//                    //run jump until / /-123
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
//                    //makes the program start checking if the player has reached the coordinates 19
//                    currentStopZ = -118;
//                    zStopDirection = -1;
//                    checkForStop = true;
//                }
//                else if(gameStage == 5) {
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
//                    //look at -173/1.2
//                    Yaw =  -160;
//                    Pitch = 20f;
//                    lerp = 0.05f;
//                    useLerp2 = false;
//                    checkForCamera = true;
//                }
//                else if(gameStage == 6) {
//                    //run jump until / /-127
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
//                    //makes the program start checking if the player has reached the coordinates 19
//                    currentStopZ = -127;
//                    zStopDirection = -1;
//                    checkForStop = true;
//                }
//                else if(gameStage == 7) {
//                    //run jump until / /-129
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
//
//                    //makes the program start checking if the player has reached the coordinates 19
//                    currentStopZ = -129;
//                    zStopDirection = -1;
//                    checkForStop = true;
//                }
//                else if(gameStage == 8) {
//                    //run jump until / /-129.8
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
//
//                    //makes the program start checking if the player has reached the coordinates 19
//                    currentStopZ = -129.8;
//                    zStopDirection = 1;
//                    checkForStop = true;
//                }
//                else if(gameStage == 9) {
//                    //run jump until / /-131.6
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
//
//                    //makes the program start checking if the player has reached the coordinates 19
//                    currentStopZ = -131.6;
//                    zStopDirection = -1;
//                    checkForStop = true;
//                }
//                else if(gameStage == 10) {//goes left and turns camera
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
//                    //look at -173/1.2
//                    Yaw =  140;
//                    Pitch = 20f;
//                    lerp = 0.05f;
//                    useLerp2 = true;
//                    checkForCamera = true;
//                }
//                else if(gameStage == 11) {
//                    //makes the program start checking if the player has reached the coordinates 19
//                    currentStopX = 22;
//                    zStopDirection = 1;
//                    checkForStop = true;
//                }
//                else if(gameStage == 12) {//goes left and turns camera
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
//                    KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
//                    //look at -173/1.2
//                    Yaw =  -180;
//                    Pitch = 20f;
//                    lerp = 0.05f;
//                    useLerp2 = true;
//                    checkForCamera = true;
//                }
//            }
//        }
//    }
//
//    public static void safetyRestart() {
//        MacroManager.warpExpected = true;
//        Minecraft.getMinecraft().thePlayer.sendChatMessage("/warp hub");
//    }
//}
