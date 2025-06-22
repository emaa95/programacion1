package actIntegr3.clases;

import actIntegr3.inputOutputJOP.Ingreso;

public class Auto extends Vehiculo{
    private int cantidadPasajeros;
    private int cantidadPuertas;
    private String tipoCombustible;

    public Auto (){

    }
    
    public Auto(String marca, String modelo, String color, Double consumoCombustible, int velocidadMaxima,
            int cantidadPasajeros, int cantidadPuertas, String tipoCombustible) {
        super(marca, modelo, color, consumoCombustible, velocidadMaxima);
        this.cantidadPasajeros = cantidadPasajeros;
        this.cantidadPuertas = cantidadPuertas;
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public double calcularConsumoCombustible(double distancia) {
        double consumoBase;

        switch (tipoCombustible.toLowerCase()) {
            case "nafta":
                consumoBase = 7.5;
                break;
            
            case "diesel": 
                consumoBase = 6.0;
                break;

            default:
                consumoBase = 8.0;
        }

        double factorPasajeros = 1 + (cantidadPasajeros * 0.02);

        double factorPuertas = 1 + ((cantidadPuertas -2)* 0.01);

        double consumoTotal = (consumoBase / 100.0) * distancia * factorPasajeros * factorPuertas;

        return consumoTotal;
    }

    @Override
    public void acelerar() {
        System.out.println("El auto acelera rápidamente.");
    }

    @Override
    public void frenar() {
        System.out.println("El auto frena suavemente.");
    }

    @Override
    public String mostrarDatos() {
        StringBuilder data = new StringBuilder(super.mostrarDatos());
        data.append("\nCantidad de pasajeros: ").append(cantidadPasajeros);
        data.append("\nCantidad de puertas: ").append(cantidadPuertas);
        data.append("\nTipo de combustible: ").append(tipoCombustible);
    return data.toString();
}


    @Override
    public void cargarDatos() {
        super.cargarDatos();
        this.cantidadPasajeros = Ingreso.leerEnteroPositivo("Ingrese la cantidad de pasajeros: ");
        this.cantidadPuertas = Ingreso.leerEnteroPositivo("Ingrese la cantidad de puertas: ");
        this.tipoCombustible = Ingreso.leerString("Ingrese el tipo de combustible: ");
    }

}
