
package Dao;

import java.util.List;
import modelo.Afiliado;


public interface AfiDao {
    
    public List<Afiliado> n_afi(String Folio);
    public List<Afiliado> t_afi(String Folio, String nombre);
    
    
}
