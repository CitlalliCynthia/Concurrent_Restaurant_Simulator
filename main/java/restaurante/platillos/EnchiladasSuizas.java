/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.platillos;

/**
 *Esta clase representa a la clase ConcreteStrategies
 *@author Cuadriello Valdés Cynthia, Cuadriello Valdés Diana, Quintana López Ernesto
 */
public class EnchiladasSuizas extends Platillos{
    /**
     * Es el constructor personalizado que pasa los valores específicos del Platillo
     * @param idMesa Representa el índice de la Mesa que pidio el Platillo
     */
    public EnchiladasSuizas(int idMesa){
        super("ENCHILADAS SUIZAS", 100.00f, idMesa, 20000, 30000); 
    }
    
    /**
     * Este método permite ver información respecto al Platillo, como Nombre del Platillo,
     * Precio y una breve descripción del mismo
     */
    public static void verInformacionPlatillo(){
        System.out.println("        -- Enchiladas Suizas --       X $100.00");
        System.out.println("    Es un plato de fettuccine con mantequilla y queso parmesano. "
                + "\n    En su versión original no lleva más nada. "
                + "\n    Se hace muy rápido y es deliciosa.");
    }
}