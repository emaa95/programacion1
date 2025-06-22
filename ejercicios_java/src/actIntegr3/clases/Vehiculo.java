package actIntegr3.clases;

import Clase6_POO_V2.inputOuput.Salida;
import actIntegr3.inputOutputJOP.Ingreso;

public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected String color;
    protected double consumoCombustible;
    protected int velocidadMaxima;

    private static int contadorVehiculos = 0;

    public Vehiculo() {
        contadorVehiculos ++;
    }

    public Vehiculo(String marca, String modelo, String color, Double consumoCombustible, int velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.consumoCombustible = consumoCombustible;
        this.velocidadMaxima = velocidadMaxima;
    }

    public abstract double calcularConsumoCombustible(double distancia);

    public abstract void acelerar();

    public abstract void frenar();

    public static int getContadorVehiculos() {
        return contadorVehiculos;
    }

   public String mostrarDatos() {
    StringBuilder data = new StringBuilder();
    data.append("Marca: ").append(marca)
        .append("\nModelo: ").append(modelo)
        .append("\nColor: ").append(color)
        .append("\nConsumo combustible (L/100km): ").append(consumoCombustible)
        .append("\nVelocidad máxima: ").append(velocidadMaxima).append(" km/h");
    return data.toString();
}


    public void cargarDatos () {
        this.marca = Ingreso.leerString("Ingrese la marca: ");
        this.modelo = Ingreso.leerString("Ingrese el modelo: ");
        this.color = Ingreso.leerString("Ingrese el color: ");
        this.consumoCombustible = Ingreso.leerDoublePositivo("Ingrese el consumo de combustible(L/100km): ");
        this.velocidadMaxima = Ingreso.leerEnteroPositivo("Ingrese la velocidad máxima: ");
    }

    
}
