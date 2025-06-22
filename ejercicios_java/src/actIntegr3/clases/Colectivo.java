package actIntegr3.clases;
import actIntegr3.inputOutputJOP.Ingreso;

public class Colectivo extends Vehiculo{
    public enum TipoColectivo { CORTA, MEDIA, LARGA }

    private int cantidadPasajeros;
    private TipoColectivo tipoColectivo;

    public Colectivo () {

    }
    
    public Colectivo(String marca, String modelo, String color, Double consumoCombustible, int velocidadMaxima,
            int cantidadPasajeros, TipoColectivo tipoColectivo) {
        super(marca, modelo, color, consumoCombustible, velocidadMaxima);
        this.cantidadPasajeros = cantidadPasajeros;
        this.tipoColectivo = tipoColectivo;
    }

    
    public TipoColectivo getTipoColectivo() {
        return tipoColectivo;
    }


    @Override
    public double calcularConsumoCombustible(double distancia) {
        
        double factor = switch (tipoColectivo) {
            case CORTA -> 1.0;
            case MEDIA -> 1.2;
            case LARGA -> 1.5;
        };

        return consumoCombustible * factor * distancia / 100;
    }

    @Override
    public void acelerar() {
        System.out.println("El colectivo acelera moderadamente.");
    }

    @Override
    public void frenar() {
        System.out.println("El colectivo frena suavemente.");
    }

    @Override
    public String mostrarDatos() {
        StringBuilder data = new StringBuilder(super.mostrarDatos());
        data.append("\nCantidad de pasajeros: ").append(cantidadPasajeros);
        data.append("\nTipo de colectivo: ").append(tipoColectivo);
    return data.toString();
}

    @Override
    public void cargarDatos() {
        super.cargarDatos();
        this.cantidadPasajeros = Ingreso.leerEnteroPositivo("Ingrese la cantidad de pasajeros: ");

        TipoColectivo[] valores = TipoColectivo.values();

        String[] tipos = new String[valores.length];
        for (int i = 0; i < valores.length; i++) {
            tipos[i] = valores[i].name();
        }

        this.tipoColectivo = valores[ Ingreso.nOpciones("Seleccione el tipo de colectivo", tipos, "Tipo de colectivo")];

    }
    
}
