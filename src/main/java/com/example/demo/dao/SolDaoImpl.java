package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Sol;

@Repository
@Transactional
public class SolDaoImpl implements SolDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Sol> checkSolByFlgCombination(String flg_combination) {
        String query = "FROM Sol WHERE del_flg = 'N' AND db_stat_code || sol_cls_flg || sol_restartability_flg = '" + flg_combination + "'";
        return entityManager.createQuery(query, Sol.class).getResultList();
    }
    
}
