package C17ExceptionFileParseing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class C1704JsonWithJackSonClass {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        File myFilse = Paths.get("src/C17ExceptionFileParseing/testData2.json").toFile();
        List<Student> studentList = new ArrayList<>();
        try {
            JsonNode jsonNode = objectMapper.readTree(myFilse);
            for(JsonNode j : jsonNode.get("students")){
                studentList.add(objectMapper.readValue(j.toString(),Student.class));
            }
            System.out.println(studentList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
class Student{
    private int id;
    private int classNumber;
    private String name;
    private String city;

    public int getId() {
        return id;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
    @Override
    public String toString(){
        return "classNumber는 "+classNumber+" 이름은 : "+name+" 도시는 "+city;
    }
}
