package actIntegr3;

import javax.swing.JOptionPane;

import actIntegr3.clases.Auto;
import actIntegr3.clases.Camion;
import actIntegr3.clases.Colectivo;
import actIntegr3.clases.Vehiculo;
import actIntegr3.inputOutputJOP.*; 

public class Main {
    public static void main(String[] args) {
        String[] opciones = {"Camion", "Auto", "Colectivo"};
    
        String tipo = opciones [Ingreso.nOpciones("Elija una opcion", opciones, "Tipo de vehículo")];
        Vehiculo vehiculo = null;
        
        switch (tipo) {
            case "Camion" -> vehiculo = new Camion();
            case "Auto" -> vehiculo = new Auto();
            case "Colectivo" -> vehiculo = new Colectivo();
        }

        vehiculo.cargarDatos();

        double distancia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la distancia a recorrer (km):"));
        double consumoTotal = vehiculo.calcularConsumoCombustible(distancia);

        vehiculo.acelerar();
        vehiculo.frenar();

        JOptionPane.showMessageDialog(null,
                "Consumo estimado: " + consumoTotal + " litros.\nVehículos creados: " + Vehiculo.getContadorVehiculos());

        String datos = vehiculo.mostrarDatos();
        Salida.mMensaje(datos, "Datos del vehículo");
    }
}
