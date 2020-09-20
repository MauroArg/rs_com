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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Votos.findAll", query = "SELECT v FROM Votos v")
    , @NamedQuery(name = "Votos.findByVotosPartido", query = "SELECT v FROM Votos v WHERE v.votosPartido = :votosPartido")
    , @NamedQuery(name = "Votos.findByPkey", query = "SELECT v FROM Votos v WHERE v.pkey = :pkey")})
public class Votos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "votos_partido", nullable = false)
    private int votosPartido;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer pkey;
    @JoinColumn(name = "id_junta", referencedColumnName = "id_junta", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Junta idJunta;
    @JoinColumn(name = "id_partido", referencedColumnName = "id_partido", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Partido idPartido;

    public Votos() {
    }

    public Votos(Integer pkey) {
        this.pkey = pkey;
    }

    public Votos(Integer pkey, int votosPartido) {
        this.pkey = pkey;
        this.votosPartido = votosPartido;
    }

    public int getVotosPartido() {
        return votosPartido;
    }

    public void setVotosPartido(int votosPartido) {
        this.votosPartido = votosPartido;
    }

    public Integer getPkey() {
        return pkey;
    }

    public void setPkey(Integer pkey) {
        this.pkey = pkey;
    }

    public Junta getIdJunta() {
        return idJunta;
    }

    public void setIdJunta(Junta idJunta) {
        this.idJunta = idJunta;
    }

    public Partido getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Partido idPartido) {
        this.idPartido = idPartido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkey != null ? pkey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Votos)) {
            return false;
        }
        Votos other = (Votos) object;
        if ((this.pkey == null && other.pkey != null) || (this.pkey != null && !this.pkey.equals(other.pkey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rs_com.entity.Votos[ pkey=" + pkey + " ]";
    }
    
}
