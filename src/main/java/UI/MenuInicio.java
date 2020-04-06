/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Scanner;

/**
 *
 * @author Velez
 */
public class MenuInicio {
    
    static int option = 0;
    
    public static void ShowMenuInicio(){
        
        option = 0;
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("Bienvenidos al Sistema de Reportes");
            System.out.println("Selecciona la opcion a la cual deseas ingresar: ");
            System.out.println("1.- Ingresar al Menu Administrador");
            System.out.println("2.- Ingresar al Menu Tecnicos");
            System.out.println("3.- Salir");
                       
            option = sc.nextInt();
            
            switch(option){
                case 1:
                    //Metodo ShowMenuAdministrador
                    MenuAdmin.ShowMenuAdministrador();
                    break;
                case 2:
                    //Metodo ShowMenuTecnico
                    MenuTecnico.ShowMenuTecnico();
                    break;
                case 3:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Selecciona una opcion valida!");
                    break;               
            }
            
        }while(option != 3);
        
    }
    
}
