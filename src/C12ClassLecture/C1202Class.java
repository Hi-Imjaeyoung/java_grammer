package C12ClassLecture;

public class C1202Class {
    public static void main(String[] args) {
////        매개변수 2개 받아서 더한 값 return;
//        System.out.println(Mycalculator.sum(10,20));
//
//        // A부서의 매출
//        Mycalculator.sumAcc(10);
//        Mycalculator.sumAcc(20);
//        Mycalculator.sumAcc(30);
//        Mycalculator.sumAcc(40);
//        System.out.println(Mycalculator.total);
//
//        // B부서의 매출
//        Mycalculator.sumAcc(10);
//        Mycalculator.sumAcc(20);
//        Mycalculator.sumAcc(30);
//        Mycalculator.sumAcc(40);
//        System.out.println(Mycalculator.total);
//        // 클래스 변수(static)을 공용으로 사용하다 보니 클래스의 확장 가능성이 굉장히 떨어진다.

        // A부서
        MycalculatorInstance departmentA =new MycalculatorInstance();
        departmentA.sumAcc(10);
        departmentA.sumAcc(20);
        departmentA.sumAcc(30);
        System.out.println(departmentA.total);
        // B부서
        MycalculatorInstance departmentB =new MycalculatorInstance();
        departmentB.sumAcc(10);
        departmentB.sumAcc(20);
        departmentB.sumAcc(30);
        System.out.println(departmentB.total);
    }
}

// 내부 클래스
// public 클래스는 하나만 존재해야함.
class Mycalculator{
    // 변수를 필드라고 함
    // 객체를 만들지 않아도 접근이 가능
    static int total=0;
    int nonStaticTotal =0;

    public static int sum(int numA,int numB){
        return numA+numB;
    }

    public static int sumAcc(int num) {
        total+=num;
        return total;
    }
}
// 내부 클래스
class MycalculatorInstance{

    // 객체를 만들지 않아도 접근이 가능

    // 클래스 변수 : static이 있는 변수
    // 객체 변수 : static이 없는 변수
    int total=0;

    public  int sum(int numA,int numB){
        return numA+numB;
    }

    public  int sumAcc(int total) {
        // this는 객체 그 자신을 의미한다.
        // this를 구지구지 붙이는 이유는? 코드의 가시성을위해
        this.total+=total;
        return total;
    }
}
