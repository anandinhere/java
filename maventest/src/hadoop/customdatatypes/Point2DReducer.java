package hadoop.customdatatypes;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Point2DReducer extends Reducer<Text, Point2D, Text, Point2D> {
	@Override
	protected void reduce(Text key, Iterable<Point2D> values,
			Reducer<Text, Point2D, Text, Point2D>.Context context)
			throws IOException, InterruptedException {

		for (Point2D value : values) {
			context.write(key, value);
		}
	}
}
