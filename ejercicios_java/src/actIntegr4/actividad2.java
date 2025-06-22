package actIntegr4;

import javax.swing.JOptionPane;

import actIntegr4.inputOutputJOP.Ingreso;
import actIntegr4.inputOutputJOP.Salida;

/*
 * Escribir un programa en Java que permita cargar una matriz de NxM elementos enteros. 
 * Obtener y mostrar los elementos mayores y su posición del promedio de la fila J ingresada por teclado.
 */

public class actividad2 {
    public static void main(String[] args) {
        int filas = Ingreso.leerEnteroPositivo("Ingrese el número de filas: ");
        int columnas = Ingreso.leerEnteroPositivo("Ingrese el número de columnas");

        int[][] matriz = cargarMatriz(filas, columnas);
        int filaSeleccionada = solicitarFilaValida(filas);

        double promedio = calcularPromedioFila(matriz[filaSeleccionada]);
        mostrarElementosMayoresAlPromedio(matriz, filaSeleccionada, promedio);
    }

    public static int[][] cargarMatriz(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = Ingreso.leerEntero("Ingrese el valor para [" + i + "][" + j + "]:");
            }
        }
        return matriz;
    }

    public static int solicitarFilaValida(int totalFilas) {
    int fila;
    while (true) {
        fila = Ingreso.leerEntero("Ingrese la fila que desea analizar (0 a " + (totalFilas - 1) + "):");
        if (fila >= 0 && fila < totalFilas) {
            return fila;
        } else {
            Salida.mError("Número de fila inválido. Debe estar entre 0 y " + (totalFilas - 1), "Error");
        }
    }
}

    public static double calcularPromedioFila(int[] fila) {
        int suma = 0;
        for (int valor : fila) {
            suma += valor;
        }
        return (double) suma / fila.length;
    }

    public static void mostrarElementosMayoresAlPromedio(int[][] matriz, int filaSeleccionada, double promedio) {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Promedio de la fila ").append(filaSeleccionada).append(": ").append(promedio).append("\n");
        resultado.append("Elementos mayores al promedio:\n");

        boolean hayMayores = false;
        for (int j = 0; j < matriz[filaSeleccionada].length; j++) {
            int valor = matriz[filaSeleccionada][j];
            if (valor > promedio) {
                resultado.append("Valor: ").append(valor)
                        .append(" en posición [").append(filaSeleccionada).append("][").append(j).append("]\n");
                hayMayores = true;
            }
        }

        if (!hayMayores) {
            resultado.append("No hay elementos mayores al promedio en esta fila.");
        }

        JOptionPane.showMessageDialog(null, resultado.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }

}
