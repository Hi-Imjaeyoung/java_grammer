package C17ExceptionFileParseing;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

// text file parsing!
public class C1702FileParsing {
    public static void main(String[] args) {
//        C:\Users\imjy2\Desktop\임재영_수강\java_grammer\src\C17ExceptionFileParseing 시스템 경로
//        src\C17ExceptionFileParseing  자바 경로
                                        // java에서는 경로 구분 / 로
        Path filePath = Paths.get("src/C17ExceptionFileParseing/test_file.txt");
//      버퍼 기능이 구현되어 있고, NIO 패키지에서는 NonBlocking방식 사용
        // 기본이 UTF-8
//        Files.write(filePath,"손흥민\n".getBytes());
//        CREATE_NEW 이후에 APPEND 실행 가능.
        try {
            // write는 CheckedException이라서 예외처리가 필수
            if(Files.exists(filePath)){
                // append 추가 , write 덮어쓰기
                Files.write(filePath,"손흥민\n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            }else {
                Files.write(filePath,"".getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE_NEW);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        // 파일 읽기 : readString, readAllLines(List 형태) : 한 줄씩 잘라줘용
        try {
            String myString = Files.readString(filePath);
            System.out.print(myString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");
        try {
            List<String> myList = Files.readAllLines(filePath);
            for(String s : myList){
                System.out.println(s+" 슈퍼 손~ 슈퍼 콘");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
