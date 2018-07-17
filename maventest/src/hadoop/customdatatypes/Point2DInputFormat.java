package hadoop.customdatatypes;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapred.InputSplit;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.RecordReader;
import org.apache.hadoop.mapred.Reporter;

public class Point2DInputFormat extends FileInputFormat<Text, Point2D> {

	@Override
	public RecordReader<Text, Point2D> getRecordReader(InputSplit split,
			JobConf job, Reporter reporter) throws IOException {

		reporter.setStatus(split.toString());
		return new Point2DRecordReader(job, (FileSplit) split);
	}

}
