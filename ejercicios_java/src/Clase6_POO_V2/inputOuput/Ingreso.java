package Clase6_POO_V2.inputOuput;

import javax.swing.JOptionPane;

public class Ingreso {
    private static String cError = "Error de Dato";

    /*---------------------------------------*/
    /* Método para ingresar un número entero */
    /*---------------------------------------*/
    public static int datoEntero(String cMensaje, String cTitulo, int icono) {
        int numero = 0;
        boolean valido = false;
        do {
            try {
                String input = JOptionPane.showInputDialog(null, cMensaje, cTitulo, icono);
                numero = Integer.parseInt(input);
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero válido.", cError, 0);
            }
        } while (!valido);
        return numero;
    }

    /*---------------------------------------*/
    /* Método para ingresar un número byte */
    /*---------------------------------------*/
    public static int datoByte(String cMensaje, String cTitulo, int icono) {
        byte numero = 0;
        boolean valido = false;
        do {
            try {
                String input = JOptionPane.showInputDialog(null, cMensaje, cTitulo, icono);
                numero = Byte.parseByte(input);
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido (0-128).", cError, 0);
            }
        } while (!valido);
        return numero;
    }

    /*-------------------------------------------------*/
    /* Método para ingresar un número decimal (double) */
    /*-------------------------------------------------*/
    public static double datoDoble(String cMensaje, String cTitulo, int icono) {
        double numero = 0;
        boolean valido = false;
        do {
            try {
                String input = JOptionPane.showInputDialog(null, cMensaje, cTitulo, icono);
                numero = Double.parseDouble(input);
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número decimal válido.", cError, 0);
            }
        } while (!valido);
        return numero;
    }

    /*------------------------------------------------*/
    /* Método para ingresar un número decimal (float) */
    /*------------------------------------------------*/
    public static float datoFloat(String cMensaje, String cTitulo, int icono) {
        float numero = 0;
        boolean valido = false;
        do {
            try {
                String input = JOptionPane.showInputDialog(null, "Ingrese un número decimal:", cTitulo, icono);
                numero = Float.parseFloat(input);
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número decimal válido.", cError, 0);
            }
        } while (!valido);
        return numero;
    }

    /*----------------------------------------*/
    /* Método para ingresar un valor booleano */
    /*----------------------------------------*/
    public static boolean datoBoolean(String cMensaje, String cTitulo, int icono) {
        boolean valor = false;
        boolean valido = false;
        do {
            try {
                String input = JOptionPane.showInputDialog(null, "Ingrese 'true' o 'false':", cTitulo, icono);
                valor = Boolean.parseBoolean(input);
                valido = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar 'true' o 'false'.", cError, 0);
            }
        } while (!valido);
        return valor;
    }

    /*---------------------------------------*/
    /* Método para ingresar un carácter */
    /*---------------------------------------*/
    public static char datoChar(String cMensaje, String cTitulo, int icono) {
        char caracter = '\0';
        boolean valido = false;
        do {
            try {
                String input = JOptionPane.showInputDialog(null, cMensaje, cTitulo, icono);
                if (input.length() != 1) {
                    throw new Exception("Debe ingresar un solo carácter.");
                }
                caracter = input.charAt(0);
                valido = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), cError, 0);
            }
        } while (!valido);
        return caracter;
    }

    /*---------------------------------------*/
    /* Método para ingresar una cadena */
    /*---------------------------------------*/
    public static String datoString(String cMensaje, String cTitulo, int icono) {
        String cadena = "";
        boolean valido = false;
        do {
            try {
                cadena = JOptionPane.showInputDialog(null, cMensaje, cTitulo, icono);
                if (cadena == null || cadena.isEmpty()) {
                    throw new Exception("La cadena no puede estar vacía.");
                }
                valido = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), cError, 0);
            }
        } while (!valido);
        return cadena;
    }

    /*---------------------------------------*/
    /* Método para seleccionar opciones */
    /*---------------------------------------*/
    public static int nOpciones(String cMensaje, String[] opc, String cTitulo) {
        int seleccion = -1;
        boolean valido = false;
        do {
            try {
                seleccion = JOptionPane.showOptionDialog(null, cMensaje,
                        cTitulo, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, opc, opc[0]);
                if (seleccion == -1)
                    throw new Exception("La Debe seleccionar una Opción");
                valido = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), cError, 0);
            }
        } while (!valido);
        return seleccion;
    }

}