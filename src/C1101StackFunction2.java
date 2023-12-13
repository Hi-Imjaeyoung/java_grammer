public class C1101StackFunction2 {
    public static void main(String[] args) {
        System.out.println("main 시작");
        function1(1);
        System.out.println("main 끝");
    }
    static int function1(int a){
        System.out.println("f1 start");
        System.out.println("f1 end");
        System.out.println(a);
        return function1(a*2);
    }
    static int function2(int a){
        System.out.println("f2 start");
        System.out.println("f2 end");
        return a*2;
    }
}
