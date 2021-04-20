package sql;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import main.launcher.CommandExecuteException;


import java.time.ZoneId;
import java.time.ZonedDateTime;


import javax.imageio.ImageIO;

import sql.Imagen;


public class SQL{
	

    public void insert(Connection conn, String NICKNAME, int PSSWORD) throws ClassNotFoundException, SQLException {
      

        Statement stmt = conn.createStatement();
        stmt.executeQuery("INSERT INTO users (NICKNAME,PSSWORD) Values ('" + NICKNAME + "','" + PSSWORD +"')");
        
        System.out.println("Insertadas dos personas\n");
        conn.commit();
    }
    
    public void uso(String user, int ps) {
    	 try {
    	        
             Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "petio01bg", "Anakin040601");

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
    
    public boolean guardarImagen(String ruta,String nombre, Connection conn) throws CommandExecuteException{
        
        ZonedDateTime date = ZonedDateTime.now(ZoneId.of( "Europe/Madrid" ));
    	
    	 String insert = "INSERT INTO Images(IMAGE,MOMENT,NICKNAMES) values("+ ruta + "," + date + "," + nombre +")";
    	 FileInputStream fis = null;
    	 PreparedStatement ps = null;
    	 try {
    	   conn.setAutoCommit(false);
    	   File file = new File(ruta);
    	   fis = new FileInputStream(file);
    	   ps = conn.prepareStatement(insert);
    	   ps.setBinaryStream(1,fis,(int)file.length());
    	   ps.setString(2, nombre);
    	   ps.executeUpdate();
    	   conn.commit();
    	   return true;
    	   
    	 } catch (Exception ex) {
    	   throw new CommandExecuteException("Fallo tecnico");
    	 }finally{
    	  try {
    	   ps.close();
    	   fis.close();
    	 } catch (Exception ex) {
    		 throw new CommandExecuteException("Fallo tecnico");
    	  }
    	 }
    	}
    
    ArrayList<Imagen> getImagenes(Connection conn, String Nombre, String Imagen) throws SQLException, CommandExecuteException {
    	Statement st = conn.createStatement();
    	ArrayList<Imagen> lista = new ArrayList<sql.Imagen>();
    	try {
    		ResultSet rs = st.executeQuery("SELECT" + Imagen + "," + Nombre + " FROM Images"); 
    		while (rs.next())
    		{
    			Imagen imagen=new Imagen();
    			Blob blob = rs.getBlob(Imagen);
    			String nombre = rs.getObject(Nombre).toString();
    			byte[] data = blob.getBytes(1, (int)blob.length());
    			BufferedImage img = null;
    			try {
    				img = ImageIO.read(new ByteArrayInputStream(data));
    			} catch (IOException ex) {
    				throw new CommandExecuteException("Fallo tecnico");
    			}
    			
    			imagen.setImagenB(img);
    			imagen.setNombre(nombre);
    			lista.add(imagen);
    		}
    		rs.close();
    	} catch (SQLException ex) {
    		throw new CommandExecuteException("Fallo tecnico");
    	}
    	return lista;
    }

    
    
    

    

}
