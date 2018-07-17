package hadoop.customdatatypes;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class Point2D implements Writable {

	public int x;
	public int y;

	public Point2D() {
		this(0, 0);
	}

	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void readFields(DataInput in) throws IOException {
		x = in.readInt();
		y = in.readInt();
	}

	public void write(DataOutput out) throws IOException {
		out.writeInt(x);
		out.writeInt(y);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
