package com.datasekolah.sma80.dto;

import lombok.Data;

@Data
public class AddDataNilaiSiswaDto {

    private int idNilaiSiswa;
    private int idMataPelajaran;
    private int idKelas;
    private int idSiswa;
    private int nilai;
}
