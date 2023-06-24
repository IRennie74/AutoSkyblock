////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package com.kingscripts.autoskyblock.autoskyblockmod.utils;
//
//import java.awt.Point;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeSet;
//import net.minecraft.block.material.MapColor;
//import net.minecraft.client.Minecraft;
//import net.minecraft.init.Items;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.BlockPos;
//import net.minecraft.util.Vec3;
//import net.minecraft.util.Vec4b;
//import net.minecraft.world.storage.MapData;
//
//public class MapUtils {
//    public MapUtils() {
//    }
//
//    public static boolean mapExists() {
//        Minecraft mc = Minecraft.getMinecraft();
//        ItemStack mapSlot = mc.thePlayer.inventory.getStackInSlot(8);
//        return mapSlot != null && mapSlot.getItem() == Items.filled_map && mapSlot.hasDisplayName() ? mapSlot.getDisplayName().contains("Magical Map") : false;
//    }
//
//    public static Integer[][] updatedMap() {
//        if (!mapExists()) {
//            return (Integer[][])null;
//        } else {
//            Minecraft mc = Minecraft.getMinecraft();
//            ItemStack mapSlot = mc.thePlayer.inventory.getStackInSlot(8);
//            MapData mapData = Items.filled_map.getMapData(mapSlot, mc.theWorld);
//            if (mapData == null) {
//                return (Integer[][])null;
//            } else {
//                Integer[][] map = new Integer[128][128];
//
//                for(int i = 0; i < 16384; ++i) {
//                    int x = i % 128;
//                    int y = i / 128;
//                    int j = mapData.colors[i] & 255;
//                    int rgba;
//                    if (j / 4 == 0) {
//                        rgba = (i + i / 128 & 1) * 8 + 16 << 24;
//                    } else {
//                        rgba = MapColor.mapColorArray[j / 4].getMapColor(j & 3);
//                    }
//
//                    map[x][y] = rgba & 16777215;
//                }
//
//                return map;
//            }
//        }
//    }
//
//    public static Point[] entranceMapCorners(Integer[][] map) {
//        if (map == null) {
//            return null;
//        } else {
//            Point[] corners = new Point[2];
//
//            for(int x = 0; x < 128; ++x) {
//                for(int y = 0; y < 128; ++y) {
//                    if (map[x][y] != null && map[x][y] == 31744 && map[x][y - 1] != null && map[x][y - 1] == 0) {
//                        if (map[x - 1][y] != null && map[x - 1][y] == 0) {
//                            corners[0] = new Point(x, y);
//                        } else if (map[x + 1][y] != null && map[x + 1][y] == 0) {
//                            corners[1] = new Point(x, y);
//                        }
//                    }
//                }
//
//                if (corners[0] != null && corners[1] != null) {
//                    break;
//                }
//            }
//
//            return corners;
//        }
//    }
//
//    public static Point getClosestNWMapCorner(Point mapPos, Point leftCorner, Point rightCorner) {
//        int roomWidthAndGap = rightCorner.x - leftCorner.x + 1 + 4;
//        Point origin = new Point(leftCorner.x % roomWidthAndGap, leftCorner.y % roomWidthAndGap);
//        mapPos.x += 2;
//        mapPos.y += 2;
//        int x = mapPos.x - mapPos.x % roomWidthAndGap + origin.x;
//        int y = mapPos.y - mapPos.y % roomWidthAndGap + origin.y;
//        if (x > mapPos.x) {
//            x -= roomWidthAndGap;
//        }
//
//        if (y > mapPos.y) {
//            y -= roomWidthAndGap;
//        }
//
//        return new Point(x, y);
//    }
//
//    public static Point getClosestNWPhysicalCorner(Vec3 vectorPos) {
//        Vec3 shiftedPos = vectorPos.addVector(0.5, 0.0, 0.5);
//        shiftedPos = shiftedPos.addVector(8.0, 0.0, 8.0);
//        int x = (int)(shiftedPos.xCoord - (double)Math.floorMod((int)shiftedPos.xCoord, 32));
//        int z = (int)(shiftedPos.zCoord - (double)Math.floorMod((int)shiftedPos.zCoord, 32));
//        return new Point(x - 8, z - 8);
//    }
//
//    public static Point getClosestNWPhysicalCorner(BlockPos blockPos) {
//        return getClosestNWPhysicalCorner(new Vec3((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ()));
//    }
//
//    public static Point physicalToMapCorner(Point physicalClosestCorner, Point physicalLeftCorner, Point leftCorner, Point rightCorner) {
//        int roomWidthAndGap = rightCorner.x - leftCorner.x + 1 + 4;
//        int xShift = (physicalClosestCorner.x - physicalLeftCorner.x) / 32;
//        int yShift = (physicalClosestCorner.y - physicalLeftCorner.y) / 32;
//        int x = leftCorner.x + roomWidthAndGap * xShift;
//        int y = leftCorner.y + roomWidthAndGap * yShift;
//        return new Point(x, y);
//    }
//
//    public static Point mapToPhysicalCorner(Point mapCorner, Point physicalLeftCorner, Point leftCorner, Point rightCorner) {
//        int roomWidthAndGap = rightCorner.x - leftCorner.x + 1 + 4;
//        int xShift = (mapCorner.x - leftCorner.x) / roomWidthAndGap;
//        int yShift = (mapCorner.y - leftCorner.y) / roomWidthAndGap;
//        int x = physicalLeftCorner.x + 32 * xShift;
//        int y = physicalLeftCorner.y + 32 * yShift;
//        return new Point(x, y);
//    }
//
//    public static String getMapColor(Point point, Integer[][] map) {
//        int x = point.x;
//        int y = point.y;
//        if (x >= 0 && y >= 0 && x <= 127 && y <= 127) {
//            if (map != null) {
//                switch (map[x][y]) {
//                    case 31744:
//                        return "green";
//                    case 7488283:
//                        return "brown";
//                    case 11685080:
//                        return "purple";
//                    case 14188339:
//                        return "orange";
//                    case 15066419:
//                        return "yellow";
//                    case 15892389:
//                        return "pink";
//                    case 16711680:
//                        return "red";
//                    default:
//                        return "undefined";
//                }
//            } else {
//                return "undefined";
//            }
//        } else {
//            return "undefined";
//        }
//    }
//
//    public static List<Point> neighboringSegments(Point originCorner, Integer[][] map, Point leftCorner, Point rightCorner, List<Point> list) {
//        if (!list.contains(originCorner)) {
//            list.add(originCorner);
//        }
//
//        if (!getMapColor(originCorner, map).equals("brown")) {
//            return list;
//        } else {
//            int roomWidth = rightCorner.x - leftCorner.x + 1;
//            List<Point> pointsToCheck = new ArrayList();
//            pointsToCheck.add(new Point(originCorner.x, originCorner.y - 1));
//            pointsToCheck.add(new Point(originCorner.x, originCorner.y + roomWidth));
//            pointsToCheck.add(new Point(originCorner.x - 1, originCorner.y));
//            pointsToCheck.add(new Point(originCorner.x + roomWidth, originCorner.y));
//            List<Point> pointsToTransform = new ArrayList();
//            pointsToTransform.add(new Point(originCorner.x, originCorner.y - 1 - 4));
//            pointsToTransform.add(new Point(originCorner.x, originCorner.y + roomWidth + 4));
//            pointsToTransform.add(new Point(originCorner.x - 1 - 4, originCorner.y));
//            pointsToTransform.add(new Point(originCorner.x + roomWidth + 4, originCorner.y));
//
//            for(int i = 0; i < 4; ++i) {
//                if (getMapColor((Point)pointsToCheck.get(i), map).equals("brown")) {
//                    Point newCorner = getClosestNWMapCorner((Point)pointsToTransform.get(i), leftCorner, rightCorner);
//                    if (!list.contains(newCorner)) {
//                        list.add(newCorner);
//                        list = neighboringSegments(newCorner, map, leftCorner, rightCorner, list);
//                    }
//                }
//            }
//
//            return list;
//        }
//    }
//
//    public static String roomSize(List<Point> segments) {
//        if (segments.size() == 1) {
//            return "1x1";
//        } else if (segments.size() == 2) {
//            return "1x2";
//        } else {
//            HashSet<Integer> x = new HashSet();
//            HashSet<Integer> y = new HashSet();
//            Iterator var3 = segments.iterator();
//
//            while(var3.hasNext()) {
//                Point segment = (Point)var3.next();
//                x.add(segment.x);
//                y.add(segment.y);
//            }
//
//            if (segments.size() == 3) {
//                return x.size() == 2 && y.size() == 2 ? "L-shape" : "1x3";
//            } else if (segments.size() == 4) {
//                return x.size() == 2 && y.size() == 2 ? "2x2" : "1x4";
//            } else {
//                return "undefined";
//            }
//        }
//    }
//
//    public static String roomCategory(String roomSize, String roomColor) {
//        if (roomSize.equals("1x1")) {
//            switch (roomColor) {
//                case "brown":
//                    return "1x1";
//                case "purple":
//                    return "Puzzle";
//                case "orange":
//                    return "Trap";
//                case "green":
//                case "red":
//                case "pink":
//                case "yellow":
//                    return "General";
//                default:
//                    return "undefined";
//            }
//        } else {
//            return roomSize;
//        }
//    }
//
//    public static Point playerMarkerPos() {
//        if (!mapExists()) {
//            return null;
//        } else {
//            Minecraft mc = Minecraft.getMinecraft();
//            ItemStack mapSlot = mc.thePlayer.inventory.getStackInSlot(8);
//            MapData mapData = Items.filled_map.getMapData(mapSlot, mc.theWorld);
//            if (mapData == null) {
//                return null;
//            } else {
//                if (mapData.mapDecorations != null) {
//                    Iterator var3 = mapData.mapDecorations.entrySet().iterator();
//
//                    while(var3.hasNext()) {
//                        Map.Entry<String, Vec4b> entry = (Map.Entry)var3.next();
//                        if (((Vec4b)entry.getValue()).func_176110_a() == 1) {
//                            int x = ((Vec4b)entry.getValue()).func_176112_b() / 2 + 64;
//                            int y = ((Vec4b)entry.getValue()).func_176113_c() / 2 + 64;
//                            return new Point(x, y);
//                        }
//                    }
//                }
//
//                return null;
//            }
//        }
//    }
//
//    public static Point getPhysicalCornerPos(String direction, List<Point> currentPhysicalSegments) {
//        TreeSet<Integer> xSet = new TreeSet();
//        TreeSet<Integer> ySet = new TreeSet();
//        Iterator var4 = currentPhysicalSegments.iterator();
//
//        while(var4.hasNext()) {
//            Point segment = (Point)var4.next();
//            xSet.add(segment.x);
//            ySet.add(segment.y);
//        }
//
//        switch (direction) {
//            case "NW":
//                return new Point((Integer)xSet.first(), (Integer)ySet.first());
//            case "NE":
//                return new Point((Integer)xSet.last() + 30, (Integer)ySet.first());
//            case "SE":
//                return new Point((Integer)xSet.last() + 30, (Integer)ySet.last() + 30);
//            case "SW":
//                return new Point((Integer)xSet.first(), (Integer)ySet.last() + 30);
//            default:
//                return null;
//        }
//    }
//
//    public static List<String> possibleDirections(String roomSize, List<Point> currentRoomSegments) {
//        List<String> directions = new ArrayList();
//        if (!roomSize.equals("1x1") && !roomSize.equals("2x2")) {
//            TreeSet<Integer> xSet = new TreeSet();
//            TreeSet<Integer> ySet = new TreeSet();
//            Iterator var5 = currentRoomSegments.iterator();
//
//            while(var5.hasNext()) {
//                Point segment = (Point)var5.next();
//                xSet.add(segment.x);
//                ySet.add(segment.y);
//            }
//
//            if (roomSize.equals("L-shape")) {
//                List<Integer> x = new ArrayList(xSet);
//                List<Integer> y = new ArrayList(ySet);
//                if (!currentRoomSegments.contains(new Point((Integer)x.get(0), (Integer)y.get(0)))) {
//                    directions.add("SW");
//                } else if (!currentRoomSegments.contains(new Point((Integer)x.get(0), (Integer)y.get(1)))) {
//                    directions.add("SE");
//                } else if (!currentRoomSegments.contains(new Point((Integer)x.get(1), (Integer)y.get(0)))) {
//                    directions.add("NW");
//                } else if (!currentRoomSegments.contains(new Point((Integer)x.get(1), (Integer)y.get(1)))) {
//                    directions.add("NE");
//                }
//            } else if (roomSize.startsWith("1x")) {
//                if (xSet.size() >= 2 && ySet.size() == 1) {
//                    directions.add("NW");
//                    directions.add("SE");
//                } else if (xSet.size() == 1 && ySet.size() >= 2) {
//                    directions.add("NE");
//                    directions.add("SW");
//                }
//            }
//        } else {
//            directions.add("NW");
//            directions.add("NE");
//            directions.add("SE");
//            directions.add("SW");
//        }
//
//        return directions;
//    }
//
//    public static BlockPos actualToRelative(BlockPos actual, String cornerDirection, Point locationOfCorner) {
//        double x = 0.0;
//        double z = 0.0;
//        switch (cornerDirection) {
//            case "NW":
//                x = (double)actual.getX() - locationOfCorner.getX();
//                z = (double)actual.getZ() - locationOfCorner.getY();
//                break;
//            case "NE":
//                x = (double)actual.getZ() - locationOfCorner.getY();
//                z = -((double)actual.getX() - locationOfCorner.getX());
//                break;
//            case "SE":
//                x = -((double)actual.getX() - locationOfCorner.getX());
//                z = -((double)actual.getZ() - locationOfCorner.getY());
//                break;
//            case "SW":
//                x = -((double)actual.getZ() - locationOfCorner.getY());
//                z = (double)actual.getX() - locationOfCorner.getX();
//        }
//
//        return new BlockPos(x, (double)actual.getY(), z);
//    }
//
//    public static BlockPos relativeToActual(BlockPos relative, String cornerDirection, Point locationOfCorner) {
//        double x = 0.0;
//        double z = 0.0;
//        switch (cornerDirection) {
//            case "NW":
//                x = (double)relative.getX() + locationOfCorner.getX();
//                z = (double)relative.getZ() + locationOfCorner.getY();
//                break;
//            case "NE":
//                x = -((double)relative.getZ() - locationOfCorner.getX());
//                z = (double)relative.getX() + locationOfCorner.getY();
//                break;
//            case "SE":
//                x = -((double)relative.getX() - locationOfCorner.getX());
//                z = -((double)relative.getZ() - locationOfCorner.getY());
//                break;
//            case "SW":
//                x = (double)relative.getZ() + locationOfCorner.getX();
//                z = -((double)relative.getX() - locationOfCorner.getY());
//        }
//
//        return new BlockPos(x, (double)relative.getY(), z);
//    }
//}
