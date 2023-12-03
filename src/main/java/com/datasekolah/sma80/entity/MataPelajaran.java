package com.datasekolah.sma80.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "mata_pelajaran")
public class MataPelajaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String namaMataPelajaran;

}
