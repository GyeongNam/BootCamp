package C16_Etc_Class;

import java.time.temporal.ChronoField;
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

        // 임의로 특정 시간을 만들어 내고 싶을 때, of 메서드 사용
        LocalDate birthDay = LocalDate.of(1980 ,2, 19);
        System.out.println(birthDay.getYear());
        System.out.println(birthDay.getMonth());
        System.out.println(birthDay.getDayOfMonth());
        LocalTime birthTime = LocalTime.of(2,2,19);

        LocalDateTime birthDayTime = LocalDateTime.of(birthDay,birthTime);
        System.out.println(birthDayTime);

        // 크로노필드 enum 타입 사용 : 매개벼ㅑㄴ수로 크로노필드를 받아 프호그램의 유연성 향상
        System.out.println(birthDayTime.get(ChronoField.YEAR));
        System.out.println(birthDayTime.get(ChronoField.MONTH_OF_YEAR));
        // 0 : 오전, 1 : 오후
        System.out.println(birthDayTime.get(ChronoField.AMPM_OF_DAY));

        LocalTime newTime = LocalTime.now();
        // 현재시간은 오전/오후 입니다.
        System.out.println("현재 시간은 " + (newTime.get(ChronoField.AMPM_OF_DAY) == 1 ? " 오후 " : "오전")+ " 입니다.");

    }

}
