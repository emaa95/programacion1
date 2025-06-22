package AO2_Chiletti_Emanuel.actividad1.clases;
import java.util.Date;

public class ProductoAlimenticio extends Producto{
    private Date fechaVencimiento;

    public ProductoAlimenticio(String nombre, double precioBase, String código, Date fechaVencimiento) {
        super(nombre, precioBase, código);
        this.fechaVencimiento = fechaVencimiento;
    }


    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    
    public double calcularPrecioFinal() {
        return getPrecioBase();
    }


    
}
