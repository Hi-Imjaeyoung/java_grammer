package C15AnonymousLamda;

// 메소드가 makeString(st 1, st 2) 하나인 이름이 Lamda인 인터페이스 생성
// main에서 lamda의 익명 객체를 ->방식으로 구현하시용
// 두 개의 문자열을 더해서 출력한다.

public class C1503LamdaExpression {
    public static void main(String[] args) {
        // 실행문이 한개 일때는 return이 생략 가능하다
        LamdaInterface lamdaInterface = (a,b,c) -> a+b;
        // 실행문 2개 이상일때는 return 필요
        // 매개변수의 타입은 순서로 인지함으로 따로 타입을 입력해줄 필요는 없다.
        LamdaInterface lamdaInterface2 = (a,b,c) ->{
            String answer = a+b;
            return answer;
        };
        System.out.println(lamdaInterface.makeString("집","가고 싶다",9));
    }

}

interface LamdaInterface{
    String makeString(String a, String b,int c);
}

