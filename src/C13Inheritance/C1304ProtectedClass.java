package C13Inheritance;

// public 은 프로젝트 전체에서 접근 가능
// protected : 패키지를 벗어나도 상속관계이면 접근가능, 패키지 내에서는 접근이 가능
// default : 패키지 내에서 접근 가능
// private :클래스 내에서 접근 가능
public class C1304ProtectedClass {
    private String privateSt = "Hello Java1";
    protected String protectedSt = "Hello Java2";
    String defaultSt = "Hello Java3";
    public String publicSt = "Hello Java4";
}
