package Clase6_POO_V2;

import Clase6_POO_V2.clases.*;
import Clase6_POO_V2.inputOuput.*;

public class demoHospital {
    public static void main(String[] args) {        

        Medico m1 = new Medico();
        m1.cargarDatos();
        Salida.mMensaje(m1.mostrarDatos(),"Datos del Medico");
        nroEmpleados();

        Enfermero e1 = new Enfermero();
        e1.cargarDatos();
        Salida.mMensaje(e1.mostrarDatos(), "Datos del Enfermero");
        nroEmpleados();

        Administrativo a1 = new Administrativo();
        a1.cargarDatos();
        Salida.mMensaje(a1.mostrarDatos(), "Datos del Administrativo");
        nroEmpleados();
    }
    public static void nroEmpleados() {
         Salida.mMensaje("Cantidad de empleados: "+Empleado.getnEmpleados(), "sdasadas");

    }

}
