package com.datasekolah.sma80.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "data_nilai")
public class DataNilai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int nilai;

    @OneToOne
    @JoinColumn(name = "id_mata_pelajaran")
    private MataPelajaran mataPelajaran;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_siswa")
    private DataSiswa dataSiswa;

}
