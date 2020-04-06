/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Conexion;
import Model.Administrativos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Velez
 */
public class AdministrativosDAO {
    
    
    public static void insertarAdministrativoDB(Administrativos administrativo){
        
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        
        try(Connection conexion = db_connect.get_connection()){
            try{
                //Crear consulta
                String query = "INSERT INTO administrativos (nombre, id_empleado, email, area) VALUES (?, ?, ?, ?)";
                //Prepara la consulta
                ps = conexion.prepareStatement(query);
                ps.setString(1, administrativo.getNombre());
                ps.setInt(2, administrativo.getIdEmpleado());
                ps.setString(3, administrativo.getEmail());
                ps.setString(4, administrativo.getArea());
                //Ejecuta la consulta
                ps.executeUpdate();
                System.out.println("Administrativo Agregado Correctamente!");
                
            }catch(SQLException ex){
                System.out.println("Error al Agregar Administrativo!");
                System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
        
    }
    
    public static void listarAdministrativosDB(){
        
       Conexion db_connect = new Conexion();
       PreparedStatement ps = null;
       ResultSet rs = null;
       
       try(Connection conexion =  db_connect.get_connection()){
           try{
               String query = "SELECT * FROM administrativos";
               ps = conexion.prepareStatement(query);
               rs = ps.executeQuery();
               
               //Listar los datos de los administrativos
               while(rs.next()){
                   System.out.println("ID: " + rs.getInt("id"));
                   System.out.println("Nombre: " + rs.getString("nombre"));
                   System.out.println("Numero de Empleado: " + rs.getInt("id_empleado"));
                   System.out.println("Email: " + rs.getString("email"));
                   System.out.println("Area: " + rs.getString("area"));
                   System.out.println("----------------------------");
               }
           }catch(SQLException ex){
               System.out.println("Error al Obtener la Lista de Administrativos");
               System.out.println(ex);
           }
       }catch(SQLException e){
           System.out.println(e);
       }
        
    }
    
    public static void borrarAdministrativoDB(int idAdministrativo){
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        
        try(Connection conexion = db_connect.get_connection()){
            try{
                String query = "DELETE FROM administrativos WHERE id = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, idAdministrativo);
                ps.executeUpdate();
                System.out.println("El Administrativo fue Eliminado!");
            }catch(SQLException ex){
                System.out.println("Error al Eliminar Administrativo!");
                System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public static void actualizarAdministrativoDB(Administrativos administrativo, int opcion){
            Conexion db_connect = new Conexion();
            PreparedStatement ps = null;
        
        try(Connection conexion = db_connect.get_connection()){
            try{
                
                if(opcion == 1){
                    String query = "UPDATE administrativos SET nombre = ? WHERE id = ?";
                    ps = conexion.prepareStatement(query);
                    ps.setString(1, administrativo.getNombre());
                    ps.setInt(2, administrativo.getId());
                    ps.executeUpdate();
                    System.out.println("La Informacion del Administrativo se ha Actualizado Correctamente!");
                }else if(opcion == 2){
                    String query = "UPDATE administrativos SET id_empleado = ? WHERE id = ?";
                    ps = conexion.prepareStatement(query);
                    ps.setInt(1, administrativo.getIdEmpleado());
                    ps.setInt(2, administrativo.getId());
                    ps.executeUpdate();
                    System.out.println("La Informacion del Administrativo se ha Actualizado Correctamente!");
                }else if(opcion == 3){
                    String query = "UPDATE administrativos SET email = ? WHERE id = ?";
                    ps = conexion.prepareStatement(query);
                    ps.setString(1, administrativo.getEmail());
                    ps.setInt(2, administrativo.getId());
                    ps.executeUpdate();
                    System.out.println("La Informacion del Administrativo se ha Actualizado Correctamente!");
                }else if(opcion == 4){
                    String query = "UPDATE administrativos SET area = ? WHERE id = ?";
                    ps = conexion.prepareStatement(query);
                    ps.setString(1, administrativo.getArea());
                    ps.setInt(2, administrativo.getId());
                    ps.executeUpdate();
                    System.out.println("La Informacion del Administrativo se ha Actualizado Correctamente!");
                }
                
            }catch(SQLException ex){
                System.out.println("Error al Actualizar la Informacion!");
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
}
