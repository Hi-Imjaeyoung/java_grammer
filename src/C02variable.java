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

        // 문자 char 2byte 할당 되어 한글 카바 가능
        char my_char = '밥';
        System.out.println(my_char);

        //boolean true (1) or false (0)
        boolean my_bool = true;
        System.out.println(my_bool);
        if(my_bool){
            System.out.println("급네치킨입니다.");
        }
        int bool1 = 20;
        int bool2 = 10;
    }
}
