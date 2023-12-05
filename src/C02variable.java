import java.math.BigDecimal;

public class C02variable {
    public static void main(String[] args) {
        // byte는 8bit +-표시 제외 2^7 만큼 범위 지정 가능.
        // 오버/언더 플로우 테스팅!
//        byte a = 127;
//        byte b = -128;
//        a++;
//        b--;
//        System.out.println("a : " +a);
//        System.out.println("b : " +b);
//
//        // 실수 : float와 double
//        double double_a = 1.123456789101112131415;
//        float float_b = 1.1233445466546f;
//        System.out.println("doible : "+double_a);
//        System.out.println("float : "+float_b);
//
//        // 부동소수점 오차 테스트;
//        double double_num = 0.1;
//        // 미세한 오차는 알아서 조정
//        System.out.println(double_num);
//        for(int i=0;i<1000;i++){
//            double_num += 0.1;
//        }
//        // 100.09999999999859 요렇게 출력
//        // 소수점 연산은 기본적으로 오차가 발생
//        System.out.println(double_num);
//
//        // 소수점 오차 해결하기.
//        double_num =0;
//        for(int i=0;i<1000;i++){
//            double_num+=0.1*10;
//        }
//        System.out.println(double_num/10);
        //저장 시 문자로
        //계산시 정수로
//        //최종 결과는 실수로
//        double d1 = 1.03;
//        double d2 = 0.42;
//        System.out.println(d1-d2);
//        BigDecimal newBigDecimal = new BigDecimal("1.03");
//        BigDecimal newBigDecimal2 = new BigDecimal("0.42");
//        // double로 데이터 변환
//        double convertDouble = newBigDecimal.doubleValue();
//        System.out.println(newBigDecimal.subtract(newBigDecimal2));

//        // 문자 char 2byte 할당 되어 한글 카바 가능
//        char my_char = '밥';
//        System.out.println(my_char);
//
//        //boolean true (1) or false (0)
//        boolean my_bool = true;
//        System.out.println(my_bool);
//        if(my_bool){
//            System.out.println("급네치킨입니다.");
//        }
//        int bool1 = 20;
//        int bool2 = 10;
//        if(bool1>bool2){
//            System.out.println("bool1이 더 크다!");
//        }else{
//            System.out.println("bool1이 더 작다아!");
//        }

        // 묵시적 타입 변환
        char my_char ='a';
        int my_int = my_char;
        System.out.println(my_int);
        //int -> double
        int my_int2 = 10;
        double my_double = my_int2;
        System.out.println(my_double);
        // double -> int
        //my_int2 = my_double 응 안돼! 에러 발생
        my_int2 = (int)my_double; // 명시적 타입 변환은 가능.(소수부 손실 가능성이 있다)
        double myDouble2 = 7.2f;
        System.out.println(myDouble2);

        //명시적 타입변환
        char myChar2 ='b';
        int myChar2Num = (int) myChar2;
        // int a =1 b =4 둘을 나눈 값을 int에 담아 출력, double에 담아 출력
        int a = 1;
        int b = 4;
        int c = a/b; // 0
        double d = a/b; //0.0
        System.out.println(1/4);
        System.out.println((double) a/(double) b); // 0.25
        System.out.println((double) a/ b); //0.25
        double aDouble = a;
        double bDouble = b;
        System.out.println(aDouble/bDouble); //0.25

        //선언과 동시에 초기화
        int a2 = 10;
        a2 = 20;
        //선언 후 초기화
        int a4; //값이 0으로 초기화 메모리 내부적으로 0으로 되어있습니다 + String은 null
        // array 만들 때 int 형의 디폴트가 0 인 이유
        a4 = 100;
        // 상수는 값의 재할당이 불가능하다 final
        final int AGE = 28;
        // AGE = 29 상수는 변경이 불가능합니다
        // 상수는 선언만 한 후 초기화하는 방식이 자바 8이전에서는 불가능 했지만 지금은 가능
    }
}
