/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

import java.util.InputMismatchException;
import restaurante.platillos.*;
import java.util.Scanner;

/**
 * Clase que permite implementar el Patrón Strategy, y que se encarga de tomar los 
 * pedidos de las mesas (incluye los Platillos a el Arreglo 'ordenesEnElaboracion' o 'ordenesEnEspera')
 *@author Cuadriello Valdés Cynthia, Cuadriello Valdés Diana, Quintana López Ernesto
 */
public class Mesero{
    /**
     * Variable flotante que permite llevar la cuenta de las ganancias del día del restaurante
     */
    public static float gananciasRestaurante = 0.00f;
    /**
     * Cadena que indica si el Restaurante está "Abierto" o "Cerrado"
     */
    public static String estadoRestaurante = "Activo";
    
    /**
     * Este método permite identificar qué tipo de platillo solicitó el usuario, 
     * y con base a ello selecciona el algoritmo adecuado (en este caso Platillo)
     * @param respMenu Esta variable entera representa cuál platillo desea pedir el usuario
     * @param idMesa Esta variable entera representa a cuál Mesa quiere ordenar el usuario
     * @return Platillo (regresa un Platillo inicializado como el usuario lo requirió)
     */
    private static Platillos getStrategyPlatillo(int respMenu, int idMesa){ //Utiliza el patrón Strategy
        Platillos platillo = new PastaAlfredo(idMesa);
        switch(respMenu){
            case 1:
                break;
            case 2:
                platillo = new EnchiladasSuizas(idMesa);
                break;
            case 3:
                platillo = new Hamburguesa(idMesa);
                break;
            case 4:
                platillo = new Pozole(idMesa);
                break;
            default:
                break;
        }
        return platillo;
    }
    
    /**
     * Este método revisa si la cocina está disponible, y si es así le pasa el platillo a
     * 'ordenesEnElaboracion', y si no es así, se lo pasa a 'ordenesEnEspera'
     * @param platillo Representa el platillo ordenado, que se va a preparar
     */
    private static void revisarDisponibilidadCocina(Platillos platillo){
        if (Cocina.ordenesEnElaboracion.size() == 6){
            Cocina.ordenesEnEspera.add(platillo);
        }
        else Cocina.ordenesEnElaboracion.add(platillo);
    }
    
    /**
     * Se le presenta un menú al usuario, en donde se le pide seleccionar una mesa,
     * y posteriormente seleccionar un platillo a ordenar. Según ello se manda el platillo al
     * arreglo de la cocina
     */
    public static void tomarPedido(){
        Scanner sc = new Scanner(System.in);
        int respMenu = 0;
        int mesaIndice;
        int salir;
        int i;
        
        if(Mesas.hayMesasOcupadas() == true){
            do{
                System.out.println("	-- Selección de Mesas --");
                System.out.println("\n   Las mesas elegibles son:");
                i = 1;
                for(Mesas mesaX : Mesas.mesas){
                    if (mesaX.getDisponibilidadMesa() == 1){
                        if (mesaX.getPlatillosPedidos() == 0) System.out.println(" * Mesa No."+i+"  --Sin órdenes pendientes");
                        else  System.out.println(" * Mesa No."+i+"  --Órdenes pendientes");  
                    }
                    i++;
                }
                System.out.println("\n   Por favor seleccione la mesa que está lista para pedir su orden: ");
                try{
                    respMenu = sc.nextInt();
                    sc.nextLine();
                    salir = 1;
                }catch(InputMismatchException e){
                    System.out.println("Error de usuario, sólo se aceptan números enteros");
                    sc.nextLine();
                    salir = 0;
                    }
            }while(respMenu <1 || respMenu >4 || Mesas.mesas[respMenu-1].getDisponibilidadMesa() == 0 || salir !=1);

            Mesas mesaProvisional = Mesas.mesas[respMenu-1];
            mesaIndice = respMenu;
            
            do{
                System.out.println("   Por favor elija cuál platillo desea ordenar:");
                System.out.println("        1) Pasta Alfredo\n        2) Enchiladas Suizas\n        3) Hamburguesa"
                        + "\n        4) Pozole");
                try{
                    respMenu = sc.nextInt();
                    sc.nextLine();
                    salir = 1;
                }catch(InputMismatchException e){
                    System.out.println("Error de usuario, sólo se aceptan números enteros");
                    sc.nextLine();
                    salir = 0;
                    }
            }while(respMenu <1 || respMenu >4 || salir !=1);
            
            Platillos platilloX = getStrategyPlatillo(respMenu, mesaIndice);
            ContextPlatillos context = new ContextPlatillos(platilloX);
            
            mesaProvisional.modificarPlatoPedidoMesa(1);
            gananciasRestaurante += context.platillo.getPrecio();
            
            revisarDisponibilidadCocina(context.platillo);
        }
        else System.out.println("    Todavía no tenemos ningún cliente :'c");
    }
}
