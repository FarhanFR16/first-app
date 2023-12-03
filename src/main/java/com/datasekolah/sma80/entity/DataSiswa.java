package com.datasekolah.sma80.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "data_siswa")
public class DataSiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nama;

    private String jenisKelamin;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="id_kelas")
    private DataKelas dataKelas;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dataSiswa")
    private List<DataNilai> dataNilaiList;

}
