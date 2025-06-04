package Clase6_POO_V2.clases;

import Clase6_POO_V2.inputOuput.*;

public class Empleado {
    private String nombre;
    private String dni;
    private byte edad;
    private static int numLegajo = 100; // Numerador de legajos
    private int legajoEmpleado;
    private double sueldoBase;
    private static int nEmpleados = 0;

    /*------------------------------------------------------------- */
    /* Constructor con Argumentos */
    /*------------------------------------------------------------- */
    public Empleado(String nombre, String dni, byte edad, double sueldoBase) {
        numLegajo++;
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.legajoEmpleado = numLegajo;
        this.sueldoBase = sueldoBase;
        nEmpleados++;
    }

    /*------------------------------------------------------------- */
    /* Constructor por defecto */
    /*------------------------------------------------------------- */
    public Empleado() {
        numLegajo++;
        this.nombre = "";
        this.dni = "";
        this.edad = 0;
        this.legajoEmpleado = numLegajo;
        this.sueldoBase = 0d;
        nEmpleados++;
    }

    /*------------------------------------*/
    /* METODO MOSTRAR DATOS */
    /*------------------------------------*/
    public String mostrarDatos() {
        StringBuilder data = new StringBuilder("Datos:");
        data.append("\nLegajo: ").append(this.legajoEmpleado);
        data.append("\nnombre: ").append(this.nombre);
        data.append("\ndni: ").append(this.dni);
        data.append("\nedad: ").append(this.edad);
        String datos = data.toString();
        return datos;
    }

    /*------------------------------------*/
    /* METODO CALCULAR SUELDO */
    /*-------------------------------- */
    public double calcularSueldoFinal() {
        double sueldo = 0;
        return sueldo;
    }

    /*------------------------------------*/
    /* METODO CARGAR DATOS */
    /*-------------------------------- */
    public void cargarDatos() {
        this.nombre = Ingreso.datoString("Ingrese el nombre del empleado", "Ingreso", 1);
        this.dni = Ingreso.datoString("Ingrese el DNI del empleado:", "Ingreso", 1);
        this.edad = (byte) Ingreso.datoByte("Ingrese la edad del Empleado", "Ingreso", 1);
        this.sueldoBase = Ingreso.datoDoble("Ingrese el sueldo base del empleado: ", "Ingreso", 1);
    }

    /*------------------------------------*/
    /* GETTERS Y SETTERS */
    /*------------------------------------*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getLegajo() {
        return legajoEmpleado;
    }

    public static int getnEmpleados() {
        return nEmpleados;
    }

    public static int getProxLegajo() {
        return numLegajo;
    }
}
