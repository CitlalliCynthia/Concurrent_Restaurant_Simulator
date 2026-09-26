/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que designa el comportamiento de las Mesas (Comensales). Esta clase es un objeto
 * y a su vez un tipo de "clase estática", pues realiza una inicialización de Mesas
 * dentro de uno de sus propios métodos
 *@author Cuadriello Valdés Cynthia, Cuadriello Valdés Diana, Quintana López Ernesto
 */
public class Mesas {
    /**
     * Un Arreglo de Mesas, en donde sus elementos son cuatro, 
     * pues sólo hay cuatro mesas en el restaurante
     */
    public static Mesas[] mesas = new Mesas[4];
    /**
     * Variable entera que representa el índice del Arreglo de Mesas en donde
     * se encuentra la primera mesa disponible
     */
    public static int ubicacionMesaPrimeraDisponible;
    /**
     * Variable entera que representa cuántos platillos pendientes tiene la mesa
     */
    private int platillosPedidos;
    /**
     * Variable entera que indica si la mesa está ocupada o disponible.
     * 1 = Ocupada, 0 = Disponible
     */
    private int disponibilidadMesa;
    
    /**
     * Constructor personalizado para Mesas. Inicializa en ceros 'disponibilidadMesa'
     * y 'platillosPedidos'
     */
    public Mesas(){
        this.disponibilidadMesa = 0;
        this.platillosPedidos = 0;
    }
    
    /**
     * Regresa el atributo entero 'disponibilidadMesa'
     * @return int disponibilidadMesa
     */
    public int getDisponibilidadMesa(){
        return this.disponibilidadMesa;
    }
    
    /**
     * Regresa el atributo entero 'getPlatillosPedidos'
     * @return int platillosPedidos
     */
    public int getPlatillosPedidos(){
        return this.platillosPedidos;
    }
    
    /**
     * Permite agregar un o quitarle un Pedido Pendiente a una mesa
     * @param aModificar Representa la cantidad a sumar (si se quiere restar debe
     * de ser un número negativo)
     */
    public void modificarPlatoPedidoMesa(int aModificar){
        this.platillosPedidos += aModificar;
    }
    
    /**
     * Este método permite crear e inicializar las Mesas que integrarán al 
     * Arreglo de Mesas 'mesas'
     */
    public static void inicializarArregloMesas(){
        for(int i=0; i<4; i++){
            Mesas mesaX = new Mesas();
            mesas[i] = mesaX;
        }
        ubicacionMesaPrimeraDisponible = -1;
    }
    
    /**
     * Este método permite averiguar si hay al menos una mesa disponible y
     * actualiza el índice de dicha Mesa
     * @return boolean ('true' si hay al menos una mesa disponible, 'false' si no hay ninguna mesa disponible)
     */
    public static boolean hayMesasDisponibles(){
        int i = 0;
        for(Mesas mesaX : mesas){
           if (mesaX.disponibilidadMesa == 0){
               ubicacionMesaPrimeraDisponible = i;
               return true;
           }
           i++;
        }
        return false;
    }
    
    /**
     * Este método estático permite marcar como ocupada a una mesa, si es que hay 
     * alguna mesa vacía en primer lugar
     */
    public static void seleccionarMesa(){
        if(hayMesasDisponibles() == true){
            System.out.println("    ¡Hay una mesa disponible! Adelante por favor");
            mesas[ubicacionMesaPrimeraDisponible].disponibilidadMesa = 1;
        }
        else{ System.out.println("    ¡Lo lamentamos! No hay mesas disponibles."
                + "\n    Esperamos verlos de nuevo pronto.");
        }
    }
    
    /**
     * Este método permite averiguar si hay al menos una mesa ocupada
     * @return boolean ('true' si hay al menos una mesa ocupada, 'false' si no hay ninguna mesa ocupada)
     */
    public static boolean hayMesasOcupadas(){
        int i = 0;
        for(Mesas mesaX : mesas){
           if (mesaX.disponibilidadMesa == 1){
               return true;
           }
           i++;
        }
        return false;
    }
    
    /**
     * Este método estático permite a una mesa "pagar" su cuenta e irse. Sin embargo,
     * para poder retirarse necesitan no tener ninguna orden pendiente
     */
    public static void dejarMesa(){
        Scanner sc = new Scanner(System.in);
        int respMenu = 0;
        int salir;
        int i;
        
        if(hayMesasOcupadas() == true){
            do{
                System.out.println("	-- Selección de Mesas --");
                System.out.println("\n   Las mesas elegibles son:");
                i = 1;
                for(Mesas mesaX : mesas){
                    if (mesaX.disponibilidadMesa == 1){
                        if (mesaX.platillosPedidos == 0) System.out.println(" * Mesa No."+i+"  --Sin órdenes pendientes");
                        else  System.out.println(" * Mesa No."+i+"  --Órdenes pendientes");  
                    }
                    i++;
                }
                System.out.println("\n   Por favor seleccione la mesa que está lista para pagar su cuenta.");
                System.out.println("   Tome en consideración que no debe de tener ninún pedido pendiente");
                System.out.println("   (ya sea servido u ordenado):");

                try{
                    respMenu = sc.nextInt();
                    sc.nextLine();
                    salir = 1;
                }catch(InputMismatchException e){
                    System.out.println("Error de usuario, sólo se aceptan números enteros");
                    sc.nextLine();
                    salir = 0;
                    }
            }while(respMenu <1 || respMenu >4 || mesas[respMenu-1].disponibilidadMesa == 0 || salir !=1);

            if (mesas[respMenu-1].platillosPedidos != 0) System.out.println("   Esta mesa todavía tiene platillos pendientes.");
            else{
                mesas[respMenu-1].disponibilidadMesa = 0;
                System.out.println("    ¡Gracias por visitarnos! ¡Vuelvan pronto!");
            }
        }
        else System.out.println("    No hay ningún cliente aún...");
    }
}
