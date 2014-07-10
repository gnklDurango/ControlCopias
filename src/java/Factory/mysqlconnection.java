
package Factory;

import java.sql.Connection;
import java.sql.DriverManager;


public final class mysqlconnection extends ConnectionDB{

    //recibir parametros de conexion
    public mysqlconnection(String[] params) {
        this.params = params;
        this.open();
    }

    
    
    @Override
   public  Connection open() {
       try{
           
           Class.forName("com.mysql.jdbc.Driver");
           this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/"+this.params[0], this.params[1], this.params[2]);
       }
       catch(Exception e){
           e.printStackTrace();
       }
    return this.connection;
    
    }
    
    
    
    
    
    
    
}
