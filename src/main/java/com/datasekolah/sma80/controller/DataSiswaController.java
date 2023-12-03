package com.datasekolah.sma80.controller;

import com.datasekolah.sma80.dto.AddDataNilaiSiswaDto;
import com.datasekolah.sma80.dto.AddDataSiswaDto;
import com.datasekolah.sma80.dto.DataNilaiSiswaDto;
import com.datasekolah.sma80.dto.DataSiswaDto;
import com.datasekolah.sma80.entity.DataKelas;
import com.datasekolah.sma80.entity.DataNilai;
import com.datasekolah.sma80.entity.DataSiswa;
import com.datasekolah.sma80.entity.MataPelajaran;
import com.datasekolah.sma80.service.DataSiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(value = "*")
public class DataSiswaController {

    @Autowired
    private DataSiswaService dataSiswaService;

    @GetMapping("/getAllDataSiswa")
    public List<DataSiswa> getAllDataSiswa(){
        return dataSiswaService.getAllDataSiswa();
    }

    @GetMapping("/getAllDataNilai")
    public List<DataNilai> getAllDataNilai(){
        return dataSiswaService.getAllDataNilai();
    }

    @GetMapping("/findMataPelajaran")
    public List<MataPelajaran> findAllMataPelajaran(){
        return dataSiswaService.getMataPelajaran();
    }

    @GetMapping("/getAllDataKelas")
    public List<DataKelas> getAllDataKelas(){
        return dataSiswaService.getAllDataKelas();
    }

    @GetMapping("/getAllDataSiswaDto")
    public List<DataSiswaDto> findDataSiswa(){
        return dataSiswaService.getAllDataSiswaDto();
    }

    @PostMapping("/addDataSiswa")
    public AddDataSiswaDto addDataSiswaDto(@RequestBody AddDataSiswaDto addDataSiswaDto){
        return dataSiswaService.saveDataSiswa(addDataSiswaDto);
    }

    @GetMapping("/getAllDataSiswaDto/{id}")
    public DataSiswaDto findDataSiswaById(@PathVariable int id){
        return dataSiswaService.getDataSiswaById(id);
    }

    @GetMapping("/getAllDataNilaiDto")
    public List<DataNilaiSiswaDto> findDataNilaiSiswa(){
        return dataSiswaService.getAllNilaiSiswa();
    }

    @PostMapping("/addDataNilaiSiswa")
    public AddDataNilaiSiswaDto addDataNilaiSiswa(@RequestBody AddDataNilaiSiswaDto addDataNilaiSiswaDto){
        return dataSiswaService.saveDataNilaiSiswa(addDataNilaiSiswaDto);
    }

    @GetMapping("/findDataNilaiSiswa/{id}")
    public DataNilaiSiswaDto findDataNilaiSiswaById(@PathVariable int id){
        return dataSiswaService.getDataNilaiSiswaById(id);
    }

    @GetMapping("/findDataNilaiByMataPelajaran/{mataPelajaran}")
    public List<DataNilaiSiswaDto> findDataNilaiSiswa(@PathVariable String mataPelajaran){
        return dataSiswaService.getAllNilaiSiswa(mataPelajaran);
    }

    @GetMapping("/findDataNilaiByNilai/{mataPelajaran}/{nilai}")
    public List<DataNilaiSiswaDto> findDataNilaiSiswa(@PathVariable String mataPelajaran, @PathVariable int nilai){
        return dataSiswaService.getAllNilaiSiswa(mataPelajaran, nilai);
    }

    @DeleteMapping("/deleteDataSiswaById/{id}")
    public void deleteDataSiswaById(@PathVariable int id){
        dataSiswaService.deleteDataSiswa(id);
    }

    @GetMapping("/getKelasList")
    public List<DataKelas> getKelasList(){
        return dataSiswaService.getListDataKelas();
    }

    @GetMapping("/getDataSiswaByKelas/{idKelas}")
    public List<DataSiswa> getDataSiswaByKelas(@PathVariable int idKelas){
        return dataSiswaService.getDataSiswaByKelas(idKelas);
    }

    @GetMapping("/getNamaMataPelajaran/{mataPelajaran}")
    public MataPelajaran findNamaMataPelajaran(@PathVariable String mataPelajaran){
        return dataSiswaService.getNamaMataPelajaran(mataPelajaran);
    }
    @GetMapping("/getDataSiswaById/{mataPelajaran}/{idKelas}")
    public List<DataSiswa> findDataSiswaByIdKelas (@PathVariable String mataPelajaran, @PathVariable int idKelas){
        return dataSiswaService.getDataSiswaById(mataPelajaran, idKelas);
    }


}
