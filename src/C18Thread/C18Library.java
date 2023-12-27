package C18Thread;

public class C18Library {
    static int bookCount = 100;
//    public static void borrowBook(){
//        if(bookCount>0){
//            // 책 빌리는 시간을 10초로 가정
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                System.out.println(e.getMessage());
//            }
//            bookCount--;
//            System.out.println("대출 완료~");
//            System.out.println("남아 있는 책 수량"+bookCount);
//        }else{
//            System.out.println("책이 없는데요");
//        }
//    }
    // synchronized 키워드를 통해 해당 메서드(자원)에 한해 lock을 걸도록 설정
    // StringBuffer 의 append에 나와있는 키워드
    public synchronized static void borrowBook(){
        if(bookCount>0){
            // 책 빌리는 시간을 10초로 가정
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            bookCount--;
            System.out.println("대출 완료~");
            System.out.println("남아 있는 책 수량"+bookCount);
        }else{
            System.out.println("책이 없는데요");
        }
    }
}
