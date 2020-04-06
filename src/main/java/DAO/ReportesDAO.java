/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Conexion;
import Model.Reportes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Velez
 */
public class ReportesDAO {
    
    public static void insertarReporteDB(Reportes reporte){
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        try(Connection conexion = db_connect.get_connection()){
            try{
                String query = "INSERT INTO reportes (descripcion_problema, solucion_problema, satisfaccion, administrativo_id, tecnico_id) VALUES (?, ?, ?, ?, ?) ";
                ps = conexion.prepareStatement(query);
                ps.setString(1, reporte.getDescripcionProblema());
                ps.setString(2, reporte.getSolucionProblema());
                ps.setString(3, reporte.getSatisfaccion());
                ps.setInt(4, reporte.getAdministrativoId());
                ps.setInt(5, reporte.getTecnicoId());
                ps.executeUpdate();
                System.out.println("Reporte Guardado Correctamente!");
                
            }catch(SQLException ex){
                System.out.println("Error al Guardar Reporte!");
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public static void listarReportesDB(){
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try(Connection conexion = db_connect.get_connection()){
            try{
                String query = "SELECT r.id, DATE_FORMAT(r.fecha, '%m/%d/%Y') AS Fecha, t.nombre, a.nombre, a.area, r.descripcion_problema, r.solucion_problema, r.satisfaccion\n" +
                    "FROM reportes AS r\n" +
                    "INNER JOIN tecnicos AS t ON t.id_empleado = r.tecnico_id\n" +
                    "INNER JOIN administrativos AS a ON a.id_empleado = r.administrativo_id";
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    System.out.println("ID del Reporte: " + rs.getInt(1));
                    System.out.println("Fecha: " + rs.getString(2));
                    System.out.println("Nombre del Tecnico: " + rs.getString(3));
                    System.out.println("Nombre del Administrativo: " + rs.getString(4));
                    System.out.println("Area: " + rs.getString(5));
                    System.out.println("Descripcion del Problema: " + rs.getString(6));
                    System.out.println("Solucion del Problema: " + rs.getString(7));
                    System.out.println("Calificacion del Administrativo: " + rs.getString(8));
                    System.out.println("");
                }
                
            }catch(SQLException ex){
                System.out.println("Error al Listar los Reportes!");
                System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public static void borrarReporteDB(int idReporte){
        
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        
        try(Connection conexion = db_connect.get_connection()){
            try{
                String query = "DELETE FROM reportes WHERE id = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, idReporte);
                ps.executeUpdate();
                System.out.println("Reporte Borrado Correctamente!");
                
            }catch(SQLException ex){
                System.out.println("Error al Borrar el Reporte!");
                System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
}
