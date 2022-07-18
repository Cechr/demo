package com.example.demo.dao;

import java.util.List;

import com.example.demo.models.Bjs;

public interface BjsDao {
    List<Bjs> getBjsFromSol(String sol_id);
}
