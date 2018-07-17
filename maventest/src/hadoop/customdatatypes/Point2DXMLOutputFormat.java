package hadoop.customdatatypes;

import java.io.IOException;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.RecordWriter;
import org.apache.hadoop.util.Progressable;

public class Point2DXMLOutputFormat extends FileOutputFormat<Text, Point2D> {

	@Override
	public RecordWriter<Text, Point2D> getRecordWriter(FileSystem ignored,
			JobConf job, String name, Progressable progress) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
