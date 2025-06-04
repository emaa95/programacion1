package Clase6_POO_V2;

import Clase6_POO_V2.clases.*;
import javax.swing.JOptionPane;

public class demoHospitalGUI {
    public static void main(String[] args) {
        Empleado medico = new Medico("Dra. Ana Torres", "12345678", (byte) 45, 150000, "Cardiología", 30);
        Empleado enfermero = new Enfermero("Carlos Medina", "87654321", (byte) 34, 95000, "Urgencias", "Noche");
        Empleado administrativo = new Administrativo("Lucía Gómez", "11223344", (byte) 29, 85000, "Finanzas", 12);

        mostrarEmpleado(medico, "Médico");
        mostrarEmpleado(enfermero, "Enfermero");
        mostrarEmpleado(administrativo, "Administrativo");

        JOptionPane.showMessageDialog(null, "Cantidad de Empleados: " + Empleado.getnEmpleados(), "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarEmpleado(Empleado emp, String tipo) {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo: ").append(tipo).append("\n");
        sb.append("Legajo: ").append(emp.getLegajo()).append("\n");
        sb.append("Nombre: ").append(emp.getNombre()).append("\n");
        sb.append("DNI: ").append(emp.getDni()).append("\n");
        sb.append("Edad: ").append(emp.getEdad()).append("\n");
        sb.append("Sueldo Base: $").append(emp.getSueldoBase()).append("\n");

        if (emp instanceof Medico) {
            Medico m = (Medico) emp;
            sb.append("Especialidad: ").append(m.getEspecialidad()).append("\n");
            sb.append("Pacientes atendidos: ").append(m.getPacientesAtendidos()).append("\n");
        } else if (emp instanceof Enfermero) {
            Enfermero e = (Enfermero) emp;
            sb.append("Área: ").append(e.getArea()).append("\n");
            sb.append("Turno: ").append(e.getTurno()).append("\n");
        } else if (emp instanceof Administrativo) {
            Administrativo a = (Administrativo) emp;
            sb.append("Departamento: ").append(a.getDepartamento()).append("\n");
            sb.append("Tareas asignadas: ").append(a.getTareasAsignadas()).append("\n");
        }

        sb.append("Sueldo Final: $").append(emp.calcularSueldoFinal());

        JOptionPane.showMessageDialog(null, sb.toString(), "Empleado", JOptionPane.INFORMATION_MESSAGE);
    }
}