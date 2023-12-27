package C18_Thread;

/*
Thread 클래스에 이미 구현되어 있는 run 메서드는 아무작업도 하지 않는 빈 메서드
작업하고 싶은 내용은 run() 메서드를 overriding 하여 정의할 수 있다.
상송관계이다 보니, 다른 클래스 상속 불가
 */
public class ExtendsThreadClass extends Thread{
    // run 메서드는 쓰레드가 시작되면 실행
    @Override
    public void run(){
        System.out.println("ExtendsThreadClass : " + Thread.currentThread().getName());
    }
}
