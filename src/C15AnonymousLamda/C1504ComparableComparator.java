package C15AnonymousLamda;

import java.util.*;

public class C1504ComparableComparator {
    public static void main(String[] args) {
//        자바에서는 비교를 위한 인터페이스 대표적으로 2개 존재. Comparable, Comparator
//        Comparable 인터페이스에는 compareTo라는 메소드가 선언되어 있으며 java에 많은 클래스에서 구현하고 있음.-> 일반적으로 직접 클래스 내에서 구현
//        Comparator 에는 compare 메서드가 선언되어 있다. -> 일반적으로 익명객체를 생성하여 사용

//        두 문자열의 각 문자를 앞에서 부터 순차적으로 비교한다.
//        첫 번째 문자열의 자리 수에 차이가 발생 할 때, 그 문자의 유니코드 값의 차이를 반환한다.
//        String a = "Hello";
//        String b = "Horld";
//        System.out.println(a.compareTo(b));
//
//        Integer intA = 1;
//        Integer intB = 10;
//        System.out.println(intA.compareTo(intB));
//
//        List<String> myList = new ArrayList<>();
//        myList.add(a);
//        myList.add(b);
//        Collections.sort(myList); // Comparable의 (String 클래스에 존재하는 )compareTo 메서드를 활용해서 정렬을 한다.
//        Collections.sort(myList,Comparator.reverseOrder());
//        myList.sort(Comparator.naturalOrder());
//        myList.sort(Comparator.reverseOrder());
////        객체의 정렬은 사용자가 직접 구현해줘야한다.
////        음수 -> 왼쪽이 작은 값 0 -> 같음 양수 -> 왼쪽이 큼
//        List<Student> students = new ArrayList<>();
//        students.add(new Student("재영",200));
//        students.add(new Student("조훈",100));
//        students.add(new Student("보석",2));
//        students.add(new Student("종표",20));
//        students.add(new Student("혜선",2020));
//        students.add(new Student("정민",1020));
//        System.out.println(students);
//        for(Student nowStudent : students){
//            System.out.println(nowStudent.getName()+" "+nowStudent.getAge());
//        }
//
////        방법 1 : Comparable 인터페이스 implements 후 compareTo 구현 (매개 변수 한개)
//        Collections.sort(students); // Comparator가 없으면 자동으로 Collection의 sort에서 지정한 객체의 compareTo로 통해서 정렬한다
////        방법 2 : Comparator 익명 객체 방식으로 활용하여 정렬 (매개 변수 두개)
//        // 나이 기준 정렬
//        students.sort(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                // 기본은 오름차순 정렬을 시도.
//                // o1.getAge - o2.getAge : 오름차순
//                // o2.getAge - o1.getAge : 내림차순
//                return o1.getAge()-o2.getAge();
//            }
//        });
//        System.out.println(students);
//        students.sort((o1,o2)-> o1.getAge() - o2.getAge());
//        // 이름 기준 정렬
//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
//        System.out.println(students);
//        students.sort((o1,o2)->o1.getName().compareTo(o2.getName()));
//
//        //글자 길이 수 정렬
//        String[] stArr = {"hello","java","c"};
//        Arrays.sort(stArr,Comparator.reverseOrder()); // 역순 정렬
//        Arrays.sort(stArr,(o1,o2)-> o1.length()-o2.length());
//        System.out.println(Arrays.toString(stArr));
//
//        //PQ 정렬 기준
//        Queue<String> pq = new PriorityQueue<>((o1,o2)->o2.length()-o1.length());
//
//        //이 문자로 결합 했을 때 이루어진 가장 큰 숫자를 구하라
//        //3 30 34 5 9
//        Arrays.sort(stArr);

        // 쓰레드 구현 방식 : 쓰레드 상속, Runnable 방식
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("내가 만든 쿠키~");
            }
        });
        t1.start();

        // 람다형식으로 표현한  쓰레드
        new Thread(()->System.out.println("내가 만든 쿠키~")).start();

        System.out.println("main 의 쓰레드 입니다");
        System.out.println("main 쓰레드 끝!");

    }
}

class Student implements Comparable<Student>{
    private String name;
    private int age;
    Student(String name , int age){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
//    자동으로 최고 조상인 Object클래스를 Overriding 상속하고 있다
    @Override
    public String toString(){
        return "이름은 "+this.name +" "+" 나이는 "+this.age;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}
