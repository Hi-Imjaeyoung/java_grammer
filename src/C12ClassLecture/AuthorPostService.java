package C12ClassLecture;

// 생성자 모든 인스턴스 변수 초기화
// 모든 클래스에 getter 생성

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AuthorPostService {
    static List<Author> authors;
    static List<Post> posts;
    public static void main(String[] args) {
        authors = new LinkedList<>();
        posts = new LinkedList<>();
        boolean isLogin = false;
        while (true){
            Scanner sc = new Scanner(System.in);
            int caseIdentify = Integer.parseInt(sc.nextLine());
            if(caseIdentify==0){
                System.out.println("아이디를 입력해주세요");

            }else if(caseIdentify==1){
                //1 회원 가입
                System.out.println("회원 정보를 입력해 주세요. '이름 이메일 비밀번호' (띄어쓰기로 구분됩니다)");
                registerAuthor(sc.nextLine().split(" "));
            }else if(caseIdentify==2){
                //2 게시글 작성
                if(isLogin){
                    System.out.println("게시물 정보를 입력해 주세요. '회원Id 제목 내용' (띄어쓰기로 구분됩니다)");
                    writePost(sc.nextLine().split(" "));
                }else{
                    System.out.println("로그인을 해주세요");
                }
            }else if(caseIdentify==3){
                //3 회원목록 조회 : 회원명, 회원 이메일들을 출력
                showAuthors();
            }else if(caseIdentify==4){
                //4 회원 상세 조회 : input 회원명 output 회원 이메일, 회원 작성 글 수
                System.out.println("회원의 ID를 입력해 주세요.");
                showDetailAuthors(sc.nextInt());
            }else{
                //5 게시글 상세 조회 : 제목, 작성자 이메일을 출력
                showDetailPost();
            }
        }
    }
    public static void showDetailPost(){
        for(Post nowPost : posts){
            System.out.println("현재 게시물들은 ");
            StringBuilder sb = new StringBuilder();
            sb.append("제목 : "+nowPost.getTitle()+" 내용 : "+nowPost.getContents());
            for(Author nowAuthor :authors){
                if(nowAuthor.getId() == nowAuthor.getId()){
                    sb.append(" 작성자 : "+nowAuthor.getName()+"\n");
                    break;
                }
            }
            System.out.println(sb);
        }

    }
    public static void showDetailAuthors(int inputAuthorId){
        for(Author nowAuthor :authors){
            if(nowAuthor.getId() == inputAuthorId){
                System.out.println("조회하신 회원의 이름은 : "+nowAuthor.getName()+" 이메일은 : "+nowAuthor.getEmail());
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Post nowPost : posts){
            System.out.println("회원님이 작성하신 글은");
            if(nowPost.getauthorId()==inputAuthorId){
                sb.append("제목 : "+nowPost.getTitle()+" 내용 : "+nowPost.getContents()+"\n");
            }
        }
        System.out.println(sb);
    }
    public static void showAuthors(){
        for(Author nowAuthor : authors){
            System.out.println("회원 이름 : "+nowAuthor.getName()+" 회원 이메일 : "+nowAuthor.getEmail());
        }
    }
    public static boolean login(String id, String  passwd){

    }
    public static void writePost(String[] inputs){

        posts.add(new Post(Long.valueOf(Integer.parseInt(inputs[0])),inputs[1],inputs[2]));
        System.out.println("이 게시물 id는" + posts.get(posts.size()-1).getId());
    }
    public static void registerAuthor(String[] inputs){
        authors.add(new Author(inputs[0],inputs[1],inputs[2]));
        System.out.println("현재 author id는 " + authors.get(authors.size()-1).getId());
        System.out.println("현재 까지 가입자는 : " + authors.size());
    }
}
// DB의 entity = 자바의 인스턴스 변수.
class Author{
    // autoGenerate
    private static long staticId;

    private long id;
    private String name, email,passwd;

    Author(String name,String email,String passwd){
        staticId++;
        id = staticId;
        this.name = name;
        this.email = email;
        this.passwd = passwd;
    }
    public long getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswd() {
        return passwd;
    }
}
class Post{
    private static long staticId;
    private Long id,author_id = 0L;
    private String title,contents;

    Post(long author_id,String title,String contents){
        staticId++;
        id = staticId;
        this.author_id = author_id;
        this.title = title;
        this.contents = contents;
    }
    public long getId(){
        return id;
    }
    public long getauthorId(){
        return author_id;
    }
    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }
}