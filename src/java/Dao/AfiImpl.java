package Dao;

import Factory.ConectionFinal;
import Factory.ConnectionDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Afiliado;

public class AfiImpl implements AfiDao {

    ConnectionDB conn;

    public AfiImpl() {
    }

    @Override
    public List<Afiliado> n_afi(String Folio) {
        this.conn = ConectionFinal.open(ConectionFinal.MYSQL);
        String q = "SELECT folio,nombre,f_inicio,f_fin,fecha_naci,edad FROM seguro_p2 WHERE folio='" + Folio + "'";
        List<Afiliado> l_a = new ArrayList<Afiliado>();
        try {
            ResultSet rs = this.conn.query(q);
            while (rs.next()) {

                Afiliado afi = new Afiliado();
                afi.setFolio(rs.getString("folio"));
                afi.setEdad(rs.getInt("edad"));
                afi.setF_fin(rs.getString("f_fin"));
                afi.setF_inicio(rs.getString("f_inicio"));
                afi.setF_nacimiento(rs.getString("fecha_naci"));
                afi.setNombre(rs.getString("nombre"));
                l_a.add(afi);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
          this.conn.close();
        
        }

        return l_a;
    }

    @Override
    public List<Afiliado> t_afi(String Folio, String nombre) {
        this.conn = ConectionFinal.open(ConectionFinal.MYSQL);
        
        String t_a="SELECT folio,nombre,f_inicio,f_fin,fecha_naci,edad FROM seguro_p2 WHERE folio='" + Folio + "' AND nombre='"+nombre+"' ";
           List<Afiliado> ta = new ArrayList<Afiliado>();
        try {
            ResultSet rs = this.conn.query(t_a);
            while (rs.next()) {

                Afiliado afi = new Afiliado();
                afi.setFolio(rs.getString("folio"));
                afi.setEdad(rs.getInt("edad"));
                afi.setF_fin(rs.getString("f_fin"));
                afi.setF_inicio(rs.getString("f_inicio"));
                afi.setF_nacimiento(rs.getString("fecha_naci"));
                afi.setNombre(rs.getString("nombre"));
                ta.add(afi);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
          this.conn.close();
        
        }
        
        
        
        return ta;
    }

}
