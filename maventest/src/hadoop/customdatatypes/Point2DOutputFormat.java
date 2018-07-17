package hadoop.customdatatypes;

import java.io.IOException;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.RecordWriter;
import org.apache.hadoop.util.Progressable;

public class Point2DOutputFormat extends FileOutputFormat<Text, Point2D> {

	@Override
	public RecordWriter<Text, Point2D> getRecordWriter(FileSystem ignored,
			JobConf job, String name, Progressable progress) throws IOException {
		Path file = FileOutputFormat.getTaskOutputPath(job, name);
		FileSystem fs = file.getFileSystem(job);
		FSDataOutputStream fileOut = fs.create(file,progress);
		return new Point2DRecordWriter(fileOut);
	}

}
