package C12_ClassLecture;

import java.util.*;

public class AuthorPostService {
    public static void main(String[] args) {
        List<Author> authors = new ArrayList<>();
        List<Post> posts = new ArrayList<>();

        top_loop:
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("사용하실 서비스는 무엇인가요?");
            System.out.println("1. 회원가입");
            System.out.println("2. 게시글 작성");
            System.out.println("3. 회원 목록 조회");
            System.out.println("4. 회원 상세 조회");
            System.out.println("5. 게시글 상세 조회");
            System.out.println("6. 종료");
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
                    System.out.println(name);
                    System.out.println(email);
                    System.out.println(password);
                    Author auth = new Author(name, email, password);
                    authors.add(auth);
                    System.out.println("회원가입에 성공했습니다.");
                    System.out.println("현재 아이디로 자동 로그인 됩니다.");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("회원가입 서비스 입니다.");
                    System.out.println();
                    sc.nextLine();
                    System.out.println("Email을 입력하세요.");
                    String em = sc.nextLine();
                    Author auth_1 = null;
                    for(Author auth_0 :authors){
                        if(auth_0.getEmail().equals(em)){
                            auth_1 = auth_0;
                        }
                    }
                    if(auth_1 != null){
                        System.out.println("제목을 입력하세요.");
                        String title = sc.nextLine();
                        System.out.println("내용을 입력하세요.");
                        String contents = sc.nextLine();
                        Post pos = new Post(title, contents, auth_1);
                        posts.add(pos);
//                        System.out.println(auth_1.getId());
//                        auth_1.PostListAdd(pos);
//                        System.out.println("게시글이 작성 되었습니다.");
                        System.out.println();
                    }else {
                        System.out.println("해당 이메일을 가진 아이디가 없습니다.");
                    }

                    break;
                case 3:
                    System.out.println("회원 목록 조회 서비스 입니다.");
                    for(Author user :authors){
                        System.out.println(user);
                        System.out.println(user.getEmail());
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("회원 상세 조회 서비스 입니다.");
                    System.out.println();
                    System.out.println("회원 Email 을 입력해 주세요.");
                    sc.nextLine();
                    String in_email = sc.nextLine();
                    for(Author user : authors){
                        if(user.getEmail().equals(in_email)){
                            System.out.println("회원명 : "+ user.getName());
                            System.out.println("회원 Email : "+ user.getEmail());
                            System.out.println("회원작성 게시글 수 : " + user.getPostList().size());

                        }else{
                            System.out.println("해당 id를 가진 회원이 존재하지 않습니다.");
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("게시글 상세 조회 서비스 입니다.");
                    System.out.println();
                    System.out.println("게시글 id를 입력해 주세요.");
                    int p_num = sc.nextInt();
                    for(Post post_0 :posts){
                        if(post_0.getId() == p_num){
                            System.out.println("제목 : "+ post_0.getTitle());
                            System.out.println("작성자 Email : "+ post_0.getAuthor().getEmail());
                        }else{
                            System.out.println("해당 id를 가진 게시글이 존재하지 않습니다.");
                        }
                    }
                    break;
                case 6:
                    System.out.println("서비스를 종료합니다.");
                    break top_loop;
            }
        }

    }
}
class Author{
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Post> postList;
    private static Long static_count = 0L;

    public List<Post> getPostList() {
        return postList;
    }

    public void PostListAdd(Post list){
        postList.add(list);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }


    Author(
            String name,
            String email,
            String password
    ){
        static_count++;
        this.id = static_count;
        this.name = name;
        this.email = email;
        this.password = password;
        this.postList = new ArrayList<>();
    }



}

class Post{
    private Long id;
    private String title;
    private String contents;
    private Author author;
    private static Long static_count = 0L;
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Author getAuthor() {
        return author;
    }

    Post(
            String title,
            String contents,
            Author author
            ){
        static_count++;
        this.id = static_count;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.author.PostListAdd(this);
    }
}