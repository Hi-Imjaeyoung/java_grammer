package C14Interface;

public class InterfaceMain {
    public static void main(String[] args) {
        // Interface로 선언하여, CatImplements의 Multi Implements중 하나의 Interface의 Method만 사용가능하게 바꿈
        AnimalInterface1 cat1 = new CatImplements();
        DogImplements dog1 = new DogImplements();
        cat1.makeSound();
        dog1.makeSound();

//        다형성이란 하나의 객체가 여러개의 참조 변수를 가질수 있음을 의미한다.
        DogMultiImplements dog2 = new DogMultiImplements();
//        Interface2에 정의된 메서드는 사용이 불가능
        AnimalInterface1 cat2 = new CatMultiImplements();
        dog2.makeSound();
        System.out.println(dog2.play("보리","룽지"));
//        System.out.println(cat2.play());

//        기본적으로 추상클래스랑 인터페이스는 객체 생성이 불가능하나, 익명 내부 클래스 방식으로 생성이 가능
        AnimalInterface1 interface1 = new AnimalInterface1() {
            @Override
            public void makeSound() {

            }
        };
    }
}
