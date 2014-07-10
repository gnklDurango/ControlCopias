
package modelo;


public class Afiliado {
    
    private String Folio;
    private String nombre;
    private String f_inicio;
    private String f_fin;
    private String f_nacimiento;
    private int edad;

    public Afiliado() {
        this.Folio="";
        this.nombre="";
        this.f_inicio="";
        this.f_fin="";
        this.f_nacimiento="";
        this.edad=0;
    }

    public Afiliado(String Folio, String nombre, String f_inicio, String f_fin, String f_nacimiento, int edad) {
        this.Folio = Folio;
        this.nombre = nombre;
        this.f_inicio = f_inicio;
        this.f_fin = f_fin;
        this.f_nacimiento = f_nacimiento;
        this.edad = edad;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String Folio) {
        this.Folio = Folio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getF_inicio() {
        return f_inicio;
    }

    public void setF_inicio(String f_inicio) {
        this.f_inicio = f_inicio;
    }

    public String getF_fin() {
        return f_fin;
    }

    public void setF_fin(String f_fin) {
        this.f_fin = f_fin;
    }

    public String getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(String f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
    
}
