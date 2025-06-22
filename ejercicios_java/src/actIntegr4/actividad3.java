package actIntegr4;

import javax.swing.JOptionPane;

import actIntegr4.inputOutputJOP.Ingreso;
import actIntegr4.inputOutputJOP.Salida;
/*
 * Escribir un programa que permita cargar dos arreglos unidimensionales (vectores) de n elementos 
 * cada uno, el primero conteniendo el legajo y el segundo la nota de cada alumno.
 * Se quiere saber que alumnos tienen una nota mayor al número K ingresado desde el teclado.
 */

public class actividad3 {
     public static void main(String[] args) {
        int n = Ingreso.leerEnteroPositivo("Ingrese la cantidad de alumnos:");

        int[] legajos = cargarLegajos(n);
        double[] notas = cargarNotas(n, legajos);
        double k = Ingreso.leerDouble("Ingrese el valor K (nota mínima a superar):");

        mostrarAlumnosConNotaMayor(n, legajos, notas, k);
    }

    public static int[] cargarLegajos(int cantidad) {
        int[] legajos = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            legajos[i] = Ingreso.leerEntero("Ingrese el legajo del alumno " + (i + 1) + ":");
        }
        return legajos;
    }

    public static double[] cargarNotas(int cantidad, int[] legajos) {
        double[] notas = new double[cantidad];
        for (int i = 0; i < cantidad; i++) {
            notas[i] = Ingreso.leerDoublePositivo("Ingrese la nota del alumno con legajo " + legajos[i] + ":");
        }
        return notas;
    }

    public static void mostrarAlumnosConNotaMayor(int cantidad, int[] legajos, double[] notas, double k) {
        StringBuilder resultado = new StringBuilder("Alumnos con nota mayor a " + k + ":\n");
        boolean hayAlumnos = false;

        for (int i = 0; i < cantidad; i++) {
            if (notas[i] > k) {
                resultado.append("Legajo: ").append(legajos[i])
                        .append(" | Nota: ").append(notas[i]).append("\n");
                hayAlumnos = true;
            }
        }

        if (!hayAlumnos) {
            resultado.append("Ningún alumno supera la nota ").append(k);
        }

        Salida.mMensaje(resultado.toString(), "Resultado");
    }
}
