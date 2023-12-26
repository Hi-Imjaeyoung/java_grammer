package C16EtcClass;

import java.util.Arrays;

public class C1603GenericMain {
    public static void main(String[] args) {
        String[] stArr={"java","python","c++"};
        // 0번째 1번째 자리 change
        swapString(stArr,0,1);
        swap(stArr,1,0);
        System.out.println(Arrays.toString(stArr));

        Integer[] intArr={1,2,3,4};
        // 1번째 2번째 자리 change
        swapInt(intArr,1,2);
        swap(intArr,2,1);
        System.out.println(Arrays.toString(intArr));

        GenericStudent<String> ageTypeStr = new GenericStudent<>();
        ageTypeStr.setAge("11살");
        GenericStudent<Integer> ageTypeInt = new GenericStudent<>();
        ageTypeInt.setAge(110);
        System.out.println(ageTypeInt.toString());
    }
    public static void swapString(String[] arr,int target1, int target2){
        String tmp = arr[target1];
        arr[target1] = arr[target2];
        arr[target2] = tmp;
    }

    public static void swapInt(Integer[] arr,int target1, int target2){
        int tmp = arr[target1];
        arr[target1] = arr[target2];
        arr[target2] = tmp;
    }
    // 재네릭 메서드 생성 : 반환 타입 왼쪽에 <T>를 선언
    // 제네릭은 객체 타입이 들어와야함에 유의
    public static <T> void swap(T[] arr,int target1, int target2){
        T tmp = arr[target1];
        arr[target1] = arr[target2];
        arr[target2] = tmp;
    }

}

class GenericStudent<E>{
    String name;
    E age;

    public String getName() {
        return name;
    }

    public E getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(E age) {
        this.age = age;
    }
    @Override
    public String toString(){
        return "이름은: "+ this.name + " age의 타입은 : "+this.age.getClass();
    }
}
