package img;

import java.awt.Color;

import ecs100.UI;

public class ImgProc {

	// [height][width]
	public static void printImage(int[][] array) {		
		try {
			for (int y = 0; y < array.length; y++) {
				for (int x = 0; x < array[0].length; x++) {
					UI.setColor(new Color(array[y][x]));
					UI.fillRect((float) x, (float) y, 1F, 1F);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int[][] invert(int[][] array) {
		try {
			for (int y = 0; y < array.length; y++) {
				for (int x = 0; x < array[0].length; x++) {
					array[y][x] = 255 - array[y][x];
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

}
