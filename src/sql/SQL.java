package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQL {
	
	private Connection connect() {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Aquí no se que poner.
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String NICKNAME, int PSSWORD) {
        String sql = "INSERT INTO USERS(NICKNAME,PSSWORD) VALUES(?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, NICKNAME);
            pstmt.setInt(2, PSSWORD);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    

}
