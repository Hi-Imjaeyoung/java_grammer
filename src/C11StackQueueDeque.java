import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class C11StackQueueDeque {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

        System.out.println(myStack);
        System.out.println(myStack.size());
        // 맨 위에 값을 보기만 함
        System.out.println(myStack.peek());
        // pop stack에서 해당 요소 반환
        while (!myStack.isEmpty()){
            System.out.print(myStack.pop() + " ");
        }

        // 웹페이지 뒤로가기 기능 구현
        // 방문한 사이트 출력 + 뒤로가기 기능 구현
        // 스캐너로 신규 사이트 방문 or 뒤로가기
        // 신규사이트방문일경우 해당 주소 push
        // 뒤로가기일 경우 해당 주소 pop

//        Scanner sc = new Scanner(System.in);
//        Stack<String> st = new Stack<>();
//        Stack<String> st2 = new Stack<>();
//        boolean isEnd = false;
//        while(true){
//            System.out.println("새로운 페이지 이동 1번, 뒤로가기 2번, 앞으로 가기 3번, 종료하기 4번 ");
//            switch (sc.nextInt()){
//                case 1:
//                    System.out.println("이동할 페이지를 입력해주세요");
//                    String newPage = sc.nextLine();
//                    System.out.println("현재 페이지 : "+newPage);
//                    st.push(newPage);
//                    break;
//                case 2:
//                    if(st.isEmpty()){
//                        System.out.println("뒤로 갈 페이지가 없습니다");
//                    }else{
//                        System.out.println("뒤로 이동합니다");
//                        st2.push(st.pop());
//                        String popPage = st.peek();
//                        System.out.println("현재 페이지 : "+popPage);
//                    }
//                    break;
//                case 3:
//                    if(st2.isEmpty()) {
//                        System.out.println("앞으로 이동할 페이지가 없습니다");
//                    }else{
//                        System.out.println("앞으로 이동합니다");
//                        String popPage=st2.pop();
//                        st.push(popPage);
//                        System.out.println("현재 페이지 : "+popPage);
//                    }
//                    break;
//                case 4:
//                    isEnd = true;
//                    break;
//            }
//            if(isEnd){
//                break;
//            }
//        }

        Queue<Integer> que = new LinkedList<>();
        que.add(10);
        que.add(20);
        que.add(30);
        System.out.println(que.poll()); // 10
        System.out.println(que.peek()); // 20

        // 프린터 대기열 예제
        // 문서 1, 문서 2, 문서 3
        que = new LinkedList<>();
        que.add(1);
        que.add(2);
        que.add(3);
        while(!que.isEmpty()){
            System.out.println("현재 출력 중인 문서 : "+que.poll()+"번 문서");
        }
        //deque를 써라...

        // 길이 제한이 있는 큐 : ArrayBlockingQueue
        Queue<String> arrayBlockingQue = new ArrayBlockingQueue<>(3);
        //add 와 offer의 차이
        //add는 길이가 다 차면 에러를 발생
        //offer는 길이가 충분할 때만 넣어줌
        arrayBlockingQue.offer("java");
        arrayBlockingQue.offer("python");
        arrayBlockingQue.offer("c++");
        arrayBlockingQue.offer("Node");
        arrayBlockingQue.offer("kotlin");
        while (!arrayBlockingQue.isEmpty()){
            System.out.println(arrayBlockingQue.poll());
        }
        arrayBlockingQue = new ArrayBlockingQueue<>(3);
//        arrayBlockingQue.add("java");
//        arrayBlockingQue.add("python");
//        arrayBlockingQue.add("c++");
//        arrayBlockingQue.add("Node");
//        arrayBlockingQue.add("kotlin"); // error 던짐

        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(20);
        pq.add(5);
        pq.add(10);
        System.out.println(pq);

//        ArrayDeque는 양방향에서 데이터를 삽입 제거 할 수 있다. 성능 굿 왜 빠름?
        // 양 방향 큐
        Deque<Integer> mydq = new ArrayDeque<>();
        mydq.addFirst(10);
        mydq.addFirst(20);
        mydq.addFirst(30);
        System.out.println(mydq);
        mydq.addLast(40);
        System.out.println(mydq);
        System.out.println(mydq.pollFirst());
        System.out.println(mydq.pollLast());


    }
}
