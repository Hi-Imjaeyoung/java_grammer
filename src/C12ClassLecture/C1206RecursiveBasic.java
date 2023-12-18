package C12ClassLecture;

public class C1206RecursiveBasic {
    public static void main(String[] args) {
//        for문을 이용하여 1~10까지 누적합 구하기
        int sum = 0;
        for(int i=1;i<11;i++){
            sum+=i;
        }
        System.out.println(sum);
        System.out.println(add_acc(10));
        //System.out.println(add_acc(21000));

//        누적 곱하기 값을 재귀함수 형식으로 만들기 (팩토리얼)
        System.out.println(factorial(10));
//        for문으로 구현한 피보나치 수열
        int[] fibo = new int[10_000];
        fibo[1] =1;
        fibo[2] =1;
        for(int i=3;i<=10; i++){
            fibo[i] = fibo[i-1]+fibo[i-2];
        }
        System.out.println(fibo[10]);
//        메모지에이션 (기억 알고리즘 - DP)
//        단계마다 계산 결과값을 중간 중간 필요할때

//        변수 3개 사용해서 해보기
        int a=1,b =1;
        int c = 0;
        for(int i=3;i<11;i++){
            c = a+b;
            a = b;
            b = c;
        }
        System.out.println(c);

        System.out.println(fibo(10));
    }
//    메서드가 자기자신을 호출하는 매서드를 재귀함수라고 하고, 이러한 호출방식을 재귀호출이라고 한다.
    static int add_acc(int nowNumber){
        if(nowNumber==0){
            return nowNumber;
        }
        return add_acc(nowNumber-1)+nowNumber;
    }
    static int factorial(int nowNumber){
//        0! =1 인 경우를 위해 조건 수정
        if(nowNumber<=1) return 1;
        return nowNumber*factorial(nowNumber-1);
    }
//    재귀함수를 사용한 fibo
    static int fibo(int nowNumber){
        if(nowNumber<=2){
            return 1;
        }
        return fibo(nowNumber-1)+fibo(nowNumber-2);
    }
}
