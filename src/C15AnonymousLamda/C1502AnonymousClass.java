package C15AnonymousLamda;

public class C1502AnonymousClass {
    public static void main(String[] args) {
//        클래스 명이 Animal이 아니고 이름없는 익명 클래스의 객체를 동시에 생성
        Animal dog = new Animal() {
            @Override
            public void makeSound(int n) {
                for(int i=0;i<n;i++){
                    System.out.println("컹컹!");
                }
            }
        };
//        익명 객체에 구현 메서드가 1개 밖에 없을 경우 람다(->)로 표현가능.
//        ()안에 매개변수 지정 하여 구현체에서 활용이 가능하다. 변수 명의 개수가 많을 때는 맞춰서 지정해줘야합니다.
        Animal cat = (n) -> {
            for(int i=0;i<n;i++){
                System.out.println("골골..골");
            }
        };

        dog.makeSound(10);
        cat.makeSound(10);
    }
}


interface Animal{
    void makeSound(int n);
}

