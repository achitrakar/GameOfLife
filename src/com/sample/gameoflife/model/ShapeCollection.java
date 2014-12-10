package com.sample.gameoflife.model;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ShapeCollection {
	private static int[][] Glider = { { 1, 0 }, { 2, 1 }, { 2, 2 }, { 1, 2 }, { 0, 2 } };
	private static int[][] smallExploder = { { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 3 }, { 2, 1 }, { 2, 2 } };
	private static int[][] exploder = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 2, 0 }, { 2, 4 }, { 4, 0 },
			{ 4, 1 }, { 4, 2 }, { 4, 3 }, { 4, 4 } };
	private static int[][] tenCellRow = { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 }, { 4, 0 }, { 5, 0 }, { 6, 0 },
			{ 7, 0 }, { 8, 0 }, { 9, 0 } };
	private static int[][] lightweightSpaceship = { { 0, 1 }, { 0, 3 }, { 1, 0 }, { 2, 0 }, { 3, 0 }, { 3, 3 },
			{ 4, 0 }, { 4, 1 }, { 4, 2 } };
	private static int[][] tumbler = { { 0, 3 }, { 0, 4 }, { 0, 5 }, { 1, 0 }, { 1, 1 }, { 1, 5 }, { 2, 0 }, { 2, 1 },
			{ 2, 2 }, { 2, 3 }, { 2, 4 }, { 4, 0 }, { 4, 1 }, { 4, 2 }, { 4, 3 }, { 4, 4 }, { 5, 0 }, { 5, 1 },
			{ 5, 5 }, { 6, 3 }, { 6, 4 }, { 6, 5 } };
	private static int[][] gliderGun = { { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 }, { 8, 3 }, { 8, 4 }, { 9, 2 }, { 9, 4 },
			{ 10, 2 }, { 10, 3 }, { 16, 4 }, { 16, 5 }, { 16, 6 }, { 17, 4 }, { 18, 5 }, { 22, 1 }, { 22, 2 },
			{ 23, 0 }, { 23, 2 }, { 24, 0 }, { 24, 1 }, { 24, 12 }, { 24, 13 }, { 25, 12 }, { 25, 14 }, { 26, 12 },
			{ 34, 0 }, { 34, 1 }, { 35, 0 }, { 35, 1 }, { 35, 7 }, { 35, 8 }, { 35, 9 }, { 36, 7 }, { 37, 8 } };

	public static HashMap<String, String> getShapeCollection() {
		HashMap<String, String> serverInfo = new LinkedHashMap<String, String>();
		serverInfo.put("None", "-1");
		serverInfo.put("Random", "0");
		serverInfo.put("Virus", "1");
		serverInfo.put("Cheshire Cat", "2");
		serverInfo.put("Pentomino", "3");
		serverInfo.put("Tumbler", "4");
		serverInfo.put("Harverster", "5");
		serverInfo.put("Glider", "6");
		serverInfo.put("Glider Gun", "7");
		serverInfo.put("Small Exploder", "8");
		serverInfo.put("Lightweight Spaceship", "9");
		serverInfo.put("Ten Cell Row", "10");

		return serverInfo;
	}

	public static int[][] getGlider() {
		return Glider;
	}

	public static int[][] getSmallExploder() {
		return smallExploder;
	}

	public static int[][] getExploder() {
		return exploder;
	}

	public static int[][] getTenCellRow() {
		return tenCellRow;
	}

	public static int[][] getLightweightSpaceship() {
		return lightweightSpaceship;
	}

	public static int[][] getTumbler() {
		return tumbler;
	}

	public static int[][] getGliderGun() {
		return gliderGun;
	}
}
