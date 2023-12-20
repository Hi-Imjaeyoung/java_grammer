package C13Inheritance;

import java.util.*; // util 하위에 모든 클래스/인터페이스 파일 import가능
//import java.*; // 이건 NO 특정 패키지의 하위 패키지의 모든 파일을 다 import하는 건 불가능


// final class는 상속이 불가능
// public class C1305Others extends FinalClass{
//
// }

final class FinalClass{

}
abstract class C13Animal{
    void sound(){
        System.out.println("동물 소리");
    }
    final void legNumber(){
        System.out.println("4개 입니다");
    }
    // abstract method가 하나라도 존재하면 abstract를 붙여줘여 한다.
    abstract void makeSound();
}

class C13Dog extends C13Animal{
    @Override
    void sound(){
        System.out.println("멍멍!!");
    }
    @Override
    void makeSound(){
        System.out.println("크르르르으 컹");
    }

//    final method는 Overriding이 불가능 하다.
//    @Override
//    void legNumber(){
//        System.out.println("난 2개인데?");
//    }

}

public class C1305Others {
    public static void main(String[] args) {
        C13Dog dog1 = new C13Dog();
        // 부모 클래스에 존재하는 메서드
        dog1.legNumber();
        //Override한 abstract 메서드
        dog1.makeSound();
        // 익명객체. Others와는 상관 없지만..또 상속 클래스도 없는 불쌍해.
        // Aniaml class는 abstract class라 객체를 만드는 것 자체가 불가능.
        C13Animal animal1 = new C13Animal() {
            // abstract 만 Overriding 하라고 자동으로 완성해준다.
            @Override
            void makeSound() {

            }
        };
        System.out.println(dog1.getClass()); // class C13Inheritance.C13Dog
        System.out.println(animal1.getClass()); // Class 13Inheritance.C1305Others$1
    }
}