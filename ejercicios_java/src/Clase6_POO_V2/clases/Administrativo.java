package Clase6_POO_V2.clases;

import Clase6_POO_V2.inputOuput.Ingreso;

public class Administrativo extends Empleado {
    private String departamento;
    private int tareasAsignadas;

    public Administrativo(String nombre, String dni, byte edad, double sueldoBase, String depto, int tarAsign) {
        super(nombre, dni, edad, sueldoBase);
        this.departamento = depto;
        this.tareasAsignadas = tarAsign;
    }

    public Administrativo() {
        super();
        this.departamento = "";
        this.tareasAsignadas = 0;
    }

    /*------------------------------------*/
    /* METODO MOSTRAR DATOS */
    /*------------------------------------*/
    public String mostrarDatos() {
        StringBuilder data = new StringBuilder();
        data.append(super.mostrarDatos());
        data.append("\nArea: ").append(departamento);
        data.append("\nTareas Asignadas: ").append(tareasAsignadas);
        data.append("\nSueldo Base: $").append(getSueldoBase());
        data.append("\nSueldo Final: $").append(calcularSueldoFinal());
        String datos = data.toString();
        return datos;
    }

    /*------------------------------------*/
    /* METODO CARGAR DATOS */
    /*-------------------------------- */
    public void cargarDatos() {
        String[] depto = { "Recursos Humanos", "Compras y Suministros", "Atención al Paciente" };
        super.cargarDatos();
        this.departamento = depto[Ingreso.nOpciones("Seleccione el Area", depto, "Ingreso")];
        System.out.println(this.departamento);
        this.tareasAsignadas = Ingreso.datoEntero("Ingrese las Tareas Asignadas: ", "Ingreso", 1);

    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getTareasAsignadas() {
        return tareasAsignadas;
    }

    public void setTareasAsignadas(int tareasAsignadas) {
        this.tareasAsignadas = tareasAsignadas;
    }

    /*----------------------------------*/
    /* Calculo de Sueldo Final */
    /*----------------------------------*/
    public double calcularSueldoFinal() {
        return getSueldoBase() + (tareasAsignadas * 300);
    }

}
