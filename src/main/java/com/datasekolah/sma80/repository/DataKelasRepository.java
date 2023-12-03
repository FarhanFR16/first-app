package com.datasekolah.sma80.repository;

import com.datasekolah.sma80.dto.DataKelasProjection;
import com.datasekolah.sma80.entity.DataKelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataKelasRepository extends JpaRepository<DataKelas, Integer> {

    @Query(value = "select dk.id idKelas, dk.kelas namaKelas from data_kelas dk \n" +
            "join data_siswa ds on dk.id = ds.id_kelas \n" +
            "group by dk.id, dk.kelas\n" +
            "order by dk.kelas", nativeQuery = true)
    List<DataKelasProjection> getKelas();

}
