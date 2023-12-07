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
//        int input = sc.nextInt();
//        int index = 1;
//        while(index<10){
//            System.out.println(input+"x"+index+"="+(input*index));
//            index++;
//        }
//        String nowPassWd = "1234";
//        int tryCount =0;
//        while (tryCount<5){
//            String inputPassWd = sc.nextLine();
//            if(inputPassWd.equals(nowPassWd)){
//                System.out.println("오세요~");
//                break;
//            }else{
//                System.out.println("나가~");
//            }
//            tryCount++;
//            System.out.println("남은 기회 :" +(5-tryCount));
//        }
////        do while문 무조건 한번은 실행된다
//        tryCount =0;
//        do{
//            String inputPassWd = sc.nextLine();
//            if(inputPassWd.equals(nowPassWd)){
//                System.out.println("오세요~");
//                break;
//            }else{
//                System.out.println("나가~");
//            }
//            tryCount++;
//            System.out.println("남은 기회 :" +(5-tryCount));
//        }while (tryCount<5);

//        for문을 연습해보자
//        int a = 2;
//        for(int i=0;i<9;i++){
//            System.out.println(a++);
//        }

//    continue 반복문 내에서 바로 조건문으로 돌아가게 만듬
//    1~10까지 홀수만 출력되도록 하세요
        for(int i=1;i<11;i++){
            if(i%2==0) continue;
            System.out.println(i);
        }
//        라벨문 : 첫번째 for문 0~4 두번째 for 문 0~4,
        loop1:
        for(int i=0;i<5;i++){
            loop2:
            for(int j=0;j<5;j++){
                System.out.println("Home..");
                break ; // home이 15 번 출력
                //break loop1; //3번 출력
            }
        }


    }

}
