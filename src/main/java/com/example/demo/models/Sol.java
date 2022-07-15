package com.example.demo.models;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "sol", schema = "tbaadm")
@ToString
public class Sol {

    @Id
    @Getter @Column(name = "sol_id", unique = true, nullable = false)
    private String sol_id;

    @Getter @Column(name = "sol_bod_date")
    private Date sol_bod_date;

    @Getter @Column(name = "sol_cls_date")
    private Date sol_cls_date;

    @Getter @Column(name = "db_stat_code")
    private char db_stat_code;
    
    @Getter @Column(name = "sol_cls_flg")
    private char sol_cls_flg;

    @Getter @Column(name = "sol_restartability_flg")
    private char sol_restartability_flg;
}