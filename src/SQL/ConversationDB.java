package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConversationDB {
	
	int NumberMesseges;

    private Connection connect(int ID1, int ID2) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Aquí no se que poner (dirección para conectarse a la base de datos)
        Connection conn = null;
        try {
        	
        	//se guarda el numero de mensajes que tiene la conversacion al mismo tiempo que 
        	//se conecta a la base de datos
        	String sql = "SELECT MAX(NUMBERMESSEGES) FROM CONVERSATION WHERE "
        			   + "((ID1 = ? AND ID2 = ?)OR(ID1 = ? AND ID2 = ?))";
        	
            conn = DriverManager.getConnection(url);
            
            PreparedStatement pstmt = conn.prepareStatement(sql); {
            
                pstmt.setInt(1, ID1);
                pstmt.setInt(2, ID2);
                NumberMesseges = pstmt.executeUpdate(); 
            }
            
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    //se manda un mensaje y se añade
    public void insertConver(int ID1, int ID2, String MESSAGE) {
        String sql = "INSERT INTO CONVERSATION(ID1,ID2,MESSAGE,MOMENT,NUMBERMESSEGES) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect(ID1,ID2);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ID1);
            pstmt.setInt(2, ID2);
            pstmt.setString(3, MESSAGE);
            
            //conversor de la fecha a un formato sql
            java.util.Date date =new java.util.Date();
            java.sql.Date sqlDate=new java.sql.Date(date.getTime());
            pstmt.setDate(4, sqlDate);
            
            NumberMesseges++;//aumenta el contador de mensajes
            pstmt.setInt(5, NumberMesseges);
            pstmt.executeUpdate();
          
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<String> takeConver(int ID1, int ID2) {
    	
    	ArrayList<String> allMessages = new ArrayList<String>();//array de guardado de datos
    	
    	ResultSet resultSet = null;//variable de recogida de datos
    	
        String sql = "SELECT MESSAGE,DATA,ID1 FROM CONVERSATION WHERE "
        		   + "((ID1 = ? AND ID2 = ?)OR(ID1 = ? AND ID2 = ?))";
        


        try (Connection conn = this.connect(ID1,ID2);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	
            pstmt.setInt(1, ID1);
            pstmt.setInt(2, ID2);
            pstmt.setInt(3, ID2);
            pstmt.setInt(4, ID1);
            
            resultSet = pstmt.executeQuery();
            		
            while(resultSet.next()) {
            	
            	//Se va creando un arraylist con todos los mensajes con el formato:
            	// USER: <ID del remitente> [ <Mensaje enviado> ] DATE: <Fecha del envio>
            	
            	allMessages.add("USER: " + resultSet.getString(2) + " ["  + resultSet.getString(1) + 
            					" ] DATE: "+ 	resultSet.getDate(3));
            	
            	
            }
            
          
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
        return allMessages;
    }
	
}
