/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iniciosesion;

import java.io.Serializable;

/**
 *Es una clase abstracta que forma parte de la implementación del Patrón "Mediator"
 *@author Cuadriello Valdés Cynthia, Cuadriello Valdés Diana, Quintana López Ernesto
 */
public abstract class Mediator implements Serializable{       
    public abstract int notificar(CuentaBase sender, String event);
}
