package hadoop.customdatatypes;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.LineRecordReader;
import org.apache.hadoop.mapred.RecordReader;

public class Point2DRecordReader implements RecordReader<Text, Point2D> {

	private LineRecordReader lineReader;
	private LongWritable linekey;
	private Text lineValue;

	public Point2DRecordReader(JobConf job, FileSplit split) throws IOException {
		lineReader = new LineRecordReader(job, split);
		linekey = lineReader.createKey();
		lineValue = lineReader.createValue();
	}

	
	
	@Override
	public boolean next(Text key, Point2D value) throws IOException {
		// get the next value
		if (!lineReader.next(linekey, key)) {
			return false;
		}

		// parse the lineValue which is in the format:
		// ObjName,x,y

		String[] pieces = lineValue.toString().split(",");
		if (pieces.length != 3) {
			throw new IOException("Invalid record received");
		}

		// try to parse int point components of value

		int ix, iy;
		try {
			ix = Integer.parseInt(pieces[1].trim());
			iy = Integer.parseInt(pieces[2].trim());
		} catch (NumberFormatException nfe) {
			throw new IOException(" Error parsing int  point value in record");
		}

		// now that we know we will succeed, overwrie the ouput objects

		key.set(pieces[0].trim());

		value.x = ix;
		value.y = iy;
		return true;
	}

	@Override
	public Text createKey() {
		return new Text("");
	}

	@Override
	public Point2D createValue() {
		return new Point2D();
	}

	@Override
	public long getPos() throws IOException {
		return lineReader.getPos();
	}

	@Override
	public void close() throws IOException {
		lineReader.close();
	}

	@Override
	public float getProgress() throws IOException {
		return lineReader.getProgress();
	}

}
