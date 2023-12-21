package C15AnonymousLamda;

import java.util.Arrays;

public class C1505StreamAPI1 {
    public static void main(String[] args) {
        int[] arr={100,22,334,56};
//        전통적인 방식의 데이터 접근 방식
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

//        데이터와 객체 중심이 아닌, 입력에 따른 출력만이 존재하는 함수형 프로그래밍 방식
//        JAVA에서 함수형프로그래밍을 지원하기위한 라이브러리 -> StreamAPI
//        현대적인 프로그램에서는 원본 데이터를 훼손하지 않으면서 작업을 수행(원본 데이터에 직접 접근하지 않겠다)
//        forEach : 스트힘의 각 요소를 소모하면서 동작을 수행
        Arrays.stream(arr).forEach(a-> System.out.println(a));
        Arrays.stream(arr).sorted().forEach(a-> System.out.println(a));

    }
}
