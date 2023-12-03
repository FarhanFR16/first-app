package com.datasekolah.sma80.dto;

import lombok.Data;

@Data
public class AddDataSiswaDto {

    private int idSiswa;
    private int idKelas;
    private String nama;
    private String jenisKelamin;
}
