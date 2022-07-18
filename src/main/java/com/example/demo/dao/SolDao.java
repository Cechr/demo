package com.example.demo.dao;

import java.util.List;

import com.example.demo.models.Sol;

public interface SolDao {
    List<Sol> checkSolByFlgCombination(String flg_combination);
}
