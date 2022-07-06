package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Bjs;

@Repository
@Transactional
public class BjsDaoImpl implements BjsDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Bjs> getBjs(String sol_id) {
        String query = "FROM Bjs WHERE sol_id = '" + sol_id + "'";
        return entityManager.createQuery(query, Bjs.class).getResultList();
    }
    
}
