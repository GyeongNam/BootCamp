package C17_Exception_File_Parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class C1704_Json_With_JackSonClass {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Students> studentsList = new ArrayList<>();
        File path = Paths.get("src/C17_Exception_File_Parsing/test-data2.json").toFile();
        for(JsonNode a : mapper.readTree(path).get("students")){
            studentsList.add(mapper.readValue(a.toString(),Students.class));
        }
        System.out.println(studentsList);
    }
}
class Students{
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private int classNumber;
    private String city;
    Students(){

    }

    @Override
    public String toString() {
        return "\n"+
                "id:" + this.id + "\n"+
                "name:" + this.name + "\n"+
                "classNumber:" + this.classNumber + "\n"+
                "city:" + this.city + "\n";
    }
}