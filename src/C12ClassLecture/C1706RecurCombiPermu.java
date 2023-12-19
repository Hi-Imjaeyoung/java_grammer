package C12ClassLecture;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;

public class C1706RecurCombiPermu {
    static int[][] combis;
    static boolean[] vist;
    static int count,max,answer ;
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>(Arrays.asList(1,2,3,4,5));

////        myList의 조합을 만들어라
//        List<List<Integer>> combi = new ArrayList<>();
//        for(int i=0;i<myList.size()-1;i++){
//            for(int j=i+1;j<myList.size();j++){
//                combi.add(new ArrayList<>(Arrays.asList(myList.get(i),myList.get(j))));
//            }
//        }
////        System.out.println(combi);
//
////        규칙 찾기
//        List<Integer> tmp = new ArrayList<>();
//        for(int i=0;i<myList.size()-1;i++){
//            tmp.add(myList.get(i));
//            for(int j=i+1;j<myList.size();j++){
//                tmp.add(myList.get(j));
//                combi.add(new ArrayList<>(tmp));
//                tmp.remove(tmp.size()-1);
//            }
//            tmp.remove(tmp.size()-1);
//        }
//
////        재귀로 해보기
//        combi = new ArrayList<>();
//        tmp = new ArrayList<>();
//        combisDetail(0,2,myList,tmp,combi);
//        System.out.println(combi);
//
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.println(combi(4,2));
        vist = new boolean[myList.size()];
        List<List<Integer>> permu = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int r = 3;
        count =0;
        //permuation(permu,myList,tmp,r);
//        System.out.println(permu);
//        System.out.println(count);

//        1. 합계가 6이상인 2개 순열만 add
        myList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        vist = new boolean[myList.size()];
        permu = new ArrayList<>();
        tmp = new ArrayList<>();
        r =2;
        permuation1(permu,myList,tmp,r);
        System.out.println(permu);
//        2. 합계가 6이상인 모든 순열 add
        myList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        vist = new boolean[myList.size()];
        permu = new ArrayList<>();
        tmp = new ArrayList<>();
        permuation2(permu,myList,tmp);
        System.out.println(permu);
//        2. 좀더 효율적이게 구해보기

//        3. 3개 순열에서 합계가 가장 큰 값 찾기.
        myList = new ArrayList<>(Arrays.asList(-9,2,-1,1,2,3,4,5));
        vist = new boolean[myList.size()];
        List<Integer> maxList = new ArrayList<>();
        tmp = new ArrayList<>();
        max = 0;
        answer = 0;
        Integer count =0;
        permuation3(myList,count);
        System.out.println(answer);

    }
    public static void permuation3(List<Integer> myList,Integer count){
        if(count==3){
            if(6<=max){
                answer=Math.max(answer,max);
            }
            return;
        }
        for(int i=0;i<myList.size();i++){
            if(!vist[i]){
                vist[i] = true;
                max+=myList.get(i);
                permuation3(myList,count+1);
                vist[i] = false;
                max-=myList.get(i);
            }
        }
    }
    public static void permuation2(List<List<Integer>> permu,List<Integer> myList, List<Integer> tmp){
        if(tmp.size()==myList.size()){
            if(sumList(tmp)>=6){
                permu.add(new ArrayList<>(tmp));
            }
            return;
        }
        if(sumList(tmp)>=6) permu.add(new ArrayList<>(tmp));
        for(int i=0;i<myList.size();i++){
            if(!vist[i]){
                vist[i] = true;
                tmp.add(myList.get(i));
                permuation2(permu,myList,tmp);
                vist[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public static void permuation1(List<List<Integer>> permu,List<Integer> myList, List<Integer> tmp, int r){
        if(tmp.size()==r){
            if(sumList(tmp)>=6){
                permu.add(new ArrayList<>(tmp));
            }
            return;
        }
        for(int i=0;i<myList.size();i++){
            if(!vist[i]){
                vist[i] = true;
                tmp.add(myList.get(i));
                permuation1(permu,myList,tmp,r);
                vist[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public static void permuation(List<List<Integer>> permu,List<Integer> myList, List<Integer> tmp, int r){
        if(tmp.size()==r){
            permu.add(new ArrayList<>(tmp));
            count++;
            return;
        }
        for(int i=0;i<myList.size();i++){
            if(!vist[i]){
                vist[i] = true;
                tmp.add(myList.get(i));
                permuation(permu,myList,tmp,r);
                vist[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public static int sumList(List<Integer> tmp){
        int sum =0;
        for(int now:tmp){
            sum+=now;
        }
        return sum;
    }
    public static void combisDetail(int s,int r,List<Integer> myList,List<Integer> tmp,List<List<Integer>> combi){
//        if(n>size){
//            return;
//        }
        if(tmp.size()==r) {
            combi.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=s;i<myList.size();i++){
            tmp.add(myList.get(i));
            combisDetail(i+1,r,myList,tmp,combi);
            //combisDetail(s+=1,r,myList,tmp,combi);
            tmp.remove(tmp.size()-1);
        }
    }
    public static int combi(int n,int r){
        if(n==1){
            return 1;
        }
        if(r==1){
            return n;
        }
        if(r==n){
            return 1;
        }
        return combi(n,r-1)+combi(n-1,r-1);

    }
}
