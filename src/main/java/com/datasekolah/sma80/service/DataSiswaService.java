package com.datasekolah.sma80.service;

import com.datasekolah.sma80.dto.*;
import com.datasekolah.sma80.entity.DataKelas;
import com.datasekolah.sma80.entity.DataNilai;
import com.datasekolah.sma80.entity.DataSiswa;
import com.datasekolah.sma80.entity.MataPelajaran;
import com.datasekolah.sma80.repository.DataKelasRepository;
import com.datasekolah.sma80.repository.DataNilaiRepository;
import com.datasekolah.sma80.repository.DataSiswaRepository;
import com.datasekolah.sma80.repository.MataPelajaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataSiswaService {

    @Autowired
    private DataKelasRepository dataKelasRepository;

    @Autowired
    private DataNilaiRepository dataNilaiRepository;

    @Autowired
    private DataSiswaRepository dataSiswaRepository;

    @Autowired
    private MataPelajaranRepository mataPelajaranRepository;


    public List<DataSiswa> getAllDataSiswa(){
        return dataSiswaRepository.findAll();
    }

    public List<DataNilai> getAllDataNilai(){
        return dataNilaiRepository.findAll();
    }

    public List<MataPelajaran> getMataPelajaran(){
        return mataPelajaranRepository.findAll();
    }

    public List<DataKelas> getAllDataKelas(){
        return dataKelasRepository.findAll();
    }

    public List<DataSiswaDto> getAllDataSiswaDto(){
        List<DataSiswaDto> dataSiswaDtoList = new ArrayList<>();
        List<DataSiswa> dataSiswaList = dataSiswaRepository.findAll();
        for ( DataSiswa dataSiswa : dataSiswaList) {
          DataSiswaDto dataSiswaDto = new DataSiswaDto();
          dataSiswaDto.setIdSiswa(dataSiswa.getId());
          dataSiswaDto.setIdKelas(dataSiswa.getDataKelas().getId());
          dataSiswaDto.setNama(dataSiswa.getNama());
          dataSiswaDto.setJenisKelamin(dataSiswa.getJenisKelamin());
          dataSiswaDto.setKelas(dataSiswa.getDataKelas().getKelas());
          dataSiswaDtoList.add(dataSiswaDto);
        }
        return dataSiswaDtoList;
    }

    public AddDataSiswaDto saveDataSiswa(AddDataSiswaDto addDataSiswaDto){
        DataSiswa dataSiswa = new DataSiswa();
        dataSiswa.setId(addDataSiswaDto.getIdSiswa());
        dataSiswa.setNama(addDataSiswaDto.getNama());
        dataSiswa.setJenisKelamin(addDataSiswaDto.getJenisKelamin());

        DataKelas dataKelas = new DataKelas();
        dataKelas.setId(addDataSiswaDto.getIdKelas());
        dataSiswa.setDataKelas(dataKelas);

        dataSiswaRepository.save(dataSiswa);
        return addDataSiswaDto;
    }


    public DataSiswaDto getDataSiswaById(int id){
        DataSiswa dataSiswa = dataSiswaRepository.findById(id).get();
        DataSiswaDto dataSiswaDto = new DataSiswaDto();
        dataSiswaDto.setIdSiswa(dataSiswa.getId());
        dataSiswaDto.setIdKelas(dataSiswa.getDataKelas().getId());
        dataSiswaDto.setNama(dataSiswa.getNama());
        dataSiswaDto.setJenisKelamin(dataSiswa.getJenisKelamin());
        dataSiswaDto.setKelas(dataSiswa.getDataKelas().getKelas());
        return dataSiswaDto;
    }

    public List<DataNilaiSiswaDto> getAllNilaiSiswa(){
        List<DataNilaiSiswaDto> dataNilaiSiswaDtoList = new ArrayList<>();
        List<DataNilai> dataNilaiList = dataNilaiRepository.findAll();
        for (DataNilai dataNilai : dataNilaiList) {
            DataNilaiSiswaDto dataNilaiSiswaDto = new DataNilaiSiswaDto();
            dataNilaiSiswaDto.setIdNilaiSiswa(dataNilai.getId());
            dataNilaiSiswaDto.setIdSiswa(dataNilai.getDataSiswa().getId());
            dataNilaiSiswaDto.setIdMataPelajaran(dataNilai.getMataPelajaran().getId());
            dataNilaiSiswaDto.setIdKelas(dataNilai.getDataSiswa().getDataKelas().getId());
            dataNilaiSiswaDto.setNama(dataNilai.getDataSiswa().getNama());
            dataNilaiSiswaDto.setNilai(dataNilai.getNilai());
            dataNilaiSiswaDto.setNamaMataPelajaran(dataNilai.getMataPelajaran().getNamaMataPelajaran());
            dataNilaiSiswaDto.setKelas(dataNilai.getDataSiswa().getDataKelas().getKelas());
            dataNilaiSiswaDtoList.add(dataNilaiSiswaDto);

        }
        return dataNilaiSiswaDtoList;
    }

    public DataNilaiSiswaDto getDataNilaiSiswaById(int id){
        DataNilai dataNilai = dataNilaiRepository.findById(id).get();
        DataNilaiSiswaDto dataNilaiSiswaDto = new DataNilaiSiswaDto();
        dataNilaiSiswaDto.setIdNilaiSiswa(dataNilai.getId());
        dataNilaiSiswaDto.setIdSiswa(dataNilai.getDataSiswa().getId());
        dataNilaiSiswaDto.setIdMataPelajaran(dataNilai.getMataPelajaran().getId());
        dataNilaiSiswaDto.setIdKelas(dataNilai.getDataSiswa().getDataKelas().getId());
        dataNilaiSiswaDto.setNama(dataNilai.getDataSiswa().getNama());
        dataNilaiSiswaDto.setNilai(dataNilai.getNilai());
        dataNilaiSiswaDto.setNamaMataPelajaran(dataNilai.getMataPelajaran().getNamaMataPelajaran());
        dataNilaiSiswaDto.setKelas(dataNilai.getDataSiswa().getDataKelas().getKelas());
        return dataNilaiSiswaDto;
    }

    public List<DataNilaiSiswaDto> getAllNilaiSiswa(String mataPelajaran){
        List<DataNilaiSiswaDto> dataNilaiSiswaDtoList = new ArrayList<>();
        List<DataNilai> dataNilaiList = dataNilaiRepository.findAll();
        for (DataNilai dataNilai : dataNilaiList) {
            if(dataNilai.getMataPelajaran().getNamaMataPelajaran().equalsIgnoreCase(mataPelajaran)) {
                DataNilaiSiswaDto dataNilaiSiswaDto = new DataNilaiSiswaDto();
                dataNilaiSiswaDto.setIdNilaiSiswa(dataNilai.getId());
                dataNilaiSiswaDto.setIdMataPelajaran(dataNilai.getMataPelajaran().getId());
                dataNilaiSiswaDto.setIdSiswa(dataNilai.getDataSiswa().getId());
                dataNilaiSiswaDto.setIdKelas(dataNilai.getDataSiswa().getDataKelas().getId());
                dataNilaiSiswaDto.setNama(dataNilai.getDataSiswa().getNama());
                dataNilaiSiswaDto.setNilai(dataNilai.getNilai());
                dataNilaiSiswaDto.setNamaMataPelajaran(dataNilai.getMataPelajaran().getNamaMataPelajaran());
                dataNilaiSiswaDto.setKelas(dataNilai.getDataSiswa().getDataKelas().getKelas());
                dataNilaiSiswaDtoList.add(dataNilaiSiswaDto);
            }

        }
        return dataNilaiSiswaDtoList;
    }

    public List<DataNilaiSiswaDto> getAllNilaiSiswa(String mataPelajaran, int nilai){
        List<DataNilaiSiswaDto> dataNilaiSiswaDtoList = new ArrayList<>();
        List<DataNilai> dataNilaiList = dataNilaiRepository.findAll();
        for (DataNilai dataNilai : dataNilaiList) {
            if(dataNilai.getMataPelajaran().getNamaMataPelajaran().equalsIgnoreCase(mataPelajaran) && dataNilai.getNilai() > nilai) {
                DataNilaiSiswaDto dataNilaiSiswaDto = new DataNilaiSiswaDto();
                dataNilaiSiswaDto.setIdNilaiSiswa(dataNilai.getId());
                dataNilaiSiswaDto.setIdMataPelajaran(dataNilai.getMataPelajaran().getId());
                dataNilaiSiswaDto.setIdSiswa(dataNilai.getDataSiswa().getId());
                dataNilaiSiswaDto.setIdKelas(dataNilai.getDataSiswa().getDataKelas().getId());
                dataNilaiSiswaDto.setNama(dataNilai.getDataSiswa().getNama());
                dataNilaiSiswaDto.setNilai(dataNilai.getNilai());
                dataNilaiSiswaDto.setNamaMataPelajaran(dataNilai.getMataPelajaran().getNamaMataPelajaran());
                dataNilaiSiswaDto.setKelas(dataNilai.getDataSiswa().getDataKelas().getKelas());
                dataNilaiSiswaDtoList.add(dataNilaiSiswaDto);
            }

        }
        return dataNilaiSiswaDtoList;
    }


    public AddDataNilaiSiswaDto saveDataNilaiSiswa(AddDataNilaiSiswaDto addDataNilaiSiswaDto){
        DataNilai dataNilai = new DataNilai();
        dataNilai.setId(addDataNilaiSiswaDto.getIdNilaiSiswa());
        dataNilai.setNilai(addDataNilaiSiswaDto.getNilai());

        DataSiswa dataSiswa = new DataSiswa();
        dataSiswa.setId(addDataNilaiSiswaDto.getIdSiswa());
        dataNilai.setDataSiswa(dataSiswa);

        MataPelajaran mataPelajaran = new MataPelajaran();
        mataPelajaran.setId(addDataNilaiSiswaDto.getIdMataPelajaran());
        dataNilai.setMataPelajaran(mataPelajaran);

        dataNilaiRepository.save(dataNilai);
        return addDataNilaiSiswaDto;
    }

    public void deleteDataSiswa(int id){
        dataSiswaRepository.deleteById(id);
    }

    public List<DataKelas> getListDataKelas(){
        var dataKelasList = new ArrayList<DataKelas>();
        var dataKelasProjectionList = dataKelasRepository.getKelas();
        for (DataKelasProjection dataKelasProjection : dataKelasProjectionList) {
            var dataKelas = new DataKelas();
            dataKelas.setKelas(dataKelasProjection.getNamaKelas());
            dataKelas.setId(dataKelasProjection.getIdKelas());
            dataKelasList.add(dataKelas);
        }

        return dataKelasList;
    }

    public List<DataSiswa> getDataSiswaByKelas(int idKelas){
        return dataSiswaRepository.getSiswaByIdKelas(idKelas);
    }

    public MataPelajaran getNamaMataPelajaran(String mataPelajaran){
        return mataPelajaranRepository.namaMataPelajaran(mataPelajaran);
    }
    public List<DataSiswa> getDataSiswaById(String mataPelajaran, int idKelas){
        return dataSiswaRepository.getDataSiswaByIdKelas(mataPelajaran, idKelas);
    }
}
