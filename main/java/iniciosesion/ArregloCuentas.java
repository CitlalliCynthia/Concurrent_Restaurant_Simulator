/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iniciosesion;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *Se crea el arreglo estático para las Cuentas
 *@author Cuadriello Valdés Cynthia, Cuadriello Valdés Diana, Quintana López Ernesto
 */
public class ArregloCuentas implements Serializable{   
    /**
     * Representa un Arreglo de Cuentas en donde se irán registrando las Cuentas
     */
    static ArrayList<CuentaBase> arreglo = new ArrayList<>();
    
    /**
     * Constructor vacío
     */
    public ArregloCuentas(){}
    
    /**
     * Regresa el Arreglo de Cuentas
     * @return ArrayList de CuentasBase 'arreglo'
     */
    public ArrayList<CuentaBase> getArreglo(){
        return arreglo;
    }
    
    /**
     * Permite designar al objeto Arreglo de Cuentas 'arreglo'
     * @param arreglo1 Es el arreglo de Cuentas al que se referenciará 'arreglo'
     */
    public void setArreglo(ArrayList<CuentaBase> arreglo1){
        arreglo = arreglo1;
    }
}

