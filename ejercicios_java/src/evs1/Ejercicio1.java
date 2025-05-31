package evs1;


import java.io.IOException;
import java.util.Scanner;

/* 
Escribir un programa que permita calcular el perímetro y la superficie de distintas figuras geométricas
(Círculos, triángulos (ojo), rectángulos, cuadrados, heptagono y octógono) mediante procedimientos.
Crear un menú que permita seleccionar la figura y de acuerdo a la selección llamar a los procedimientos
para el calculo correspondiente.
Para los métodos deben utilizar distintos tipos de retorno void, float, double, según corresponda al llamado del método.  Controlar el ingreso de datos por teclado utilizando control de excepciones.
*/

public class Ejercicio1 {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        int option = -1, opcionT = -1;
        double lado,lado1, lado2, lado3, perimetro, superficie;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); /*  */
                System.out.println("╔═════════════════════════╗"); /* 201 ╔ 205 ═ 200 ╚ 187╗ 186 ║ 188 ╝ */
                System.out.println("║   Seleccione la opcion  ║");
                System.out.println("╚═════════════════════════╝");
                System.out.println("\t1.circulo");
                System.out.println("\t2.triangulo");
                System.out.println("\t3.rectangulo");
                System.out.println("\t4.cuadrado");
                System.out.println("\t5.heptagono");
                System.out.println("\t6.octogono");
                System.out.println("\t0.salir");

                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Error de Ingreso de datos");
            }
            switch (option) {
                case 1:
                    System.out.println("Seleccionado Circulo");
                    calcularCirculo(sc);
                    break;

                case 2:
                    opcionT = mostrarMenuTriangulo(sc);
                    switch (opcionT) {
                        case 1:
                            System.out.println("Equilatero");
                            lado = leerDoublePositivo(sc, "Ingrese el lado: ");
                            perimetro = calcularPerimetroTriangulos(lado, lado, lado); 
                            superficie = calcSuperficieTriangulos(lado, lado, lado);
                            System.out.println("El perímetro del triángulo equilatero es: " + perimetro);
                            System.out.println("La superficie del triángulo equilatero es: " + superficie);
                            break;
                        case 2:
                            System.out.println("Isósceles");
                            do {
                                lado1 = leerDoublePositivo(sc, "Ingrese el valor de los lados iguales: ");
                                lado3 = leerDoublePositivo(sc, "Ingrese el valor del otro lado: ");
                        
                                if (!esTrianguloValido(lado1, lado1, lado3)) {
                                    System.out.println("Los lados ingresados no forman un triángulo isósceles válido. Intente de nuevo.");
                                }
                            } while (!esTrianguloValido(lado1, lado1, lado3));                        
                            perimetro = calcularPerimetroTriangulos(lado1, lado1, lado3); 
                            superficie = calcSuperficieTriangulos(lado1, lado1, lado3);
                            System.out.println("El perímetro del triángulo isósceles es: " + perimetro);
                            System.out.println("La superficie del triángulo isósceles es: " + superficie);
                            break;
                        case 3:
                            System.out.println("Escaleno");
                                do {
                                    lado1 = leerDoublePositivo(sc, "Ingrese el lado 1: ");
                                    lado2 = leerDoublePositivo(sc, "Ingrese el lado 2: ");
                                    lado3 = leerDoublePositivo(sc, "Ingrese el lado 3: ");
                            
                                    if (!esTrianguloValido(lado1, lado2, lado3)) {
                                        System.out.println("Los lados ingresados no forman un triángulo válido. Intente de nuevo.");
                                    }
                                } while (!esTrianguloValido(lado1, lado2, lado3));

                            perimetro = calcularPerimetroTriangulos(lado1, lado2, lado3); 
                            superficie = calcSuperficieTriangulos(lado1, lado2, lado3);
                            System.out.println("El perímetro del triángulo escaleno es: " + perimetro);
                            System.out.println("La superficie del triángulo escaleno es: " + superficie);
                            
                            break;

                        default:
                            System.out.println("Error de selección");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Seleccionado Rectángulo");
                    double base =  leerDoublePositivo(sc, "Ingrese la base del rectángulo: ");
                    double altura = leerDoublePositivo(sc, "Ingrese la altura del rectángulo: ");
                    System.out.println("El perímetro del rectángulo es: " + perimetroRectangulo(base, altura));
                    System.out.println("La superficie del rectángulo es: " + superficieRectangulo(base, altura));
                    break;

                case 4:
                    System.out.println("Seleccionado Cuadrado");
                    lado = leerDoublePositivo(sc, "Ingrese el lado del cuadrado: ");
                    System.out.println("El perímetro del cuadrado es: " + calcularPerimetroPoligonoReg(4, lado));
                    System.out.println("La superficie del cuadrado es: " + calcularSuperficiePoligonoReg(4,lado) );
                    break;

                case 5:
                    System.out.println("Seleccionado Heptágono");
                    lado = leerDoublePositivo(sc, "Ingrese el lado del heptágono: ");
                    System.out.println("El perímetro del heptágono es: " + calcularPerimetroPoligonoReg(7, lado));
                    System.out.println("La superficie del heptágono es: " + calcularSuperficiePoligonoReg(7, lado));
                    break;

                case 6:
                    System.out.println("Seleccionado Octógono");
                    lado = leerDoublePositivo(sc, "Ingrese el lado del Octógono: ");
                    System.out.println("El perímetro del octógono es: " + calcularPerimetroPoligonoReg(8, lado));
                    System.out.println("La superficie del octógono es: " + calcularSuperficiePoligonoReg(8, lado));
                    break;

                case 0:
                    System.out.println("Hasta luego");
                    break;

                default:
                    System.out.println("Ingrese una opción válida.");
                    break;
            }
            if (option != 0) {
                System.out.print("\nPresione una tecla para continuar...");
                sc.nextLine();
            }

        } while (option != 0);

        sc.close();
    }

    public static double leerDoublePositivo(Scanner sc, String mensaje) {
        boolean repetir;
        double valor = 0;
        do {
            repetir = false;
            try {
                System.out.print(mensaje);
                valor = Double.parseDouble(sc.nextLine());

                if (valor <= 0) {
                    System.out.println("Debe ingresar un decimal mayor a 0. Intente de nuevo");
                    repetir = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
                repetir = true;
            }
        } while (repetir);
        return valor;
    }
    

    public static void calcularCirculo(Scanner sc){
        System.out.println("Haz seleccionado el circulo");
        double radio = leerDoublePositivo(sc, "Ingrese el radio:");
        double perimetro = perimetroCirculo(radio);
        double superficie = superficieCirculo(radio);

        System.out.println("Perímetro del círculo: " + perimetro);
        System.out.println("Superficie del círculo: " + superficie);
    }

    public static double calcularPerimetroPoligonoReg(int cantLados, double lado) {
        double perimetro = lado * cantLados;
        return perimetro;
    }

    public static double calcularSuperficiePoligonoReg (int cantLados, double lado) {
        double apotema = lado / (2*Math.tan(Math.PI/cantLados));
        double superficie = (lado * cantLados * apotema) / 2;
        return superficie;
    }

    public static double perimetroCirculo (double radio) {
        return 2*Math.PI*radio;
    }

    public static double superficieCirculo (double radio) {
        return Math.PI * Math.pow(radio, 2);
    }

    public static double perimetroRectangulo (double base, double altura ) {
        return 2*(base + altura);
    }

    public static double superficieRectangulo (double base, double altura) {
        return base*altura;
    }

    public static Double calcSuperficieTriangulos (double lado1, double lado2, double lado3) {
        double s = (lado1+lado2+lado3) / 2;
        return Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
    }

    public static int mostrarMenuTriangulo(Scanner sc) {
        int opcion = -1;
        try {
            System.out.println("Seleccionado Triángulo");
            System.out.println("╔═════════════════════════╗");
            System.out.println("║   Seleccione triángulo  ║");
            System.out.println("╚═════════════════════════╝");
            System.out.println("\t1. Equilátero");
            System.out.println("\t2. Isósceles");
            System.out.println("\t3. Escaleno");
            opcion = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Error de selección.");
        }
        return opcion;
    }

    public static boolean esTrianguloValido(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public static double calcularPerimetroTriangulos (double lado1, double lado2, double lado3){
        return lado1 + lado2 + lado3;
    }
}

