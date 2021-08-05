package com.dio.controleponto.controller;

import com.dio.controleponto.model.Movimentacao;
import com.dio.controleponto.sevice.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    public Movimentacao createMovi(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.save(movimentacao);
    }

    @GetMapping
    public List<Movimentacao> getMoviList(){
        return movimentacaoService.findAll();
    }

    @GetMapping("/{idMovi}")
    public List<Movimentacao> getMoviByID(@PathVariable("idMovi") Long idMovi) throws Exception {
        return  movimentacaoService.getById(idMovi);
    }

    @PutMapping
    public Movimentacao updateMovi(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.updateMovi(movimentacao);
    }

    @DeleteMapping("/{idMovi}")
    public ResponseEntity deleteByID(@PathVariable("idMovi") Long idMovi) throws Exception {
        try {
            movimentacaoService.deleteMovi(idMovi);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idMovi, HttpStatus.OK);
    }

}
