package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDB {
	
	private int _nextID = 0;
	
	
    private Connection connect() {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Aquí no se que poner (dirección para conectarse a la base de datos)
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String NICKNAME, int PSSWORD) {
        String sql = "INSERT INTO USERS(NICKNAME,PSSWORD,_nextID) VALUES(?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, NICKNAME);
            pstmt.setInt(2, PSSWORD);
            pstmt.executeUpdate();
            _nextID++;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //elimina una fila
    public void delate(int DELETEID) {
        String sql = "DELETE FROM USERS WHERE (ID = ?)";

        try (Connection conn = this.connect();
        		
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, DELETEID);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        InsertDB app = new InsertDB();
        // insert three new rows
        app.insert("Pepe", 1357);
        app.insert("Manolo", 2468);
        app.insert("Paca", 9876);
    }
}
