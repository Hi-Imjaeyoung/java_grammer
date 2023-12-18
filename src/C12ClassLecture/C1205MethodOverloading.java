package C12ClassLecture;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class C1205MethodOverloading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C1205MethodOverloading instant= new C1205MethodOverloading();
//        메서드 오버로딩을 통해 이름이 같은 메서드 재활용
        System.out.println(instant.sum(1,2));
        System.out.println(instant.sum(1,2,3));
        System.out.println(instant.sum(1.5,2.3));
//        재네릭을 통해 타입을 재활용
        List<Integer> list = new LinkedList<>();
    }
    public int sum(int a,int b){
        return a+b;
    }
    // method overloading 이름이 같은 메서드를 파라미터가 다르면 메소드 생성 가능
    public int sum(int a, int b, int c){
        return a+b+c;
    }
    double sum(double a, double b){
        return  a+b;
    }
}
