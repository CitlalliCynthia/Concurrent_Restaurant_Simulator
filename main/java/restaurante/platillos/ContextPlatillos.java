/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.platillos;

/**
 *Esta clase representa a la clase Contexto del Patrón Strategy
 *@author Cuadriello Valdés Cynthia, Cuadriello Valdés Diana, Quintana López Ernesto
 */
public class ContextPlatillos {
    /**
     * Atributo de tipo Platillos
     */
    public Platillos platillo;
    
    /**
     * El constructor recibe un Platillos y lo asigna a su atributo 'platillo'
     * @param platillo Es el platillo creado en getStrategy()
     */
    public ContextPlatillos(Platillos platillo){
        this.platillo = platillo;
    }
}
