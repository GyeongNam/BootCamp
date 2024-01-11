package Spring;

import java.sql.*;

public class DatabaseConnect {
    public static void main(String[] args)  {
        String url = "jdbc:mysql://localhost:3306/board1";
        String userName = "root";
        String pw = "1234";

        try {
            Connection conn = DriverManager.getConnection(url, userName, pw);
            System.out.println("DB 커넥션 성공");

            // 쿼리를 담아 db에 보낼 수 있는 객체
            Statement st = conn.createStatement();
            String Query = "select * from author";
            ResultSet rs =  st.executeQuery(Query);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id : "+ id);
                System.out.println("name : "+ name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
