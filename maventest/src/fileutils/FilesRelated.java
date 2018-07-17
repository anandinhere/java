package fileutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;

public class FilesRelated {
	public static void main(String[] args) throws IOException {

		checkFilesOrder(args);

		/*
		 * File folder = new File(args[0]);
		 * 
		 * File[] files = folder.listFiles();
		 * 
		 * for (File file : files) {
		 * 
		 * FileReader fileReader = new FileReader(file); BufferedReader
		 * bufferedReader = new BufferedReader(fileReader);
		 * 
		 * String line = null;
		 * 
		 * // line.spl
		 * 
		 * while ((line = bufferedReader.readLine()) != null) { if
		 * (line.contains("CSVExcelStorage") &&
		 * line.contains("$LOAD_OUTPUT/delete/")) {
		 * 
		 * int fileNameStartIndex = line .indexOf("$LOAD_OUTPUT/delete/") + 20;
		 * 
		 * String temp = line.substring(fileNameStartIndex);
		 * System.out.println(temp.substring(0, temp.indexOf("'")));
		 * 
		 * } } bufferedReader.close();
		 * 
		 * }
		 */

	}

	private static void checkFilesOrder(String[] args) {
		File dir = new File(args[0]);
		System.out.println(args[0]);
		Collection<File> files = FileUtils.listFiles(dir, null, true);
		List<File> filesList = new ArrayList<File>(files);
		if ("Y".equalsIgnoreCase("y")) {
			Collections.sort(filesList);
		}

		ArrayList<String> testStrs = new ArrayList<String>();

		/*
		 * for (File dataFile : filesList) { testStrs.add(dataFile.getName());
		 * System.out.println(dataFile.getName()); }
		 * 
		 * Collections.sort(testStrs); System.out.println("********"); for
		 * (String s : testStrs)
		 * 
		 * System.out.println(s);
		 */

		TreeMap<Integer, File> filesMap = new TreeMap<Integer, File>();
		for (File dataFile : filesList) {
			System.out.println(dataFile.getName());

			String[] fileName = (dataFile.getName()).split("\\.");

			Integer fileNameNumberPart = Integer.valueOf(fileName[0]);
			filesMap.put(fileNameNumberPart, dataFile);
		}

		List<File> sortedFiles = (List<File>) filesMap.values();
		for (File f : sortedFiles) {
			System.out.println(f.getName());
		}

	}

	// System.out.println(getFileContents(file.getAbsolutePath()));
	@SuppressWarnings("unused")
	private static String getFileContents(String fileLocation)
			throws IOException {

		File file = new File(fileLocation);
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fis.read(data);
		fis.close();
		return new String(data, "UTF-8");
	}
}
