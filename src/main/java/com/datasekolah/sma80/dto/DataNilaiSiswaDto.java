package com.datasekolah.sma80.dto;

import lombok.Data;

@Data
public class DataNilaiSiswaDto {

    private int idNilaiSiswa;
    private int idMataPelajaran;
    private int idSiswa;
    private String nama;
    private String kelas;
    private String namaMataPelajaran;
    private int nilai;
}
