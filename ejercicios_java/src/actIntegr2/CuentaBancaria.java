package actIntegr2;

import javax.swing.JOptionPane;

import actIntegr2.utils.ValidadorEntrada;

/*
 * Crear una clase CuentaBancaria que represente una cuenta bancaria con los siguientes atributos:
 Atributos:
1. Una variable estática totalCuentas de tipo int que lleve el conteo de cuántas cuentas bancarias se han creado.
2. Un atributo titularCuenta de tipo String que almacene el nombre del titular de la cuenta bancaria.
3. Un atributo numeroCuenta de tipo String que almacene el número único de la cuenta bancaria.
4. Un atributo saldo de tipo double que almacene el saldo actual de la cuenta.
5. Un atributo estado de tipo boolean que indique si la cuenta está activa (true) o inactiva (false).
6. Un tipo de dato enum llamado TipoCuenta con los valores: CAJA_AHORRO, CUENTA_CORRIENTE,
CUENTA_SUELDO, que representa el tipo de cuenta.
 Constructores sobrecargados:
1. Un constructor que reciba numeroCuenta, saldo , tipoCuenta y estado como parámetros.
2. Un constructor que reciba numeroCuenta y tipoCuenta como parámetros, asignando por defecto el saldo como 0 y
estado como true (cuenta activa).
 Métodos:
 Getters y Setters para todos los atributos ( numeroCuenta, saldo, estado, tipoCuenta ).
 Un método depositar(double monto) que reciba un valor y lo sume al saldo actual si la cuenta está activa. Si la
cuenta está inactiva, no debe realizar la operación.
 Un método retirar(double monto) que permita retirar dinero de la cuenta si hay suficiente saldo y la cuenta está
activa. Si no hay suficiente saldo o la cuenta está inactiva, debe devolver un mensaje indicando que no se puede
realizar la operación.
 Un método desactivarCuenta() que cambie el estado de la cuenta a false , lo que implica que la cuenta ha sido
desactivada.
 Un método activarCuenta() que permita cambiar el estado de la cuenta a true para reactivar la cuenta si ha sido
deshabilitada.
 Crear un Método cargarCuenta() que permita cargar los datos de la cuenta utilizando la Librería Scanner y
JOptionPane
 Crear un Método mostrarDatosCuenta() que permita mostrar los datos de la cuenta utilizando la salida por consola
o JOptionPane
 Reglas de negocio:
 Si la cuenta está inactiva, no se puede depositar ni retirar dinero.
 El número de cuenta debe ser único y no modificable una vez asignado.
 totalCuentas debe incrementarse cada vez que se cree una nueva cuenta.
 No puede desactivar una cuenta que tenga saldo, salvo que se permita (debe tener la opción de permitirle)
 Crear un programa Principal (DemoCuentaBancaria)
 Que permita instanciar 3 objetos del tipo cuenta Bancaria.
 Utilizar los distintos métodos para modificar y mostrar la información de los atributos.
 Crear un método (dentro del Main) para que pueda comparar y mostrar la Cuenta con mayor Saldo.
 Mostrar el cada momento el número de Cuentas creadas.
 Crear un programa Principal (DemoCuentaBancariaMenu)
 Crear un Menú que permita interactuar con un objeto y con todos los métodos de la clase.
 */
public class CuentaBancaria {
  
    private String titularCuenta;
    private String numeroCuenta;
    private double saldo;
    private boolean estado;
    private TipoCuenta tipoCuenta;
    private static int totalCuentas = 0;

    public enum TipoCuenta {
        CAJA_AHORRO,
        CUENTA_CORRIENTE,
        CUENTA_SUELDO
    }

    
    public CuentaBancaria(String titularCuenta, String numeroCuenta, double saldo, boolean estado,
        TipoCuenta tipoCuenta) {
        this.titularCuenta = titularCuenta;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.estado = estado;
        this.tipoCuenta = tipoCuenta;

        totalCuentas ++;
    }

    public CuentaBancaria(String numeroCuenta, double saldo,TipoCuenta tipoCuenta, boolean estado) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
        this.estado = estado;
    }

    public CuentaBancaria(String numeroCuenta, TipoCuenta tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = 0.0;
        this.estado = true;
    }

    public static int getTotalCuentas() {
        return totalCuentas;
    }

    public String getTitularCuenta() {
        return titularCuenta;
    }

    public void setTitularCuenta(String titularCuenta) {
        this.titularCuenta = titularCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double depositar(double monto) {
        if (estado) {
            if (monto <= 0) {
                System.out.println("No se puede ingresar un monto menor o igual a 0");
            } else {
            saldo += monto;
            }
        } else {
            System.out.println("No se puede depositar en una cuenta inactiva.");
        }
        return saldo;
    }

    public void retirar (double monto) {
        if (estado) {
            if (saldo >= monto) {
                saldo -= monto;
                System.out.println("La operación se realizó con éxito");
            } else{
                System.out.println("No se pudo realizar la operación - Saldo insuficiente");
            } 
        } else {
            System.out.println("No se pudo realizar la operación - Cuenta inanctiva");
        }
    }

    public void desactivarCuenta () {
        if (saldo == 0){
            estado = false;
            System.out.println("La cuenta ha sido desactivada.");
        } else {
            System.out.println("No se puede desactivar una cuenta que tiene saldo");
        }
    }

    public void activarCuenta () {
        estado = true;
    }

    public void cargarCuenta() {
        
        titularCuenta = ValidadorEntrada.leerString("Ingrese el nombre del titular: ");

        numeroCuenta = ValidadorEntrada.leerNumeroCuenta("Ingrese el número de cuenta: ");

        saldo = ValidadorEntrada.leerDoublePositivo("Ingrese el saldo de la cuenta: ");

        int estadoSeleccionado  = JOptionPane.showConfirmDialog(null,"¿La cuenta esta activa?", "Estado de la cuenta", JOptionPane.YES_NO_OPTION);

        if (estadoSeleccionado == JOptionPane.YES_OPTION) {
            estado = true;
        } else {
            estado = false;
        }
        
        String[] opciones = {"CAJA_AHORRO", "CUENTA_CORRIENTE", "CUENTA_SUELDO"};
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione el tipo de cuenta:","Tipo de Cuenta",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, opciones, opciones[0]);
        tipoCuenta = TipoCuenta.valueOf(opciones[seleccion]);

    }

    public void mostrarDatosCuenta() {
        String mensaje = "Titular: " + titularCuenta +
                         "\nNúmero de Cuenta: " + numeroCuenta +
                         "\nSaldo: $" + saldo +
                         "\nEstado: " + (estado ? "Activa" : "Inactiva") +
                         "\nTipo de Cuenta: " + tipoCuenta;
    
        JOptionPane.showMessageDialog(null, mensaje, "Datos de la Cuenta", JOptionPane.INFORMATION_MESSAGE);
    }

}
