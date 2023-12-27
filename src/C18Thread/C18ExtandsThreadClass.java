package C18Thread;

// Thread class에 구현되어 있는 run메서드는 아무작업도 하지 않는 빈 메서드이다.
// 작업하고 싶은 내용을 run() 메서드 Overriding 하여 정의할 수 있다.
// 상속관계이다 보니, 다른 클래스 상속이 불가하다. : 단점 -> runnable 로 대체
public class C18ExtandsThreadClass extends Thread{
    // run 메서드는 Thread가 시작되면 실행된다.
    @Override
    public void run(){
        System.out.println("C18ExtandsThreadClass :" + Thread.currentThread().getName());
    }
}
