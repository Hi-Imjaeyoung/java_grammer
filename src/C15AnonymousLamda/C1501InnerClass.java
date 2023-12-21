package C15AnonymousLamda;

public class C1501InnerClass {
    // static 내부 클래스
    // 이 클래스는 C1501의 정적 멤버 처럼 활용이 된다.

    public static void main(String[] args) {
        MemberInnerClass.StaticInnerClass s1 =new MemberInnerClass.StaticInnerClass();
        s1.display();
    }
}
//일반 내부 클래스
class MemberInnerClass {

    static class StaticInnerClass {
        private int data;

         void display() {
            System.out.println("data is : " + data);
        }
    }

}

