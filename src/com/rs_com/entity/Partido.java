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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Partido.findAll", query = "SELECT p FROM Partido p")
    , @NamedQuery(name = "Partido.findByIdPartido", query = "SELECT p FROM Partido p WHERE p.idPartido = :idPartido")
    , @NamedQuery(name = "Partido.findByNombrePart", query = "SELECT p FROM Partido p WHERE p.nombrePart = :nombrePart")})
public class Partido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_partido", nullable = false)
    private Integer idPartido;
    @Basic(optional = false)
    @Column(name = "nombre_part", nullable = false, length = 50)
    private String nombrePart;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPart", fetch = FetchType.LAZY)
    private Candidato candidato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPartido", fetch = FetchType.LAZY)
    private List<Votos> votosList;

    public Partido() {
    }

    public Partido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public Partido(Integer idPartido, String nombrePart) {
        this.idPartido = idPartido;
        this.nombrePart = nombrePart;
    }

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public String getNombrePart() {
        return nombrePart;
    }

    public void setNombrePart(String nombrePart) {
        this.nombrePart = nombrePart;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
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
        hash += (idPartido != null ? idPartido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partido)) {
            return false;
        }
        Partido other = (Partido) object;
        if ((this.idPartido == null && other.idPartido != null) || (this.idPartido != null && !this.idPartido.equals(other.idPartido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rs_com.entity.Partido[ idPartido=" + idPartido + " ]";
    }
    
}
