//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod;

import com.google.gson.JsonObject;
import com.kingscripts.autoskyblock.autoskyblockmod.commands.MacroCommand;
import com.kingscripts.autoskyblock.autoskyblockmod.handlers.ConfigHandler;
import com.kingscripts.autoskyblock.autoskyblockmod.handlers.TextRenderer;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.MacroManager;
//import com.kingscripts.autoskyblock.autoskyblockmod.macros.dungeons.catacombs.DungeonManager;
//import com.kingscripts.autoskyblock.autoskyblockmod.macros.dungeons.catacombs.RoomDetection;
//import com.kingscripts.autoskyblock.autoskyblockmod.macros.dungeons.catacombs.Waypoints;
import com.kingscripts.autoskyblock.autoskyblockmod.macros.garden.GardenManager;
import com.kingscripts.autoskyblock.autoskyblockmod.utils.Utils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = "autoskyblock",
        version = "1.0"
)
public class AutoSkyblock {
    public static final String MODID = "autoskyblock";
    public static final String VERSION = "1.0";
    Minecraft mc = Minecraft.getMinecraft();
    public static Logger logger;
    public static JsonObject roomsJson;
    public static JsonObject waypointsJson;
    public static HashMap<String, HashMap<String, long[]>> ROOM_DATA = new HashMap();
    public static boolean usingSBPSecrets = false;
    public static KeyBinding[] keyBindings = new KeyBinding[3];
    public static String imageHotkeyOpen = "gui";
    static int tickAmount = 1;
    public static List<String> textToDisplay = null;
    public static int textLocX = 50;
    public static int textLocY = 5;
    public static List<String> motd = null;
    public static String configDir;
    public static boolean firstLogin = false;

    public AutoSkyblock() {
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new MacroCommand());
        configDir = event.getModConfigurationDirectory().toString();
        logger = LogManager.getLogger(AutoSkyblock.class);
        Utils.setLogLevel(LogManager.getLogger(AutoSkyblock.class), Level.INFO);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        long time1 = System.currentTimeMillis();
        MinecraftForge.EVENT_BUS.register(this);
//        MinecraftForge.EVENT_BUS.register(new DungeonManager());
//        MinecraftForge.EVENT_BUS.register(new RoomDetection());
//        MinecraftForge.EVENT_BUS.register(new Waypoints());
        MinecraftForge.EVENT_BUS.register(new MacroManager());
        MinecraftForge.EVENT_BUS.register(new GardenManager());
        MinecraftForge.EVENT_BUS.register(new MacroCommand());
        ConfigHandler.reloadConfig();
        keyBindings[0] = new KeyBinding("Starts Macro", 24, "Auto Skyblock Mod");
        keyBindings[1] = new KeyBinding("Pauses/Resumes Macro", 25, "Auto Skyblock Mod");
        keyBindings[2] = new KeyBinding("Cancel Macro", 38, "Auto Skyblock Mod");
        KeyBinding[] var4 = keyBindings;
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            KeyBinding keyBinding = var4[var6];
            ClientRegistry.registerKeyBinding(keyBinding);
        }

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        usingSBPSecrets = Loader.isModLoaded("asm");
    }

    @SubscribeEvent
    public void onServerConnect(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        if (this.mc.getCurrentServerData() != null) {
            if (this.mc.getCurrentServerData().serverIP.toLowerCase().contains("hypixel.")) {
            }

        }
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == Phase.START) {
            EntityPlayerSP player = this.mc.thePlayer;
            ++tickAmount;
            if (tickAmount % 20 == 0 && player != null) {
                Utils.checkForSkyblock();
                Utils.checkForCatacombs();
                Utils.checkForPrivateIsland();
                Utils.checkForHub();
                Utils.checkForGarden();
                tickAmount = 0;
            }

        }
    }

    @SubscribeEvent
    public void renderPlayerInfo(RenderGameOverlayEvent.Post event) {
        if (event.type == ElementType.ALL) {
            if (Utils.inSkyblock && textToDisplay != null && !textToDisplay.isEmpty()) {
                ScaledResolution scaledResolution = new ScaledResolution(this.mc);
                int y = 0;

                for(Iterator var4 = textToDisplay.iterator(); var4.hasNext(); y += this.mc.fontRendererObj.FONT_HEIGHT) {
                    String line = (String)var4.next();
                    int roomStringWidth = this.mc.fontRendererObj.getStringWidth(line);
                    TextRenderer.drawText(this.mc, line, scaledResolution.getScaledWidth() * textLocX / 100 - roomStringWidth / 2, scaledResolution.getScaledHeight() * textLocY / 100 + y, 1.0, true);
                }
            }

        }
    }
}
