/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs_com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Mauricio Argumedo
 * Fecha: 20-09/2020
 * Version: 1.0
 * Institucion: ITCA-FEPADE
 */
@Entity
@Table(catalog = "bdrs_com", schema = "")
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")
    , @NamedQuery(name = "Municipio.findByIdMun", query = "SELECT m FROM Municipio m WHERE m.idMun = :idMun")
    , @NamedQuery(name = "Municipio.findByNombreMun", query = "SELECT m FROM Municipio m WHERE m.nombreMun = :nombreMun")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_mun", nullable = false)
    private Integer idMun;
    @Basic(optional = false)
    @Column(name = "nombre_mun", nullable = false, length = 20)
    private String nombreMun;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idMun", fetch = FetchType.LAZY)
    private CentroVotacion centroVotacion;
    @JoinColumn(name = "id_dep", referencedColumnName = "id_dep", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departamento idDep;

    public Municipio() {
    }

    public Municipio(Integer idMun) {
        this.idMun = idMun;
    }

    public Municipio(Integer idMun, String nombreMun) {
        this.idMun = idMun;
        this.nombreMun = nombreMun;
    }

    public Integer getIdMun() {
        return idMun;
    }

    public void setIdMun(Integer idMun) {
        this.idMun = idMun;
    }

    public String getNombreMun() {
        return nombreMun;
    }

    public void setNombreMun(String nombreMun) {
        this.nombreMun = nombreMun;
    }

    public CentroVotacion getCentroVotacion() {
        return centroVotacion;
    }

    public void setCentroVotacion(CentroVotacion centroVotacion) {
        this.centroVotacion = centroVotacion;
    }

    public Departamento getIdDep() {
        return idDep;
    }

    public void setIdDep(Departamento idDep) {
        this.idDep = idDep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMun != null ? idMun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.idMun == null && other.idMun != null) || (this.idMun != null && !this.idMun.equals(other.idMun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rs_com.entity.Municipio[ idMun=" + idMun + " ]";
    }
    
}
