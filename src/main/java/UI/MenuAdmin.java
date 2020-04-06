/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Services.AdministrativosServices;
import Services.TecnicosServices;
import java.util.Scanner;

/**
 *
 * @author Velez
 */
public class MenuAdmin {
    
    static int option = 0;
    
    public static void ShowMenuAdministrador(){
        
        option = 0;
        
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("---------------");
            System.out.println("Bienvenido al Menu de Administrador");
            System.out.println("1.- Insertar Tecnico");
            System.out.println("2.- Insertar Administrativo");
            System.out.println("3.- Listar Tecnicos");
            System.out.println("4.- Listar Administrativos");
            System.out.println("5.- Editar Tecnico");
            System.out.println("6.- Editar Administrativo");
            System.out.println("7.- Eliminar Tecnico");
            System.out.println("8.- Eliminar Administrativo");
            System.out.println("9.- Salir");
            
            option = sc.nextInt();
            
            switch(option){
                case 1:
                    TecnicosServices.insertarTecnico();
                    break;
                case 2:
                    AdministrativosServices.insertarAdministrativo();
                    break;
                case 3:
                    TecnicosServices.listarTecnicos();
                    break;
                case 4:
                    AdministrativosServices.listarAdministrativos();
                    break;
                case 5:
                    TecnicosServices.editarTecnico();
                    break;
                case 6:
                    AdministrativosServices.editarAdministrativo();
                    break;
                case 7:
                    TecnicosServices.borrarTecnico();
                    break;
                case 8:
                    AdministrativosServices.borrarAdministrativo();
                    break;
                case 9:
                    System.out.println("Adios");
                    MenuInicio.ShowMenuInicio();
                    break;
                default:
                    System.out.println("Selecciona una opcion valida!");
                    break;
            }
            
        }while(option != 9);
        
    }
}
