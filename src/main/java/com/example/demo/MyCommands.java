package com.example.demo;

import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellComponent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.BjsDao;
import com.example.demo.models.Bjs;

@ShellComponent
public class MyCommands {

    @ShellMethod("Add two integers together.")
    public int add(int a, int b) {
        return a + b;
    }
    
    @Autowired
    private BjsDao bjsDao;

    @ShellMethod("Get a list of Batch Jobs in table bjs.")
    public List<Bjs> getBjs(String sol_id) {
        return bjsDao.getBjs(sol_id);
    }
}
