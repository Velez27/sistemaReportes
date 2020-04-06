/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Conexion;
import Model.Tecnicos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Velez
 */
public class TecnicosDAO {
    
    public static void insertarTecnicoDB(Tecnicos tecnico){
        
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        
        try(Connection conexion = db_connect.get_connection()){
            
            try{
                String query = "INSERT INTO tecnicos (nombre, id_empleado, email) VALUES (?, ?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, tecnico.getNombre());
                ps.setInt(2, tecnico.getIdEmpleado());
                ps.setString(3, tecnico.getEmail());
                ps.executeUpdate();
                System.out.println("Tecnico Agregado Correctamente!");
                
            }catch(SQLException ex){
                System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public static void listarTecnicosDB(){
        
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try(Connection conexion = db_connect.get_connection()){
            
            String query = "SELECT * FROM tecnicos";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Numeron de Empleado: " + rs.getInt("id_empleado"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Area: " + rs.getString("area"));
                System.out.println("---------------------------------");
            }
        }catch(SQLException e){
            System.out.println("Error al Obtener la Lista de Tecnicos!");
            System.out.println(e);
        }
        
    }
    
    public static void borrarTecnicoDB(int idTecnico){
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        
        try(Connection conexion = db_connect.get_connection()){
            try{
                String query = "DELETE FROM tecnicos WHERE id = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, idTecnico);
                ps.executeUpdate();
                System.out.println("El Tecnico fue Eliminado!");
            }catch(SQLException ex){
                System.out.println("Error al Eliminar Tecnico!");
                System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public static void actualizarTecnicoDB(Tecnicos tecnico, int opcion){
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        
        try(Connection conexion = db_connect.get_connection()){
            try{
                
                if(opcion == 1){
                    String query = "UPDATE tecnicos SET nombre = ? WHERE id = ?";
                    ps = conexion.prepareStatement(query);
                    ps.setString(1, tecnico.getNombre());
                    ps.setInt(2, tecnico.getId());
                    ps.executeUpdate();
                    System.out.println("La Informacion del Tecnico se ha Actualizado Correctamente!");
                }else if(opcion == 2){
                    String query = "UPDATE tecnicos SET id_empleado = ? WHERE id = ?";
                    ps = conexion.prepareStatement(query);
                    ps.setInt(1, tecnico.getIdEmpleado());
                    ps.setInt(2, tecnico.getId());
                    ps.executeUpdate();
                    System.out.println("La Informacion del Tecnico se ha Actualizado Correctamente!");
                }else if(opcion == 3){
                    String query = "UPDATE tecnicos SET email = ? WHERE id = ?";
                    ps = conexion.prepareStatement(query);
                    ps.setString(1, tecnico.getEmail());
                    ps.setInt(2, tecnico.getId());
                    ps.executeUpdate();
                    System.out.println("La Informacion del Tecnico se ha Actualizado Correctamente!");
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
