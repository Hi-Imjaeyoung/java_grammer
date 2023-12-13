import java.util.*;

public class C10Set {
    public static void main(String[] args) {
        // 순서 없고 중복 없다.
        Set<String> firstSet = new HashSet<>();
        firstSet.add("home");
        firstSet.add("home");
        firstSet.add("my home");
        firstSet.add("love home");
        firstSet.add("want home");
        firstSet.add("happy home");
        firstSet.add("love home");
        System.out.println(firstSet);

        //  학생들이 좋아하는 운동 종목 : list로 만들고
        //  좋아하는 종목을 추려보기
        List<String> sports = new ArrayList<>(Arrays.asList("soccer","tennis","soccer","soccer","baseball","yoga","yoga","yoga"));
        // 1.인자를 하나하나 넣기
        Set<String> sportSet = new HashSet<>();
        for(String a:sports){
            sportSet.add(a);
        }
        System.out.println("학생들이 좋아하는 종목의 수는 :" +sportSet.size());
        // 2. 리스트(Collection frame work는 다 가능) 를 넣기
        sportSet = new HashSet<>(sports);
        System.out.println("학생들이 좋아하는 종목의 수는 :" +sportSet.size());

        // 3. 배열을 인자값으로 set 초기값 세팅
        String[] sportsArr = {"soccer","tennis","soccer","soccer","baseball","yoga","yoga","yoga"};
        sportSet = new HashSet<>(Arrays.asList(sportsArr));

        sportSet.remove("soccer");
        System.out.println(sportSet);

        Set<String> strSet1 = new HashSet<>(Arrays.asList("java","javascript","python"));
        Set<String> strSet2 = new HashSet<>(Arrays.asList("java","html","c++"));
        // a.retainAll(b) : 교집합 (a에 교집합만 딱 남음)
        Set<String> tmpSet = new HashSet<>(strSet1);
        tmpSet.retainAll(strSet2);
        System.out.println(tmpSet);
        // a.addAll(b) : 합집합 (a와b의 합이 a에 남음
        tmpSet = new HashSet<>(strSet1);
        tmpSet.addAll(strSet2);
        System.out.println(tmpSet);
        // a.removeAll(b) : 차집합 (교집합을 뺸 a가 남음)
        tmpSet = new HashSet<>(strSet1);
        tmpSet.removeAll(strSet2);
        System.out.println(tmpSet);

        //LinkedHashSet TreeSet
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("hello2");
        treeSet.add("hello1");
        treeSet.add("hello4");
        System.out.println(treeSet);
    }
}
