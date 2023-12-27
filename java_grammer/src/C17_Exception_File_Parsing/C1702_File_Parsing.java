package C17_Exception_File_Parsing;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class C1702_File_Parsing {
    public static void main(String[] args)  {
        /*
        src\C17_Exception_File_Parsing
         */
        Path filePath = Paths.get("src/C17_Exception_File_Parsing/text_file.txt");

        /*
        버퍼 기능이 구현되어있고, nio 패키지에서는 non-blocking 방식 사용
        기본이 StandardCharsets.UTF_8 이다.
        */
        try {
            if(Files.exists(filePath)){
                Files.write(filePath, "손흥민\n".getBytes(), StandardOpenOption.WRITE);
            }else{
                Files.write(filePath, "손흥민\n".getBytes(), StandardOpenOption.CREATE_NEW);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        // 파일 일기 : readString , readAllLines(List 형태)
        try {
            String str = Files.readString(filePath);
            System.out.println(str);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println();

        try {
            List<String> stringList = Files.readAllLines(filePath);
            for(String str :stringList){
                System.out.println(str);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
