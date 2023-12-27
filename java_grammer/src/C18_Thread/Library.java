package C18_Thread;

public class Library {
    static int bookCount = 100;
//    public  static  void barrowBook(){
//        if(bookCount>0){
//            try{
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//            // 책 빌리는 시간
//            bookCount -= 1;
//            System.out.println("대출 완료");
//            System.out.println("남아있는 수량: " +bookCount);
//        }else{
//            System.out.println("대출 불가");
//        }
//    }

    // synchronized 키워드를 통해 해당 메서드 한해서는 lock걸도록 설정

    public synchronized static void barrowBook(){
        if(bookCount>0){
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 책 빌리는 시간
            bookCount -= 1;
            System.out.println("대출 완료");
            System.out.println("남아있는 수량: " +bookCount);
        }else{
            System.out.println("대출 불가");
        }
    }
}
