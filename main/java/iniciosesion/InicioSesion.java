/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iniciosesion;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *Representa el Menú de Opciones que se imprime en pantalla, y en el que
 * el usuario decide qué acciones realizar
 *@author Cuadriello Valdés Cynthia, Cuadriello Valdés Diana, Quintana López Ernesto
 */
public class InicioSesion{
    /**
     * Una instancia de Scanner para poder utilizarla en varios lugares
     */
    public static Scanner sc = new Scanner(System.in);
    
    /**
     * Representa el Menú de Registro / Inicio Sesión
     */
    public static void Menu(){
        Mediator arregloObject = new ExtMediator();
        
        File archivo1 = new File("Cuentas");
        if (archivo1.length() == 0) { System.out.println("No hay registos previos"); } 
        else SistemaCuentas.CargarDatos();

        CuentaBase cuentaCliente = new CuentaBase();
        
        int menu =1;
        int salir;
        
        do{
            System.out.println("\n\n[NOMBRE DEL RESTAURANT]");
            System.out.println("[1]Iniciar Sesion");
            System.out.println("[2]Registrarse");
            
            System.out.println("¿Qué deseas hacer?");

            try{
                menu = sc.nextInt();
                sc.nextLine(); 
                switch(menu){
                    case 1:
                        menu = SistemaCuentas.AsignarDatos(cuentaCliente, arregloObject, "InicioSesion");
                        break;
                    case 2:
                        menu = SistemaCuentas.AsignarDatos(cuentaCliente, arregloObject, "Registro");
                        break;
                    default:
                        System.out.println("[OPCION INVALIDA]");
                        break;
                }
                salir = 1;
            }catch(InputMismatchException e){
                System.out.println("Error de usuario, sólo se aceptan números enteros");
                sc.nextLine();
                salir = 0;
                }
        }while(menu!=0 || salir !=1);
    }
}