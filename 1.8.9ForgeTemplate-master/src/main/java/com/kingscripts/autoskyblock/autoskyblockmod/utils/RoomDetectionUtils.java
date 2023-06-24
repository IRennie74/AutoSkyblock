//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class RoomDetectionUtils {
    public static final double DEG_TO_RAD = 0.017453292519943295;
    public static final double RAD_TO_DEG = 57.29577951308232;
    public static HashSet<Integer> whitelistedBlocks = new HashSet(Arrays.asList(100, 103, 104, 105, 106, 200, 300, 301, 400, 700, 1800, 3507, 4300, 4800, 8200, 9800, 9801, 9803, 15907, 15909, 15915));

    public RoomDetectionUtils() {
    }

    public static Vec3 getVectorFromRotation(float yaw, float pitch) {
        float f = MathHelper.cos(-yaw * 0.017453292F - 3.1415927F);
        float f1 = MathHelper.sin(-yaw * 0.017453292F - 3.1415927F);
        float f2 = -MathHelper.cos(-pitch * 0.017453292F);
        float f3 = MathHelper.sin(-pitch * 0.017453292F);
        return new Vec3((double)(f1 * f2), (double)f3, (double)(f * f2));
    }

    public static List<Vec3> vectorsToRaytrace(int vectorQuantity) {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP player = mc.thePlayer;
        List<Vec3> vectorList = new ArrayList();
        Vec3 eyes = new Vec3(player.posX, player.posY + (double)player.getEyeHeight(), player.posZ);
        float aspectRatio = (float)mc.displayWidth / (float)mc.displayHeight;
        double fovV = (double)(mc.gameSettings.fovSetting * mc.thePlayer.getFovModifier());
        double fovH = Math.atan((double)aspectRatio * Math.tan(fovV * 0.017453292519943295 / 2.0)) * 2.0 * 57.29577951308232;
        float verticalSpacing = (float)(fovV * 0.8 / (double)vectorQuantity);
        float horizontalSpacing = (float)(fovH * 0.9 / (double)vectorQuantity);
        float playerYaw = player.rotationYaw;
        float playerPitch = player.rotationPitch;
        if (mc.gameSettings.thirdPersonView == 2) {
            playerYaw += 180.0F;
            playerPitch = -playerPitch;
        }

        for(float h = (float)(-(vectorQuantity - 1)) / 2.0F; h <= (float)(vectorQuantity - 1) / 2.0F; ++h) {
            for(float v = (float)(-(vectorQuantity - 1)) / 2.0F; v <= (float)(vectorQuantity - 1) / 2.0F; ++v) {
                float yaw = h * horizontalSpacing;
                float pitch = v * verticalSpacing;
                float yawScaled = yaw * (playerPitch * playerPitch / 8100.0F + 1.0F) / (Math.abs(v / (float)vectorQuantity) + 1.0F);
                Vec3 direction = getVectorFromRotation(yawScaled + playerYaw, pitch + playerPitch);
                vectorList.add(eyes.addVector(direction.xCoord * 64.0, direction.yCoord * 64.0, direction.zCoord * 64.0));
            }
        }

        return vectorList;
    }

    public static boolean blockPartOfDoorway(BlockPos blockToCheck) {
        if (blockToCheck.getY() >= 66 && blockToCheck.getY() <= 73) {
            int relX = Math.floorMod(blockToCheck.getX() - 8, 32);
            int relZ = Math.floorMod(blockToCheck.getZ() - 8, 32);
            if (relX >= 13 && relX <= 17) {
                if (relZ <= 2) {
                    return true;
                }

                if (relZ >= 28) {
                    return true;
                }
            }

            if (relZ >= 13 && relZ <= 17) {
                if (relX <= 2) {
                    return true;
                }

                if (relX >= 28) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }
}
