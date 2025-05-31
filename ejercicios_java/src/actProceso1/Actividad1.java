package actProceso1;

/*
    Para las actividades deben utilizar Métodos,  la clase Scanner para el ingreso de los datos y aplicar excepciones cuando crea conveniente.
    Escribir un programa en Java que permita ingresar 10 enteros positivos por teclado (validar que sea positivo), determine y muestre un mensaje «Correcto» si el numero N es múltiplo de 5 y se encuentra entre los 25 primeros números decimales. Al finalizar mostrar la cantidad de Enteros que cumplen la condición y su promedio. Utilice el ciclo más apropiado.
    El factorial de un número entero se denota de la siguiente manera "n!" y su resultado es n!=n*(n-1)*(n-2)*1. Por ejemplo: 5!=5*4*3*2*1 siendo el resultado 120. Se pide desarrollar un programa en Java que lea un valor N por teclado y determine su factorial. Utilice ciclo for() y while().

*/
import java.util.Scanner;

public class Actividad1 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int op = 0;

        do {

            System.out.println("1. Ejercicio 1");
            System.out.println("2. Ejercicio 2");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opción: ");

            op = sc.nextInt();

            switch (op) {
                case 1:
                    ingresoYverificacionDeNumeros(sc);
                    break;
                
                case 2: 
                    int n ; 
                    n = leerEntero(sc, "Ingre un número mayor a 0: ");
                    System.out.println("El factorial de " + n + " con el ciclo for es: " + factorialCicloFor(n));
                    System.out.println("El factorial de " + n + " con el ciclo while es: " + factorialCicloWhile(n));
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            
        } while (op != 3 );
    }

    public static int leerEntero(Scanner ixt, String cMens ) {
        boolean repetir;
        int n = 0;
        do {
            repetir = false;
            try {
                System.out.println("cMens");
                n = ixt.nextInt();
            } catch (Exception e) {
                System.out.println("Valor no válido");
                repetir = true;
            } finally {
                ixt.nextLine();
            }
        } while (repetir);
        return n;
    }

    public static void ingresoYverificacionDeNumeros (Scanner sc) {
        int num;
        int suma = 0;
        double promedio = 0;
        int numerosCorrectos = 0;
        for (int i = 0; i < 10; i++) {
            do {
                System.out.println("Ingrese un número positivo: ");
                num = sc.nextInt();
                if (num < 0) {
                    System.out.println("Error... cargue otro número que sea mayor a cero");
                }

            } while (num < 0);
            if (num % 5 == 0 && num <= 25) {
                System.out.println("Correcto");
                suma += num;
                numerosCorrectos ++;
            }
        }
        if (numerosCorrectos > 0) {
            promedio = suma / numerosCorrectos;
            System.out.println("Cantidad de números que cumplen la condición: " + numerosCorrectos);
            System.out.println("Promedio de los números que cumplen la condición: " + promedio);
        }

    }

    public static long factorialCicloFor (int n) {
        long factorial = 1;
        for (int i = 0; i < 1; i++) {
            factorial *= 1;
        }
        return factorial;
    }

    public static long factorialCicloWhile (int n) {
        long factorial = 1;
        int i = 1;
        while (i <= n) {
            factorial *= i;
            i++;
        }
        return factorial;
    }

}