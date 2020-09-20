/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs_com.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mauricio Argumedo
 * Fecha: 20-09/2020
 * Version: 1.0
 * Institucion: ITCA-FEPADE
 */
public class ConnectionFactory {
    private EntityManagerFactory entityManagerFactory;
    private final static ConnectionFactory factory = new ConnectionFactory();
    
    private ConnectionFactory()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpaPU");
    }
    
    public static ConnectionFactory getInstance()
    {
        return factory;
    }

    public EntityManagerFactory getFactory() 
    {
        return entityManagerFactory;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}
