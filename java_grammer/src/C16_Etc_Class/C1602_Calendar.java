package C16_Etc_Class;

import java.util.Calendar;
import java.time.*;

public class C1602_Calendar {
    public static void main(String[] args) {
        // 날짜 관련 클래스 종류
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());

        // 특정한 숫값은 get 함수의 input 값으로 주어 원하는 날짜 정보를 출력할 수 있게 해준다.
        System.out.println(cal.get(1));
        System.out.println(cal.get(2)+1);
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH)+1);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
        System.out.println(cal.get(Calendar.HOUR));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
        System.out.println(cal.get(Calendar.MILLISECOND));

        // java.time 패키지 : Local~ 클래스
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getDayOfWeek());

    }
}
