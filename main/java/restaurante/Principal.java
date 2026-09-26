/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package restaurante;

import iniciosesion.InicioSesion;

/**
 *Ésta es la clase 'Principal' que permite correr todo el programa
 *@author Cuadriello Valdés Cynthia, Cuadriello Valdés Diana, Quintana López Ernesto
 */
public class Principal {

    /**
     * Este método 'main' llama a varios métodos estáticos de otras clases, 
     * crea instancias de 'Menu' y 'Cocina', y luego corre los hilos respectivos
     * @param args Realmente no requiere ingresar ningún parámetro
     */
    public static void main(String[] args) {
        InicioSesion.Menu();
        
        Mesas.inicializarArregloMesas();
        Cocina cocina = new Cocina();
        Menu menu = new Menu();
        
        cocina.start();
        menu.start();
    }
}
