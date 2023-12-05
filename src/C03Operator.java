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

    }
}
