import java.util.Arrays;
import java.util.Comparator;

public class C07Array {
    public static void main(String[] args) {
//        리터럴 방식의 값 세팅
        int[] int_arr1 ={1,2,3,4};
//        표현식
        int[]  int_arr2 = new int[4];
        int_arr2[0] = 1;
        int_arr2[1] = 2;
        int_arr2[2] = 3;
        int_arr2[3] = 4;
//        표현식3
        int[] int_arr3 = new int[]{1,2,3,4};
//        표현식4 는 불가
        //int[] int_arr4 = new int[]; //길이가 지정되어야함

        // 85,65,90 인 int 배열을 선언한 뒤, 총합 평균을 구하세여~
        int[] arr_practice1 = {85,65,90};
        int sum=0, avg =0;
        for(int i=0;i<arr_practice1.length;i++){
            sum+=arr_practice1[i];
        }
        System.out.println("합 "+sum +"\n"+"평군 "+sum/arr_practice1.length);

        int[] arr_max_min ={10,20,30,12,8,17};
        int max =arr_max_min[0];
        int min =arr_max_min[0];
        for(int i=0;i<arr_max_min.length;i++){
            max = Math.max(max,arr_max_min[i]);
            min = Math.min(max,arr_max_min[i]);
        }
        System.out.println("max value is "+max);
        System.out.println("min value is "+min);

        // 배열의 순서 바꾸기
        int [] arr_change = {1,2,3,4};
        int tmp = arr_change[0];
        arr_change[0] = arr_change[2];
        arr_change[2] = tmp;

//        0과1 자리바꾸고 1과 2자리 바꾸고 2와 3 자리바꾸고...
        int[] arr_pr2 ={10,20,30,40,50,60,70};
        for(int i=0;i<arr_pr2.length-1;i++){
            int saveNumber= arr_pr2[i];
           arr_pr2[i] = arr_pr2[i+1];
           arr_pr2[i+1] = saveNumber;
        }
        System.out.println(Arrays.toString(arr_pr2));

//        배열 뒤집기
        int[] arr_reverse = {1,2,3,4,5,6};
        int[] arr_reverse_result = new int [6];
        for(int i=0;i<arr_reverse.length;i++){
            arr_reverse_result[arr_reverse.length-i-1] = arr_reverse[i];
        }
        System.out.println(Arrays.toString(arr_reverse_result));

//        배열 뒤집기 2
//        1 2 3 4
        for(int i=0;i<arr_reverse.length/2;i++){
            int saveNumber = arr_reverse[i];
            arr_reverse[i]=arr_reverse[arr_reverse.length-i-1];
            arr_reverse[arr_reverse.length-i-1] = saveNumber;
        }
        System.out.println(Arrays.toString(arr_reverse));

//        정렬 sort() 사용 : 클래스 메서드
        int[] arr_sort_test = {4,1,-2,2,4,100,-40};
        // 가본 오름차순
        Arrays.sort(arr_sort_test);
        System.out.println(Arrays.toString(arr_sort_test));

        // 내림차순
        // 방법 1. Comparator 객체 사용
        // 객체 타입인 경우에만 Comparator 클래스 사용 가능 -> 기본형 타입은 호환이 안됌
        String[] st_arrr ={"hello","hi","bye","goodmorning"};
        Arrays.sort(st_arrr);
        System.out.println(Arrays.toString(st_arrr));
        Arrays.sort(st_arrr, Comparator.reverseOrder());
        System.out.println(Arrays.toString(st_arrr));
        Integer[] arr_sort_integer = {5,12,15,6,22,1,2};
        Arrays.sort(arr_sort_integer,Comparator.reverseOrder()); // Integer은 가능

//        Arrays.sort(arr_sort_test,Comparator.reverseOrder());  원시타입에는 Comparator 클래스 사용이 불가하다
        // 방법 2. 배열 뒤집기 기본형 타입인 경우는 이렇게 함
        for(int i=0;i<arr_sort_test.length/2;i++){
            int save = arr_sort_test[i];
            arr_sort_test[i] = arr_sort_test[arr_sort_test.length-1-i];
            arr_sort_test[arr_sort_test.length-1-i]=save;
        }
        System.out.println(Arrays.toString(arr_sort_test));

        // 방법 3. stream api와 lambda를 사용한 내림차순 정렬
        // 원본을 훼손 시키지 않는다. (현대적인 코딩 패턴)
        int[] stream_test = {1,52,-23,22,4,6,94};
        int[] stream_test_sorted = Arrays.stream(stream_test)//array를 대상 stream객체(복제본 느낌) 생성하는법
                                    .boxed() // Integer로 형 변환한 스트림 객체 생성 (boxing)
                                    .sorted(Comparator.reverseOrder()) // 내림차순 정렬
                                    .mapToInt(a->a) // Integer를 int로 변환하는 걱
                                    .toArray(); // 배열로 변환
     }
}
