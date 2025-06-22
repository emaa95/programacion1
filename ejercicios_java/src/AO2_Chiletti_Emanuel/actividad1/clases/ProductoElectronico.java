package AO2_Chiletti_Emanuel.actividad1.clases;

public class ProductoElectronico extends Producto{
    private int garantiaMeses;

    public ProductoElectronico(String nombre, double precioBase, String código, int garantiaMeses) {
        super(nombre, precioBase, código);
        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    public double calcularPrecioFinal(){
        return getPrecioBase() * 1.10;
    }

    
   

    
}
