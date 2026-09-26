/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iniciosesion;

import java.io.Serializable;

/**
 *Permite unir las Cuentas con SistemaCuentas
 *@author Cuadriello Valdés Cynthia, Cuadriello Valdés Diana, Quintana López Ernesto
 */
public class ExtMediator extends Mediator implements Serializable{

    /**
     * Dependiendo del evento recibido, realiza acciones determinadas e imprime en pantalla mensajes 
     * @param sender Representa a la Cuenta que envió el evento
     * @param event Representa el evento enviado
     * @return int (Hace que se repita o no el while de InicioSesion)
     */
    @Override
    public int notificar(CuentaBase sender, String event){//, ArrayList<CuentaBase> arregloCuentas){
        if ("NuevoRegistro".equals(event)){
            ArregloCuentas.arreglo.add(sender);
            SistemaCuentas.GuardarDatos(ArregloCuentas.arreglo);
            System.out.println("\n --- Este Usuario ha sido registrado con éxito");
        }
        if ("YaRegistrado".equals(event)){
            System.out.println("\n --- Este Usuario ya está registrado, intente otro");
        }
        if ("YaRegistradoInicio".equals(event)){
            String modi;
            modi = sender.getMod();
            if ("Admin".equals(modi)) System.out.println("\n\n   ----- BIENVENIDO AL RESTAURANTE, ADMINISTRADOR -----");
            if ("Cliente".equals(modi)) System.out.println("\n\n   ----- BIENVENIDO AL RESTAURANTE, CLIENTE -----");
            return 0;
        }
        if ("NoRegistroInicio".equals(event)){
            System.out.println("\n --- El Usuario o Contraseña son incorrectos, intente nuevamente");
        }
        return 1;
    }
    
}
