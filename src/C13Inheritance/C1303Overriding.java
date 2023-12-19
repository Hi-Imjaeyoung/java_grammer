package C13Inheritance;

import java.util.LinkedList;
import java.util.List;

// Animal class 생성
// Animal 을 상속하는 cat, dog을 생성
// Animal class 의 sound()를 오버라이딩을 하여 각 자식  클래스 이름에 맞는 이름 출력
public class C1303Overriding {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //오~~
        //상속관계일때 부모클래스 타입을 자식클래스 객체의 타입으로 지정 가능하다.
        Animal dog1 = new Dog();
        // Animal class 안에 있는 기능만! 사용가능
        // Dog에만 정의된 메서드는 x , Override된 메서드는 사용가능
//        dog1.sound2();
        dog1.sound();
        dog.sound();
        dog.sound2();
        Cat cat = new Cat();
        cat.sound();
        cat.printLegNumber();

        List<String> myList = new LinkedList<>();
        // LinkedList는 큐와 리스트 둘 다 interface로 가능
        // myList. -> List interface안에 존재하는 메서드들만 나옴
    }
}
class Animal{
    void sound(){
        System.out.println("동물은 말을 못합니다");
    }
    void printLegNumber(){
        System.out.println("다리는 4개지요");
    }
}
class Dog extends Animal{
    @Override
    void sound(){
        System.out.println("멍멍이");
    }
    void printLegNumber(int a) {
        System.out.println("다리는 "+a+"개 지요");
    }
    void sound2(){
        System.out.println("멍멍이22");
    }
}
class Cat extends Animal{
    @Override
    void sound(){
        System.out.println("냥냥이");
    }
}
