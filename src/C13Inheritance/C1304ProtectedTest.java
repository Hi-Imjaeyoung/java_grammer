package C13Inheritance;

public class C1304ProtectedTest {
    public static void main(String[] args) {
        C1304ProtectedClass instant = new C1304ProtectedClass();
        System.out.println(instant.protectedSt); // 상속 x라도 같은 패키지 내에서는 접근이 가능!
        System.out.println(instant.publicSt);
        System.out.println(instant.defaultSt);
//        System.out.println(instant.privateSt);
    }
}
