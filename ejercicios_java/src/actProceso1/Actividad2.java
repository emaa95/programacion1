package actProceso1;

import java.util.Scanner;

/*
    Ejercicio 1
    Diseñar un programa en Java que permita leer desde teclado la información sobre 
    el nombre, altura, edad, y sexo (‘F’/’M’) de los participantes de un curso. 
    Después que se haya ingresado la información de un participante, para continuar con la carga 
    el programa debe preguntar si desea continuar o no. 
    En caso de la respuesta negativa (lectura finalizada) determine y muestre:

    Promedio de altura de las mujeres.
    Promedio de altura de los varones.
    Promedio de edad de los participantes.
    Nombre, edad y sexo de la persona más joven.

*/
public class Actividad2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int op = 0;

        do {
            
            sc.nextLine(); 

            System.out.println("1. Ejercicio 1");
            System.out.println("2. Ejercicio 2");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opción: ");

            op = sc.nextInt();

            switch (op) {
                case 1:
                    cargaYprocesoDeDatos(sc);
                    break;
                
                case 2: 
                   
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            
        } while (op != 3 );
    }

    public static void cargaYprocesoDeDatos (Scanner sc) {
        int op, edad, cantVarones = 0, cantMujeres = 0, sumaEdad=0;
        String nombre, sexo;
        double altura, promAltM, promAltV, promEdad, sumaAltM = 0, sumaAltV = 0;

        do {
            System.out.println("Ingrese la información de los participantes: ");
            
            sc.nextLine();

            nombre = leerNombre(sc, "Nombre: ");
            altura = leerAltura(sc, "Altura: ");
            edad = leerEdad(sc, "Edad: ");
            sexo = leerSexo(sc, "Sexo (F o M): ");

            System.out.println("¿Desea continuar con la carga de participantes(1. Si 0. No)");
            op = sc.nextInt();

            sumaEdad += edad;

            if (sexo.equals("F")){
                sumaAltM += altura;
                cantMujeres ++;
            } else {
                sumaAltV += altura;
                cantVarones ++;
            } 


            promAltM = promedio(sumaAltM, cantMujeres);
            promAltV = promedio(sumaAltV, cantVarones);
            promEdad = promedio(sumaEdad, cantMujeres + cantVarones);
            


        } while (op != 0);

        System.out.printf("Promedio de altura de mujeres: %.2f cm%n", promAltM);
        System.out.printf("Promedio de altura de varones: %.2f cm%n", promAltV);
        System.out.printf("Promedio de edad de los participantes: %d años%n", promEdad);


    }

    public static String leerNombre(Scanner sc, String cMens) {
        boolean repetir;
        String nombre = "";
        do {
            repetir = false;
            try {
                System.out.println(cMens);
                nombre = sc.nextLine();

                if (nombre.trim().isEmpty()) {
                    throw new Exception("El nombre no puede estar vacio");
                }
            } catch (Exception e) {
                System.out.println("Valor no válido: " + e.getMessage());
                repetir = true;
            } 
        } while (repetir);
        return nombre;
    }  

    public static double leerAltura(Scanner sc, String cMens) {
        boolean repetir; 
        double altura = 0;

        do {
            repetir = false;
            try {
                System.out.println(cMens);
                altura = sc.nextDouble();

                if (altura <= 0) {
                    throw new Exception("La altura debe ser un número positivo");
                }

            } catch (Exception e) {
                System.out.println("Valor no válido" + e.getMessage());
                repetir = true;
            }
        } while (repetir);

        return altura;
    }

    public static int leerEdad(Scanner sc, String cMens) {
        boolean repetir; 
        int edad = 0;

        do {
            repetir = false;
            try {
                System.out.println(cMens);
                edad = sc.nextInt();

                if (edad <= 0) {
                    throw new Exception("La edad debe ser un número positivo");
                }

            } catch (Exception e) {
                System.out.println("Valor no válido" + e.getMessage());
                repetir = true;
            }
        } while (repetir);

        return edad;
    }

    public static String leerSexo(Scanner sc, String cMens) {
        boolean repetir; 
        String sexo = "";

        do {
            repetir = false;
            try {
                System.out.println(cMens);
                sexo = sc.nextLine().toUpperCase();

                if (!sexo.equals("F") && !sexo.equals("M")) {
                    throw new Exception("El sexo debe ser F o M: ");
                }

            } catch (Exception e) {
                System.out.println("Valor no válido" + e.getMessage());
                repetir = true;
            }
        } while (repetir);

        return sexo;
    }

    public static double promedio (double suma, int cant) {
        return suma/cant;
    }





    

}
