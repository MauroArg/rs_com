/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs_com.controller;

import com.rs_com.connection.ConnectionFactory;
import com.rs_com.entity.Candidato;
import javax.persistence.EntityManager;

/**
 *
 * @author Mauricio Argumedo
 * Fecha: 20-09/2020
 * Version: 1.0
 * Institucion: ITCA-FEPADE
 */
public class CandidatoController extends AbstractController<Candidato> {

    @Override
    protected EntityManager getEntityManager() {
        return ConnectionFactory.getInstance().getEntityManagerFactory().createEntityManager();
    }
    
}
