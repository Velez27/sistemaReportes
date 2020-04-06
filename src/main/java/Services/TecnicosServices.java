/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.TecnicosDAO;
import Model.Tecnicos;
import UI.MenuAdmin;
import java.util.Scanner;

/**
 *
 * @author Velez
 */
public class TecnicosServices {
    
    public static void insertarTecnico(){
        //Se piden los datos al usuario
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe el Nombre del Tecnico: ");
        String nombre = sc.nextLine();
        
        System.out.println("Escribe el Numero de Empleado del Tecnico: ");
        int idEmpleado = sc.nextInt();
        //Limpiar el buffer
        //Sin esta linea el programa no se detiene para pedir el Email.
        sc.nextLine();
        
        System.out.println("Escribe el Email del Tecnico: ");
        String email = sc.nextLine();
                
        //Se preparan los datos en un objeto tipo Tecnicos
        Tecnicos tecnico = new Tecnicos();
        tecnico.setNombre(nombre);
        tecnico.setIdEmpleado(idEmpleado);
        tecnico.setEmail(email);
        //Se envia la informacion a la capa DAO
        TecnicosDAO.insertarTecnicoDB(tecnico);
        
    }
    
    public static void listarTecnicos(){
        TecnicosDAO.listarTecnicosDB();
    }
    
    public static void borrarTecnico(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el ID del Tecnico ha Eliminar: ");
        int idTecnico = sc.nextInt();
        
        TecnicosDAO.borrarTecnicoDB(idTecnico);
    }
    
    public static void editarTecnico(){
        
        Scanner sc = new Scanner(System.in);
        Tecnicos tecnico = new Tecnicos();
        
        System.out.println("Cual es el ID del Tecnico que Desea Modificar?");
        int idTecnico = sc.nextInt();
        tecnico.setId(idTecnico);
        //Limpiar Buffer
        sc.nextLine();
        
        int option = 0;
        
        do{
            System.out.println("-----------------");
            System.out.println("Que Campo Deseas Modificar? - ID del Tecnico: " + idTecnico);
            System.out.println("1.- El nombre");
            System.out.println("2.- El ID de Empleado");
            System.out.println("3.- El Email");
            System.out.println("4.- Salir");
            
            option = sc.nextInt();
            //Limpiar Buffer
            sc.nextLine();
            
            switch(option){
                case 1:
                    System.out.println("Escribe el Nuevo Valor del Nombre");
                    String nombre = sc.nextLine();
                    tecnico.setNombre(nombre);
                    TecnicosDAO.actualizarTecnicoDB(tecnico, option);
                    break;
                case 2:
                    System.out.println("Escribe el Nuevo ID de Empleado");
                    int idEmpleado = sc.nextInt();
                    tecnico.setIdEmpleado(idEmpleado);
                    TecnicosDAO.actualizarTecnicoDB(tecnico, option);
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("Escribe el Nuevo Email");
                    String email = sc.nextLine();
                    tecnico.setEmail(email);
                    TecnicosDAO.actualizarTecnicoDB(tecnico, option);
                    break;
                case 4:
                    System.out.println("Adios!");
                    MenuAdmin.ShowMenuAdministrador();
                    break;
                default:
                    System.out.println("Selecciona una Opcion Valida!");
                    break;
            }
            
        }while(option != 4);
        
    }
    
}
