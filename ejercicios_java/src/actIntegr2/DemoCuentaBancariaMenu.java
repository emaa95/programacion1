package actIntegr2;

import javax.swing.JOptionPane;

public class DemoCuentaBancariaMenu {
    
    public void mostrarMenu(CuentaBancaria cuenta) {
        int op ;
        double monto;
        
        do {
            String menu = """
                1. Depositar
                2. Retirar
                3. Activar Cuenta
                4. Desactivar Cuenta
                5. Mostrar Datos
                6. Cargar Cuenta
                7. Ver Total de Cuentas
                0. Salir        
            """;

            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {
                case 1:
                    monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese monto a depositar:"));
                    cuenta.depositar(monto);
                    break;
                
                case 2:
                    monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese monto a retirar:"));
                    cuenta.retirar(monto);
                    break;
                
                case 3:
                    cuenta.activarCuenta();
                    break;
                case 4: 
                    if (cuenta.getSaldo()>0) {
                        int opcion = JOptionPane.showConfirmDialog(null, "La cuenta tiene saldo. ¿Desea desactivarla igual?", "Confirmar", JOptionPane.YES_NO_OPTION);
                        if (opcion == JOptionPane.YES_OPTION) {
                            cuenta.setEstado(false);
                            JOptionPane.showMessageDialog(null, "Cuenta desactivada forzadamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Operación cancelada.");
                        }
                    } else {
                        cuenta.desactivarCuenta();
                    }
                    break;
                
                case 5: 
                    cuenta.mostrarDatosCuenta();
                    break;
                
                case 6: 
                    cuenta.cargarCuenta();
                    break;

                case 7:
                    JOptionPane.showMessageDialog(null, "Total cuentas: " + CuentaBancaria.getTotalCuentas());
                    break;
                case 0: 
                    JOptionPane.showMessageDialog(null, "Saliendo.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
                    break;
            }
        } while (op != 0);   
    }
}


