package Dao;

import java.util.List;
import modelo.clave;
public interface claveDao {
    
    public List<clave> con_cm (String clave);
    public List<clave> des(String des);
    public List<clave> con_dm (String descrip);
    
}
