package hadoop.dirvers;

import hadoop.customdatatypes.Point2D;
import hadoop.customdatatypes.Point2DMapper;
import hadoop.customdatatypes.Point2DReducer;
import hadoop.dirvers.WordCount.IntSumReducer;
import hadoop.dirvers.WordCount.TokenizerMapper;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class Point2DDriver {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "Point 2D");

		String[] otherArgs = new GenericOptionsParser(conf, args)
				.getRemainingArgs();
		if (otherArgs.length != 2) {
			System.err.println("Usage: wordcount <in> <out>");
			System.exit(2);
		}

		if (!(otherArgs.length != 2 || otherArgs.length != 4)) {
			System.err
					.println("Usage: wordcount <in> <out> [-skip skipPatternFile]");
			System.exit(2);
		}

		job.setJarByClass(Point2DDriver.class);
		job.setMapperClass(Point2DMapper.class);
		job.setCombinerClass(Point2DReducer.class);
		job.setReducerClass(Point2DReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Point2D.class);

		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}
