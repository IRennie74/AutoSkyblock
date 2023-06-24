//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.StringUtils;

public class TextRenderer extends Gui {
    public TextRenderer() {
    }

    public static void drawText(Minecraft mc, String text, int x, int y, double scale, boolean outline) {
        GlStateManager.pushMatrix();
        GlStateManager.scale(scale, scale, scale);
        y -= mc.fontRendererObj.FONT_HEIGHT;
        String[] var7 = text.split("\n");
        int var8 = var7.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            String line = var7[var9];
            y = (int)((double)y + (double)mc.fontRendererObj.FONT_HEIGHT * scale);
            if (outline) {
                String noColourLine = StringUtils.stripControlCodes(line);
                mc.fontRendererObj.drawString(noColourLine, (float)((int)Math.round((double)x / scale) - 1), (float)((int)Math.round((double)y / scale)), 0, false);
                mc.fontRendererObj.drawString(noColourLine, (float)((int)Math.round((double)x / scale) + 1), (float)((int)Math.round((double)y / scale)), 0, false);
                mc.fontRendererObj.drawString(noColourLine, (float)((int)Math.round((double)x / scale)), (float)((int)Math.round((double)y / scale) - 1), 0, false);
                mc.fontRendererObj.drawString(noColourLine, (float)((int)Math.round((double)x / scale)), (float)((int)Math.round((double)y / scale) + 1), 0, false);
                mc.fontRendererObj.drawString(line, (float)((int)Math.round((double)x / scale)), (float)((int)Math.round((double)y / scale)), 16777215, false);
            } else {
                mc.fontRendererObj.drawString(line, (float)((int)Math.round((double)x / scale)), (float)((int)Math.round((double)y / scale)), 16777215, true);
            }
        }

        GlStateManager.popMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
