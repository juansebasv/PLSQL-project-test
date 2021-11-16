/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.plsql.proyectofinal.mbeans;

import edu.plsql.proyectofinal.mbeans.servicios.GeneralServicio;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dpinedar@ucentral.edu.co
 */
@Named(value = "generalBean")
@ViewScoped
public class GeneralBean implements Serializable {

    private boolean seleccionarRegion;
    private boolean seleccionarArea;
    private boolean seleccionarPoblacion;

    private String parametroBusquedaRegion;
    private int parametroBusquedaArea;
    private int parametroBusquedaPoblacion;

    public GeneralBean() {
    }

    public void actionCargarBaseDatos(ActionEvent event) {

        try {
            GeneralServicio generalServicio = new GeneralServicio();
            generalServicio.ejecutarCargaBaseDatos();
            crearMensajeGrowl("INICIO LA CARGA", FacesMessage.SEVERITY_INFO);
        } catch (Exception ex) {
            System.out.println(ex);
            crearMensajeGrowl(ex.getLocalizedMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void actionEliminarBaseDatos(ActionEvent event) {
        crearMensajeGrowl("ELIMINAR REPORTE", FacesMessage.SEVERITY_INFO);
    }

    public void actionGenerarReporte(ActionEvent event) {
        crearMensajeGrowl("GENERAR REPORTE", FacesMessage.SEVERITY_INFO);
    }

    public boolean isSeleccionarRegion() {
        return seleccionarRegion;
    }

    public void setSeleccionarRegion(boolean seleccionarRegion) {
        this.seleccionarRegion = seleccionarRegion;
    }

    public boolean isSeleccionarArea() {
        return seleccionarArea;
    }

    public void setSeleccionarArea(boolean seleccionarArea) {
        this.seleccionarArea = seleccionarArea;
    }

    public boolean isSeleccionarPoblacion() {
        return seleccionarPoblacion;
    }

    public void setSeleccionarPoblacion(boolean seleccionarPoblacion) {
        this.seleccionarPoblacion = seleccionarPoblacion;
    }

    public String getParametroBusquedaRegion() {
        return parametroBusquedaRegion;
    }

    public void setParametroBusquedaRegion(String parametroBusquedaRegion) {
        this.parametroBusquedaRegion = parametroBusquedaRegion;
    }

    public int getParametroBusquedaArea() {
        return parametroBusquedaArea;
    }

    public void setParametroBusquedaArea(int parametroBusquedaArea) {
        this.parametroBusquedaArea = parametroBusquedaArea;
    }

    public int getParametroBusquedaPoblacion() {
        return parametroBusquedaPoblacion;
    }

    public void setParametroBusquedaPoblacion(int parametroBusquedaPoblacion) {
        this.parametroBusquedaPoblacion = parametroBusquedaPoblacion;
    }

    private void crearMensajeGrowl(String mensaje, FacesMessage.Severity tipoMensaje) {
        FacesMessage message = new FacesMessage(tipoMensaje, mensaje, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
