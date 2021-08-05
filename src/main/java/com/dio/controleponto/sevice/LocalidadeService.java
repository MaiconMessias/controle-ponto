package com.dio.controleponto.sevice;

import com.dio.controleponto.model.CategoriaUsuario;
import com.dio.controleponto.model.Localidade;
import com.dio.controleponto.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadeService {

    LocalidadeRepository localidadeRepository;

    @Autowired
    public LocalidadeService(LocalidadeRepository localidadeRepository) {
        this.localidadeRepository = localidadeRepository;
    }

    public Localidade save(Localidade localidade){
        return localidadeRepository.save(localidade);
    }

    public List<Localidade> findAll() {
        return localidadeRepository.findAll();
    }

    public Optional<Localidade> getById(Long idLocal) {
        return localidadeRepository.findById(idLocal);
    }

    public Localidade updateLocal(Localidade localidade){
        return localidadeRepository.save(localidade);
    }

    public void deleteLocal(Long idLocal) {
        localidadeRepository.deleteById(idLocal);
    }
}
