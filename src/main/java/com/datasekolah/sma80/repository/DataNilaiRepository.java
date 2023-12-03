package com.datasekolah.sma80.repository;

import com.datasekolah.sma80.entity.DataNilai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataNilaiRepository extends JpaRepository<DataNilai, Integer> {


}
