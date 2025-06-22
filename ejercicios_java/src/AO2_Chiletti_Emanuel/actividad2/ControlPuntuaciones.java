package AO2_Chiletti_Emanuel.actividad2;

import javax.swing.JOptionPane;

import AO2_Chiletti_Emanuel.actividad2.inputOutputJOP.Ingreso;
import AO2_Chiletti_Emanuel.actividad2.inputOutputJOP.Salida;

public class ControlPuntuaciones {

    static  int [] puntajes = new int[10];
    static boolean puntajesCargados = false;

    public static void main(String[] args) {
     int opcion;

        do {
            String input = JOptionPane.showInputDialog(null,
                    "========== MENÚ PRINCIPAL ==========\n"
                    + "1.Cargar puntajes\n"
                    + "2.Mostrar puntajes\n"
                    + "3.Calcular total acumulado\n"
                    + "4.Mostrar puntajes ordenados (burbuja)\n"
                    + "5.Mostrar puntaje más alto y más bajo\n"
                    + "6. Contar rondas con puntajes mayores a 80\n"
                    + "7. Verificar si un puntaje ya fue ingresado\n"
                    + "0. Salir\n\n"
                    + "Seleccione una opción:", "Menú", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                // Usuario presionó Cancelar
                break;
            }

            try {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        cargarPuntajes();
                        break;
                    case 2:
                        mostrarPuntajes();
                        break;
                    case 3:
                        calcularTotal();
                        break;
                    case 4:
                        mostrarPuntajesOrdenados();
                        break;
                    case 5:
                        mostrarMayorYMenor();
                        break;
                    case 6: 
                        contarMayoresA80();
                        break;
                    case 7:
                        verificarNuevoPuntaje();
                    case 0:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no válida. Por favor ingrese un número.");
                opcion = -1; // Valor inválido para continuar el bucle
            }

        } while (true);

    
    }
    
    public static void cargarPuntajes () {
      for (int i = 0; i < puntajes.length; i++) {
        int puntaje;
        do {
            puntaje = Ingreso.leerEntero("Ingrese el puntaje de la ronda " + (i+1) + " (entre 1 y 100): ");
            if (puntaje < 1 || puntaje > 100) {
                Salida.mError("El puntaje debe estar entre 1 y 100", "Erro de puntaje");
            };
        } while (puntaje < 1 || puntaje > 100);
            puntajes[i] = puntaje; 
            puntajesCargados = true;
        }
    }

    public static void mostrarPuntajes() {
        if (!puntajesCargados) {
            Salida.mError("Primero debe cargar los puntajes.", "Error");
            return;
        }
        StringBuilder resultado = new StringBuilder("Puntajes ingresados:\n");
        for (int i = 0; i < puntajes.length; i++) {
            resultado.append("Ronda ").append(i + 1).append(": ").append(puntajes[i]).append("\n");
        }
            Salida.mMensaje(resultado.toString(), "Lista de Puntajes");
    }

    public static void calcularTotal() {
        if (!puntajesCargados) {
            Salida.mError("Debe cargar los puntajes primero.", "Error");
            return;
        }

        int total = 0;
        for (int i = 0; i < puntajes.length; i++) {
        total += puntajes[i];
        }

        Salida.mMensaje("Total acumulado: " + total, "Total de Puntajes");
    }

    public static void mostrarPuntajesOrdenados() {
        if (!puntajesCargados) {
            Salida.mError("Debe cargar los puntajes primero.", "Error");
        return;
        }

  
        for (int i = 0; i < puntajes.length - 1; i++) {
        for (int j = 0; j < puntajes.length - 1 - i; j++) {
            if (puntajes[j] > puntajes[j + 1]) {
                int temp = puntajes[j];
                puntajes[j] = puntajes[j + 1];
                puntajes[j + 1] = temp;
            }
        }
        }

        StringBuilder sb = new StringBuilder("Puntajes ordenados (menor a mayor):\n");
        for (int i = 0; i < puntajes.length; i++) {
            sb.append(puntajes[i]);
            if (i < puntajes.length - 1) sb.append(", "); 
        }

        Salida.mMensaje(sb.toString(), "Puntajes ordenados");

    }

    public static void mostrarMayorYMenor() {
        if (!puntajesCargados) {
            Salida.mError("Debe cargar los puntajes primero.", "Error");
            return;
        }

        int menor = puntajes[0];
        int mayor = puntajes[0];

        for (int p : puntajes) {
            if (p < menor) menor = p;
            if (p > mayor) mayor = p;
        }

        String mensaje = "Puntaje más bajo: " + menor + "\nPuntaje más alto: " + mayor;
        Salida.mMensaje(mensaje, "Máximo y Mínimo");
    }

    public static void contarMayoresA80() {
        if (!puntajesCargados) {
            Salida.mError("Debe cargar los puntajes primero.", "Error");
        return;
        }

        int contador = 0;
        for (int i = 0; i < puntajes.length; i++) {
            if (puntajes[i] > 80) {
            contador++;
            }
        }

        Salida.mMensaje("Cantidad de rondas con puntaje mayor a 80: " + contador, "Análisis > 80");
    }

    public static void verificarNuevoPuntaje() {
        if (!puntajesCargados) {
            Salida.mError("Debe cargar los puntajes primero.", "Error");
            return;
        }

        int nuevo = Ingreso.leerEntero("Ingrese un puntaje a verificar:");
        boolean encontrado = false;

        for (int p : puntajes) {
            if (p == nuevo) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            Salida.mMensaje("El puntaje ya fue obtenido en una ronda anterior.", "Repetido");
        } else {
            Salida.mMensaje("El puntaje NO fue obtenido anteriormente.", "Nuevo puntaje");
        }
    }

}


