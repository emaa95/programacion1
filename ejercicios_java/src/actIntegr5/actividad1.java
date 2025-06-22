package actIntegr5;

import javax.swing.JOptionPane;

import actIntegr5.inputOutputJOP.Ingreso;

/*
 * Escribir un programa que permita cargar un arreglo unidimensional de N elementos. 
 * El programa debe permitir el ingreso de un elemento desde el teclado e informar la posición que ocupa en el arreglo. 
 * En caso contrario, mostrar el mensaje "elemento no encontrado".

    Nota : utilizar la búsqueda binaria.
 */

public class actividad1 {
    public static void main(String[] args) {
        int[] arreglo = cargarArreglo();
        ordenarArreglo(arreglo);
        mostrar(arreglo, "Arreglo ordenado:");

        int buscado = Ingreso.leerEntero("Ingrese el número a buscar:");
        int posicion = busquedaBinaria(arreglo, buscado);

        if (posicion != -1) {
            mostrar(null, "Elemento " + buscado + " encontrado en la posición: " + posicion);
        } else {
            mostrar(null, "Elemento " + buscado + " no encontrado.");
        }
    }

    public static int[] cargarArreglo() {
        int n = Ingreso.leerEnteroPositivo("Ingrese la cantidad de elementos del arreglo:");
        int[] arreglo = new int[n];
        for (int i = 0; i < n; i++) {
            arreglo[i] = Ingreso.leerEntero("Ingrese el elemento " + (i + 1) + ":");
        }
        return arreglo;
    }

    public static void ordenarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public static int busquedaBinaria(int[] arreglo, int clave) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (arreglo[medio] == clave) return medio;
            else if (arreglo[medio] < clave) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return -1;
    }

    public static void mostrar(int[] arreglo, String mensaje) {
        if (arreglo == null) {
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            StringBuilder sb = new StringBuilder(mensaje + "\n");
            for (int i = 0; i < arreglo.length; i++) {
                sb.append("[").append(i).append("]: ").append(arreglo[i]).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

}
