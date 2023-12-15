package C12_ClassLecture;


public class C1204_Constructor {
    public static void main(String[] args) {
        Calender cal1 = new Calender("2023", "12", "15");
        Calender cal2 = new Calender("2023", "12");
        Calender cal3 = new Calender("2023");
        Calender cal4 = new Calender();
    }

    static class Calender{
        private String year;
        private String month;
        private String day;

        Calender(String year, String month, String day){
            this.year = year;
            this.month = month;
            this.day = day;
            System.out.println("성");
            System.out.println( this.year);
            System.out.println( this.month);
            System.out.println( this.day);
        }

        // 메서드 오버로딩을 통해 같은 이름의 생성자 생성가능
        Calender(String year, String month){
            this.year = year;
            this.month = month;
        }

        Calender(String year){
            // this 키워드를 통해 클래스내 매개변수에 맞는 생성자 호출 가능
            this(year,null, null);
        }

        Calender(){

        }
    }
}


