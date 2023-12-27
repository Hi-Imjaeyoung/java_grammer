package C17ExceptionFileParseing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedList;
import java.util.List;

public class C1705JsonWithJackSonHttp {
    public static void main(String[] args) {
        // http 클라이언트 생성
        HttpClient client = HttpClient.newHttpClient();
        // http 요청 객체 생성
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .GET()
                .build();
        // http 응답객체 생성
        ObjectMapper mapper = new ObjectMapper();

        try {
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            String post = response.body();
//            System.out.println(post);
            JsonNode jsonNode = mapper.readTree(post);
//            Post post1 = new Post(jsonNode.get("userId").asInt()
//                    ,jsonNode.get("id").asInt()
//                    ,jsonNode.get("title").asText()
//                    ,jsonNode.get("body").asText());
//            System.out.println(post1);

//            readValue를 사용해서 객체로 곧바로 매핑
            // getter는 필요하다.
            // Post post2 = mapper.readValue(post,Post.class);
            // System.out.println(post2);

            List<Post> posts = new LinkedList<>();
            // JsonNode는 트리구조 이므로 아래와 같은 형식이 가능하다
            for(JsonNode j :jsonNode){
                posts.add(mapper.readValue(j.toString(),Post.class));
            }
            //System.out.println(posts.size());
            //System.out.println(posts.get(99));

            // 자바 객체에 대한 정보를 Json 데이터로 직렬화과정
            String serialized_data = mapper.writeValueAsString(posts);
            //System.out.println(serialized_data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
class Post<T>{
    private T userId;
    private T id;
    private String title;
    private String body;

    public T getUserId() {
        return userId;
    }

    public T getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    Post(){

    }

    Post(T userId, T id, String title,String body){
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
    @Override
    public String toString(){
        return "userId : "+userId+"\nid: "+id+"\ntitle :"+title+"\nbody : "+body;
    }
}
