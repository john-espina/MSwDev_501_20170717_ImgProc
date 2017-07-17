package img;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class IOTest {

	String fileName = "C://greyRose.PGM";

	@Test
	public void getLineTest() throws IOException {
		assertEquals("P2 ", IO.getLine(0, fileName));
		assertEquals("255  ", IO.getLine(2, fileName));
	}

	@Test
	public void getLineDimensionTest() throws IOException {
		int[] imgDimensions = IO.getImgDimensions(fileName);
		assertEquals(345, imgDimensions[0]); // width
		assertEquals(317, imgDimensions[1]); // height
	}

	@Test
	public void readFileAsArrayTest() {
		// [height][width]
		int[][] fileAsArray = IO.readFileAsArray(fileName);
		int height = fileAsArray.length;
		int width = fileAsArray[0].length;
		assertEquals(317, height); // height
		assertEquals(345, width); // width
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				System.out.print(fileAsArray[y][x] + " ");
			}
			System.out.println("");
			// print just 10 lines
			if (y == 10) {
				break;
			}
		}
	}

}
