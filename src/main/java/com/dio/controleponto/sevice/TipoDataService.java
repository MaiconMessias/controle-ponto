package com.dio.controleponto.sevice;

import com.dio.controleponto.model.TipoData;
import com.dio.controleponto.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDataService {
    TipoDataRepository tipoDataRepository;

    @Autowired
    public TipoDataService(TipoDataRepository tipoDataRepository) {
        this.tipoDataRepository = tipoDataRepository;
    }

    public TipoData save(TipoData tipoData){
        return tipoDataRepository.save(tipoData);
    }

    public List<TipoData> findAll() {
        return tipoDataRepository.findAll();
    }

    public Optional<TipoData> getById(Long idTpData) {
        return tipoDataRepository.findById(idTpData);
    }

    public TipoData updateTpOcorr(TipoData tipodata){
        return tipoDataRepository.save(tipodata);
    }

    public void deleteTpOcorr(Long idTpData) {
        tipoDataRepository.deleteById(idTpData);
    }
}