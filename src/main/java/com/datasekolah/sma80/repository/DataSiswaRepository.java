package com.datasekolah.sma80.repository;

import com.datasekolah.sma80.entity.DataSiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataSiswaRepository extends JpaRepository<DataSiswa, Integer> {

    @Query(value = "select ds from DataSiswa ds where ds.dataKelas.id = :idKelas")
    List<DataSiswa> getSiswaByIdKelas(int idKelas);

    @Query(value = "select * from data_siswa ds \n" +
            "where ds.id not in (select ds2.id from data_siswa ds2 \n" +
            "join data_nilai dn on ds2.id = dn.id_siswa \n" +
            "join mata_pelajaran mp on mp.id = dn.id_mata_pelajaran \n" +
            "where mp.nama_mata_pelajaran = :mataPelajaran) and ds.id_kelas = :idKelas", nativeQuery = true)
    List<DataSiswa> getDataSiswaByIdKelas(String mataPelajaran, int idKelas);

}