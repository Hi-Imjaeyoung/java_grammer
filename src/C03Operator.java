public class C03Operator {
    public static void main(String[] args) {
//        산술연산자
        int num1 =8,num2 =3;
//        * / %
        System.out.println("더하기 : " +(num1+num2));
        System.out.println("뺴기 : " +(num1-num2));
        System.out.println("곱하기 : " +(num1*num2));
        System.out.println("나누기 : " +(num1/(double)num2));
        System.out.println("나머지 : " +(num1%num2));

//        대입연산자
        int num3 =7, num4 =7, num5 =7;
        num3 =num3-3; // 4
        num4 -=3; // 4
        num5 =-3; // -3

//        /= %=
        int num6 = 10 , num7 =10;
        num6 %=3;
        System.out.println(num6);
        num7 /=3;
        System.out.println(num7);
//        전위 증감 연산자 : 현재 라인이 실행되기 전에 증감
//        후위 증감 연산자 : 실행된 후 증감
        int num8 =5;
        int num9 = num8++;
        System.out.println(num8); // 6
        System.out.println(num9); // 5

        num8 =5;
        num9= ++num8;
        System.out.println(num8); // 6
        System.out.println(num9); // 6
//        그냥 쪼개서 할래?

//        비교연산자 연산자의 결과가 boolean 타입으로 나옴.
        char char1 = 'a';
        char char2 = 'A';
        System.out.println(char1==char2);
        System.out.println(char1!=char2);

//        논리연산자 && || !
        int num10 =10, num11 =20;
        boolean result1,result2;
//        result1에 num10이 5보다 큰지 조건과 num1이 20보다 작은지 조건을 and 조건을 통해 boolean값으로 담아주세요
        result1 = num10>5 && num10<20;
//        result2에 num11이 10보다 작은 조건과 30보다 작은 조건을 or 조건을 통해 boolean값 담기
        result2 = num11<10 || num11<30;
        System.out.println(result1); //true
        System.out.println(!result2); //false

//        비트 연산자
        System.out.println("----bit 연산자-----");
//        & 둘 다 1인경우만 1이 된다
        System.out.println(2&1);
        System.out.println(2>0 & 3>0);
        int num12 = 10 , num13 =20;
//        하나만 체크하면 끗
        if(num12>20 && num13 <30) {

        }
//        둘다 체킹해야함
        if(num12>20 & num13 <30){
            System.out.println("예");
        }

//    000101  // 000110
        int n1 = 5, n2 =6;
//         &(둘다 1이면 1) 와 |(하나라도 1이면 1)
        System.out.println(n1&n2); // 4 0100
        System.out.println(n1|n2); // 7 00111
//        ^ 대응되는 비트가 달라야지 1을 반환, ~그냥 반대로 뽑아내는 연산
        System.out.println(n1^n2); // 3 0011
        System.out.println(Integer.toBinaryString(~n1)); // -6  보수 마저 바꿔서 음수로 바꿈
//        <<, >> 시프트 연산 자리를 방향 만큼 옯김 곱셈과 나눗셈의
        System.out.println(n1<<1); // 10 0001010
        System.out.println(n2>>1); // 3  000011 재미있네.

        int a = 13; // 00001101
        int b = 9; // 00001001
        while (b!=0){
            int sameIndex = a&b;
            // case 1 1001
            // case 2 0000
            a = a ^ b;
            // case 1 a = 0100
            // case 2 a = 10110
            b = sameIndex << 1;
            // case 1 b = 10010
            // case 2 b = 00000;
        }
    }


}
