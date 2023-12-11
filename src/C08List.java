import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C08List {

    public static void main(String[] args) {
//        List선언 방법
        //ArrayList<String> myList1 = new ArrayList<String>();
//        인터페이스 오른쪽 구현체
        ArrayList<String> myList1 = new ArrayList<>();
//        가장 일반적인 방법
        List<String> myList2 = new ArrayList<>();

//        초기값 생성 방법
        myList1.add("java");
        myList1.add("python");
        myList1.add("c++");
        System.out.println(myList1);

//        초기값 생성 방법2 한번에 add 배열을 이용한 변환
        String[] myarr1 ={"java","python","c++"};
        List<String> myList3 = new ArrayList<>(Arrays.asList("java", "python", "c++"));
//        배열이 int인 경우 형변환 이슈 발생
        int[] myIntArr ={1,2,3};
//        List<Integer> myIntList = new ArrayList<>(Arrays.asList(myIntArr)); Int타입은 원시형 데이터..형변환이 필요
        List<Integer> myIntList = new ArrayList<>();
        for(int a: myIntArr){
            myIntList.add(a);
        }
    }
}
