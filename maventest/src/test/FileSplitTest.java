package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileSplitTest {
	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");
	private String inputFile;
	private String outputPath;
	private int recordsPerFile;

	public FileSplitTest(String inputFile, String outputPath, int recordsPerFile)
			throws Exception {
		this.inputFile = inputFile;
		this.outputPath = outputPath;
		this.recordsPerFile = recordsPerFile;

		// Create output folder if it doesn't exist
		File outputDir = new File(outputPath);
		if (!outputDir.exists()) {
			outputDir.mkdir();
		}
	}

	public static void main(String[] args) throws Exception {
		if (args == null || args.length < 3) {
			System.out
					.println("Provide \n 1.Task or Event File Name \n 2. OutputDirectory to write split data \n 3. Records per file");
			//System.exit(0);
		}

		String inputFile = "hi";
		String outputPath = "hello";
		String recordsPerFileStr = "";
		int recordsPerFile = 10000;

		if (null != recordsPerFileStr && !recordsPerFileStr.equals("")) {
			recordsPerFile = Integer.parseInt(recordsPerFileStr);
		}

		FileSplitTest activitySplitter = new FileSplitTest(inputFile,
				outputPath, recordsPerFile);
		activitySplitter.splitFiles();
	}

	public void splitFiles() throws UnsupportedEncodingException,
			FileNotFoundException, Exception, IOException {

		long totalLinesCount = 2000000;

		if (totalLinesCount == 0) {
			return;
		}

		long numSplits = totalLinesCount / recordsPerFile;

		BufferedWriter bw = null;
		String lineStr = null;
		int destIx = 0;
		int idxCounter = 1;
		int count = 1;
		int fileIdx = 0;

		for (; destIx < numSplits; destIx++) {
			fileIdx = ((destIx + 1) % 10 == 0) ? (idxCounter - 1) * 1000
					: (((destIx + 1) % 10) * 1000);
			fileIdx += idxCounter;
			System.out.println(fileIdx);
			count++;
			if (count % 10 == 0) {
				idxCounter++;
			}

			// If File exists give a different file name
			File outputFile = new File(outputPath + "/" + fileIdx + ".csv");
			if (outputFile.exists()) {
				fileIdx = ((destIx + 1) % 10 == 0) ? (idxCounter - 1) * 99999
						: (((destIx + 1) % 10) * 99999);
				fileIdx += idxCounter;
			}

			bw = new BufferedWriter(new FileWriter(outputPath + "/" + fileIdx
					+ ".csv", true));

			for (int i = 0; i < recordsPerFile; i++) {
				// readWrite(bw, raf.readLine());
			}

			bw.close();
		}

	}

	static void readWrite(BufferedWriter bw, String lineStr) throws IOException {
		if (null != lineStr) {
			bw.write(lineStr);
			bw.write(LINE_SEPARATOR);
		}
	}

	static long getLinesCount(String fileName) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName)));
		long linesCount = 0;
		String input = null;

		while ((input = reader.readLine()) != null) {
			linesCount++;
		}
		reader.close();
		return linesCount;
	}
}
