package C13Inheritance;

import C12ClassLecture.C1205MethodOverloading;

// implements 는 인터페이스를 구현 할 때
// extends 키워드를 통해 상속 관계를 표현한다.
public class C1301Inheritance extends Parents {
    // 인스턴스 변수
    int c = 30;
    public static void main(String[] args) {
        C1301Inheritance instant = new C1301Inheritance();
        System.out.println(instant.c);
        // 부모의 인스턴스 변수를 사용 가능
        System.out.println(instant.a);
        // 상속받은 클라스 하여도 private은 접근이 불가하다
//        System.out.println(instant.b);
        instant.parentsMethod();
        instant.childMethod();
    }

    void childMethod(){
        System.out.println("자식 클라스~");
    }

//    부모 클래스이 method명을 동일하게 사용함. 메서드 Override헀다.
    @Override
    void parentsMethod(){
        System.out.println("부모 클라스~가 아니고 자식 클라스~");
    }
}
// 내부 클래스
class Parents{
    int a = 10;
    // 프라이빗으로 선언된 변수는 상속관계에서도 사용이 x
    private int b = 20;
    void parentsMethod(){
        System.out.println("부모 클라스~");
    }
}

// interface는 전부다 Override를 통해서 구현을 해야함.
//interface ParentsInterface{
//    void parentsMethod(){
//
//    }
//}
