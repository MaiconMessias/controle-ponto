package com.dio.controleponto.sevice;

import com.dio.controleponto.model.Movimentacao;
import com.dio.controleponto.model.Usuario;
import com.dio.controleponto.repository.MovimentacaoRepository;
import com.dio.controleponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    MovimentacaoRepository movimentacaoRepository;

    @Autowired
    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    public Movimentacao save(Movimentacao movimentacao){
        return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    public List<Movimentacao> getById(Long idMovi) {
        return movimentacaoRepository.findByMovimentacaoIdId(idMovi);
    }

    public Movimentacao updateMovi(Movimentacao movimentacao){
        return movimentacaoRepository.save(movimentacao);
    }

    public void deleteMovi(Long idMovi) {
        movimentacaoRepository.deleteMovi(idMovi);
    }

}
