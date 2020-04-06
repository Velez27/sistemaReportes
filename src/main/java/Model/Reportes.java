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
public class Reportes {
    //Atributos
    int id;
    String fecha;
    String descripcionProblema;
    String solucionProblema;
    String satisfaccion;
    int administrativoId;
    int tecnicoId;

    //Constructor
    public Reportes(String fecha, String satisfaccion, int administrativoId, int tecnicoId) {
        this.fecha = fecha;
        this.satisfaccion = satisfaccion;
        this.administrativoId = administrativoId;
        this.tecnicoId = tecnicoId;
    }
    
    public Reportes(){
        
    }
    
    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    public String getSolucionProblema() {
        return solucionProblema;
    }

    public void setSolucionProblema(String solucionProblema) {
        this.solucionProblema = solucionProblema;
    }

    public String getSatisfaccion() {
        return satisfaccion;
    }

    public void setSatisfaccion(String satisfaccion) {
        this.satisfaccion = satisfaccion;
    }

    public int getAdministrativoId() {
        return administrativoId;
    }

    public void setAdministrativoId(int administrativoId) {
        this.administrativoId = administrativoId;
    }

    public int getTecnicoId() {
        return tecnicoId;
    }

    public void setTecnicoId(int tecnicoId) {
        this.tecnicoId = tecnicoId;
    }
    
    
    
}
