package utils;

import javax.swing.JOptionPane;

public class menuJOP {
    public static void main(String[] args) {
        int opcion;

        do {
            String input = JOptionPane.showInputDialog(null,
                    "========== MENÚ PRINCIPAL ==========\n"
                    + "1. Opción 1 - [Descripción de la opción]\n"
                    + "2. Opción 2 - [Descripción de la opción]\n"
                    + "3. Opción 3 - [Descripción de la opción]\n"
                    + "4. Opción 4 - [Descripción de la opción]\n"
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
                        JOptionPane.showMessageDialog(null, "Has seleccionado la Opción 1.");
                        // Lógica para la opción 1
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Has seleccionado la Opción 2.");
                        // Lógica para la opción 2
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Has seleccionado la Opción 3.");
                        // Lógica para la opción 3
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Has seleccionado la Opción 4.");
                        // Lógica para la opción 4
                        break;
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
}
