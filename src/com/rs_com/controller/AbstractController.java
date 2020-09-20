/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs_com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Mauricio Argumedo
 * Fecha: 20-09/2020
 * Version: 1.0
 * Institucion: ITCA-FEPADE
 */
public abstract class AbstractController <T>{
    public Class<T> entityClass;
    
    public void create(T entity) throws Exception
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
        finally
        {
            if (em.isOpen()) 
            {
                em.close();
            }
        }
    }
    
    public void edit(T entity) throws Exception
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
        finally
        {
            if (em.isOpen()) 
            {
                em.close();
            }
        }
    }
    
    public void delete(T entity) throws Exception
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
        finally
        {
            if (em.isOpen()) 
            {
                em.close();
            }
        }
    }
    
    public T find(T entity,Object id) throws Exception
    {
        EntityManager em = getEntityManager();
        
        try
        {
            return em.find((Class<T>) entity.getClass() , id);
           
        }
        catch(Exception e)
        {
            em.getTransaction().rollback();
            throw new Exception(e);
        }
        finally
        {
            if (em.isOpen()) 
            {
                em.close();
            }
        }
    }
    
    
    public List<T> findAll(T entity) throws Exception
    {
        
        EntityManager em = getEntityManager();
        
        
        List<T> entities = new ArrayList<>();
        
        try
        {
            String jpql = "SELECT o FROM " + entity.getClass().getSimpleName() + " o";
            Query q = em.createQuery(jpql);
            entities = q.getResultList();
        }
        catch(Exception e)
        {
            throw new Exception(e);
        }
        finally
        {
            if (em.isOpen()) 
            {
                em.close();
            }
        }
        return entities;
    }
    
    protected abstract EntityManager getEntityManager();
}
