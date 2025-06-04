package Clase6_POO_V2.clases;

import Clase6_POO_V2.inputOuput.Ingreso;

public class Medico extends Empleado {
    private String especialidad;
    private int pacientesAtendidos;

    public Medico(String nombre, String dni, byte edad, double sueldoBase, String especialidad, int pacientesAtendidos) {
        super(nombre, dni, edad, sueldoBase);
        this.especialidad = especialidad;
        this.pacientesAtendidos = pacientesAtendidos;
    }

    public Medico(String especialidad, int pacientesAtendidos) {
        super();
        this.especialidad = especialidad;
        this.pacientesAtendidos = pacientesAtendidos;
    }

    public Medico() {
        super();
        this.especialidad = "";
        this.pacientesAtendidos = 0;
    }

    /*------------------------------------*/
    /* METODO MOSTRAR DATOS */
    /*------------------------------------*/
    public String mostrarDatos() {
        StringBuilder data = new StringBuilder();
        data.append(super.mostrarDatos());
        data.append("\nEspecialidad: ").append(especialidad);
        data.append("\nPacientes Atendidos: ").append(pacientesAtendidos);
        data.append("\nSueldo Base: $").append(getSueldoBase());
        data.append("\nSueldo Final: $").append(calcularSueldoFinal());
        String datos = data.toString();
        return datos;
    }

    /*------------------------------------*/
    /* METODO CARGAR DATOS */
    /*-------------------------------- */
    public void cargarDatos() {
        super.cargarDatos();
        String[] opcEspecialidad = { "Clínica Médica","Cardiólogía","Oftalmología"};
        this.especialidad = opcEspecialidad[Ingreso.nOpciones("Seleccione la Especialidad", opcEspecialidad, "Ingreso")];
        this.pacientesAtendidos = Ingreso.datoEntero("Ingrese los pacientes Atendidos:", "Ingreso", 1);
        // setSueldoBase(Ingreso.datoDoble("Ingrese el sueldo base del empleado: ",
        // "Ingreso", 0));
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getPacientesAtendidos() {
        return pacientesAtendidos;
    }

    public void setPacientesAtendidos(int pacientesAtendidos) {
        this.pacientesAtendidos = pacientesAtendidos;

    }

    /*----------------------------------*/
    /* Calculo de Sueldo Final */
    /*----------------------------------*/
    public double calcularSueldoFinal() {
        return getSueldoBase() + (pacientesAtendidos * 500);
    }

}
