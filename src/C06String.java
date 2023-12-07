import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class C06String {
    public static void main(String[] args) {
//        참조 자료형 : 기본 자료형을 제외한 모든 자료형
//        Wrapper calss : 기본형 타입에 없는 다양한 기능을 지원하기 위한 클래스

        // int와 Integer간의 형변환
//        int a = 10;
//        Integer b = new Integer(10);
////        auto unboxing (wrapper를 자동으로 풀러줌)
//        int c = b;
////        unboxing
//        int d = b.intValue();
////        auto boxing
//        Integer e = a;
////        boxing
//        Integer f = Integer.valueOf(a);

//        String과 int의 형변환
//        int a = 10;
//        String stA = Integer.toString(a);
//        int c = Integer.parseInt(stA);

//        참조자료형에 원시자료형을 담을 떄는 wrapper class를 사용해야 한다
//        Collection framework(List, set...)
//        List<Integer> list = new ArrayList<>();
//        list.add(10);
//        list.add(20);
//        list.add(30);
//        System.out.println(list.toString());
//        배열은 원시자료형을 그냥 담는다.

//        String pool 과 String 객체
//        String myst1 = new String("hello");
//        String myst2 = new String("hello");
//        String myst3 = "hello";
//        String myst4 = "hello";
//        String myst5 = myst1; //스택메모리는 다르지만 같은 공간의 힙메모리를 가짐
//        System.out.println(myst1 == myst2); // false
//        System.out.println(myst1 == myst3); // false
//        System.out.println(myst3 == myst4); // true
//        System.out.println(myst1 == myst5); // true
////        equals method를 사용해라
//        System.out.println(myst1.equals(myst2)); // true
//        System.out.println(myst1.equals(myst3)); // true
//

//        List<Integer> list2 = new ArrayList<>(); // 객체 간의 ==을 조심하세요
//        list2.add(10);
//        list2.add(20);
//        list2.add(30);
//        List<Integer> list3 = list2; // 주소가 동일하기 떄문 수정 시 동일해짐
//        list3.add(40);
//        list2.add(50);
//        System.out.println(list2);
//        System.out.println(list3);

////        문자열의 길이는 length
//        String myst = "hello";
//        System.out.println(myst.length());
////        indexOf
//        String myst2 = "hello java java";
//        System.out.println(myst2.indexOf("j")); // 특정 문자열의 위치를 반환 (가장 먼저 나오는 문자열의 위치를 리턴) 공백도 문자열
////        contains : 특정 문자열이 있는지 여부를 boolean으로 리턴
//        String contains_test = "hello java!";
//        System.out.println(contains_test.contains("j"));
//        System.out.println(contains_test.contains("java"));
//        System.out.println(contains_test.contains("jaba"));
//        System.out.println(contains_test.contains("hello "));
////        charAt : 문자열에서 특정 위치의 char를 리턴
//        String charAt_test = "hello";
//        System.out.println(charAt_test.charAt(2)); // l
//        // 실습 문자열내 문자 갯수 구하기
//        //String st = "avasdaaavae";
//        String st = "asdfghlpout";
//        int cnt =0;
//        for(int i =0 ;i<st.length();i++){
//            if(st.charAt(i) == 'a'){ // char 이니까 == 가능합니다
//                cnt++;
//            }
//        }
//        System.out.println(cnt);

//        substring : 문자열 자르기
        // substring(a,b) a이상 b미만의 index를 잘라
//        String st1 = "hello world";
//        System.out.println(st1.substring(0,5));
//        System.out.println(st1.substring(6,st1.length()));
//
////        trim : 문자 양 옆 공백 제거 유니코드에서 발생되는 공백을 인식 못함 그냥 strip 써~
////        / strip (java 11에서 추가)
//        String trim_test ="   2   hello world   ";
//        String strip_test = "   2   hello world   ";
//        System.out.println(trim_test.trim());
//        System.out.println(strip_test.strip());
//
////        toUpperCase , toLowerCase
//        String upToLow_test = "aAbBcCdD";
//        System.out.println(upToLow_test.toUpperCase());
//        System.out.println(upToLow_test.toLowerCase());
//
////        문자열 더하기
//        String a = "hello";
//        a+="world";
//        System.out.println(a);
//
////        char를 String으로
//        char ch1 = 'a';
//        String charToString_test = Character.toString(ch1);
//
//        String replace_test ="abcdefg1234한글";
//        System.out.println(replace_test.replaceAll("[^a-z]",""));
//
//        System.out.println((int)'a');
//        System.out.println((int)'z');
//        String answer ="";
//        for(char nowChar:replace_test.toCharArray()){
//            if(nowChar>=97 &&  nowChar<=122){
//                answer+=Character.toString(nowChar);
//            }
//        }
//        answer = "";
//        for(int i=0;i<replace_test.length();i++){
//            if(replace_test.charAt(i)>=97 &&replace_test.charAt(i)<=122){
//                answer+=Character.toString(replace_test.charAt(i));
//            }
//        }
//        System.out.println(answer);

//        replace(a,b) : a를 찾아서 b로 바꿔서 리턴.
//        replaceAll : 정규 표현식을 사용 가능
//        String replace_test = "hello world";
//        System.out.println(replace_test.replaceAll("world","java"));
//        System.out.println(replace_test.replace("world","hoon"));
//
//        String regx_test ="awE213가나AAsd나가1124";
////        [a-z] 소문자 알파벳 , [A-Z] 대문자, [a-zA-z]
//        System.out.println(regx_test.replaceAll("[a-z]",""));
//        System.out.println(regx_test.replaceAll("[a-zA-Z]",""));
////        [가-힣] 한글
//        System.out.println(regx_test.replaceAll("[가-힣]",""));
//        System.out.println(regx_test.replaceAll("[^가-힣]",""));
////        [0-9] 숫자
//        System.out.println(regx_test.replaceAll("[0-9]",""));
////        숫자 알파벳 다 없애기 [a-zA-Z0-9]
//        System.out.println(regx_test.replaceAll("[a-zA-Z0-9]",""));

//        pattern class
        // + 줄줄이 나온다라는 의미 ..
        boolean mathers = Pattern.matches("[a-z]+","helloworld");
        System.out.println(mathers);
        // .* .*부분적으로 있으면 확인
        mathers = Pattern.matches(".*[a-z].*","한글hell한o글w한o글rl한d글");
        System.out.println(mathers);
        // 전화번호 검증
        // \\d 숫자 {} :연속으로 나오는 숫자
        mathers = Pattern.matches("^\\d{3}-\\d{4}-\\d{4}$","010-1234-1234");
        System.out.println(mathers);
        // 이메일 검증
        mathers = Pattern.matches("^[a-z0-9]+@[a-z]+.com$","hello1@naver.com");
        System.out.println(mathers);
        mathers = Pattern.matches("^[a-z0-9]+@[a-z]+.com$","hello1!naver.com");
        System.out.println(mathers);

//        split 문자열 쪼개기 > 쪼개서 String[]을 리턴
        String spilt_test = "a:b:c:d";
        System.out.println(Arrays.toString(spilt_test.split(":")));
        spilt_test = "a b c d";
        System.out.println(Arrays.toString(spilt_test.split(" ")));
        // 공백이 중복될때 원하는 방식으로 안나옴
        spilt_test = "a b  c    d";
        System.out.println(Arrays.toString(spilt_test.split(" ")));
        // \\s 공백을 의미 +(여러개를 의미)
        System.out.println(Arrays.toString(spilt_test.split("\\s+")));
        // 양쪽에 공백이 있을 때 어휴..
        spilt_test = " a b  c    d";
        System.out.println(Arrays.toString(spilt_test.strip().split("\\s+")));

//        isEmpty : null과는 다름에 유의 "" 과 null은 다름
        String empty_test = "";
        System.out.println(empty_test.isEmpty()); // true;
        empty_test = null;
        System.out.println(empty_test.isEmpty()); //false
    }
}
