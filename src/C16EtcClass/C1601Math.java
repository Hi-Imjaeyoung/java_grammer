package C16EtcClass;

import java.lang.Math;

public class C1601Math {
    public static void main(String[] args) {
//        for(int i=0;i<10;i++){
//            //0.0 부터 1.0미만의 double형 반환
//            // 숫자를 난수로 뽑아 줄 수 있다
//            double randomValue = Math.random();
//            System.out.println((int)(randomValue*10));
//        }
        // abs (): 절대값 반환
        System.out.println(Math.abs(-5));

        //floor():내림 ,ceil():올림 ,round(): 반올림
        System.out.println(Math.floor(99.9));
        System.out.println(Math.ceil(99.9));
        System.out.println(Math.round(99.9));

        // max, min
        System.out.println(Math.max(22,1));
        System.out.println(Math.min(22,1));

        //pow : 제곱 연산 수행 pow(a,b) = a^b
        System.out.println(Math.pow(2,10));

        // sqrt() : 제곱근 연산 수행
        System.out.println(Math.sqrt(1024));
        int n =100;
        for(int i=2;i<(int)Math.sqrt(n);i++){

        }

    }
}
