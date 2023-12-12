import java.util.*;
import java.util.stream.Collectors;

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
//        같은 값이면 맨 앞에 있는 값을 삭제합
        add_list.remove(0);
        System.out.println(add_list);
        // 원시타입x -> 참조타입으로 변환 해야합 리턴 타입은 boolean
        add_list.remove((Integer) 15);
        System.out.println(add_list);

//        set(int index, E Element) : index 자리에 값 변경
        add_list.set(add_list.size()-1,100);
        System.out.println(add_list);

//        contains : 특정 값이 있는지 없는지 boolean return
        System.out.println(add_list.contains(30));
        System.out.println(add_list.contains(3000));

        List<Integer> my_list3 = new ArrayList<>(Arrays.asList(10,10,20,30));
//        indexOf : 몇번째 index에 위치하는지 리턴
        System.out.println(my_list3.indexOf(10)); // 먼저 나온 값 리턴
        System.out.println(my_list3.indexOf(30));
        System.out.println(my_list3.indexOf(3000)); // 없을 시 -1을 리턴

//        clear : 전체 삭제
//        isEmpty : 값이 비었는지, 안비었는지
        System.out.println(my_list3.isEmpty());
        my_list3.clear();
        System.out.println(my_list3);
        System.out.println(my_list3.isEmpty());

//        리스트 출력
        List<int[]> list_arr = new ArrayList<>();
        list_arr.add(new int[]{12,2});
        list_arr.add(new int[3]);
        list_arr.get(1)[0] = 10;
        list_arr.get(1)[2] = 20;

        int cnt =1;
        list_arr = new ArrayList<>();
        for(int i=0;i<3;i++){
            list_arr.add(new int[3]);
            for(int j=1;j<=list_arr.get(i).length;j++){
                list_arr.get(i)[j-1] = j*cnt;;
                list_arr.get(i)[j-1] = j*(int)Math.pow(10,i);;
            }
            cnt*=10;
        }
        for(int i=0;i<list_arr.size();i++){
            System.out.println(Arrays.toString(list_arr.get(i)));
        }

        List<Integer> sort_test_list = new ArrayList<>(Arrays.asList(12,4,5,22,156,1,-122,0));
//        리스트정렬 1 : Collections.sort()
        Collections.sort(sort_test_list);
        System.out.println(sort_test_list);
        Collections.sort(sort_test_list, Comparator.reverseOrder());
        System.out.println(sort_test_list);
//        리스트정렬 2 : List.sort()
        sort_test_list.sort(Comparator.naturalOrder());
        System.out.println(sort_test_list);
        sort_test_list.sort(Comparator.reverseOrder());
        System.out.println(sort_test_list);

//         1.String 배열을 List로 변환
        String[] str_arr = new String[]{"hello","Java","!!"};
        // 1-1
        List<String> str_list = new ArrayList<>(Arrays.asList(str_arr));
        System.out.println(str_list);
        // 1-2
        str_list = new ArrayList<>();
        for(String str : str_arr){
            str_list.add(str);
        }
        //1-3 Stream : 참고
        List<String> str_list3 = Arrays.stream(str_arr).collect(Collectors.toList());

//        2.int 배열을 List로 변환
        //2.1 Arrays.asList 사용 불가
        //2.2 for문 담기 사용가능 오토언박싱
        //2.3 Stream int를 박싱해준다
        List<Integer> int_list1= Arrays.stream(new int[]{1,2,3,4,}).boxed().collect(Collectors.toList());

//        3. String List를 String []로 변환
        String[] str_arr2 =
        //3.1 for문 사용
        str_arr2 = new String[str_list.size()];
        int index =0;
        for(String now : str_list){
            str_arr2[index++] = now;
        }
        //3.2 Stream API 사용
        str_arr2 =str_list.stream().toArray(a->new String[a]);

//        4.int list를 int[]로 변환
        //4.1 for
        //4.2 stream API
    }
}
