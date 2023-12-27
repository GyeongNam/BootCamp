package C17_Exception_File_Parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInput;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class C1705_Json_With_JackSonHttp {
    public static void main(String[] args) {
        // http 클라 생성
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        // http 요청객체 생성
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();

        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .GET()
                .build();

        // http 응답 객체 생성
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonNode node = mapper.readTree(response.body());
            Post post = new Post(
                    node.get("userId").asInt(),
                    node.get("id").asInt(),
                    node.get("title").asText(),
                    node.get("body").asText()
            );
            Post post1 = mapper.readValue(response.body(),Post.class);
            // System.out.println(post1);

            /*
            json Node는 트리구조 이므로,
            for(JsonNode a : jsonNode) 형식으로 사용가능
            */

            HttpResponse<String> response1 = client.send(request1, HttpResponse.BodyHandlers.ofString());
            ArrayList<Post> postArrayList = new ArrayList<>();
            JsonNode node1 = mapper.readTree(response1.body());
            for(JsonNode a : node1){
//                Post post3 = new Post(
//                        a.get("userId").asInt(),
//                        a.get("id").asInt(),
//                        a.get("title").asText(),
//                        a.get("body").asText()
//                );
                Post post3 = mapper.readValue(a.toString(),Post.class);
                postArrayList.add(post3);
            }
            System.out.println(postArrayList);

            // java 객체를 json 데이터로 정렬화
            String serialized_data = mapper.writeValueAsString(postArrayList);
            System.out.println(serialized_data);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class Post{
    private int userId;
    private int id;
    private String title;
    private String body;
    Post(int userId,  int id,  String title, String body){
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
    Post(){

    }
    @Override
    public String toString() {
        return "userId : " + this.userId + "\n"
                + "id : " + this.id + "\n"
                + "title : " + this.title + "\n"
                + "body : " + this.body + "\n";
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}