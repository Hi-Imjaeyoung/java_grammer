package Spring;

import java.sql.*;

public class DatabaseConnect {
    public static void main(String[] args) {
        // db의 url : localhost:3306
        String url ="jdbc:mysql://localhost:3306/board1?useSSL=false";
        String userName = "root";
        String pw = "1234";

        try {
            // DriverManager java 내장 함수
            // 각 DB에 맞는 커넥터 외부 라이브러리가 필요.
            // 외부로 부터 요청이니 예외처리 필수
            Connection conn = DriverManager.getConnection(url,userName,pw);
            System.out.println("db 연결 성공!");
            // statement는 커리를 담아 db에 보낼 수 있는 객체
            Statement st = conn.createStatement();
            String myQuery ="select * from author";
            ResultSet rs = st.executeQuery(myQuery);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id : " + id + " name : "+ name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
