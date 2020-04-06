/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.ReportesDAO;
import Model.Reportes;
import java.util.Scanner;

/**
 *
 * @author Velez
 */
public class ReportesServices {
    
    public static void insertarReporte(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Cual es tu ID de Tecnico?: ");
        int tecnicoId = sc.nextInt();
        sc.nextLine();
        System.out.println("Cual es el ID del Administrativo a Atender?: ");
        int administrativoId = sc.nextInt();
        sc.nextLine();
        System.out.println("Cual es la Descripcion del Problema?: ");
        String descripcionProblema = sc.nextLine();
        System.out.println("Cual fue la Solucion al Problema?: ");
        String solucionProblema = sc.nextLine();
        System.out.println("Cual fue la Calificacion que Recibiste por el Administrativo?: ");
        System.out.println("Opciones: Bueno, Regular, Malo");
        String satisfaccion = sc.nextLine();
        
        Reportes reporte = new Reportes();
        reporte.setTecnicoId(tecnicoId);
        reporte.setAdministrativoId(administrativoId);
        reporte.setDescripcionProblema(descripcionProblema);
        reporte.setSolucionProblema(solucionProblema);
        reporte.setSatisfaccion(satisfaccion);
        
        ReportesDAO.insertarReporteDB(reporte);
        
    }
    
    public static void listarReportes(){
        ReportesDAO.listarReportesDB();
    }
    
    public static void borrarReporte(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Cual es el ID del Reporte que desea Eliminar?: ");
        int idReporte = sc.nextInt();
        
        ReportesDAO.borrarReporteDB(idReporte);
        
    }
    
}
