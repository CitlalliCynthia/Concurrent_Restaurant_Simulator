/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

import java.util.Scanner;
import restaurante.platillos.*;
import java.util.InputMismatchException;

/**
 *Representa el Menú que se le muestra al usuario, en donde puede pedir platillos,
 *dar la bienvenida a los comensales, despedir una mesa, ver el menú, y cerrar el Restaurante
 *@author Cuadriello Valdés Cynthia, Cuadriello Valdés Diana, Quintana López Ernesto
 */
public class Menu extends Thread{
    /**
     * Método estático que imprime los diferentes platillos que conforman el menú
     */
    private void menuPlatillos(){
        Scanner sc = new Scanner(System.in);    
        System.out.println("                            //       **-- MENÚ --**       //");
        System.out.println("");
        PastaAlfredo.verInformacionPlatillo();
        System.out.println("");
        EnchiladasSuizas.verInformacionPlatillo();
        System.out.println("");
        Hamburguesa.verInformacionPlatillo();
        System.out.println("");
        Pozole.verInformacionPlatillo();
        System.out.println(""); 
        System.out.println("    Presiona enter para continuar: ");
        sc.nextLine();  
    }
    
    /**
     * Este método representa la corrida del hilo Menu. Literalmente presenta un menú
     * que le da ciertas opciones al usuario para realizar
     */
    @Override
    public void run(){
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;
        int respMenu = 0;
        int salir;
        
        while(bandera == true){
            do{
                System.out.println("            //--- RESTAURANTE: OPCIONES ---//");
                System.out.println("	1) Ver menú de platillos");
                System.out.println("	2) Dar la bienvenida a comensales");
                System.out.println("	3) Pedir algún platillo");
                System.out.println("	4) Pedir la cuenta de una mesa");
                System.out.println("	5) Terminar servicio (Salir)");
                System.out.println("");
                System.out.println("	Escribe la opción deseada: ");
                try{
                    respMenu = sc.nextInt();
                    sc.nextLine();
                    salir = 1;
                }catch(InputMismatchException e){
                    System.out.println("  Error de usuario, sólo se aceptan números enteros");
                    sc.nextLine();
                    salir = 0;
                }
            }while (salir != 1);
            
            switch(respMenu){
                case 1:
                    menuPlatillos();
                    break;
                case 2:
                    Mesas.seleccionarMesa();
                    break;
                case 3:
                    Mesero.tomarPedido();
                    break;
                case 4:
                    Mesas.dejarMesa();
                    break;
                case 5:
                    System.out.println("    Se terminarán de servir y recoger las órdenes pendientes");
                    System.out.println("    (si es que hay) Y se cerrará el restaurante.");
                    Mesero.estadoRestaurante = "Inactivo";
                    bandera = false;
                    break;
                default:
                    System.out.println("La entrada no fue válida. Sólo un rango de 1-5");
            }
            System.out.println("");
        }
    }
}
