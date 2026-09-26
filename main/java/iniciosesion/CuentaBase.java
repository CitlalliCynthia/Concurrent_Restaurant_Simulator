/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iniciosesion;

import java.io.Serializable;

/**
 *Representa el objeto que engloba todas las características que conforman a un Cliente
 *@author Cuadriello Valdés Cynthia, Cuadriello Valdés Diana, Quintana López Ernesto
 */
public class CuentaBase implements Serializable{
    /**
     * Representa el Nombre del Usuario
     */
    String usuario;
    /**
     * Representa la Contraseña del Usuario
     */
    String contrasena;
    /**
     * Es el objeto Mediator que permite pasar notificaciones entre clases
     */
    Mediator dialogo;
    /**
     * Representa el Tipo de Usuario 'Admin' o 'Cliente'
     */
    String modalidad;
    
    /**
     * Constructor Vacío
     */
    public CuentaBase(){}
    
    /**
     * Constructor Personalizado, que inicializa una Cuenta con sus datos
     * @param usuario Representa al Nombre de Usuario ingresado por el usuario
     * @param contrasena Representa a la Contraseña ingresada por el usuario
     * @param dialogo Es el objeto mediador
     * @param modalidad Una cadena que representa si el Usuario es Administrador o Cliente
     */
    public CuentaBase(String usuario, String contrasena, Mediator dialogo, String modalidad){
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.dialogo = dialogo;
        this.modalidad = modalidad;
    }
    
    /**
     * Método que permite conectar con el mediador mediante un evento
     * @param texto Representa al evento
     * @return int (Hace que se repita o no el while de InicioSesion)
     */
    public int notificarCuenta(String texto){
        return this.dialogo.notificar(this, texto);
    }

    /**
     * Regresa la Contraseña del Cliente
     * @return String contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Regresa el Nombre de Usuario del Cliente
     * @return String usuario
     */
    public String getUsuario() {
        return usuario;
    }
    
    /**
     * Regresa el Tipo de Cliente
     * @return String 'Admin' o 'Cliente'
     */
    public String getMod() {
        return this.modalidad;
    }

    /**
     * Permite establecerle al Cliente una Contraseña dada
     * @param contrasena Una cadena que contiene la contraseña a sobrescribir
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Permite establecerle al Cliente un Nombre de Usuario
     * @param usuario Una cadena que contiene el Nombre de Usuario a sobrescribir
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    /**
     * Permite establecerle al Cliente un "Tipo de Cliente"
     * @param modalidad Una cadena que contiene la modalidad del Cliente: 'Admin' o 'Cliente'
     */
    public void setMod(String modalidad) {
        this.modalidad = modalidad;
    }
}
