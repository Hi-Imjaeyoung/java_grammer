import java.util.Arrays;

public class C05Looppractice {
    public static void main(String[] args) {
////        1. 1~20 짝수의 합 구하기
//        int answer = 0;
//        for(int i=1;i<21;i++){
//            if(i%2!=0) continue;
//            answer +=i;
//        }
//        System.out.println(answer);
////        2. 숫자 reverse
//        int value = 2345;
//        int reverse =0;
//        for(int i=0;i<4;i++){
//            int lastNumber = value%10;
//            reverse *=10;
//            value/=10;
//            reverse+= lastNumber;
//        }
//        System.out.println(reverse);
//
//        int value2 = 2345;
//        int reverse2 =0;
//        while (value2!=0){
//            reverse2 *=10;
//            reverse2 += value2%10;
//            value2/=10;
//        }
//        System.out.println(reverse2);
////        3. 최대 공약수 구하기.
//        int num1 =2345123 ,num2 =43534051;
//        int maxAnswer = 0;
//        for(int i=1;i<Math.max(num1,num2);i++){
//            if(num1%i==0 && num2%i ==0){
//                maxAnswer = i;
//            }
//        }
//        System.out.println(maxAnswer);
////        Array
//        int[] myArr = {1,2,3,4,5};
////        일반 for
//        for(int i=0;i<5;i++){
//            myArr[i]+=10;
//        }
//        System.out.println(Arrays.toString(myArr));
////        enhanced for
//        for(int now:myArr){
//            now+=10;
//        }
//        System.out.println(Arrays.toString(myArr));

//        자바 변수의 유효 범위 : {}
//        int a = 10;
////        int a = 20; 유효 범위 안에 같은 변수를 선언하면 안된다.
//        int num = 10;
//        if(num>1){
//            int abc = 20;
//            num = 20;
//        }
//        System.out.println(num); // 20
//      System.out.println(abc); if 블럭 안에는 몰루.
//
//        이중 for문 연습
//        for(int i=2;i<10;i++){
//            System.out.println(i+"단 입니다");
//            for(int j=1;j<10;j++){
//                System.out.println(i+" x "+j +" = "+(i*j));
//            }
//        }
//        lable문 활용
//        문제 : target이 matrix에 i,j에 있는지 출력하시오
//        int[][] matrix ={{1,2,3,4},{5,6,7},{8,9,10},{10,11,12,13,14,15}};
//        int target = 11;
//        loop1:
//        for(int i=0;i<matrix.length;i++){
//            for (int j=0;j<matrix[i].length;j++){
//              if(matrix[i][j]==target){
//                  System.out.println(i+","+j);
//                  break loop1;
//              }
//            }
//        }
//        문제 약수 찾기
        loop1:
        for(int i=1;i<=20;i++){
            int cnt =0;
            loop2:
            for(int j=1;j<=20;j++){
                if(i%j==0) cnt++;
            }
            if(cnt==5){
                System.out.println(i);
                break loop1;
            }

        }


    }
}
