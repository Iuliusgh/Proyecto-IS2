package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQL{
	

    public void insert(Connection conn, String NICKNAME, int PSSWORD) throws ClassNotFoundException, SQLException {
      

        Statement stmt = conn.createStatement();
        stmt.executeQuery("INSERT INTO users (NICKNAME,PSSWORD) Values ('" + NICKNAME + "','" + PSSWORD +"')");
        
        System.out.println("Insertadas dos personas\n");
        conn.commit();
    }
    
    public void uso(String user, int ps) {
    	 try {
    	        
             Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "petio01bg", "**");

             if (conn != null) {
                 conn.setAutoCommit(false); // Desactivamos el autoCommit
                 
                 insert(conn,user,ps);
                 todasPersonas(conn);
             
                 conn.close();  
             } else {
                 System.out.println("Failed to make connection!");
             }

         } catch (SQLException e) {
             System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
    
    public static void todasPersonas(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT NICKNAME, PSSWORD FROM users");
        System.out.println("Listado de personas");
        int cont = 1;
        while(rs.next()) {
            System.out.println(cont + ") " + rs.getString("NICKNAME") + "\t" + rs.getString("PSSWORD"));
            cont++;
        }
        System.out.println();
    }

    

}

    

}
