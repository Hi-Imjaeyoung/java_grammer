import java.util.Scanner;

public class C05Loopstatements {
    public static void main(String[] args) {
        //        while을 사용하여 2~10까지
//        int a = 2;
//        while(a<=10){
//            System.out.println(a);
//            a++;
//        }
//        구구구구단
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int index = 1;
        while(index<10){
            System.out.println(input+"x"+index+"="+(input*index));
            index++;
        }
    }
}
