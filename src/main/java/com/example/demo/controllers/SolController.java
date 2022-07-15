package com.example.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.SolDao;

import dnl.utils.text.table.TextTable;

@ShellComponent
@ShellCommandGroup("Sol commands")
public class SolController {
    @Autowired
    private SolDao SolDao;

    @ShellMethod("Get the current status in all branches in Table: Sol (Only Important Information)")
    public void checkSolGeneralStatus() {
        List<Object[]> listSol = SolDao.checkSolGeneralStatus();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

        String[] columnNames = {"#","sol_quantity","sol_bod_date","sol_cls_date","db_stat_code","sol_cls_flg","sol_restartability_flg"};
        
        Object[][] data = new Object[listSol.size()][columnNames.length]; //[1][7]

        //System.out.println(listSol.size() + " - " + columnNames.length);

        int i = 0;
        for (Object[] objects : listSol) {
            int j = 0;
            //System.out.println("[" + i + "] [" + j + "] = " + (i + 1));
            data[i][j] = i + 1;
            for (Object object : objects) {
                j++;
                //System.out.println("[" + i + "] [" + j + "] = " + object);
                data[i][j] = j == 2 || j == 3 ? formatter.format(object) : object;
            }
            i++;
        }
        
        TextTable tt = new TextTable(columnNames, data);                                                         
        tt.printTable();
        System.out.println("");
        System.out.println(listSol.size() + " row(s)");
    }
}