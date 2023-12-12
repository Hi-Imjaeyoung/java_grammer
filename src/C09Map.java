import java.util.*;
import java.util.stream.Stream;

public class C09Map {
    public static void main(String[] args) {
        //Map은 빠르다
        // 삽입된 데이터의 순서가 없다.
        HashMap<String,String> myMap1 = new HashMap<>();
        myMap1.put("sleep","졸리다");
        myMap1.put("home","집");
        myMap1.put("friday","금요일");
        myMap1.put("go","집에 가다");
        System.out.println(myMap1);
        System.out.println(myMap1.get("home"));
        // size isEmpty 가능합니다

//        // 이미 key가 있을 경우, 덮어쓰기!
//        myMap1.put("go","집에 날라가다");
//        //  없으면 put 해준다. 있으면 안함
//        myMap1.putIfAbsent("home","증말로 가고싶어요");
//        System.out.println(myMap1);
//
//        // getOrDefault: 없으면 default value를 리턴
//        System.out.println(myMap1.getOrDefault("lay","없는 값입니다"));
//
//        // containsKey / value
//        // value에서는 O(1)이 아닌가..?
//        System.out.println(myMap1.containsKey("lay")); //false
//        System.out.println(myMap1.containsValue("집"));
//
//        //remove
//        myMap1.remove("go"); // 삭제도 빠르다
//
//        // key, values만 쭉 뽑기 keySet, values
//        System.out.println(myMap1.keySet());
//        System.out.println(myMap1.values());
//
//        // enhanced for 문을 사용하여 키 값 하나씩 출력
//        for(String  a :myMap1.keySet()){
//            System.out.print(a+" ");
//            System.out.println(myMap1.get(a));
//        }

        // iterator 을 통해 key값을 하나씩 출력
        // Collection에 대부분 iterator가 존재
        Iterator<String> myIterator = myMap1.keySet().iterator();
        // next 마다 하나씩 소모한다. = queue pop가 유사
        while(myIterator.hasNext()){
            System.out.println(myIterator.next());
        }

        List<String> myList = new ArrayList<>();
        myList.add("basketball");
        myList.add("basketball");
        myList.add("baseball");
        myList.add("baseball");
        myList.add("baseball");
        myList.add("baseball");
        myList.add("tennis");
        Map<String,Integer> my_map2 = new HashMap<>();
        for(String nameOfSport : myList){
            if(my_map2.containsKey(nameOfSport)){
                my_map2.put(nameOfSport,my_map2.get(nameOfSport)+1);
            }else{
                my_map2.put(nameOfSport,1);
            }
        }
       Iterator<String> it = my_map2.keySet().iterator();
        while(it.hasNext()){
            String nowSport = it.next();
            System.out.println("종목 : "+nowSport+" 좋아하는 사람 수 : "+my_map2.getOrDefault(nowSport,0));
        }

    }
}
