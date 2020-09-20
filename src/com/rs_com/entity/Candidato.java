/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs_com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(catalog = "bdrs_com", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_part"})})
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c")
    , @NamedQuery(name = "Candidato.findByIdCand", query = "SELECT c FROM Candidato c WHERE c.idCand = :idCand")
    , @NamedQuery(name = "Candidato.findByNombreCand", query = "SELECT c FROM Candidato c WHERE c.nombreCand = :nombreCand")})
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cand", nullable = false)
    private Integer idCand;
    @Basic(optional = false)
    @Column(name = "nombre_cand", nullable = false, length = 50)
    private String nombreCand;
    @JoinColumn(name = "id_part", referencedColumnName = "id_partido", nullable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Partido idPart;

    public Candidato() {
    }

    public Candidato(Integer idCand) {
        this.idCand = idCand;
    }

    public Candidato(Integer idCand, String nombreCand) {
        this.idCand = idCand;
        this.nombreCand = nombreCand;
    }

    public Integer getIdCand() {
        return idCand;
    }

    public void setIdCand(Integer idCand) {
        this.idCand = idCand;
    }

    public String getNombreCand() {
        return nombreCand;
    }

    public void setNombreCand(String nombreCand) {
        this.nombreCand = nombreCand;
    }

    public Partido getIdPart() {
        return idPart;
    }

    public void setIdPart(Partido idPart) {
        this.idPart = idPart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCand != null ? idCand.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidato)) {
            return false;
        }
        Candidato other = (Candidato) object;
        if ((this.idCand == null && other.idCand != null) || (this.idCand != null && !this.idCand.equals(other.idCand))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rs_com.entity.Candidato[ idCand=" + idCand + " ]";
    }
    
}
