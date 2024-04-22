package cn.vincent.avro;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class DemoWithoutCodeGeneration {
    public static void main(String[] args) throws IOException {
        Path schemaPath = Paths.get(DemoWithoutCodeGeneration.class.getClassLoader().getResource("avro/student.avsc").getPath().substring(1));
        Schema schema = new Schema.Parser().parse(schemaPath.toFile());
        GenericRecord student = new GenericData.Record(schema);
        student.put("id", 2);
        student.put("name", "john");
        student.put("courses", Arrays.asList("maths", "sports"));

        Path path = Paths.get(DemoWithoutCodeGeneration.class.getClassLoader().getResource("").getPath().substring(1), "student.avsc");
        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
        dataFileWriter.create(schema, path.toFile());
        dataFileWriter.append(student);
        dataFileWriter.close();

        DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>(schema);
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<GenericRecord>(path.toFile(), datumReader);
        student = null;
        while (dataFileReader.hasNext()) {
            student = dataFileReader.next(student);
            System.out.println(student);
        }
    }
}
