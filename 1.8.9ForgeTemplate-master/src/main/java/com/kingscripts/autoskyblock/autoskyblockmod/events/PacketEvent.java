////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package com.kingscripts.autoskyblock.autoskyblockmod.events;
//
//import net.minecraft.network.Packet;
//import net.minecraftforge.fml.common.eventhandler.Cancelable;
//import net.minecraftforge.fml.common.eventhandler.Event;
//
//@Cancelable
//public class PacketEvent extends Event {
//    public Direction direction;
//    public Packet<?> packet;
//
//    public PacketEvent(Packet<?> packet) {
//        this.packet = packet;
//    }
//
//    static enum Direction {
//        INBOUND,
//        OUTBOUND;
//
//        private Direction() {
//        }
//    }
//
//    public static class SendEvent extends PacketEvent {
//        public SendEvent(Packet<?> packet) {
//            super(packet);
//            this.direction = PacketEvent.Direction.OUTBOUND;
//        }
//    }
//
//    public static class ReceiveEvent extends PacketEvent {
//        public ReceiveEvent(Packet<?> packet) {
//            super(packet);
//            this.direction = PacketEvent.Direction.INBOUND;
//        }
//    }
//}
