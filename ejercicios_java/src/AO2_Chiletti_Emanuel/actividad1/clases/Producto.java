package AO2_Chiletti_Emanuel.actividad1.clases;

public class Producto {
    private String nombre;
    private double precioBase;
    private String código;
    
    public Producto(String nombre, double precioBase, String código) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.código = código;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getCódigo() {
        return código;
    }

    public void setCódigo(String código) {
        this.código = código;
    }

    public double calcularPrecioFinal() {
        return precioBase;
    }



    


}
