package fileutils;

import java.io.File;

public class TestFileExists {
	public static void main(String[] args) {
		File testFile = new File(args[0]);

		if (testFile.exists()) {
			System.out.println("Exists");
		}

	}
}
