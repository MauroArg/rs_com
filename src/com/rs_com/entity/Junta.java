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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Junta.findAll", query = "SELECT j FROM Junta j")
    , @NamedQuery(name = "Junta.findByIdJunta", query = "SELECT j FROM Junta j WHERE j.idJunta = :idJunta")
    , @NamedQuery(name = "Junta.findByVotasJunta", query = "SELECT j FROM Junta j WHERE j.votasJunta = :votasJunta")})
public class Junta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_junta", nullable = false)
    private Integer idJunta;
    @Basic(optional = false)
    @Column(name = "votas_junta", nullable = false)
    private int votasJunta;
    @JoinColumn(name = "id_centro", referencedColumnName = "id_centro", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CentroVotacion idCentro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJunta", fetch = FetchType.LAZY)
    private List<Votos> votosList;

    public Junta() {
    }

    public Junta(Integer idJunta) {
        this.idJunta = idJunta;
    }

    public Junta(Integer idJunta, int votasJunta) {
        this.idJunta = idJunta;
        this.votasJunta = votasJunta;
    }

    public Integer getIdJunta() {
        return idJunta;
    }

    public void setIdJunta(Integer idJunta) {
        this.idJunta = idJunta;
    }

    public int getVotasJunta() {
        return votasJunta;
    }

    public void setVotasJunta(int votasJunta) {
        this.votasJunta = votasJunta;
    }

    public CentroVotacion getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(CentroVotacion idCentro) {
        this.idCentro = idCentro;
    }

    public List<Votos> getVotosList() {
        return votosList;
    }

    public void setVotosList(List<Votos> votosList) {
        this.votosList = votosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJunta != null ? idJunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Junta)) {
            return false;
        }
        Junta other = (Junta) object;
        if ((this.idJunta == null && other.idJunta != null) || (this.idJunta != null && !this.idJunta.equals(other.idJunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rs_com.entity.Junta[ idJunta=" + idJunta + " ]";
    }
    
}
