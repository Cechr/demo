package com.example.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.BjsDao;
import com.example.demo.models.Bjs;

import dnl.utils.text.table.TextTable;

@ShellComponent
@ShellCommandGroup("Bjs commands")
public class BjsController {
    @Autowired
    private BjsDao bjsDao;

    @ShellMethod(value = "Get a list of Batch Jobs for a Branch in Table: Bjs (Only Important Information)", key = "bjsfromsol")
    public void getBjsFromSol(String sol_id) {
        List<Bjs> listBjs = bjsDao.getBjsFromSol(sol_id);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

        String[] columnNames = {"#","sol_id","job_group","job_id","job_desc","next_exec_date","job_freq_type"};
        
        Object[][] data = new Object[listBjs.size()][columnNames.length];

        for (int i = 0; i < listBjs.size(); i++) {
            //System.out.println(listBjs.get(i));
            int j = columnNames.length;
            data[i][columnNames.length - (j--)] = i + 1;
            data[i][columnNames.length - (j--)] = listBjs.get(i).getSol_id();
            data[i][columnNames.length - (j--)] = listBjs.get(i).getJob_group(); //== null ? "NULL" : listBjs.get(i).getJob_group();
            data[i][columnNames.length - (j--)] = listBjs.get(i).getJob_id();
            data[i][columnNames.length - (j--)] = listBjs.get(i).getJob_desc();
            data[i][columnNames.length - (j--)] = formatter.format(listBjs.get(i).getNext_exec_date());
            data[i][columnNames.length - (j--)] = listBjs.get(i).getJob_freq_type();
        }

        TextTable tt = new TextTable(columnNames, data);                                                         
        tt.printTable();
        System.out.println("");
        System.out.println(listBjs.size() + " row(s)");
    }

    @ShellMethod("Test format")
    public void table() {
        String[] columnNames = {"First Name",
                        "Last Name",
                        "Sport",
                        "# of Years",
                        "Vegetarian"};

        Object[][] data = {
            {"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)}/*,
            {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)} */
        };

        

        TextTable tt = new TextTable(columnNames, data);                                                         
        tt.printTable();

        for (int i = 0; i < 1; i++)
            for (int j = 0; j < 5; j++)
                System.out.println("arr[" + i + "][" + j + "] = "
                                   + data[i][j]);
    }
}