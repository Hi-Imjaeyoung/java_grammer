package C15AnonymousLamda;

import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C1505StreamAPI1 {
    public static void main(String[] args) {
//        int[] arr={100,22,334,56};
////        전통적인 방식의 데이터 접근 방식
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i]);
//        }
//
////        데이터와 객체 중심이 아닌, 입력에 따른 출력만이 존재하는 함수형 프로그래밍 방식
////        JAVA에서 함수형프로그래밍을 지원하기위한 라이브러리 -> StreamAPI
////        현대적인 프로그램에서는 원본 데이터를 훼손하지 않으면서 작업을 수행(원본 데이터에 직접 접근하지 않겠다)
////        forEach : 스트힘의 각 요소를 소모하면서 동작을 수행
//        Arrays.stream(arr).forEach(a-> System.out.println(a));
//        Arrays.stream(arr).sorted().forEach(a-> System.out.println(a));

//        스트림의 생성
        String[] str = {"HTML","CSS","JAVA","PYTHON"};
//        stream<객체> : 재네릭 타입<> 으로 스트림 객체가 생성>
        Stream<String> strStream = Arrays.stream(str);
        // 참조변수의 스트림 변환의 경우 제네릭의 타입소거 문제 발생
        // 제네릭의 타입소거란 java버전의 호환성을 위해 제네릭 타입을 런타입시점에 제거하는 것을 의미
        String[] starr2 = strStream.filter(a->a.length()<=4).toArray(a->new String[a]);
        // 메서드 참조 방식으로 표현하는 것이 더 일반적이다.
        // 클래스 :: 메서드 (메서드 참조 방식) new가 메서드
        //String[] starr3 = strStream.filter(a->a.length()<=4).toArray(String[] :: new);
        System.out.println(Arrays.toString(starr2));

        int[] intArr = {1,22,3,45,567};
        IntStream intStream =Arrays.stream(intArr);
        int[] intArr2 = intStream.filter(a->a>20).toArray();
        System.out.println(Arrays.toString(intArr2));

//        스트림의 중계 연산 : filter, map , sorted, distinct
        // distinct : 중복 제거 후 새로운 stream 반환
        intArr = new int[]{10,20,30,10,40,20,10,50};
        System.out.println(Arrays.stream(intArr).distinct().sum());

        String[] starr = {"java","java","c++","c#"};
        // 중복제거 후 새로운 배열 생성
        starr2 = Arrays.stream(starr).distinct().toArray(String[] :: new);
        System.out.println(Arrays.toString(starr2));
        // 중복제거하고 길이가 3개 이하 것으로 제한하고, 남은 배열의 길이 총합
        // mapToInt를 통해 Intstream으로 변환이 된다. -> sum메서드를 사용 가능
        IntStream intStream1 = Arrays.stream(starr).distinct().filter(a->a.length()<=3).mapToInt(a->a.length());
        System.out.println(Arrays.stream(starr).distinct().filter(a->a.length()<=3).mapToInt(a->a.length()).sum());

        // sorted : 정렬된 스트림반환
        intArr = new int[]{2,5,7,1,11,59,22};
        // 오름 차순 정렬된 신규 배열 반환
        // 사용자화 정렬은 int 타입이라서 comparator 사용이 어렵다.
        System.out.println(Arrays.toString(Arrays.stream(intArr).sorted().toArray()));


        // List의 역순 정렬
        List<Integer> intList = new ArrayList<>(Arrays.asList(8,2,1,4,5,2,1,0));
        intList.stream().sorted((o1,o2)->o2-o1).forEach(System.out::print);
        // collect(넣어 줄 Collections 객체 명시)
        System.out.println(intList.stream().sorted((o1,o2)->o2-o1).collect(Collectors.toList()));

        List<String> strList = new ArrayList<>(Arrays.asList("java","python","c++","javascript"));
        // StreamAPI를 사용하여 문자열 길이가 4개 이상인 문자의 문자열 길이를 기준으로 내림차순 정렬 후 신규 리스트 생성
        List<String> mySortedList = strList.stream()
                                           .filter(a->a.length()>=4)
                                           .sorted((o1,o2)->o2.length()-o1.length())
                                           .collect(Collectors.toList());
        System.out.println(mySortedList);

        // map 요소값을 받아서 함수에 맞는 새로운 스트림으로 반환
        int[] intArrPlus10 = Arrays.stream(intArr).map(a->a+10).toArray();
        System.out.println(Arrays.toString(intArrPlus10));
        // intArr에서 짝수만 골라서 해당 수의 제곱의 총합을 구하여라
        System.out.println(Arrays.stream(intArr)
                                 .filter(a->a%2==0)
                                 .map(a->a*a)
                                 .sum());

        // Stream 소모 : forEach, reduce
        // forEach
        Arrays.stream(intArr).forEach(a-> System.out.print(a+" "));
        // 메서드 참조 방식으로
        Arrays.stream(intArr).forEach(System.out::print);

        //reduce로 누적 곱 구하기.
        //reduce는 기준점과 값이 들어올 변수 총 두개의 매개변수가 필요하다
        // 초기값을 지정하지 않으면 optional 객체를 return 해준다.
            //optional 객체는 값이 있을 수도 있고, 없을 수도 있다는 것을 명시한 타입(java 8)
                // nullpointException : 값이 없는 null에 연산을 수행하면 발생하는 런타임 에러
        List<String> myList = new ArrayList<>(Arrays.asList("java",null));
