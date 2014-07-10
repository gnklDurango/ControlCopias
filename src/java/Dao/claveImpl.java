package Dao;

import Factory.ConectionFinal;
import Factory.ConnectionDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.clave;

public class claveImpl implements claveDao {

    ConnectionDB conn;

    public claveImpl() {
    }

    @Override
    public List<clave> con_cm(String clave) {
        this.conn = ConectionFinal.open(ConectionFinal.MYSQL);
        String consu = "SELECT clave,descrip,SUM(cajas) FROM inventario_uni WHERE clave='" + clave + "' GROUP BY clave  ";
        List<clave> cv = new ArrayList<clave>();
        try {
            ResultSet rs = this.conn.query(consu);
            while (rs.next()) {

                clave c_m = new clave();
                c_m.setClave(rs.getString("clave"));
                c_m.setCantidad(rs.getInt("SUM(cajas)"));
                c_m.setDescripcion(rs.getString("descrip"));
                cv.add(c_m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.conn.close();

        }

        return cv;

    }

    @Override
    public List<clave> des(String des) {
        this.conn = ConectionFinal.open(ConectionFinal.MYSQL);
        String consu = "SELECT descrip FROM inventario_uni WHERE descrip like '" + des + "%' GROUP BY descrip limit 20  ";
        List<clave> cv = new ArrayList<clave>();
        try {
            ResultSet rs = this.conn.query(consu);
            while (rs.next()) {

                clave c_m = new clave();
                c_m.setDescripcion(rs.getString("descrip"));
                cv.add(c_m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.conn.close();

        }

        return cv;
    }

    @Override
    public List<clave> con_dm(String descrip) {
        this.conn = ConectionFinal.open(ConectionFinal.MYSQL);
        String consu = "SELECT clave,descrip,SUM(cajas) FROM inventario_uni WHERE descrip='" + descrip + "' GROUP BY clave  ";
        List<clave> cv = new ArrayList<clave>();
        try {
            ResultSet rs = this.conn.query(consu);
            while (rs.next()) {

                clave c_m = new clave();
                c_m.setClave(rs.getString("clave"));
                c_m.setCantidad(rs.getInt("SUM(cajas)"));
                c_m.setDescripcion(rs.getString("descrip"));
                cv.add(c_m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.conn.close();

        }

        return cv;
    }

}
