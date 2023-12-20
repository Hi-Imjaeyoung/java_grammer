package C13InheritanceTest;

import C13Inheritance.C1304ProtectedClass;

public class C1301ProtectedTest extends C1304ProtectedClass{
    public static void main(String[] args) {
        C1304ProtectedClass instant = new C1304ProtectedClass();
        System.out.println(instant.publicSt);
//        System.out.println(instant.protecedSt);
//        상속관계라 하더라도 부모 클래스의 객체를 만드는 것으로 protected 변수 접근이 불가
//        자식 클래스 객체로 접근이 가능
        C1301ProtectedTest instant2 = new C1301ProtectedTest();
        System.out.println(instant2.protectedSt);
        System.out.println(instant2.publicSt);
    }
}
