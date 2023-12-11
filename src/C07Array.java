import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;

public class C07Array {
    public static void swap(int i,int j,int[]arr){
        int saveNumber = arr[i];
        arr[i] = arr[j];
        arr[j] = saveNumber;
    }
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

        // 숫자 조합의 합 : 각기 다른 숫자의 배열이 있을때 만들어질 수 있는 2개의 조합의합을 출력하라
        int[] combi_arr = {10,20,30,40,50,60};
        int cnt=0;
        for(int i=0;i<combi_arr.length-1;i++){
            for(int j=i+1;j<combi_arr.length;j++){
                cnt++;
                System.out.print((combi_arr[i]+combi_arr[j])+" ");
            }
        }
        System.out.println(cnt +"개의 조합이 있습니다");


        int[] remove_test = {10,10,40,5,7};
        Arrays.sort(remove_test);
        int[] non_duplicate_arr = new int[remove_test.length];
        non_duplicate_arr[0] = remove_test[0];
        int index =1;
        for(int i=0;i<remove_test.length-1;i++){
            if(remove_test[i]==remove_test[i+1]){
                continue;
            }
            non_duplicate_arr[index] = remove_test[i+1];
            index++;
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(non_duplicate_arr,0,index)));

        // 배열 복사
        int[] copy_test = Arrays.copyOfRange(remove_test,0,3);
        System.out.println(Arrays.toString(copy_test));

        // 배열의 검색
        int[] search = {0,1,3,3,3,5,7,8};

        // 이진 검색
        // 사전에 오름차순 정렬이 되어 있어야 함 (divide and conquer)
        Arrays.sort(search);
        // 값이 유니크 해야함
        System.out.println(Arrays.binarySearch(search,3));

        OptionalInt search_Index = Arrays.stream(search).filter(a->a==3).findFirst();
        int search_Index_int = Arrays.stream(search).filter(a->a==3).findFirst().getAsInt();
        System.out.println(search_Index_int);

        // equals : 순서까지 동일해야 true
        int[] equals1 ={1,2,3};
        int[] equals2 = {1,2,3};
        System.out.println(Arrays.equals(equals1,equals2));

        // 배열 복사 : copyOf(대상배열, endindex)
        // copyOfRange(대상배열, startIndex, endIndex)
        int[] copy_test1 = {10,20,30,40,50};
        int[] copy_test2 = Arrays.copyOf(copy_test1,10);
        int[] copy_test3 = Arrays.copyOfRange(copy_test1,0,4);
        System.out.println(Arrays.toString(copy_test2));
        System.out.println(Arrays.toString(copy_test3));

        // 2차원 배열
        int[][] dimension2_arr1 ={{1,2,3},{4,5,6}}; // 리터럴 방법
        int[][] dimension2_arr2 = new int[2][3];
        dimension2_arr2[0][0] = 1;
        dimension2_arr2[0][1] = 2;
        dimension2_arr2[0][2] = 3;
        dimension2_arr2[1][0] = 4;
        dimension2_arr2[1][1] = 5;
        dimension2_arr2[1][2] = 6;

        int[][] dimension2_arr3 = new int[3][]; // 가변 배열
        dimension2_arr3[0] = new int[1];
        dimension2_arr3[1] = new int[2];
        dimension2_arr3[2] = new int[3];

        // runtime error 발생 선언을 해주야 한다.
//        dimension2_arr3[0][0] = 10;
//        dimension2_arr3[0][1] = 20;
//        dimension2_arr3[0][2] = 30;

        System.out.println(Arrays.deepToString(dimension2_arr1));
        System.out.println(Arrays.deepToString(dimension2_arr2));
        System.out.println(Arrays.deepToString(dimension2_arr3));

//        [3][4] 사이즈의 배열을 선언한 뒤
//        1,2,3~12까지 숫자값 각 배열에 할당
        int[][] dimension2_test = new int[3][4];
        int count = 1;
        for(int i=0;i<dimension2_test.length;i++){
            for(int j=0;j<dimension2_test[i].length;j++){
                dimension2_test[i][j] = count ++;
            }
        }
        System.out.println(Arrays.deepToString(dimension2_test));

//        가변배열 만들기 : 전체 사이즈는 5 각 배열마다 사이즈 1,2,3,4,5로 커지도록 만들어 놓기
//        count 1부터 시작해서 끝날때 까지 +1시키면서 데이터 세팅
        int[][] dimension2_test2 = new int[5][];
        for(int i=0;i<dimension2_test2.length;i++){
            dimension2_test2[i] = new int[i+1];
            for(int j=0;j<dimension2_test2[i].length;j++){
                dimension2_test2[i][j] = (i+1)*10;
            }
        }
        System.out.println(Arrays.deepToString(dimension2_test2));
        int[] arr = {30,22,20,25,12};

        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    swap(i,j,arr);
                }
            }
        }
        //ASC
        System.out.println(Arrays.toString(arr));

        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    swap(i,j,arr);
                }
            }
        }
        //DEC
        System.out.println(Arrays.toString(arr));

        //Bubble sort
        for(int i=arr.length-1; i>=0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    swap(j,j+1,arr);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        // 효율성 문제
        int[] bubble_sort={5,1,2,3,4};
        boolean isFin = false;

        for(int i= bubble_sort.length-1; i>=0;i--){
            isFin = true;
            for(int j=0;j<i;j++){
                if( bubble_sort[j]> bubble_sort[j+1]){
                    swap(j,j+1, bubble_sort);
                    isFin = false;
                }
            }
            if(isFin){
                System.out.println("now i " + i);
                break;
            }
        }
     }
}
