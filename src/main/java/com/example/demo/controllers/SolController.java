package com.example.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.SolDaoCustom;
import com.example.demo.models.Sol;
import com.example.demo.dao.SolDao;

import dnl.utils.text.table.TextTable;

@ShellComponent
@ShellCommandGroup("Sol commands")
public class SolController {
    @Autowired
    private SolDaoCustom solDaoCustom;

    @Autowired
    private SolDao solDao;

    @ShellMethod(value = "Get the current status in all branches in Table: Sol (Only Important Information)", key = "chsolgenstat")
    public void checkSolGeneralStatus() {
        List<Object[]> listSol = solDaoCustom.checkSolGeneralStatus();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

        String[] columnNames = {"#","sol_quantity","sol_bod_date","sol_cls_date","db_stat_code","sol_cls_flg","sol_restartability_flg"};
        
        Object[][] data = new Object[listSol.size()][columnNames.length]; //[1][7]

        ArrayList<String> flg_combination_list = new ArrayList<String>();

        int i = 0;
        for (Object[] objects : listSol) {
            String flg_combination = "";
            int j = 0;            
            //System.out.println("[" + i + "] [" + j + "] = " + (i + 1));
            data[i][j] = i + 1;
            for (Object object : objects) {
                j++;
                //System.out.println("[" + i + "] [" + j + "] = " + object);
                data[i][j] = j == 2 || j == 3 ? formatter.format(object) : object;
                flg_combination += j == 4 || j == 5 || j == 6 ? object : "";
            }

            if (!("YYN".equals(flg_combination))) {
                flg_combination_list.add(flg_combination);
            }

            i++;
        }

        TextTable tt = new TextTable(columnNames, data);                                                         
        tt.printTable();
        System.out.println("");
        System.out.println(listSol.size() + " row(s)");

        if(flg_combination_list.size() > 0) {
            System.out.println("Se han encontrado incidencias en sucursales, se proceden a puntualizar cuales son: ");
        }

        for (String flg_combination : flg_combination_list) {
            //System.out.println(flg_combination);
            checkSolByFlgCombination(flg_combination);
        }
    }

    @ShellMethod(value = "Get the current status in a branche by flag combination in Table: Sol (Only Important Information)", key = "chsolflgcomb")
    public void checkSolByFlgCombination(String flg_combination) {       

        List<Sol> listBjs = solDao.checkSolByFlgCombination(flg_combination);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

        String[] columnNames = {"#","sol_id","sol_bod_date","sol_cls_date","db_stat_code","sol_cls_flg","sol_restartability_flg"};
        
        Object[][] data = new Object[listBjs.size()][columnNames.length];

        for (int i = 0; i < listBjs.size(); i++) {
            //System.out.println(listBjs.get(i));
            int j = columnNames.length;
            data[i][columnNames.length - (j--)] = i + 1;
            data[i][columnNames.length - (j--)] = listBjs.get(i).getSol_id();
            data[i][columnNames.length - (j--)] = formatter.format(listBjs.get(i).getSol_bod_date());
            data[i][columnNames.length - (j--)] = formatter.format(listBjs.get(i).getSol_cls_date());
            data[i][columnNames.length - (j--)] = listBjs.get(i).getDb_stat_code();
            data[i][columnNames.length - (j--)] = listBjs.get(i).getSol_cls_flg();
            data[i][columnNames.length - (j--)] = listBjs.get(i).getSol_restartability_flg();
        }

        TextTable tt = new TextTable(columnNames, data);                                                         
        tt.printTable();
        System.out.println("");
        System.out.println(listBjs.size() + " row(s)");
    }
}