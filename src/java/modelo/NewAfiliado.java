package modelo;

public class NewAfiliado {
    
    private String folio;
    private String nombre;
    private String a_m;
    private String a_p;
    private String f_inicio;
    private String f_fin;
    private String programa;
    private int edad;
    private String f_naci;
    private String sexo;

    public NewAfiliado() {
        this.a_m="";
        this.a_p="";
        this.nombre="";
        this.edad=0;
        this.f_fin="";
        this.f_inicio="";
        this.f_naci="";
        this.sexo="";
        
    }

    public NewAfiliado(String folio, String nombre, String a_m, String a_p, String f_inicio, String f_fin, String programa, int edad, String f_naci, String sexo) {
        this.folio = folio;
        this.nombre = nombre;
        this.a_m = a_m;
        this.a_p = a_p;
        this.f_inicio = f_inicio;
        this.f_fin = f_fin;
        this.programa = programa;
        this.edad = edad;
        this.f_naci = f_naci;
        this.sexo= sexo;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getA_m() {
        return a_m;
    }

    public void setA_m(String a_m) {
        this.a_m = a_m;
    }

    public String getA_p() {
        return a_p;
    }

    public void setA_p(String a_p) {
        this.a_p = a_p;
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

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getF_naci() {
        return f_naci;
    }

    public void setF_naci(String f_naci) {
        this.f_naci = f_naci;
    }
    
    
}
