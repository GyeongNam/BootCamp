package C17_Exception_File_Parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class C1703_Json_With_JackSonRaw {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // readTree 를 통해서 json을 계층적 트리구조 형태로 변환
            File path = Paths.get("src/C17_Exception_File_Parsing/test-data1.json").toFile();
            JsonNode jsonNode = objectMapper.readTree(path);
            Map<String, String> map = new HashMap<>();
            map.put("id", jsonNode.get("id").asText());
            map.put("name", jsonNode.get("name").asText());
            map.put("classNumber", jsonNode.get("classNumber").asText());
            map.put("city", jsonNode.get("city").asText());
            System.out.println(map);

            // key : value 중에 value의 타입이 예상되지 않을 때는 Object 타입으로도 받을 수 있다.
            Map<String, Object> stringMap = objectMapper.readValue(path,Map.class);
            System.out.println(stringMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
