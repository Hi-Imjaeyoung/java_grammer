package C12ClassLecture;

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
            System.out.println("0 로그인, 1 회원가입, 2 게시글 작성, 3 회원목록 조회, 4 회원 상세 조회, 5 게시글 상세 조회");
            int caseIdentify = Integer.parseInt(sc.nextLine());
            if(caseIdentify==0){
                System.out.println("아이디를 입력해주세요");
                String inputEmail = sc.nextLine();
                System.out.println("비밀번호도 입력해주세요");
                String inputPasswd = sc.nextLine();
                if(login(inputEmail,inputPasswd)){
                    System.out.println("로그인 됬습니다");
                    isLogin = true;
                }else{
                    System.out.println("회원정보가 다릅니다.");
                }
            }else if(caseIdentify==1){
                //1 회원 가입
                System.out.println("회원 정보를 입력해 주세요. '이름 이메일 비밀번호' (띄어쓰기로 구분됩니다)");
                registerAuthor(sc.nextLine().split(" "));
            }else if(caseIdentify==2){
                //2 게시글 작성
                if(isLogin){
                    System.out.println("email을 입력해주세요");
                    Author writer = validateEmail(sc.nextLine());
                    if(writer == null){
                        System.out.println("이메일이 없습니다");
                        continue;
                    }
                    System.out.println("게시물 정보를 입력해 주세요. '제목 내용 (줄바꿈으로 구분됩니다)");
                    writePost(writer,sc.nextLine(),sc.nextLine());
                }else{
                    System.out.println("로그인을 해주세요");
                }
            }else if(caseIdentify==3){
                //3 회원목록 조회 : 회원명, 회원 이메일들을 출력
                showAuthors();
            }else if(caseIdentify==4){
                //4 회원 상세 조회 : input 회원명 output 회원 이메일, 회원 작성 글 수
                System.out.println("회원의 Email를 입력해 주세요.");
                showDetailAuthors(sc.nextLine());
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
            sb.append("게시물 번호 "+nowPost.getId()+" 제목 : "+nowPost.getTitle()+" 내용 : "+nowPost.getContents());
            // Author를 Post가 가짐으로서 해결
//            for(Author nowAuthor :authors){
//                if(nowAuthor.getId() == nowAuthor.getId()){
//                    sb.append(" 작성자 : "+nowAuthor.getName()+"\n");
//                    break;
//                }
//            }
            sb.append(" 작성자 :" +nowPost.getAuthor().getName());
            System.out.println(sb);
        }
    }
    public static void showDetailAuthors(String inputAuthorEmail){
        Author targetAuthor = null;
        for(Author nowAuthor :authors){
            if(nowAuthor.getEmail().equals(inputAuthorEmail)){
                targetAuthor = nowAuthor;
                System.out.println("조회하신 회원의 이름은 : "+nowAuthor.getName()+" 이메일은 : "+nowAuthor.getEmail());
                break;
            }
        }
        // author가 posts 를 가져서 해결
//        StringBuilder sb = new StringBuilder();
//        for(Post nowPost : posts){
//            System.out.println("회원님이 작성하신 글은");
//            if(nowPost.getAuthor().getId()==inputAuthorId){
//                sb.append("제목 : "+nowPost.getTitle()+" 내용 : "+nowPost.getContents()+"\n");
//            }
//        }
        System.out.println("작성한 총 포스트는"+ targetAuthor.postNumber()+" 개 입니다");
    }
    public static void showAuthors(){
        for(Author nowAuthor : authors){
            System.out.println("회원 이름 : "+nowAuthor.getName()+" 회원 이메일 : "+nowAuthor.getEmail());
        }
    }
    public static boolean login(String id, String  passwd){
        for(Author nowAuthor : authors) {
            if(nowAuthor.getEmail().equals(id)){
                if(nowAuthor.getPasswd().equals(passwd)){
                    return true;
                }
            }
        }
        return false;
    }
    public static Author validateEmail(String email){
        Author writer = null;
        for(Author nowAuthor:authors){
            if(nowAuthor.getEmail().equals(email)){
                writer = nowAuthor;
            }
        }
        return writer;
    }
    public static void writePost(Author writer, String nowTitle, String nowContent){
        Post nowPost =new Post(writer,nowTitle,nowContent);
        posts.add(nowPost);
        //writer.addPost(nowPost); 세종님 방법 실행
        System.out.println("이 게시물은 " + posts.get(posts.size()-1).getId()+" 째 입니다");
    }
    public static void registerAuthor(String[] inputs){
        authors.add(new Author(inputs[0],inputs[1],inputs[2]));
        //필요 없음
        //System.out.println("현재 author id는 " + authors.get(authors.size()-1).getId());
        System.out.println("현재 까지 가입자는 : " + authors.size());
    }
}
// DB의 entity = 자바의 인스턴스 변수.
class Author{
    // autoGenerate
    private static long staticId;
    private long id;
    private String name, email,passwd;
    private List<Post> posts;
    // 그냥 null로 할당하기.
//    Author(){
//
//    }
    Author(String name,String email,String passwd){
        posts = new LinkedList<>();
        staticId++;
        id = staticId;
        this.name = name;
        this.email = email;
        this.passwd = passwd;
    }
    public void addPost(Post post){
        this.posts.add(post);
    }
    public int postNumber(){
        return posts.size();
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
    private Long id;
    private Author author;
    private String title,contents;
    Post(Author author,String title,String contents){
        staticId++;
        id = staticId;
        //주소 들어가는거니까 순서는 상관 없음 아이디어가 기가막힌다.진짜루.
        this.author = author;
        this.author.addPost(this);
        this.author = author;
        this.title = title;
        this.contents = contents;
    }
    public long getId(){
        return id;
    }
    public Author getAuthor(){
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getContents() {
        return contents;
    }
}