package actIntegr5;

import javax.swing.JOptionPane;

import actIntegr4.inputOutputJOP.Ingreso;
import actIntegr4.inputOutputJOP.Salida;

/*
 * Una empresa comercializa hasta 100 productos, cada uno de los cuales

       tiene  las siguientes características:

                                                   código : ENTERO

                                                  nombre : CADENA DE CARACTERES

                                                  precio : NUMERO REAL

        Desarrolle un programa con los métodos  necesarios; para  que admita las

       siguientes opciones:

                  1. Ingreso de datos en 3 arreglos unidimensionales de hasta 100 productos.

                 2. Ordenamiento de los productos por sus códigos.

                 3. Búsqueda lineal de un producto por su código.

                 4. Búsqueda binaria de un producto por su código.

                 5. Producto con mayor precio ;

                 0. Salida del programa.
*/
public class actividad2 {

    public static final int MAX_PRODUCTOS = 100;
    public static int[] codigos = new int[MAX_PRODUCTOS];
    public static String[] nombres = new String[MAX_PRODUCTOS];
    public static double[] precios = new double[MAX_PRODUCTOS];
    public static int cantidadProductos = 0;
    public static void main(String[] args) {
       int opcion;

       String[] opciones = {
        "Salir", "Ingresar productos", "Ordenar por código",
        "Buscar código (lineal)", "Buscar código (binaria)",
        "Producto con mayor precio"
       };

       StringBuilder mensaje = new StringBuilder("Seleccione una opción:\n");
        for (int i = 0; i < opciones.length; i++) {
            mensaje.append(i).append(" - ").append(opciones[i]).append("\n");
        }

       do {
        
        opcion = Ingreso.leerEntero(mensaje.toString());
        
        switch (opcion) {
                case 1 -> ingresarProductos();
                case 2 -> ordenarPorCodigo();
                case 3 -> busquedaLineal();
                case 4 -> busquedaBinaria();
                case 5 -> mostrarProductoMayorPrecio();
        }
        
        } while (opcion != 0);
    }

    public static void ingresarProductos() {
        cantidadProductos = Ingreso.leerEnteroPositivo("Ingrese la cantidad de productos (máx. 100):");
        if (cantidadProductos > MAX_PRODUCTOS) {
            Salida.mError("No se puede ingresar mas de 100 productos", "Error");
            cantidadProductos = 0;
            return;
        }

        for (int i = 0; i < cantidadProductos; i++) {
            codigos[i] = Ingreso.leerEntero("Ingrese código del producto " + (i + 1) + ":");
            nombres[i] = Ingreso.leerString("Ingrese nombre del producto " + (i + 1) + ":");
            precios[i] = Ingreso.leerDouble("Ingrese precio del producto " + (i + 1) + ":");
        }
    }

    public static void ordenarPorCodigo() {
    for (int i = 0; i < cantidadProductos - 1; i++) {
        for (int j = 0; j < cantidadProductos - i - 1; j++) {
            if (codigos[j] > codigos[j + 1]) {
                // Intercambio directo en codigos
                int tempCod = codigos[j];
                codigos[j] = codigos[j + 1];
                codigos[j + 1] = tempCod;

                // Intercambio directo en nombres
                String tempNom = nombres[j];
                nombres[j] = nombres[j + 1];
                nombres[j + 1] = tempNom;

                // Intercambio directo en precios
                double tempPre = precios[j];
                precios[j] = precios[j + 1];
                precios[j + 1] = tempPre;
            }
        }
    }
    StringBuilder sb = new StringBuilder("Productos ordenados por código:\n\n");
    for (int i = 0; i < cantidadProductos; i++) {
        sb.append("Código: ").append(codigos[i])
          .append(" | Nombre: ").append(nombres[i])
          .append(" | Precio: ").append(precios[i])
          .append("\n");
    }

    Salida.mMensaje(sb.toString(), "Productos ordenados");
    }

    public static void busquedaLineal() {
        int buscado = Ingreso.leerEntero("Ingrese código del producto a buscar (lineal):");
        for (int i = 0; i < cantidadProductos; i++) {
            if (codigos[i] == buscado) {
                mostrarProducto(i);
                return;
            }
        }
        Salida.mError("Producto no encontrado", "Error");
    }

    public static void busquedaBinaria() {
        int buscado = Ingreso.leerEntero("Ingrese código del producto a buscar (binaria):");
        int inicio = 0, fin = cantidadProductos - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (codigos[medio] == buscado) {
                mostrarProducto(medio);
                return;
            } else if (codigos[medio] < buscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        Salida.mError("Producto no encontrado", "Error");
    }

    public static void mostrarProductoMayorPrecio() {
        if (cantidadProductos == 0) {
            Salida.mError("No hay productos cargados", "Error");
            return;
        }

        int maxIndex = 0;
        for (int i = 1; i < cantidadProductos; i++) {
            if (precios[i] > precios[maxIndex]) {
                maxIndex = i;
            }
        }

        JOptionPane.showMessageDialog(null,
            "Producto con mayor precio:\n" +
            "Código: " + codigos[maxIndex] + "\n" +
            "Nombre: " + nombres[maxIndex] + "\n" +
            "Precio: $" + precios[maxIndex]
        );
    }

    public static void mostrarProducto(int index) {
        JOptionPane.showMessageDialog(null,
            "Producto encontrado:\n" +
            "Código: " + codigos[index] + "\n" +
            "Nombre: " + nombres[index] + "\n" +
            "Precio: $" + precios[index]
        );
    }

    
}
