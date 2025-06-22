package clase_7_arrays_10_06;

import inputOuput.*;

//Se tiene un arreglo de N filas y M columnas compuesto de elementos enteros. 
//Realizar un programa en Java con Visual Studio Code que indique la posición de cada elemento par 
//y su valor (en la fila y la columna en la que se encuentra ese elemento).
// Mostrar al finalizar la suma de elementos pares. Utilizar métodos para la resolución de las actividades

public class Ejercicio_1 {
    public static void main(String[] args) {
        int filas = Ingreso.datoEntero("ingrese el numero de filas", "numero filas", 1);
        int columnas = Ingreso.datoEntero("ingrese el numero de coumnas", "columnas", 1);
        int[][] arreglo = new int[filas][columnas];

        cargarArreglo(arreglo);
        mostrarArreglo(arreglo);
        double prom = promedio(arreglo);
        // mayor(arreglo);

        Salida.mMensaje("El promedio total es: " + prom, "titulo");
        mayorAlPromedio(arreglo, prom);

    }

    public static void cargarArreglo(int arreglo[][]) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                arreglo[i][j] = Ingreso.datoEntero("ingrese un numero en la posicion [" + i + "] [" + j + "]:",
                        "ingresando numero", 1);
            }
        }
    }

    /* Lee la matriz de enteros */
    public static void mostrarArreglo(int arreglo[][]) {
        StringBuilder data = new StringBuilder("Datos de la Matriz\n");
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                data.append("[" + i + "] , [" + j + "] es: " + arreglo[i][j] + "\n");
            }
        }
        Salida.mMensaje(data.toString(), "mostrando numero");
    }

    /* Obtiene el mayor, muestra su posicion */
    public static void mayor(int arreglo[][]) {
        int mayor = arreglo[0][0], filas = 0, columnas = 0;
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                if (mayor < arreglo[i][j]) {
                    mayor = arreglo[i][j];
                    filas = i;
                    columnas = j;
                }
            }
        }
        Salida.mMensaje("El mayor numero del arreglo es: " + mayor + "\nEsta en la posicion [" + filas + "]["
                + columnas + "]", "mostrando mayor");
    }

    public static double promedio(int arreglo[][]) {
        int filas = arreglo.length, columnas = arreglo[0].length, suma = 0;
        double promedio = 0;

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                suma += arreglo[i][j];
            }
        }
        promedio = (double) suma / (filas * columnas);
        return promedio;
    }

    public static void mayorAlPromedio(int nA[][], double prom) {
        StringBuilder data = new StringBuilder("Elementos mayores a: " + prom + "\n");
        for (int i = 0; i < nA.length; i++) {
            for (int j = 0; j < nA[0].length; j++) {
                if (prom < nA[i][j]) {
                    data.append(nA[i][j] + " \n");
                }
            }
        }
        Salida.mMensaje(data.toString(), "Info: ");
    }

}