package actIntegr1;

import javax.swing.JOptionPane;
public class Actividad1 {
    public static void main(String[] args) {
        

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del trabajador:");
        int antiguedad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los años de antigüedad:"));
        double sueldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el sueldo del trabajador:"));

        double bonoAntiguedad = bonoMensualAntiguedad(antiguedad, sueldo);
        double bonoSueldo = bonoMensualXMonto(sueldo);

        double bonoFinal = Math.max(bonoAntiguedad, bonoSueldo);

        String mensaje = "Trabajador: " + nombre + "\n" +
                         "Antigüedad: " + antiguedad + " años\n" +
                         "Sueldo: $" + sueldo + "\n\n" +
                         "Bono por antigüedad: $" + bonoAntiguedad + "\n" +
                         "Bono por sueldo: $" + bonoSueldo + "\n\n" +
                         ">>> Bono otorgado: $" + bonoFinal;

        JOptionPane.showMessageDialog(null, mensaje, "Resultado del Bono", JOptionPane.INFORMATION_MESSAGE);
    }

    public static double bonoMensualAntiguedad(int antiguedad, double sueldo) {
        double sueldoFinal = sueldo;  
    
        if (antiguedad > 2 && antiguedad < 5) {
            sueldoFinal = sueldo + sueldo * 0.2;  
        } else if (antiguedad >= 5) {
            sueldoFinal = sueldo + sueldo * 0.3;  
        } else {
            System.out.println("No hay bono por antigüedad");
        }
    
        return sueldoFinal;
    }
    

    public static double bonoMensualXMonto(double sueldo) {
        double sueldoFinal = sueldo;  
    
        if (sueldo <= 1000) {
            sueldoFinal = sueldo + sueldo * 0.25;  
        } else if (sueldo > 1000 && sueldo <= 3500) {
            sueldoFinal = sueldo + sueldo * 0.15;  
        } else if (sueldo > 3500) {
            sueldoFinal = sueldo + sueldo * 0.1;  
        } else {
            System.out.println("No hay bono por monto de sueldo");
        }
    
        return sueldoFinal;
    }
    
}
