
package Dao;

import Factory.ConectionFinal;
import Factory.ConnectionDB;
import java.util.List;
import modelo.NewAfiliado;


public class AddAfiImpl implements AddAfiDao{

    ConnectionDB conn;
   
    public AddAfiImpl() {
    }

    
    
    
    @Override
    public boolean afiliado(NewAfiliado afil) {
        boolean guardar= false;
        this.conn = ConectionFinal.open(ConectionFinal.MYSQL);
        try{
        String nom1 = afil.getNombre()+" "+afil.getA_p()+" "+afil.getA_m();
        String afi="INSERT INTO seguro_p2 VALUES('"+afil.getFolio()+"','"+afil.getA_p()+"','"+afil.getA_m()+"','"+afil.getNombre()+"','"+nom1+"','-','-','-','"+afil.getF_inicio()+"','"+afil.getF_fin()+"','"+afil.getPrograma()+"','"+afil.getEdad()+"','"+afil.getF_naci()+"','-',0,'"+afil.getSexo()+"') ";           
            
        this.conn.execute(afi);
        
        guardar = true;
        }catch(Exception e){
        e.printStackTrace();
        }finally{
        this.conn.close();
        }
    return guardar;    
    }

    @Override
    public boolean actualizar(NewAfiliado afi) {
       boolean renovar= false;
        this.conn = ConectionFinal.open(ConectionFinal.MYSQL);
        try{
        String reno ="UPDATE seguro_p2 SET f_fin='"+afi.getF_fin()+"',edad='"+afi.getEdad()+"' WHERE folio='"+afi.getFolio()+"' AND nombre='"+afi.getNombre()+"' ";
         this.conn.execute(reno);
        renovar = true;
        }catch(Exception e){
        e.printStackTrace();
        }finally{
        this.conn.close();
        }
    return renovar;   
    }
    
}
