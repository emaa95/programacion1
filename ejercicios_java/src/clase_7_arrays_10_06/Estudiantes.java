package clase_7_arrays_10_06;

import java.io.IOException;
import java.util.Scanner;

public class Estudiantes {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner ent = new Scanner(System.in);
        String estudiantes[], cBuscar;
        int notas[];
        int n, opcion;

        System.out.println("----------------------");
        System.out.println("  GESTIÓN DE ALUMNOS  ");
        System.out.println("----------------------");
        System.out.print("Ingrese la cantidad de alumnos: ");
        n = Integer.parseInt(ent.nextLine());
        estudiantes = new String[n];
        notas = new int[n];
        /*-------------------------------------------*/
        cargaEstudiantesNotas(estudiantes, notas, ent);
        limpiar(ent);
        do {
            mostrarMenu();
            System.out.print("\n\tIngrese la opcion: ");
            opcion = Integer.parseInt(ent.nextLine());
            // opcion = ent.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("┌──────────────────────────────────────┐");
                    System.out.println("│    Lista de Estudiantes  - Notas     │");
                    System.out.println("└──────────────────────────────────────┘");
                    mostrarEstudiantesNotas(estudiantes, notas);
                    break;

                case 2:
                    System.out.println("┌──────────────────────────────────┐");
                    System.out.println("│       Promedio de las Notas      │");
                    System.out.println("└──────────────────────────────────┘");
                    System.out.println("El promedio de las Notas ingresadas es: " + calculaPromedio(notas));
                    break;

                case 3:
                    int nMayor = mayorNota(notas);
                    System.out.println("┌──────────────────────────────────────┐");
                    System.out.println("│        Estudiante con Mayor Nota     │");
                    System.out.println("└──────────────────────────────────────┘");
                    System.out.println("El alumnos con la mayor nota es: " + estudiantes[nMayor]);
                    System.out.println("Con  una nota de " + notas[nMayor]);
                    break;

                case 4:
                    System.out.println("┌──────────────────────────────────────┐");
                    System.out.println("│    Orden de Mérito de Estudiantes    │");
                    System.out.println("└──────────────────────────────────────┘");
                    ordenaNotas(estudiantes, notas);
                    mostrarEstudiantesNotas(estudiantes, notas);
                    break;

                case 5:
                    System.out.println("┌──────────────────────────────────────┐");
                    System.out.println("│    Orden Alfabético de Estudiantes   │");
                    System.out.println("└──────────────────────────────────────┘");
                    ordenaNombres(estudiantes, notas);
                    mostrarEstudiantesNotas(estudiantes, notas);
                    break;

                case 6:
                    System.out.print("\nIngrese el Nombre del Estudiante a buscar: ");
                    cBuscar = ent.nextLine();
                    if (buscaNombreLineal(estudiantes, cBuscar) == -1)
                        System.out.println("\nNo se Encuenra el Estudiante " + cBuscar);
                    else
                        System.out.println("\nEl Estudiante " + cBuscar + " se encuentra en la lista");
                    break;

                case 7:
                    System.out.print("\nIngrese el Nombre del Estudiante a buscar: ");
                    cBuscar = ent.nextLine();
                    ordenaNombres(estudiantes, notas);
                    if (buscaNombreBinario(estudiantes, cBuscar) == -1)
                        System.out.println("\nNo se Encuenra el Estudiante " + cBuscar);
                    else
                        System.out.println("\nEl Estudiante " + cBuscar + " se encuentra en la lista");
                    break;

                default:
                    if (opcion != 8) {
                        System.out.println("┌──────────────────────────────────────┐");
                        System.out.println("│            OPCIÓN NO VALIDA          │");
                        System.out.println("└──────────────────────────────────────┘");
                    } else {
                        System.out.println("┌──────────────────────────────────────┐");
                        System.out.println("│         Adiós, Muchas Gracias        │");
                        System.out.println("└──────────────────────────────────────┘");
                    }
            }
            if (opcion != 8)
                limpiar(ent);

        } while (opcion != 8);
    }

    /*--------------------------------------------*/
    /* MENU DE OPCIONES */
    /*--------------------------------------------*/
    public static void mostrarMenu() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║       Menu de Opciones      ║");
        System.out.println("╚═════════════════════════════╝");
        System.out.println("1) Mostar los Estudiantes");
        System.out.println("2) Mostrar Promedio de Notas");
        System.out.println("3) Mostar el Estudiantes con Mayor Nota");
        System.out.println("4) Ordena los Estudiantes por Nota");
        System.out.println("5) Orden Alfabético de Estudiantes");
        System.out.println("6) Busca Estudiante (Lineal)");
        System.out.println("7) Busca Estudiante (Binaria)");
        System.out.println("8) Salir");
    }

    /*----------------------------------------------------*/
    /* METODO PARA LIMPIAR LA TERMNAL */
    /*----------------------------------------------------*/
    public static void limpiar(Scanner entr) throws InterruptedException, IOException {
        System.out.print("\nPresione enter para continuar...");
        entr.nextLine();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    /*---------------------------------------------------- */
    /* METODO PARA CARGAR LOS DATOS DE LOS ESTUDIANTES */
    /*---------------------------------------------------- */
    public static void cargaEstudiantesNotas(String estud[], int notas[], Scanner xdata) {
        boolean lError = false;
        for (int i = 0; i < estud.length; i++) {
            System.out.print("\nIngrese el Nombre del Estudiante " + (i + 1) + ": ");
            estud[i] = xdata.nextLine();
            do {
                try {
                    lError = false;
                    System.out.print("Ingrese la Nota del Estudiante " + (i + 1) + ": ");
                    notas[i] = Integer.parseInt(xdata.nextLine());
                } catch (Exception e) {
                    lError = true;
                    System.out.println("Error de Datos... Debe ser un entero!!!");
                }

            } while (lError);
        }
    }

    /*----------------------------------------------------*/
    /* MOSTRAR ALUMNOS Y NOTAS */
    /*----------------------------------------------------*/
    public static void mostrarEstudiantesNotas(String estud[], int notas[]) {
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Estudiante: " + i + " = " + estud[i] + "\t -> Nota: " + notas[i]);
        }
    }

    /*----------------------------------------------------*/
    /* CALCULA PROMEDIO DE NOTAS */
    /*----------------------------------------------------*/
    public static double calculaPromedio(int notas[]) {
        int acum = 0;
        double promedio;
        for (int i = 0; i < notas.length; i++) {
            acum += notas[i];
        }
        promedio = (double) acum / notas.length;
        return promedio;
    }

    /*---------------------------------------------------*/
    /* Busca la mayor nota y retorna la posicion */
    /*---------------------------------------------------*/
    public static int mayorNota(int notas[]) {
        int Mayor = 0, posMay = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > Mayor) {
                Mayor = notas[i];
                posMay = i;
            }
        }
        return posMay;
    }

    /*---------------------------------------------------*/
    /* Ordena el Vector de Notas de Mayor as Menor */
    /*---------------------------------------------------*/
    public static void ordenaNotas(String estud[], int notas[]) {
        boolean swapped;
        int auxNota;
        String auxName;
        for (int i = 1; i < notas.length; i++) {
            swapped = false;
            /*--------------------------------------------- */
            /* Recorremos el array para comparar */
            /*--------------------------------------------- */
            for (int j = 0; j < notas.length - i; j++) {
                /* Si el elemento actual es mayor que el posterior */
                /* se intercambian - Para cambiar el orden cambiar */
                /* ascendente cambiar > por < */
                if (notas[j] < notas[j + 1]) {
                    auxNota = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = auxNota;
                    /*----------------------------------*/
                    /* Se intercambia el Nombre tambien */
                    /*----------------------------------*/
                    auxName = estud[j];
                    estud[j] = estud[j + 1];
                    estud[j + 1] = auxName;
                    swapped = true;
                    // intercambios++;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /*---------------------------------------------------*/
    /* Ordena el Vector de Notas de Mayor as Menor */
    /*---------------------------------------------------*/
    public static void ordenaNombres(String estud[], int notas[]) {
        boolean swapped;
        int auxNota;
        String auxName;
        for (int i = 1; i < notas.length; i++) {
            swapped = false;
            /*--------------------------------------------- */
            /* Recorremos el array para comparar */
            /*--------------------------------------------- */
            for (int j = 0; j < notas.length - i; j++) {
                /* Si el elemento actual es mayor que el posterior */
                /* se intercambian - Para cambiar el orden cambiar */
                /* ascendente cambiar > por < */
                if (estud[j].compareTo(estud[j + 1]) > 0) {
                    auxName = estud[j];
                    estud[j] = estud[j + 1];
                    estud[j + 1] = auxName;
                    /*----------------------------------*/
                    /* Se intercambia las Notas tambien */
                    /*----------------------------------*/
                    auxNota = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = auxNota;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /*--------------------------------------------------*/
    /* Busca un Estudiante por su Nombre (Lineal) */
    /*--------------------------------------------------*/
    static int buscaNombreLineal(String est[], String nameBusca) {
        for (int i = 0; i < est.length; i++) {
            if (est[i].compareTo(nameBusca) == 0)
                return i;
        }
        return -1;
    }

    /*--------------------------------------------------*/
    /* Busca un Estudiante por su Nombre (Binaria) */
    /*--------------------------------------------------*/
    static int buscaNombreBinario(String estud[], String clave) {
        int central, izquierda, derecha;
        int nResulComp;
        izquierda = 0;
        derecha = estud.length - 1;
        while (izquierda <= derecha) {
            central = (izquierda + derecha) / 2;
            nResulComp = estud[central].compareTo(clave);
            if (nResulComp == 0)
                return central;
            else if (nResulComp > 0)
                derecha = central - 1;
            else
                izquierda = central + 1;
        }
        return -1;
    }
}