//        myList.sort(Comparator.reverseOrder());
        Optional<String> optional = Optional.ofNullable("hello");
        if(optional.isPresent()){ // 값이 있으면! optional은 null 일 수도 있기 때문에 이런식으로 조건을 거는 것이 좋은 코드
            System.out.println(optional.get().length());
        }
        // 누적 곱
        System.out.println(Arrays.stream(intArr).reduce(1,(a,b)-> a*b));
        // 누적 합
        System.out.println(Arrays.stream(intArr).reduce(0,(a,b)->a+b));

        starr = new String[]{"hello","java","world"};
        // String배열을 하나의 문자열로 만들어보세용
        System.out.println(Arrays.stream(starr).reduce("",(a,b)->a+b+", "));
        Optional<String> answer = Arrays.stream(starr).reduce((a,b)->a+", "+b);
        if(answer.isPresent()){
            System.out.println(answer.get());
        }

        //최소/최대/평균/총합 : min max average sum
        intList = new ArrayList<>(Arrays.asList(1,5,78,3,56,32,9));
        System.out.println(intList.stream().mapToInt(a->a).max().getAsInt());
        System.out.println(intList.stream().mapToInt(a->a).average().getAsDouble());
        System.out.println(intList.stream().mapToInt(a->a).sum());

        List<Student> students = new ArrayList<>();
        students.add(new Student("재영 ",4));
        students.add(new Student("훈",53));
        students.add(new Student("종표",36));
        students.add(new Student("은지",30));
        students.add(new Student("혜선",39));
        students.add(new Student("보석",40));
        students.add(new Student("정민",76));
        students.add(new Student("선국 ",8));
        Student student1 = students.stream().filter(a->a.getAge()>5).findAny().get();

        //1. 가장 나이 어린 사람 찾기 (이름을 출력)
        System.out.println(students.stream()
                                   .sorted((o1,o2)->o1.getAge()-o2.getAge())
                                   .findFirst().map(a->a.getName())
                                   .get());
        //2. 30대가 몇명인지 출력
        System.out.println(students.stream()
                                   .filter(a->a.getAge()>=30 && a.getAge()<40)
                                   .count());
        //3 모든 객체의 평균 나이
        System.out.println(students.stream()
                                   .mapToInt(a->a.getAge())
                                   .average()
                                   .getAsDouble());
        //4 30세 이하 선찬순 한명 이름 출력
        System.out.println(students.stream()
                                   .filter(a->a.getAge()<30)
                                   .map(a->a.getName())
                                   .findFirst()
                                   .get());

        // 기존 자바의 null 처리
        String st = null;

        // 에러를 막기 위한 전통적인 처리
        if(st != null){
            System.out.println(st.compareTo("abc")); // 런타임 에러(nullpointException) 발생
        }
        // java 8 이후에 나온 Optional객체를 통해 특정 객체에 값이 없을지도 모른다는 것을 명시적으로 표현
        // Optional 객체에 빈 값을 명시적으로 넣는 방법은 Optional.empty();
        // 1) java에서 리턴 타입이 optional
        // 2) String에서 리턴 타입이 optional
        Optional<String> opt1 = Optional.empty();

        // 빈값인지 아닌지 체크하는 메소드 : isPresent()
        // 코드가 길어지고 지저분해짐
        if(opt1.isPresent()){
            System.out.println(opt1.get().compareTo("abc"));
        }else{
            System.out.println("값이 없습니다");
        }

        // Optional 객체 생성
        Optional<String> opt2 = Optional.ofNullable("hello"); // 집적 값을 넣어는 것이 아님

        // orElse관련 메소드 사용하여 null 처리
        // orElse(), orElseGet() orElseThrow()
        /// orElse() : 값이 있으면 해당값 return 없으면 default 지장값 return
        System.out.println(opt2.orElse("").compareTo("abc"));

        //orElseGet() : 값이 있으면 해당 값 리턴, 없으면 람다함수 또는 메소드 참조가 실행 들어온다.
        System.out.println(opt1.orElseGet(String :: new).compareTo("abc"));
        System.out.println(opt1.orElseGet(()->new String("none")).compareTo("abc"));

        //orElseThrow() : 값이 있으면 해당 값 리턴, 없으면 지정된 예외 강제 발생
            // 예외 처리는 개발에 있어어 중요하다. (사용자에게 어떻게 최적의 에러를 보여줄 것 인가)
//        int result1 =opt1.orElseThrow(()->new NoSuchElementException("객체에 값이 없습니다요")).compareTo("abc");
//            //추후 try catch를 통해서 문구를 출력
//        result1 =opt1.orElseThrow(NoSuchElementException::new).compareTo("abc");
//        System.out.println(result1);

        //OptionalInt, Long, Double
        OptionalInt optionalInt = new ArrayList<>(Arrays.asList(1,2,3,4,5)).stream().mapToInt(a->a).max();
        // isPresent()
        if(optionalInt.isPresent()){
            System.out.println(optionalInt.getAsInt());
        }
        //orElseThrow 방법 활용
        System.out.println(optionalInt.orElseThrow(()->new NoSuchElementException()));

        //과제 Stream API가 디버깅이 어렵다. peek() 이라는 메서드가 존재하긴 하는데
    }
}
