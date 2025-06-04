package Clase6_POO_V2.clases;

import Clase6_POO_V2.inputOuput.Ingreso;

public class Enfermero extends Empleado {
    private String area;
    private String turno;

    public Enfermero(String nombre, String dni, byte edad, double sueldoBase, String area, String turno) {
        super(nombre, dni, edad, sueldoBase);
        this.area = area;
        this.turno = turno;
    }

    public Enfermero(String especialidad, int pacientesAtendidos) {
        super();
        this.area = area;
        this.turno = turno;
    }

    public Enfermero() {
        super();
        this.area = area;
        this.turno = turno;
    }

    /*------------------------------------*/
    /* METODO MOSTRAR DATOS */
    /*------------------------------------*/
    public String mostrarDatos() {
        StringBuilder data = new StringBuilder();
        data.append(super.mostrarDatos());
        data.append("\nArea: ").append(area);
        data.append("\nTurno: ").append(turno);
        data.append("\nSueldo Base: $").append(getSueldoBase());
        data.append("\nSueldo Final: $").append(calcularSueldoFinal());
        String datos = data.toString();
        return datos;
    }

    /*------------------------------------*/
    /* METODO CARGAR DATOS */
    /*-------------------------------- */
    public void cargarDatos() {
        String[] opcArea = { "Enfermería", "Guardia", "Quirófano" };
        String[] opcTurno = { "Mañana", "Tarde", "Noche" };
        super.cargarDatos();
        this.area = opcArea[Ingreso.nOpciones("Seleccione el Area", opcArea, "Ingreso")];
        System.out.println(this.area);
        this.turno = opcTurno[Ingreso.nOpciones("Seleccione el Turno", opcTurno, "Ingreso")];
        System.out.println(this.turno);

    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    /*----------------------------------*/
    /* Calculo de Sueldo Final */
    /*----------------------------------*/
    public double calcularSueldoFinal() {
        return turno.equalsIgnoreCase("Noche") ? getSueldoBase() + 500 : getSueldoBase();
    }

}
