/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iniciosesion;

import java.io.*;
import java.util.*;
import java.io.Serializable;

/**
 *Permite manejar las cuentas, así como guardar y cargar
 *@author Cuadriello Valdés Cynthia, Cuadriello Valdés Diana, Quintana López Ernesto
 */
public class SistemaCuentas implements Serializable{

    /**
     * Permite guardar los datos de una cuenta en un Arreglo de Cuentas
     * @param arregloCuentas Arreglo de cuentas que se utilizará para registrar cuentas 
     */
    static public void GuardarDatos(ArrayList<CuentaBase> arregloCuentas){
        
        try{
            File archivo1 = new File("Cuentas");
            archivo1.delete();
            ObjectOutputStream guardarArchivo = new ObjectOutputStream(new FileOutputStream("Cuentas"));
            guardarArchivo.writeObject(arregloCuentas);
            guardarArchivo.close();        

        }catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }
        catch(IOException i){
            System.out.println("IO: " + i.getMessage());
        }
    }
    
    /**
     * Permite cargar los datos de un archivo y sobrescribir el 'arregloCuentas'
     */
    static public void CargarDatos(){
        
        try{
            ObjectInputStream cargarArchivo= new ObjectInputStream(new FileInputStream("Cuentas"));
            ArregloCuentas.arreglo = (ArrayList<CuentaBase>) cargarArchivo.readObject();
            cargarArchivo.close();

        }catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
            
        }
        catch(IOException e){
            System.out.println("IO: " + e.getMessage());
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            System.out.println("IO: " + e.getMessage());
        }
    }
    
    /**
     * Le solicita al usuario los datos que componen a un Cliente y
     * lo crea para pasárselo a VerificarUsuario y VerificarUsuarioInicio
     * @param clienteCompleto Cliente 'cascaron' que se rellenará con los datos del usuario
     * @param mediator Representa al objeto mediador
     * @param queEs Indica si se quiere realizar un Registro o un InicioSesion
     * @return int (Hace que se repita o no el while de InicioSesion)
     */
    static public int AsignarDatos(CuentaBase clienteCompleto, Mediator mediator, String queEs){
        int Regresar = 1;
        try{
            System.out.println("Ingrese el nombre del usuario: ");
            String usuario = InicioSesion.sc.nextLine();
            System.out.println("Ingrese la contraseña: ");
            String contrasena = InicioSesion.sc.nextLine();
            int modalidad;
            if ("Registro".equals(queEs)){
                do{
                    System.out.println("Eliga su modalidad  1) Administrador  2) Cliente Regular: ");
                    modalidad = InicioSesion.sc.nextInt();
                    InicioSesion.sc.nextLine(); 
                }while (modalidad != 1 && modalidad != 2);
            }else{
                modalidad = 2;
            }
            if (modalidad == 1){
                CuentaBase clienteModif = new CuentaBase(usuario, contrasena, mediator, "Admin");
                clienteCompleto = clienteModif;
            }else{
                CuentaBase clienteModif = new CuentaBase(usuario, contrasena, mediator, "Cliente");
                clienteCompleto = clienteModif;
            }
            if ("Registro".equals(queEs)) Regresar = VerificarUsuario(clienteCompleto);
            else Regresar = VerificarUsuarioInicio(clienteCompleto);
        }
        catch(InputMismatchException e){
            InicioSesion.sc.nextLine();
            System.out.println("InputMismatchException: El caracter introducido es inválido.");
        }
        finally{
            return Regresar;
        }
    }
    
    /**
     * Permite identificar al Tipo de Usuario que se le pasa como parámetro
     * cuando se selecciona 'Registrar'
     * @param clienteCompleto Cliente a registrar
     * @return int (Hace que se repita o no el while de InicioSesion)
     */
    static public int VerificarUsuario(CuentaBase clienteCompleto){
        String texto = "";
        int i;
        if (ArregloCuentas.arreglo.isEmpty()== false){
            for(i=0; i<ArregloCuentas.arreglo.size(); i++){
                if (ArregloCuentas.arreglo.get(i).getUsuario().equals(clienteCompleto.getUsuario())){
                    texto = "YaRegistrado";
                    break;
                } 
            }if (!"YaRegistrado".equals(texto)) texto = "NuevoRegistro";
            return clienteCompleto.notificarCuenta(texto);
        }else return clienteCompleto.notificarCuenta("NuevoRegistro");
    }
    
    /**
     * Permite identificar al Tipo de Usuario que se le pasa como parámetro
     * cuando se selecciona 'Iniciar Sesión'
     * @param clienteCompleto Cliente con el que se quiere iniciar sesión
     * @return int (Hace que se repita o no el while de InicioSesion)
     */
    static public int VerificarUsuarioInicio(CuentaBase clienteCompleto){
        String texto = "";
        int i;
        if (ArregloCuentas.arreglo.isEmpty()== false){
            for(i=0; i<ArregloCuentas.arreglo.size(); i++){
                if (ArregloCuentas.arreglo.get(i).getUsuario().equals(clienteCompleto.getUsuario())){
                    if (ArregloCuentas.arreglo.get(i).getContrasena().equals(clienteCompleto.getContrasena())){
                        texto = "YaRegistradoInicio";
                        i += 1;
                        break;
                    }
                }
            }if (!"YaRegistradoInicio".equals(texto)) texto = "NoRegistroInicio";
            return ArregloCuentas.arreglo.get(i-1).notificarCuenta(texto);
        }else return clienteCompleto.notificarCuenta("NoRegistroInicio");
    }
}

