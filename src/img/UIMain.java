package img;

import java.io.IOException;

import ecs100.UI;
import ecs100.UIButtonListener;

public class UIMain {

	private static String fileName = "D://lib//resources//greyRose.PGM";
	private static int[][] currentArray;

	private UIMain() {
		UI.initialise();
		addButtons();
	}

	public static void main(String... args) {
		new UIMain();
	}

	private static void addButtons() {
		UI.addButton("Load Img", new UIButtonListener() {

			@Override
			public void buttonPerformed() {
				currentArray = IO.readFileAsArray(fileName);
				printCurrentArray();
			}

		});

		UI.addButton("Invert", new UIButtonListener() {
			@Override
			public void buttonPerformed() {
				currentArray = ImgProc.invert(IO.readFileAsArray(fileName));
				printCurrentArray();
			}
		});

		UI.addButton("Save", new UIButtonListener() {
			@Override
			public void buttonPerformed() {
				try {
					IO.saveArrayAsImage(currentArray);
				} catch (IOException e) {
					e.printStackTrace();
					UI.println(e.getLocalizedMessage());
				}
			}
		});

	}

	private static void printCurrentArray() {
		ImgProc.printImage(currentArray);
	}

}
