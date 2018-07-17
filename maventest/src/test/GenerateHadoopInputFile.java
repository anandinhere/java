package test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import au.com.bytecode.opencsv.CSVWriter;

public class GenerateHadoopInputFile {
	public static void main(String[] args) {
		CSVWriter writer;
		try {
			writer = new CSVWriter(new FileWriter(args[0]
					+ "\\hadoop_input_coordinates.csv"));

			for (int i = 0; i <= 100000; i++) {

				// nextInt is normally exclusive of the top value,
				// so add 1 to make it inclusive
				GenerateHadoopInputFile genHdpFile = new GenerateHadoopInputFile();

				String record[] = { String.valueOf(genHdpFile.getRandomChar()),
						String.valueOf(genHdpFile.getRandomInt()),
						String.valueOf(genHdpFile.getRandomInt()) };

				writer.writeNext(record);

			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int getRandomInt() {
		Random rand = new Random();
		return (rand.nextInt((5 - (-5)) + 1) + (-5));
	}

	private char getRandomChar() {
		Random r = new Random();
		char c = (char) (r.nextInt(26) + 'a');
		return c;
	}

}
