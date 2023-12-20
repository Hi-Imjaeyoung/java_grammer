package C14Interface;

public class StaticFinalInterface {
    public static void main(String[] args) {
        System.out.println(myImplements.sInt);
        myImplements instant = new myImplements();
        System.out.println(instant.sInt);

    }
}

interface MyInterface{
    // 아래 변수는 컴파일 타임에 static final이 붙습니다. (상수이자 클래스 변수이다)
    // interface에서 구지 인스턴스 변수를 선언해줄 필요가 읎다.
    int myConstant = 100;
    abstract void methodA();
}

class myImplements implements MyInterface{
    static int sInt = 10;
    @Override
    public void methodA() {
        System.out.println(myConstant);
    }

//      final로 선언됨을 알 수 있다.
//    public void setMyConstant(){
//        myConstant = 10;
//    }
}