/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs_com.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Mauricio Argumedo
 * Fecha: 20-09/2020
 * Version: 1.0
 * Institucion: ITCA-FEPADE
 */
@Entity
@Table(name = "centro_votacion", catalog = "bdrs_com", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_mun"})})
@NamedQueries({
    @NamedQuery(name = "CentroVotacion.findAll", query = "SELECT c FROM CentroVotacion c")
    , @NamedQuery(name = "CentroVotacion.findByIdCentro", query = "SELECT c FROM CentroVotacion c WHERE c.idCentro = :idCentro")})
public class CentroVotacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_centro", nullable = false)
    private Integer idCentro;
    @JoinColumn(name = "id_mun", referencedColumnName = "id_mun", nullable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Municipio idMun;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCentro", fetch = FetchType.LAZY)
    private List<Junta> juntaList;

    public CentroVotacion() {
    }

    public CentroVotacion(Integer idCentro) {
        this.idCentro = idCentro;
    }

    public Integer getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(Integer idCentro) {
        this.idCentro = idCentro;
    }

    public Municipio getIdMun() {
        return idMun;
    }

    public void setIdMun(Municipio idMun) {
        this.idMun = idMun;
    }

    public List<Junta> getJuntaList() {
        return juntaList;
    }

    public void setJuntaList(List<Junta> juntaList) {
        this.juntaList = juntaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCentro != null ? idCentro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroVotacion)) {
            return false;
        }
        CentroVotacion other = (CentroVotacion) object;
        if ((this.idCentro == null && other.idCentro != null) || (this.idCentro != null && !this.idCentro.equals(other.idCentro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rs_com.entity.CentroVotacion[ idCentro=" + idCentro + " ]";
    }
    
}
