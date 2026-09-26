/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

import java.util.Vector;
import restaurante.platillos.Platillos;

/**
 *Representa uno de los hilos principales, y se encarga de llevar un seguimiento
 * de los Platillos (sub-procesos / hilos)
 *@author Cuadriello Valdés Cynthia, Cuadriello Valdés Diana, Quintana López Ernesto
 */
public class Cocina extends Thread{ //Es la clase Contexto de los platillos
    /**
     * Vector de Platillos: Representa a los platillos que están cocinándose, y nunca excede de 6 elementos (Platillos) 
     */
    public static Vector<Platillos> ordenesEnElaboracion = new Vector<>();
    /**
     * Vector de Platillos: Representa a los platillos que están esperando a cocinarse (Lista de Espera)
     */
    public static Vector<Platillos> ordenesEnEspera = new Vector<>();
    /**
     * Vector de Platillos: Representa a los platillos que están siendo consumidos por los comensales
     */
    public static Vector<Platillos> ordenesTerminandose = new Vector<>();
    
    /**
     * Es el método que corre el hilo, y lo que hace es mantenerse siempre revisando los Vectores,
     * y si se da cuenta de que tiene Platillos pendientes por preparar y estos sub-procesos (hilos)
     * no han sido iniciados aún, los inicia
     */
    @Override
    public void run(){
        Platillos platilloX;
        while("Activo".equals(Mesero.estadoRestaurante) || (ordenesTerminandose.isEmpty() == false || ordenesEnElaboracion.isEmpty() == false)){
            if(ordenesEnElaboracion.isEmpty() == false){
               	platilloX = ordenesEnElaboracion.firstElement();
                if(platilloX.getHilo().isAlive() != true) platilloX.startHilo();
           }
        }
        System.out.println("                    Las ganancias del día de hoy fueron: $"+ Mesero.gananciasRestaurante);
    }
    
}
