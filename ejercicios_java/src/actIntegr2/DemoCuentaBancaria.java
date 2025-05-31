package actIntegr2;

import actIntegr2.CuentaBancaria.TipoCuenta;

public class DemoCuentaBancaria {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("Juan Perez", "1234567890", 1000.0, true, TipoCuenta.CAJA_AHORRO);
        CuentaBancaria cuenta2 = new CuentaBancaria("Maria Gomez", "0987654321", 2000.0, true, TipoCuenta.CUENTA_CORRIENTE);
        CuentaBancaria cuenta3 = new CuentaBancaria("Carlos Lopez", "1122334455", 1500.0, true, TipoCuenta.CUENTA_SUELDO);
        
        DemoCuentaBancariaMenu menu = new DemoCuentaBancariaMenu(); 

        cuenta1.retirar(1000);
        cuenta1.mostrarDatosCuenta();
        cuenta1.desactivarCuenta();
        cuenta1.activarCuenta();
        cuenta1.depositar(100);
        cuenta1.mostrarDatosCuenta();

        cuenta2.retirar(1500);
        cuenta2.mostrarDatosCuenta();

        cuenta3.depositar(2000);
        cuenta3.mostrarDatosCuenta();

        
        double saldo1 = cuenta1.getSaldo();
        double saldo2 = cuenta2.getSaldo();
        double saldo3 = cuenta3.getSaldo();

        double mayorSaldo = obtenerMayorSaldo(saldo1, saldo2, saldo3);

        if (mayorSaldo == saldo1) {
            System.out.println("\nLa cuenta con mayor saldo es: " + cuenta1.getNumeroCuenta() + " con saldo: " + saldo1);
        } else if (mayorSaldo == saldo2) {
            System.out.println("\nLa cuenta con mayor saldo es: " + cuenta2.getNumeroCuenta() + " con saldo: " + saldo2);
        } else {
            System.out.println("\nLa cuenta con mayor saldo es: " + cuenta3.getNumeroCuenta() + " con saldo: " + saldo3);
        }

        menu.mostrarMenu(cuenta1);
    }

    public static double obtenerMayorSaldo(double saldo1, double saldo2, double saldo3) {
        double mayorSaldo = saldo1;

        if (saldo2 > mayorSaldo){
            mayorSaldo = saldo2;
        }

        if (saldo3 > mayorSaldo){
            mayorSaldo = saldo3;
        }

        return mayorSaldo;
    }
}
