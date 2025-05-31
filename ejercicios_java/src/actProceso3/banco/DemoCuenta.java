package actProceso3.banco;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class DemoCuenta {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        /* Permite mostrar siempre el menu después de cada operación */
        // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        Scanner data = new Scanner(System.in);
        data.useLocale(Locale.ENGLISH); /* Set del teclado para el punto sea separador de decimales */

        String name;
        long nroCuenta;
        double importe;

        int opcion;
        char bloqueo;

        TipoCuenta[] tCuenta = TipoCuenta.values();

        CuentaBancaria cb;
        System.out.println("Creacion de cuenta");
        System.out.println("------------------");
        System.out.println("Ingrese los datos de la cuenta");
        System.out.print("\tNombre Cliente: ");
        name = data.nextLine();
        System.out.print("\tNº Cuenta: ");
        nroCuenta = data.nextLong();
        System.out.println("\tTipos de cuenta");

        for (int i = 0; i < tCuenta.length; i++) {
            System.out.println("\t\t" + (i + 1) + "| " + tCuenta[i]);
        }

        System.out.println("\tSeleccione una opción: ");
        opcion = data.nextInt();

        cb = new CuentaBancaria(name, nroCuenta, 0, tCuenta[opcion-1]);

        do {
            System.out.println("\n ************************* ");
            System.out.println("|      Menú de opciones   |");
            System.out.println("*****************************");
            System.out.println(" 1) Mostrar datos cuenta");
            System.out.println(" 2) Ingresar dinero");
            System.out.println(" 3) Retirar Dinero");
            System.out.println(" 4) Bloquear Cuenta");
            System.out.println(" 5) Desbloquear Cuenta\n");

            System.out.println("Seleccione una Opcion 0 -> sale: ");
            opcion = data.nextInt();

            //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            switch (opcion) {
                case 0:
                    System.out.println("Adios...\n");
                    break;
                
                case 1: 
                    cb.mostrarCuenta();
                    break;

                case 2: 
                    if (cb.getEstadoCta()) {
                        cb.setDeposito(data);
                    }
                    break;

                case 3: 
                    if (cb.getEstadoCta()) {
                        System.out.println("Ingrese el importe a retirar: ");
                        importe = data.nextDouble();

                        if (!cb.setRetiro(importe)) {
                            System.out.println("No tiene saldo suficiente para retirar");
                        }
                    }
                    break;

                case 4: 
                    if (!cb.getBoqueoCta()){
                        System.out.println("La cuenta ya se encuentra bloqueada");
                    } else {
                        System.out.println("¿Desea bloquear la cuenta? s/n");
                        bloqueo = (char) System.in.read();
                        if (bloqueo == (char) 'S' || bloqueo == (char) 's') {
                            cb.setBloqueoCta(false);
                            cb.mensExito();
                        }
                    }
                    break;

                case 5: 
                    if (cb.getBoqueoCta()){
                        System.out.println("La cuenta ya se encuentra Habilitada");
                    } else {
                        System.out.println("¿Desea habilitar la cuenta? s/n");
                        bloqueo = (char) System.in.read();
                        if (bloqueo == (char) 'S' || bloqueo == (char) 's') {
                            cb.setBloqueoCta(true);
                            cb.mensExito();
                        }
                    }
                    break;

                default:
                    System.out.println("Selección no valida...");;
            }

        } while (opcion != 0); 
            
        data.close();

    }
}
