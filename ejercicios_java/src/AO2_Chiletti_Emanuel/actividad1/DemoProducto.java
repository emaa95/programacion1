package AO2_Chiletti_Emanuel.actividad1;

import AO2_Chiletti_Emanuel.actividad1.clases.Producto;
import AO2_Chiletti_Emanuel.actividad1.clases.ProductoAlimenticio;
import AO2_Chiletti_Emanuel.actividad1.clases.ProductoElectronico;

public class DemoProducto {
    public static void main(String[] args) {
        ProductoAlimenticio productoAlimenticio = new ProductoAlimenticio("Arroz", 1500, "A100", 12/12/2023);

        ProductoElectronico productoElectronico = new ProductoElectronico("Televisor", 10000, "E200", 24);
    
        productoAlimenticio.calcularPrecioFinal();

        productoElectronico.calcularPrecioFinal();
    }

}
