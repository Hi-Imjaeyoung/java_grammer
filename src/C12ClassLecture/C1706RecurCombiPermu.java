package C12ClassLecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class C1706RecurCombiPermu {
    static int[][] combis;
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>(Arrays.asList(1,2,3,4));

//        myList의 조합을 만들어라
        List<List<Integer>> combi = new ArrayList<>();
        for(int i=0;i<myList.size()-1;i++){
            for(int j=i+1;j<myList.size();j++){
                combi.add(new ArrayList<>(Arrays.asList(myList.get(i),myList.get(j))));
            }
        }
//        System.out.println(combi);

//        규칙 찾기
        List<Integer> tmp = new ArrayList<>();
        for(int i=0;i<myList.size()-1;i++){
            tmp.add(myList.get(i));
            for(int j=i+1;j<myList.size();j++){
                tmp.add(myList.get(j));
                combi.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size()-1);
            }
            tmp.remove(tmp.size()-1);
        }

//        재귀로 해보기
        combi = new ArrayList<>();
        tmp = new ArrayList<>();
        combisDetail(0,2,myList,tmp,combi);
        System.out.println(combi);


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(combi(4,2));
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
