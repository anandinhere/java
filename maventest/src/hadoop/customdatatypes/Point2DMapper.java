package hadoop.customdatatypes;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Point2DMapper extends Mapper<Text, Point2D, Text, Point2D> {
	@Override
	protected void map(Text key, Point2D value,
			Mapper<Text, Point2D, Text, Point2D>.Context context)
			throws IOException, InterruptedException {
		int x = value.x;
		int y = value.x;

		if (x >= 0 && y >= 0) {
			context.write(key, value);
		}
	}
}
