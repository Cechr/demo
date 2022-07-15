package com.example.demo.models;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "bjs", schema = "tbaadm")
@ToString
public class Bjs {

    @Getter @Column(name = "sol_id", unique = true, nullable = false)
    private String sol_id;

    @Getter @Column(name = "job_group")
    private String job_group;

    @Id
    @Getter @Column(name = "job_id")
    private String job_id;

    @Getter @Column(name = "job_desc")
    private String job_desc;

    @Getter @Column(name = "next_exec_date")
    private Date next_exec_date;

    @Getter @Column(name = "job_freq_type")
    private char job_freq_type;    
}