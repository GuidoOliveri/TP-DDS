package disenio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion         
//EXECUTEUPDATE PARA ACTUALIZAR ALGO EN LA BASE
//EXECUTREQUERY PARA OBTENER ALGO DE LA BASE
{
   public void query(String db_connect_string,String queryString)
   {
      try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection conn = DriverManager.getConnection(db_connect_string);
         System.out.println("Se ha establecido la conexión con la base de datos\n");

         Statement statement = conn.createStatement();

         ResultSet rs;

         rs = statement.executeQuery(queryString);
         
	     /*             while (rs.next()) 
         {
            System.out.println(rs.getString(1)+"      "+rs.getString(2)+"        "+rs.getString(3).substring(0, 40)+""+rs.getString(4).substring(0, 30)+""+rs.getString(5).substring(0, 30)+""+rs.getString(6)+"    "+rs.getString(7));

         }
*/  
         
         statement.executeQuery(queryString);

         System.out.println("\n");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public void update(String db_connect_string,String queryString)
   {
      try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection conn = DriverManager.getConnection(db_connect_string);
         System.out.println("Se ha establecido la conexión con la base de datos\n");

         Statement statement = conn.createStatement();

         statement.executeUpdate(queryString);

         System.out.println("\n");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
}