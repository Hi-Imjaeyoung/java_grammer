package C13Inheritance;


// super() : 부모클래스의 생성자를 의미,  super : keyword (부모클래스를 의미)
// class는 중복 상속이 안됨 (어떤 클래스의 메서드인지 구분이 안가잖아)
// interface는 가능 (어차피 구현 해주기 때문에)
public class C1302SuperChildClass extends SuperParents{
    int b;
    int a;
    C1302SuperChildClass(){
        // 부모의 생성자를 출력
        // 부모가 생성자가 있으면 자식 생성자에서 부모의 생성자 호출을 강제 함
        super(100);
        this.a= 30;
        this.b= 20;
    }
    @Override
    void display(){
        // 이렇게 부모거를 다시 호출이 가능. 근데 구지구지 이미 Overriding을 했는데 왜 씀!
        super.display();
        System.out.println(a);
        System.out.println(super.a);
        System.out.println(b);
    }
    public static void main(String[] args) {
        C1302SuperChildClass instant = new C1302SuperChildClass();
        System.out.println(instant.a +" "+instant.b);
        instant.display();
        instant.display2();
    }
}

class SuperParents{
    int a;
    static int b =1;
    SuperParents(int a){
        this.a = a;
    }
    void display(){

    }
    void display2(){
        System.out.println("부모 클라스~");
    }
}
