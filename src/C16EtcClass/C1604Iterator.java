package C16EtcClass;
import java.util.*;

public class C1604Iterator {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("mango");
        fruits.add("melon");
        fruits.add("watermelon");

        // enhancedFor : 원본 변경 x -> remove 불가
        for(String now :fruits){
            // 원본 데이터 삭제 불가
            System.out.println(now);
        }
        System.out.println("--------------------------------------");
        // iterator사용 : 참조하고 있는 원본데이터 삭제 가능. -> remove
        Iterator<String> iterator = fruits.listIterator();
        while(iterator.hasNext()){
            if(iterator.next().equals("banana")){
                iterator.remove();
            }
        }
        System.out.println(fruits);
    }
}
