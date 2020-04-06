/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Services.AdministrativosServices;
import Services.ReportesServices;
import java.util.Scanner;

/**
 *
 * @author Velez
 */
public class MenuTecnico {
    
    static int option = 0;
    
    public static void ShowMenuTecnico(){
        
        option = 0;
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("--------------------");
            System.out.println("Bienvenido al Menu del Tecnico");
            System.out.println("1.- Generar un Reporte");
            System.out.println("2.- Listar los Reportes");
            System.out.println("3.- Listar Administrativos");
            System.out.println("4.- Eliminar un Reporte");
            System.out.println("5.- Salir");
            
            option = sc.nextInt();
            
            switch(option){
                case 1:
                    ReportesServices.insertarReporte();
                    break;
                case 2:
                    ReportesServices.listarReportes();
                    break;
                case 3:
                    AdministrativosServices.listarAdministrativos();
                    break;
                case 4:
                    ReportesServices.borrarReporte();
                    break;
                case 5:
                    System.out.println("Adios!");
                    MenuInicio.ShowMenuInicio();
                    break;
                default:
                    System.out.println("Selecciona una Opcion Valida!");
                    break;
            }
            
        }while(option != 5);
        
    }
    
}
