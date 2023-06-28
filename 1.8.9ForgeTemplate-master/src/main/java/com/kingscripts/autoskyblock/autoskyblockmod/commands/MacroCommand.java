//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.commands;

import com.kingscripts.autoskyblock.autoskyblockmod.handlers.ConfigHandler;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.Cobblestone;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.GardenManager;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.WheatInHub;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class MacroCommand extends CommandBase {
    public MacroCommand() {
    }

    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    public String getCommandName() {
        return "macro";
    }

    public String getCommandUsage(ICommandSender sender) {
        return "Picks the Macro";
    }

    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("sneak")) {
            if (Cobblestone.sneakIsActive) {
                Cobblestone.sneakIsActive = false;
                ConfigHandler.writeBooleanConfig("toggles", "toggledSneak", false);
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Set Sneak to false"));
                ConfigHandler.reloadConfig();
            } else {
                Cobblestone.sneakIsActive = true;
                ConfigHandler.writeBooleanConfig("toggles", "toggledSneak", true);
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Set Sneak to true"));
                ConfigHandler.reloadConfig();
            }
        }
        if (args.length > 0 && args[0].equalsIgnoreCase("paste")) {
            if (Cobblestone.sneakIsActive) {
                WheatInHub.pasting = false;
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Set to Copying"));
            } else {
                WheatInHub.pasting = true;
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Set to Pasting"));
            }
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("north")) {
            GardenManager.north_South = true;
            ConfigHandler.writeBooleanConfig("toggles", "northSouth", true);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Set to North"));
            ConfigHandler.reloadConfig();
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("south")) {
            GardenManager.north_South = true;
            ConfigHandler.writeBooleanConfig("toggles", "northSouth", true);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Set to South"));
            ConfigHandler.reloadConfig();
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("east")) {
            GardenManager.north_South = false;
            ConfigHandler.writeBooleanConfig("toggles", "northSouth", false);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Set to East"));
            ConfigHandler.reloadConfig();
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("west")) {
            ConfigHandler.writeBooleanConfig("toggles", "northSouth", false);
            GardenManager.north_South = false;
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Set to West"));
            ConfigHandler.reloadConfig();
        }
        if (args.length > 0 && args[0].equalsIgnoreCase("1")) {
            GardenManager.chosenGardenMacro = 1;
            ConfigHandler.writeIntConfig("macro", "chosenGardenMacro", 1);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Set Macro to Side To Side"));
            ConfigHandler.reloadConfig();
        } else if (args.length > 0 && args[0].equalsIgnoreCase("2")) {
            ConfigHandler.writeIntConfig("macro", "chosenGardenMacro", 2);
            GardenManager.chosenGardenMacro = 2;
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Set Macro to Cobblestone"));
            ConfigHandler.reloadConfig();
        } else if (args.length > 0 && args[0].equalsIgnoreCase("3")) {
            ConfigHandler.writeIntConfig("macro", "chosenGardenMacro", 3);
            GardenManager.chosenGardenMacro = 3;
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Set Macro to Flat Crops with No Farm"));
            ConfigHandler.reloadConfig();
        } else if (args.length > 0 && args[0].equalsIgnoreCase("4")) {
            ConfigHandler.writeIntConfig("macro", "chosenGardenMacro", 4);
            GardenManager.chosenGardenMacro = 4;
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Set Macro to Wheat in Hub"));
            ConfigHandler.reloadConfig();
        } else if (args.length > 0 && args[0].equalsIgnoreCase("5")) {
            ConfigHandler.writeIntConfig("macro", "chosenGardenMacro", 5);
            GardenManager.chosenGardenMacro = 5;
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Set Macro to Side To Side and Forward"));
            ConfigHandler.reloadConfig();
        } else if (args.length > 0 && args[0].equalsIgnoreCase("6")) {
            ConfigHandler.writeIntConfig("macro", "chosenGardenMacro", 6);
            GardenManager.chosenGardenMacro = 6;
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLACK + "Set Macro to Side To Side With Direction"));
            ConfigHandler.reloadConfig();
        }

    }
}
