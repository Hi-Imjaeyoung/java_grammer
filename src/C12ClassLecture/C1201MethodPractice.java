package C12ClassLecture;

import java.util.Scanner;

public class C1201MethodPractice {
    public static void main(String[] args) {
        // 소수 : 1과 자기자신을 제외 약수가 없는 것
        // 소수를 판별하는 메서드를 만들어 주세요
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(isPrime(n)){

        }else{

        }
    }

    public static boolean isPrime(int number){
        if(number==1){
            return false;
        }
        for(int i=2;i*i<number;i++){
            if(number%i==0){
                // void에서도 강제 종료를 위해 return을 사용 가능.
                return false;
            }
        }
        return true;
    }
    public static void isPrimePrint(int number){
        if(number==1){
            return;
        }
        for(int i=2;i*i<number;i++){
            if(number%i==0){
                System.out.println("소수가 아닙니다요");
            }
        }
        System.out.println("소수 입니다요");
        return;
    }
}
