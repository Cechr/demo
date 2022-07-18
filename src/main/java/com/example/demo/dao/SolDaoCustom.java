package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Sol;

@Repository
public interface SolDaoCustom extends JpaRepository<Sol, Integer>{
    @Query("SELECT count (1), sol_bod_date, sol_cls_date, db_stat_code, sol_cls_flg, sol_restartability_flg FROM Sol WHERE del_flg = 'N' GROUP BY sol_bod_date, sol_cls_date, db_stat_code, sol_cls_flg, sol_restartability_flg")
    List<Object[]> checkSolGeneralStatus();
}
