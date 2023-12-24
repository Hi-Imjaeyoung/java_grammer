package C16EtcClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

public class C1602Calendar {
    public static void main(String[] args) {
        // 날짜 관련 클래스 종류 1. Calender(java.util) 2.java.time에 있는 Local-클래스
        Calendar time = Calendar.getInstance();
        System.out.println(time.getTime());

        // 특정한 숫자 값을 get 함수의 input값으로 주어 원하는 날짜 정보를 출력할 수 있게 해준다.
        System.out.println(time.get(Calendar.YEAR)); // year
        System.out.println(time.get(Calendar.MONTH)+1); // month-1
        System.out.println(time.get(Calendar.DAY_OF_WEEK));
        System.out.println(time.get(Calendar.DAY_OF_MONTH));
        System.out.println(time.get(Calendar.HOUR_OF_DAY)); // 24시
        System.out.println(time.get(Calendar.MINUTE));
        System.out.println(time.get(Calendar.SECOND));

        //java.time 패키지 Local~클래스
        LocalTime presentTime = LocalTime.now();
        System.out.println(presentTime);
        // int로 제공
        System.out.println(presentTime.getMinute());
        System.out.println(presentTime.getHour());

        LocalDate presentDate = LocalDate.now();
        System.out.println(presentDate);

        LocalDateTime presentLocalDateTime = LocalDateTime.now();
        System.out.println(presentLocalDateTime);
    }
}
