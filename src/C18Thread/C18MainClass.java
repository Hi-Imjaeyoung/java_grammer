package C18Thread;

public class C18MainClass {
    public static void main(String[] args) {
        C18ExtandsThreadClass etc1 = new C18ExtandsThreadClass();
        etc1.start();
        Thread etc2 = new C18ExtandsThreadClass();
        etc2.start();
        new C18ExtandsThreadClass().start();
        // Thread 실행 시 순차적으로 실행되지 않음에 유의

        // Thread 생성자로 Runnable 객체를 주입
        // Thread class에 Runnable객체가 전달되어 사용자가 직접 정의한 run() 메서드가 실행
        // 표현식 1
        Thread rt1 = new Thread(new C18RunnableImplementsClass());
        rt1.start();
        // 표현식 2
        new Thread(new C18RunnableImplementsClass()).start();
        // 표현식 3 익명객체 생성
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("악명객체 쓰레드");
            }
        });
        // 표현식 4 람다식으로 표현
        new Thread(() -> System.out.println("악명객체 쓰레드")).start();

        // Thread 동시성 이슈 테스트
        // 단일 스레드 (메인 스레드 사용) 일반 호출
//        for(int i=0;i<1000;i++){
//            C18Library.borrowBook();
//        }
//        System.out.println("최종 남은 수량 : "+C18Library.bookCount);

        for(int i=0;i<1000;i++){
            Thread th = new Thread(()->C18Library.borrowBook());
            th.start();
            // join 메서드를 통해 다른 스레드의 완료전까지 새로운 스레드가 실행되지 않도록 막음.
            // 멀티스레드를 차단! -> 이러면 멀티 스레드의 의미가 있을까?
//            try {
//                th.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
        System.out.println("최종 남은 수량 : "+C18Library.bookCount);

    }
}
