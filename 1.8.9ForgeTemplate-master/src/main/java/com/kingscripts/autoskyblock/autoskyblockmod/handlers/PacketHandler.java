//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kingscripts.autoskyblock.autoskyblockmod.handlers;

import com.kingscripts.autoskyblock.autoskyblockmod.events.PacketEvent;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import net.minecraft.network.Packet;
import net.minecraftforge.common.MinecraftForge;

public class PacketHandler extends ChannelDuplexHandler {
    public PacketHandler() {
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof Packet) {
            MinecraftForge.EVENT_BUS.post(new PacketEvent.ReceiveEvent((Packet)msg));
        }

        super.channelRead(ctx, msg);
    }

    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (msg instanceof Packet) {
            MinecraftForge.EVENT_BUS.post(new PacketEvent.SendEvent((Packet)msg));
        }

        super.write(ctx, msg, promise);
    }
}
