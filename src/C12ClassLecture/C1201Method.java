package C12ClassLecture;

public class C1201Method {
    public static void main(String[] args) {
//        //for문 이용해서 1부터 10까지  total값 구하기
//        int sum = 0;
//        for(int i=1;i<11;i++){
//            sum+=i;
//        }
//        System.out.println(sum);
//
//        //10~20 까지
//        sum = 0;
//        for(int i=10;i<21;i++){
//            sum+=i;
//        }
//        System.out.println(sum);
//
        // 코드의 중복이 발생함으로 반복을 피하게 위해 특정 기능 집합을 분리
        int total  = sumAcc(100,200);
        int total2 = C1201Method.sumAcc(1,10);
    }
    // void return 타입 x
    // int arr 등
    // static 클래스 메서드 ( 원칙적으로는 C1201Method.sumAcc() 이렇게 사용해야 함)
    // 같은 클래스 내에 메서드들은 static 이여도 클래스 이름 생략가능.

    // 메서드 구성: 매개변수, 반환타입, 접근제어자(생략시 default) 클래스메서드 여부
    // 접근 제어자 : 접근에 관한 관리(public(어디서든 접근이 가능하다), private, default)
    static int sumAcc(int start, int end){
        int sum = 0;
        for(int i=start;i<=end;i++){
            sum+=i;
        }
        return sum;
    }
}
