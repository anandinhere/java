package fileutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PrintNoOfColumnsInHeader {
	public static void main(String[] args) throws IOException {
		File folder = new File(args[0]);

		File[] files = folder.listFiles();

		for (File file : files) {
			if (!file.isDirectory()) {
				printNoOfColumns(file.getAbsolutePath());
			}
		}
		
		for(int i =0;i<142;i++){
			System.out.print(i+",");
		}
	}

	private static void printNoOfColumns(String fileLocation)
			throws IOException {

		File file = new File(fileLocation);
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fis.read(data);
		fis.close();
		String header = new String(data, "UTF-8");
		System.out.println(file.getName().replace(".txt", "") + "," + (header.split(",")).length);
	}
}
