package hadoop.customdatatypes;

import java.io.DataOutputStream;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.RecordWriter;
import org.apache.hadoop.mapred.Reporter;

public class Point2DRecordWriter implements RecordWriter<Text, Point2D> {

	private static final String utf8 = "UTF-8";

	private DataOutputStream out;

	public Point2DRecordWriter(DataOutputStream out) throws IOException {
		this.out = out;
		out.writeBytes("Test");
	}

	@Override
	public void write(Text key, Point2D value) throws IOException {
		boolean nullkey = key == null;
		boolean nullValue = value == null;

		if (nullkey && nullValue) {
			return;
		}

		Text keyObj = key;

		if (nullkey) {
			keyObj = new Text("value");
		}

		writeKey(keyObj);

		if (!nullValue) {
			writeValue(value);
		}

	}

	private void writeValue(Point2D value) throws IOException {
		out.writeBytes("X Coordinate : ");
		out.writeBytes(String.valueOf(value.x));

		out.writeBytes("Y Coordinate : ");
		out.writeBytes(String.valueOf(value.y));
	}

	private void writeKey(Text keyObj) throws IOException {
		out.writeBytes(keyObj.toString());
	}

	@Override
	public void close(Reporter reporter) throws IOException {
		out.close();

	}

}
