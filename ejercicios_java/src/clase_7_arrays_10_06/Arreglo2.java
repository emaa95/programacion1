package clase_7_arrays_10_06;

import java.util.Scanner;

/* Crear un Array de enteros de n x m. Cargue y lea al array mediante métodos */
/* Crear un Metodo que cargue un Vector con la suma de los elementos Fila del array */
/* Mostar el array cargado y el vector Suma */
public class Arreglo2 {
   public static void main(String[] args) throws Exception {
      int[][] aEnteros;
      int[] sumaFilas;
      int m, n;

      Scanner data = new Scanner(System.in);
      System.out.print("Ingrese la cantidad de Filas: ");
      n = data.nextInt();
      System.out.print("Ingrese la cantidad de Columnas: ");
      m = data.nextInt();
      aEnteros = new int[n][m];
      sumaFilas=new int[n] ;

      /* Iniciamos un ciclo para la carga del Vector */
      System.out.println("---------------------------------");
      System.out.println("        CARGA DE LA MATRIZ       ");
      System.out.println("---------------------------------");

      // Llamamos el metodo para cargar la matriz
      cargaMatriz(aEnteros, data);

      /* Leemos con un ciclo los datos de la Matriz */
      System.out.println("---------------------------------");
      System.out.println("      LECTURA DE LA MATRIZ       ");
      System.out.println("---------------------------------");
      // Llamamos el metodo para leer la matriz
      leeMatriz(aEnteros);

      /* cargamos la suma de las filas en el vector sumaFilas */
      sumarLasFilas(aEnteros,sumaFilas);

   }

   /*--------------------------------------------------------- */
   /* METODOS PARA LAS OPERACIONES CON LA MATRIZ */
   /*--------------------------------------------------------- */
   /* CARGA LA MATRIZ */
   /*--------------------------------------------------------- */
   public static void cargaMatriz(int me[][], Scanner idata) {
      for (int i = 0; i < me.length; i++) {
         for (int j = 0; j < me[i].length; j++) {
            System.out.print("Introduzca el elemento [" + i + "," + j + "]: ");
            me[i][j] = idata.nextInt();
         }
      }
   }

   /*--------------------------------------------------------- */
   /* LEE LA MATRIZ */
   /*--------------------------------------------------------- */
   public static void leeMatriz(int me[][]) {
      for (int i = 0; i < me.length; i++) {
         System.out.println("\nFila "+i);
         System.out.println("--------");
         for (int j = 0; j < me[i].length; j++) {
            System.out.println("Elemento [" + i + "," + j + "]: "+me[i][j]);            
         }
      }

      /* Imprime por pantalla la Matriz */

      System.out.println("\n\tMatriz de "+me.length+" Filas - "+me[0].length+" Columnas");
      System.out.print("\t----------------------------");
      for (int i = 0; i < me.length; i++) {
         System.out.println("\n");         
         for (int j = 0; j < me[i].length; j++) {
            System.out.print("\t"+me[i][j]);            
         }
      }
      System.out.println("\n");
   }

   /*--------------------------------------------------------- */
   /* CARGA UN ARRAY CON LA SUMA DE LAS FILAS                  */
   /*--------------------------------------------------------- */
   public static void sumarLasFilas(int me[][], int sumaF[]){
      int suma;     
      for (int i = 0; i < me.length; i++) {         
         suma=0;
         System.out.println("\nSuma las filas "+i);
         System.out.println("--------");
         for (int j = 0; j < me[i].length; j++) {
            System.out.println("Elemento [" + i + "," + j + "]: "+me[i][j]);
            suma += me[i][j];
         }
         sumaF[i]=suma;
      }
      /* Recorre el vector suma y muestra */
      System.out.println("La suma de las filas: ");
      for(int x=0 ; x < sumaF.length;x++){
         System.out.println("Fila "+x+": "+sumaF[x]);
      }
   }
}
