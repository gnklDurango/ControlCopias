
package Factory;


public class ConectionFinal {
    
    public static final int MYSQL = 1;
     public static String [] configMYSQL ={"r_durango", "root", "eve9397"};

    
    
    public static ConnectionDB open(int typeDb){
       switch(typeDb){
           case ConectionFinal.MYSQL:
               return new mysqlconnection(configMYSQL);
             
           default:
              return null;    
        }     
        }    
        }