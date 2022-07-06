package com.example.demo.models;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "bjs", schema = "tbaadm")
@ToString
public class Bjs {

    @Id
    @Getter @Column(name = "sol_id", unique = true, nullable = false)
    private String sol_id;

    @Getter @Column(name = "job_id")
    private String job_id;

    @Getter @Column(name = "job_desc")
    private String job_desc;

    @Getter @Column(name = "job_freq_type")
    private char job_freq_type;

    @Getter @Column(name = "next_exec_date")
    private Date next_exec_date;

    @Getter @Column(name = "job_active_flg")
    private char job_active_flg;

    @Getter @Column(name = "job_prio_num")
    private int job_prio_num;

    @Getter @Column(name = "lchg_user_id")
    private char lchg_user_id;

    @Getter @Column(name = "lchg_time")
    private Date lchg_time;

    @Getter @Column(name = "blocking_job")
    private char blocking_job;

    @Getter @Column(name = "job_category")
    private char job_category;

    @Getter @Column(name = "job_group")
    private String job_group;
}