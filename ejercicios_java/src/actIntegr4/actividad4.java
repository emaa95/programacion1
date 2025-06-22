package actIntegr4;

import javax.swing.JOptionPane;

/*
 * Realice un programa en Java que lea un vector de enteros y a partir de él forme un segundo vector, con los mismos datos pero en el orden inverso, mostrar. 
 * Obtener a partir del primer vector el promedio y luego mostrar solo los enteros que sean mayores que el promedio. 
 * Utilizar métodos para las distintas operaciones.
 */

import actIntegr4.inputOutputJOP.Ingreso;
import actIntegr4.inputOutputJOP.Salida;

public class actividad4 {
    public static void main(String[] args) {
        int n = Ingreso.leerEnteroPositivo("Ingrese la cantidad de elementos del vector:");

        int[] vectorOriginal = cargarVector(n);
        int[] vectorInvertido = invertirVector(vectorOriginal);

        mostrarVector("Vector original", vectorOriginal);
        mostrarVector("Vector invertido", vectorInvertido);

        double promedio = calcularPromedio(vectorOriginal);
        JOptionPane.showMessageDialog(null, "Promedio del vector: " + promedio);

        mostrarMayoresAlPromedio(vectorOriginal, promedio);
    }

    public static int[] cargarVector(int n) {
        int[] vec = new int[n];
        for (int i = 0; i < n; i++) {
            vec[i] = Ingreso.leerEntero("Ingrese el elemento " + (i + 1) + ":");
        }
        return vec;
    }

    public static int[] invertirVector(int[] vec) {
        int n = vec.length;
        int[] invertido = new int[n];
        for (int i = 0; i < n; i++) {
            invertido[i] = vec[n - 1 - i];
        }
        return invertido;
    }

    public static double calcularPromedio(int[] vec) {
        int suma = 0;
        for (int num : vec) {
            suma += num;
        }
        return (double) suma / vec.length;
    }

    public static void mostrarMayoresAlPromedio(int[] vec, double promedio) {
        StringBuilder resultado = new StringBuilder("Elementos mayores al promedio (" + promedio + "):\n");
        boolean hay = false;
        for (int num : vec) {
            if (num > promedio) {
                resultado.append(num).append("\n");
                hay = true;
            }
        }
        if (!hay) {
            resultado.append("No hay elementos mayores al promedio.");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    public static void mostrarVector(String titulo, int[] vec) {
        StringBuilder datos = new StringBuilder(titulo + ":\n");
        for (int num : vec) {
            datos.append(num).append(" ");
        }
        JOptionPane.showMessageDialog(null, datos.toString());
    }
}
