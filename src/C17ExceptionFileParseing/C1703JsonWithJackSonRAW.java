package C17ExceptionFileParseing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class C1703JsonWithJackSonRAW {
    // module에서 dependency 추가
    public static void main(String[] args) {
        // Mapper : json parser
        ObjectMapper mapper = new ObjectMapper();
        try {
//             readTree를 통해서 Json을 계층적 트리구조형태로 변환
//            JsonNode data1 = mapper.readTree((Paths.get("src/C17ExceptionFileParseing/testData1.json").toFile()));
//            Map<String,String> studentMap = new HashMap<>();
//            studentMap.put("id",data1.get("id").asText());
//            studentMap.put("name",data1.get("name").asText());
//            studentMap.put("classNumber",data1.get("classNumber").asText());
//            studentMap.put("city",data1.get("city").asText());
//            System.out.println(studentMap);


            File myPaths = Paths.get("src/C17ExceptionFileParseing/testData1.json").toFile();
            JsonNode data1 = mapper.readTree(myPaths);
            // value 타입이 불확실할 경우 Object 클래스 선언  //Overloading 되어서 File 형태도 가능하다.
            Map<String,String>studentMap = mapper.readValue(myPaths,Map.class);
            System.out.println(studentMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
