/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.platillos;

import restaurante.Cocina;
import restaurante.Mesas;

/**
 *Esta clase representa a la clase Strategy (es la clase base para los demás Platillos)
 *@author Cuadriello Valdés Cynthia, Cuadriello Valdés Diana, Quintana López Ernesto
 */
public abstract class Platillos implements Runnable{   
    /**
     * Una cadena que representa el Nombre del Platillo
     */
    String nombrePlatillo;
    /**
     * Una variable flotante que representa el Costo del Platillo
     */
    float costoPlatillo;
    /**
     * Una cadena que representa el Estado del "hilo": 
     * Preparacion, Comensales, lavando (termina el hilo, el platillo se ha terminado de comer)
     */
    String estado;
    /**
     * Variable entera que representa a la Mesa que solicitó el platillo
     */
    int idMesa;
    /**
     * Variable long que representa el tiempo requerido en la cocina para terminar el Platillo
     */
    long tiempoCocinar;
    /**
     * Variable long que representa el tiempo requerido de los comensales para terminar el Platillo
     */
    long tiempoComer;
    /**
     * El "hilo" que representa el sub-proceso inherente del Platillo
     */
    public Thread hilo;
    
    /**
     * Constructor personalizado que inicializa los valores del Platillo
     * @param nombrePlatillo Nombre del Platillo
     * @param costoPlatillo Costo del Platillo
     * @param idMesa Índice de la Mesa que ordenó el Platillo
     * @param tiempoCocinar Tiempo que tarda en cocinarse el Platillo
     * @param tiempoComer Tiempo que tarda la Mesa en terminarse el Platillo
     */
    public Platillos(String nombrePlatillo, float costoPlatillo, int idMesa, long tiempoCocinar, long tiempoComer){
        this.nombrePlatillo = nombrePlatillo;
        this.costoPlatillo = costoPlatillo;
        this.tiempoCocinar = tiempoCocinar;
        this.tiempoComer = tiempoComer;
        this.idMesa = idMesa;
        this.estado = "";
        this.hilo = new Thread(this);
    }
    
    /**
     * Regresa el hilo que tiene como atributo el objeto
     * @return Thread hilo
     */
    public Thread getHilo(){
        return this.hilo;
    }
    
    /**
     * Este método permite correr el hilo del atributo
     */
    public void startHilo(){
        this.estado = "Preparacion"; 
        this.hilo.start();
    }
    
    /**
     * Regresa el precio del Platillo
     * @return float costoPlatillo
     */
    public float getPrecio(){
        return costoPlatillo;
    }
    
    /**
     * Método que se llama cuando el hilo es activado. Aquí se revisa el "estado" del hilo, 
     * y dependiendo de dicho estado es la acción que se realiza
     */
    @Override
    public void run(){
        while(!"lavando".equals(this.estado)){
            try{
                if ("Preparacion".equals(this.estado)){
                    Thread.sleep(this.tiempoCocinar);
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t-- El platillo '" + this.nombrePlatillo + "' para la mesa "
                            + "No. " + this.idMesa + " está listo --"
                                    + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t...Entregando a los comensales de la mesa No. "+this.idMesa);
                    
                    Cocina.ordenesTerminandose.add(Cocina.ordenesEnElaboracion.firstElement());
                    Cocina.ordenesEnElaboracion.remove(0);

                    if(Cocina.ordenesEnEspera.isEmpty() == false){
                        Cocina.ordenesEnElaboracion.add(Cocina.ordenesEnEspera.firstElement());
                        Cocina.ordenesEnEspera.remove(0);
                        
                    }
                    this.estado = "Comensales";
                }
                else{
                    if ("Comensales".equals(this.estado)){
                        Thread.sleep(this.tiempoComer);
                        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t-- La mesa No. " + this.idMesa + " ha terminado su platillo '" + this.nombrePlatillo + "' --"
                                + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t...El plato se les es retirado");
                        Mesas.mesas[this.idMesa-1].modificarPlatoPedidoMesa(-1);
                        
                        Cocina.ordenesTerminandose.remove(0);
                        this.estado = "lavando";
                    }
                } 
            }
            catch(InterruptedException e){
                System.out.println("    ¡EXCEPCIÓN: EL HILO FUE INTERRUMPIDO!");
            }
        }
    }
}

