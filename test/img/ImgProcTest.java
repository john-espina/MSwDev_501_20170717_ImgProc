package img;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ImgProcTest {
	
	String fileName = "C://greyRose.PGM";

	@Test
	public void test() {
		ImgProc.printImage(IO.readFileAsArray(fileName));
	}

}
