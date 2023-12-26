package C17_Exception_File_Parsing.Author_Exception;

import java.util.*;

public class AuthorController {
    public static void main(String[] args) {
        // 메모리 DB에 데이터 추가/삭제 부분은 repository 로 분리
        AuthorService authorService = new AuthorService();
        top_loop:
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("사용하실 서비스는 무엇인가요?");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            int service = sc.nextInt();

            switch (service){
                case 1:
                    System.out.println("회원가입 서비스 입니다.");
                    System.out.println();
                    sc.nextLine();
                    System.out.println("이름을 입력하세요.");
                    String name = sc.nextLine();
                    System.out.println("이메일을 입력하세요.");
                    String email = sc.nextLine();
                    System.out.println("비밀번호를 입력하세요.");
                    String password = sc.nextLine();
                    Author auth = new Author(name, email, password);
                    try {
                        authorService.register(auth);
                        System.out.println("회원가입에 성공했습니다.");
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("로그인 서비스 입니다.");
                    System.out.println();
                    sc.nextLine();
                    System.out.println("로그인 하실 Email을 입력하세요.");
                    String login_email = sc.nextLine();
                    System.out.println("로그인 하실 password를 입력하세요.");
                    String login_pwd = sc.nextLine();
                    Optional<Author> login_Author = Optional.empty();
                    try {
                        login_Author = authorService.login(login_email,login_pwd);
                        System.out.println( login_Author.get().getName()+"님 로그인 되었습니다.");
                    } catch (IllegalArgumentException | NoSuchElementException e) {
                        System.out.println("로그인 실패");
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

    }
}
