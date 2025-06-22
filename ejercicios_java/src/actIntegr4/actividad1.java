package actIntegr4;

import actIntegr4.inputOutputJOP.Ingreso;
import actIntegr4.inputOutputJOP.Salida;

/*
 Escribir un programa en Java que luego de cargar un array unidimensional (vector) 
 de n elementos, imprima la cantidad de elementos mayores al promedio.
 */

public class actividad1 {
    public static void main(String[] args) {  

    int maximo = Ingreso.leerEnteroPositivo("Ingrese el tamaño máximo del arreglo: ");
    int [] elementos = new int[maximo];
    int contadorNumeros = 0;
    boolean respuesta;

    do {
         
        if (contadorNumeros >= elementos.length) {
            System.out.println("Se alcanzó el límite máximo de elementos.");
            break;
        }

        int elemento = Ingreso.leerEnteroPositivo("Ingrese el valor del elemento (mayor a 0): ");
        elementos[contadorNumeros++] = elemento;

        respuesta = Ingreso.confirmar("¿Desea ingresar otro elemento?", "Confirmación");

   

    } while(respuesta);
    
    double promedio = calcularPromedio(elementos, elementos.length);

    int elementosMayores = contarMayoresAlPromedio(elementos, elementos.length, promedio);

    mostrarResultados(elementos, contadorNumeros, promedio, elementosMayores);

    }

    public static double calcularPromedio(int[] array, int cantidad) {
        int suma = 0;
        for (int i = 0; i < cantidad; i++) {
            suma += array[i];
        }
        return (double) suma / cantidad;
    }

    public static int contarMayoresAlPromedio(int[] array, int cantidad, double promedio) {
        int contador = 0;
        for (int i = 0; i < cantidad; i++) {
            if (array[i] > promedio) {
                contador++;
            }
        }
        return contador;
    }

    public static void mostrarResultados(int[] array, int cantidad, double promedio, int mayoresAlPromedio) {
        StringBuilder sb = new StringBuilder();
        sb.append("📊 Resultados del análisis:\n\n");
        sb.append("Total de elementos ingresados: ").append(cantidad).append("\n");
        sb.append("Promedio: ").append(String.format("%.2f", promedio)).append("\n");
        sb.append("Cantidad de elementos mayores al promedio: ").append(mayoresAlPromedio).append("\n\n");

        sb.append("🧮 Elementos ingresados: ");
        for (int i = 0; i < cantidad; i++) {
            sb.append(array[i]);
            if (i < cantidad - 1) sb.append(", ");
        }

        sb.append("\n\n🔼 Elementos mayores al promedio: ");
        boolean hayMayores = false;
        for (int i = 0; i < cantidad; i++) {
            if (array[i] > promedio) {
                sb.append(array[i]).append(" ");
                hayMayores = true;
            }
        }
        if (!hayMayores) {
            sb.append("Ninguno");
        }

        Salida.mMensaje(sb.toString(), "Resumen del Análisis");
    }
}

