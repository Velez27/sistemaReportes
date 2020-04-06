/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Velez
 */
public class Usuarios {
    //Atributos
    int id;
    String nombre;
    int idEmpleado;
    String area;
    String email;
    
    //Constructor
    public Usuarios(){
        
    }
    
    public Usuarios(String nombre, int idEmpleado, String area, String email) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
        this.area = area;
        this.email = email;
    }
    
    
}
