package C12ClassLecture;

import java.time.*;
import java.util.StringTokenizer;
// 요구사항 내부클래스 calender
// 변수 year month day -> String
// 생성자 1. year month day
// 생성자 2. year,month
// 생성자 3. 초기화 없음


public class C1204ClassConsturctor {
    public static void main(String[] args) {
        System.out.println(Calender.nowTime());
        Calender calender1 = new Calender();
        Calender calender2 = new Calender("1592","1","1");
        Calender calender3 = new Calender("2002","4");

    }
}
class Calender{
    LocalDate localdate;
    private String year, month, day;
    Calender(){
    }
    Calender(String year,String month,String day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    // 메서드 오버로딩을 통해 같은 이름의 생성자 생성가능
//    Calender(String year,String month){
//        this.year = year;
//        this.month = month;
//    }
    Calender(String year,String month){
        this(year,month,null);
    }
    Calender(String year){
        // 키워드를 통해 클래스 내 매개변수에 맞는 생성자 호출가능.
        this(year,null,null);
    }
    public static LocalDate nowTime(){
        return LocalDate.now();
    }
    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }
}
