package C17ExceptionFileParseing.AuthorException;



import java.util.*;

// 메모리DB에 데이터 추가 삭제 부분은 repository로 구분 -> 클래스를 생성
// 컨트롤러(입력받아 객체 생성,예외 처리)에서 서비스(등록, 로그인)를 호풀, 서비스에서 repo호출
public class AuthorController {

    public static void main(String[] args) {
        AuthorService authorService = new AuthorService();
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("0 로그인, 1 회원가입");
            int caseIdentify = Integer.parseInt(sc.nextLine());
            if(caseIdentify==0){
                System.out.println("이메일를 입력해주세요");
                String inputEmail = sc.nextLine();
                System.out.println("비밀번호도 입력해주세요");
                String inputPasswd = sc.nextLine();
                Optional<Author> loginedAuthor = Optional.empty();
                try {
                    loginedAuthor = authorService.logIn(inputEmail,inputPasswd);
                }catch (NoSuchElementException e){
                    System.out.println(e.getMessage());
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    System.out.println("비밀번호 찾기를 시작하시려면 1번 처음화면으로 돌아가시려면 0번을 입력해주세요");
                    int input = Integer.parseInt(sc.nextLine());
                    if(input==1){
                        System.out.println("찾으실 회원의 이름을 입력해주세요");
                        String name = sc.nextLine();
                        Optional<Author> findAuthor = Optional.empty();
                        try {
                            findAuthor=authorService.findPassWd(name);
                        }catch (NoSuchElementException e2){
                            System.out.println(e2.getMessage());
                        }
                        if(findAuthor.isPresent()){
                            System.out.println("이름 : "+ findAuthor.get().getName() +" 이메일 :"+findAuthor.get().getEmail()
                                    +" 비밀번호 : "+findAuthor.get().getPasswd());
                        }
                    }
                }
                if(loginedAuthor.isPresent()){
                    System.out.println(loginedAuthor.get().getName()+"님 환영합니다!!");
                }
            }else if(caseIdentify==1){
                //1 회원 가입
                System.out.println("이름를 입력해주세요");
                String inputName = sc.nextLine();
                System.out.println("이메일를 입력해주세요. *중복된 이메일은 가입할 수 없습니다");
                String inputEmail = sc.nextLine();
                System.out.println("비밀번호도 입력해주세요. *비밀번호는 6자리 이상으로 부탁드려요");
                String inputPasswd = sc.nextLine();
                try {
                    authorService.register(new Author(inputName,inputEmail,inputPasswd));
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }catch (NoSuchElementException e){
                    System.out.println(e.getMessage());
                }

            }
        }
    }
}
