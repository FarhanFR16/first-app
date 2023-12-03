package com.datasekolah.sma80.repository;

import com.datasekolah.sma80.entity.MataPelajaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MataPelajaranRepository extends JpaRepository<MataPelajaran, Integer> {

    @Query(value = "select * from mata_pelajaran mp \n" +
            "where nama_mata_pelajaran = :mataPelajaran" , nativeQuery = true)
    MataPelajaran namaMataPelajaran(String mataPelajaran);
}
