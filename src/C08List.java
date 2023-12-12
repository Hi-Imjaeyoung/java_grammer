import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C08List {

    public static void main(String[] args) {
////        List선언 방법
//        //ArrayList<String> myList1 = new ArrayList<String>();
////        인터페이스 오른쪽 구현체
//        ArrayList<String> myList1 = new ArrayList<>();
////        가장 일반적인 방법
//        List<String> myList2 = new ArrayList<>();
//
////        초기값 생성 방법
//        myList1.add("java");
//        myList1.add("python");
//        myList1.add("c++");
//        System.out.println(myList1);
//
////        초기값 생성 방법2 한번에 add 배열을 이용한 변환
//        String[] myarr1 ={"java","python","c++"};
//        List<String> myList3 = new ArrayList<>(Arrays.asList("java", "python", "c++"));
////        배열이 int인 경우 형변환 이슈 발생
//        int[] myIntArr ={1,2,3};
////        List<Integer> myIntList = new ArrayList<>(Arrays.asList(myIntArr)); Int타입은 원시형 데이터..형변환이 필요
//        List<Integer> myIntList = new ArrayList<>();
//        for(int a: myIntArr){
//            myIntList.add(a);
//        }

//        add
        List<Integer> add_list = new ArrayList<>();
        add_list.add(10);
        add_list.add(20);
        System.out.println(add_list);
        // 중간에 값 삽입은 성능 저하를 야기한다
        add_list.add(1,15);
        System.out.println(add_list);

        List<Integer> add_list2 = new ArrayList<>();
        add_list2.add(30);
        add_list2.add(40);
        add_list2.add(50);
//        addAll(Collection 객체) : 특정 list의 요소를 모두 add
        add_list.addAll(add_list2);
        System.out.println(add_list);

//        get(int index) : 특정 위치의 요소를 반환
        System.out.println(add_list.get(0));
        for(int i=0;i<add_list.size();i++){
            System.out.println(add_list.get(i));
        }
        for(int nowInt : add_list){
            System.out.print(nowInt+" ");
        }
        System.out.println();
//        remove : 요소삭제 , index(주소값)을 알고 있을때 바로 O(1) , value를 찾을 때 O(n)
        add_list.remove(0);
        System.out.println(add_list);
        add_list.remove((Integer) 15);
        System.out.println(add_list);
    }
}
