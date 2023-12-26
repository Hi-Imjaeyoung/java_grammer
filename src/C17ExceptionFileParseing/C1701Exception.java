package C17ExceptionFileParseing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class C1701Exception {
    public static void main(String[] args) {
//        //ArithmeticException : 0을 나눌 떄
//        System.out.println("나눗셈 프로그램입니다. 숫자10에 나눌 분모값을 입력해주세요");
//        int num = 10;
//        Scanner sc = new Scanner(System.in);
//        // 예외가 발생할것으로 예상되는 코드에 try catch를 감싸준다
//        try {
//            int input = sc.nextInt();
//            System.out.println("10에"+input+"을 나누면");
//            System.out.println(num/input+" 입니다");
//        // catch에는 try구문 안에서 발생 가능한 예외상황을 적어야 catch가 된다.
//        }catch (InputMismatchException e){
//            // 어쩌구 저쩌구
//            System.out.println("삒!!!! 입력값이 비정상입니다");
//            e.printStackTrace();
//        } catch (ArithmeticException e){
//            System.out.println("ㅃ뺶ㄲㄲㄲ!!!!! 0 으로 못 나눕니다");
//            // 예외 관련된 정보들이 들어있음
//            // 방법 1
//            System.out.println(e.getMessage());
//            // 방법 2
//            e.printStackTrace();
//            // 로그 파일에 정제된 형태로 남겨야함 (스프링 에서)
//        }catch (Exception e){
//            //  모든 예외의 조상을 마지막에 모든 예외를 다 잡는다
//            System.out.println("삑!!!!!!알 수 없는 예외가 발생했습니다");
//            e.printStackTrace();
//        }finally {
//            // 반드시 실행되어야 하는 구문 삽입
//        }
//        System.out.println("감사합니다");

        //throw와 throws 예제
        String passWd = "1234";
        try {
            logIn(passWd);
        }catch (IllegalArgumentException e){
            // e.getMessage는 throw new 한 곳에서 넘어온 메시지이다.
            System.out.println(e.getMessage());
        }
    }
    // unchecked Exception에서 throws를 하지 않더라도 예외는 호출한 곳으로 전파된다.
    // throws를 하는 이유는 명시적으로 예외가 발생할 수 있음을 알리는 것 뿐이다

    // checkedException은 예외처리가 강제되고, 해당메서드에서 예외처리를 하든지 throws를 통해 호출한 곳에 위임
    // 이때 호출한 쪽에서 예외처리가 강제된다. (third party에서 발 생하는

    static void logIn(String passWd) throws IllegalArgumentException{
        if(passWd.length()<10){
            throw new IllegalArgumentException("비밀번호가 너무 짧습니다.");
        }
    }
}
