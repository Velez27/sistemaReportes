/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.AdministrativosDAO;
import Model.Administrativos;
import UI.MenuAdmin;
import java.util.Scanner;

/**
 *
 * @author Velez
 */
public class AdministrativosServices {
    
    public static void insertarAdministrativo(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe el Nombre del Administrativo: ");
        String nombre = sc.nextLine();
        System.out.println("Escribe el numero de Empleado del Administrativo: ");
        int idAdministrativo = sc.nextInt();
        sc.nextLine();
        System.out.println("Escribe el Email del Administrativo: ");
        String email = sc.nextLine();
        System.out.println("Escribe el Area del Administrativo");
        String area = sc.nextLine();
        
        Administrativos administrativo = new Administrativos();
        administrativo.setNombre(nombre);
        administrativo.setIdEmpleado(idAdministrativo);
        administrativo.setEmail(email);
        administrativo.setArea(area);
        
        AdministrativosDAO.insertarAdministrativoDB(administrativo);
    }
    
    public static void listarAdministrativos(){
        AdministrativosDAO.listarAdministrativosDB();
    }
    
    
    public static void borrarAdministrativo(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe el ID del Administrativo a Eliminar: ");
        int idAdministrativo = sc.nextInt();
        AdministrativosDAO.borrarAdministrativoDB(idAdministrativo);
        
    }
    
    public static void editarAdministrativo(){
        
        Scanner sc = new Scanner(System.in);
        Administrativos administrativo = new Administrativos();
        
        System.out.println("Cual es el ID del Administrativo que Desea Modificar?");
        int idAdministrativo = sc.nextInt();
        administrativo.setId(idAdministrativo);
        //Limpiar Buffer
        sc.nextLine();
        
        int option = 0;
        
        do{
            System.out.println("-----------------");
            System.out.println("Que Campo Deseas Modificar? - ID del Administrativo: " + idAdministrativo);
            System.out.println("1.- El nombre");
            System.out.println("2.- El ID de Empleado");
            System.out.println("3.- El Email");
            System.out.println("4.- El Area");
            System.out.println("5.- Salir");
            
            option = sc.nextInt();
            //Limpiar Buffer
            sc.nextLine();
            
            switch(option){
                case 1:
                    System.out.println("Escribe el Nuevo Valor del Nombre");
                    String nombre = sc.nextLine();
                    administrativo.setNombre(nombre);
                    AdministrativosDAO.actualizarAdministrativoDB(administrativo, option);
                    break;
                case 2:
                    System.out.println("Escribe el Nuevo ID de Empleado");
                    int idEmpleado = sc.nextInt();
                    administrativo.setIdEmpleado(idEmpleado);
                    AdministrativosDAO.actualizarAdministrativoDB(administrativo, option);
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("Escribe el Nuevo Email");
                    String email = sc.nextLine();
                    administrativo.setEmail(email);
                    AdministrativosDAO.actualizarAdministrativoDB(administrativo, option);
                    break;
                case 4:
                    System.out.println("Escribe la Nueva Area");
                    String area = sc.nextLine();
                    administrativo.setArea(area);
                    AdministrativosDAO.actualizarAdministrativoDB(administrativo, option);
                    break;
                case 5:
                    System.out.println("Adios!");
                    MenuAdmin.ShowMenuAdministrador();
                    break;
                default:
                    System.out.println("Selecciona una Opcion Valida!");
                    break;
            }
            
        }while(option != 5);
        
        
    }
    
}
