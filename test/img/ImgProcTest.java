package img;

import org.junit.Test;

public class ImgProcTest {

	String fileName = "D://lib//resources//greyRose.PGM";

	@Test
	public void test() {
		ImgProc.printImage(IO.readFileAsArray(fileName));
	}

}
