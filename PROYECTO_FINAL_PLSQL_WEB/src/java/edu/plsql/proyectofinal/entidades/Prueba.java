/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.plsql.proyectofinal.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dpinedar@ucentral.edu.co
 */
@Entity
@Table(name = "PRUEBA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prueba.findAll", query = "SELECT p FROM Prueba p")})
public class Prueba implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATO")
    private Long dato;
    @Size(max = 300)
    @Column(name = "MSG")
    private String msg;

    public Prueba() {
    }

    public Prueba(Long dato) {
        this.dato = dato;
    }

    public Long getDato() {
        return dato;
    }

    public void setDato(Long dato) {
        this.dato = dato;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dato != null ? dato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prueba)) {
            return false;
        }
        Prueba other = (Prueba) object;
        if ((this.dato == null && other.dato != null) || (this.dato != null && !this.dato.equals(other.dato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.plsql.proyectofinal.entidades.Prueba[ dato=" + dato + " ]";
    }
    
}
