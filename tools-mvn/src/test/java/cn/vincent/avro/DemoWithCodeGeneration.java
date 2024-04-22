package cn.vincent.avro;

import cn.vincent.demo.avro.Student;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class DemoWithCodeGeneration {
    public static void main(String[] args) throws IOException {
        Student student = Student.newBuilder()
                .setId(1)
                .setName("bob")
                .setCourses(Arrays.asList("geography", "history"))
                .build();

        Path path = Paths.get(DemoWithCodeGeneration.class.getClassLoader().getResource("").getPath().substring(1), "student.avsc");
        DatumWriter<Student> datumWriter = new SpecificDatumWriter<Student>(Student.class);
        DataFileWriter<Student> dataFileWriter = new DataFileWriter<Student>(datumWriter);
        dataFileWriter.create(student.getSchema(), path.toFile());
        dataFileWriter.append(student);
        dataFileWriter.close();

        DatumReader<Student> datumReader = new SpecificDatumReader<Student>(Student.class);
        DataFileReader<Student> dataFileReader = new DataFileReader<Student>(path.toFile(), datumReader);
        student = null;
        while (dataFileReader.hasNext()) {
            student = dataFileReader.next(student);
            System.out.println(student);
        }
    }
}
