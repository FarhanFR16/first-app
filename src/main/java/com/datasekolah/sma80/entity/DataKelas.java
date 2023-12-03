package com.datasekolah.sma80.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "data_kelas")
public class DataKelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "kelas")
    private String kelas;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dataKelas")
    private List<DataSiswa> dataSiswaList;

}
