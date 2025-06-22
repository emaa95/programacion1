package actIntegr3.clases;

import actIntegr3.inputOutputJOP.*;

public class Camion extends Vehiculo{
    private double tara;
    private double pesoCarga;
    private int numeroEjes;
    
    public Camion () {

    }

    public Camion(String marca, String modelo, String color, Double consumoCombustible, int velocidadMaxima,
            double tara, double pesoCarga, int numeroEjes) {
        super(marca, modelo, color, consumoCombustible, velocidadMaxima);
        this.tara = tara;
        this.pesoCarga = pesoCarga;
        this.numeroEjes = numeroEjes;
    }

    @Override
    public double calcularConsumoCombustible(double distancia) {
        double consumoBase = 0.3;
        double pesoTotal = (tara +pesoCarga) / 1000.0;
        double factorEjes = 1 + (numeroEjes * 0.05);
        double consumoTotal = consumoBase * pesoTotal * factorEjes * distancia;
        return consumoTotal;
    }

    @Override
    public void acelerar() {
        System.out.println("El camión acelera lentamente.");
    }

    @Override
    public void frenar() {
        System.out.println("El camión frena con fuerza.");
    }

    @Override
    public String mostrarDatos() {
        StringBuilder data = new StringBuilder(super.mostrarDatos());
        data.append("\nTara: ").append(tara);
        data.append("\nPeso de carga: ").append(pesoCarga);
        data.append("\nNúmero de ejes: ").append(numeroEjes);
    return data.toString();
}


    @Override
    public void cargarDatos() {
        super.cargarDatos();
        this.tara = Ingreso.leerDouble("Ingrese la tara: ");
        this.pesoCarga = Ingreso.leerDouble("Peso de carga (kg): ");
        this.numeroEjes = Ingreso.leerEnteroPositivo("Ingrese el número de ejes: ");    
    }
    
}
