package img;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import ecs100.UI;

public class IO {

	/**
	 * 
	 * @param fileName
	 * @return [height][width]
	 */
	public static int[][] readFileAsArray(String fileName) {
		int imageLineInFile = 3;

		int[] imgDim = null;
		try {
			imgDim = getImgDimensions(fileName);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int height = imgDim[1];
		int width = imgDim[0];

		int[][] array = new int[height][width];

		int currentLine = 0;
		int currentCol = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			// skip
			while (imageLineInFile-- > 0) {
				br.readLine();
			}

			String lineStr;
			outer: while ((lineStr = br.readLine()) != null) {
				String[] splittedLine = lineStr.split(" ");
				for (int i = 0; i < splittedLine.length; i++) {
					// check if is the end of line
					if (currentCol == width) {
						currentLine++;
						currentCol = 0;
						// check if is the end of rows
						if (currentLine == height) {
							break outer;
						}
					}
					array[currentLine][currentCol++] = Integer.parseInt(splittedLine[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return array;
	}

	/**
	 * @param fileName
	 * @return [width][height]
	 * @throws IOException
	 */
	protected static int[] getImgDimensions(String fileName) throws IOException {
		String[] splitted = getLine(1, fileName).split(" ");
		return new int[] { Integer.valueOf(splitted[0]), Integer.valueOf(splitted[1]) };
	}

	/**
	 * first line is 0
	 * 
	 * @param single
	 *            line to return
	 * @return the respective line as String
	 * @throws IOException
	 */
	protected static String getLine(int line, String fileName) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while (line-- > 0) {
				br.readLine();
			}
			return br.readLine();
		}
	}

	public static void saveArrayAsImage(int[][] array) throws IOException {
		String fileName = "C:\\Users\\Public\\Documents\\savedImage.bmp";
		int height = array.length;
		int width = array[0].length;
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				bi.setRGB(x, y, (array[y][x]) | 0xFF0000);
			}
		}
		ImageIO.write(bi, "BMP", new File(fileName));
		UI.println("Saved on " + fileName);
	}

}
