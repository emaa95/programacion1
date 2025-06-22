package clase_7_arrays_10_06;


//Se tiene un arreglo de N filas y M columnas compuesto de elementos enteros. 
//Realizar un programa en Java con Visual Studio Code que indique la posición de cada elemento par 
//y su valor (en la fila y la columna en la que se encuentra ese elemento).
// Mostrar al finalizar la suma de elementos pares. Utilizar métodos para la resolución de las actividades

import java.util.Scanner;

public class Arreglo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el número de columnas: ");
        int columnas = scanner.nextInt();

        int[][] arreglo = new int[filas][columnas];

        Escribirarreglo(filas, columnas, arreglo);
        mostarArreglo(filas, columnas, arreglo);
        lecturadelarray(filas, columnas, arreglo);
        buscaMayor(filas, columnas, arreglo);

        scanner.close();

    }

    /*--------------------------------- */
    /* INGRESO DE DATOS */
    /*--------------------------------- */
    public static void Escribirarreglo(int filas, int columnas, int[] arreglo[]) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el valor para [" + i + "][" + j + "]: ");
                arreglo[i][j] = scanner.nextInt();
            }
        }

        scanner.close();
    }

    /*--------------------------------- */
    /* LECTURA DE DATOS */
    /*--------------------------------- */

    public static void mostarArreglo(int filas, int columnas, int[] arreglo[]) {
        System.out.println("---------------------------------");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.println("El elemento [" + i + "][" + j + "] tiene valor " + arreglo[i][j]);
            }
        }
    }

    public static void lecturadelarray(int filas, int columnas, int[] arreglo[]) {
        System.out.println("---------------------------------");
        int suma = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (esPar(arreglo[i][j])) {
                    System.out.println("El elemento [" + i + "][" + j + "] es par y tiene valor " + arreglo[i][j]);
                    suma += arreglo[i][j];
                }
            }
        }
        System.out.println("---------------------------------");
        System.out.println("La suma de los elementos pares es " + suma);
        System.out.println("---------------------------------");
    }

    public static boolean esPar(int num) {
        return num % 2 == 0;
    }

    public static void buscaMayor(int filas, int columnas, int[] arreglo[]) {
        System.out.println("---------------------------------");
        int nMayor = arreglo[0][0];
        int indiceF = 0;
        int indiceC = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (arreglo[i][j] > nMayor) {
                    nMayor = arreglo[i][j];
                    indiceF = i;
                    indiceC = j;
                }
            }
        }
        System.out.println(
                "El elemento mayor es " + nMayor + " y esta en la fila: " + indiceF + " y la columna: " + indiceC);
    }
}