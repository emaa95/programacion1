package actIntegr1;

import javax.swing.JOptionPane;

/*
    Escribir un programa en Java que permita leer desde teclado números hasta que la suma de los mismos llegue a 1000. Mientras tanto se debe obtener y mostrar al finalizar:

    La cantidad de números múltiplos de 6.
    La suma de los números que se encuentran entre el 1 y el 10 (incluidos).
    El Mayor y el Menor de los números ingresados y su posición de ingreso.

    Puede utilizar Scanner u JOptionPane para el ingreso de datos por teclado.
*/
public class Actividad2 {
    public static void main(String[] args) {
        int sumaTotal = 0;
        int contadorMultiplos6 = 0;
        int sumaEntre1y10 = 0;
        int mayor = 0, menor = 0;
        int posicionMayor = 1, posicionMenor = 1;
        int posicion = 0;
        boolean primerIngreso = true;

        int numero;

        do {
            numero = pedirNumero(sumaTotal);
            sumaTotal += numero;
            posicion++;
            
            if (primerIngreso) {
                mayor = numero;
                menor = numero;
                primerIngreso = false;
            }

            if (esMultiploDe6(numero)) {
                contadorMultiplos6++;
            }

            if (estaEntre1y10(numero)) {
                sumaEntre1y10 += numero;
            }

            if (numero > mayor) {
                mayor = numero;
                posicionMayor = posicion;
            }

            if (numero < menor) {
                menor = numero;
                posicionMenor = posicion;
            }

        } while (sumaTotal < 1000);

        mostrarResultados(contadorMultiplos6, sumaEntre1y10, mayor, posicionMayor, menor, posicionMenor, sumaTotal);
    }

    public static int pedirNumero(int sumaTotal) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese un número (suma actual: " + sumaTotal + "):");
                
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Programa cancelado por el usuario.");
                    System.exit(0); 
                }
    
                numero = Integer.parseInt(input);

                if (numero > 0) {
                    valido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: El número debe ser mayor a 0.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
            }
        }

        return numero;
    }

    public static boolean esMultiploDe6(int numero) {
        return numero % 6 == 0;
    }

    public static boolean estaEntre1y10(int numero) {
        return numero >= 1 && numero <= 10;
    }

    public static void mostrarResultados(int multiplos6, int suma1a10, int mayor, int posMayor, int menor, int posMenor, int sumaTotal) {
        String mensaje = ">>> RESULTADOS <<<\n\n" +
                         "Cantidad de números múltiplos de 6: " + multiplos6 + "\n" +
                         "Suma de números entre 1 y 10: " + suma1a10 + "\n" +
                         "Número mayor: " + mayor + " (posición: " + posMayor + ")\n" +
                         "Número menor: " + menor + " (posición: " + posMenor + ")\n" +
                         "Suma total acumulada: " + sumaTotal;

        JOptionPane.showMessageDialog(null, mensaje, "Resultado Final", JOptionPane.INFORMATION_MESSAGE);
    }
}
