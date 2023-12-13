public class C1101StackFunction {
    public static void main(String[] args) {
        System.out.println("main 시작");
        function1();
        System.out.println("main 끝");
    }
    static void function1(){
        System.out.println("f1 start");
        function2();
        System.out.println("f1 end");
    }
    static void function2(){
        System.out.println("f2 start");

        System.out.println("f2 end");
    }
}
