package C16EtcClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
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

        // 암의로 특정 시간을 만들어 내고 싶을 때 : of 메서드 사용
        LocalDate brithDay = LocalDate.of(1996,9,4);
        // 일반 내장 메서드를 사용
        System.out.println(brithDay.getYear());
        System.out.println(brithDay.getMonth());
        System.out.println(brithDay.getDayOfMonth());
        // of는 메서드오버로딩이 되어서 sec 생략가능
        LocalTime brithTime = LocalTime.of(18,02,19);
        LocalDateTime brithDaytime= LocalDateTime.of(brithDay,brithTime);

        // 크로노필드 enum타입 사용 : 매개변수로 크로노필드를 받아 프로그램의 유연성 향상
        System.out.println(brithDaytime.get(ChronoField.YEAR));
        System.out.println(brithDaytime.get(ChronoField.MONTH_OF_YEAR));
        // 0 : am , 1 :pm
        System.out.println(brithDaytime.get(ChronoField.AMPM_OF_DAY));
        LocalTime nowTime = LocalTime.now();
        if(nowTime.get(ChronoField.AMPM_OF_DAY)==0){
            System.out.println("현재는 오전 입니다 졸리군요");
        }else{
            System.out.println("현재는 오후 입니다 집에 갑시다");
        }
    }
}
