package modelo;


public class clave {
    private String clave;
    private String descripcion;
    private int cantidad;

    public clave() {
    }

    public clave(String clave, String descripcion, int cantidad) {
        this.clave = clave;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
