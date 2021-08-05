package com.dio.controleponto.controller;

import com.dio.controleponto.model.CategoriaUsuario;
import com.dio.controleponto.model.Ocorrencia;
import com.dio.controleponto.sevice.CategoriaUsuarioService;
import com.dio.controleponto.sevice.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    OcorrenciaService ocorrenciaService;

    @PostMapping
    public Ocorrencia createOcorr(@RequestBody Ocorrencia ocorrencia){
        return ocorrenciaService.save(ocorrencia);
    }

    @GetMapping
    public List<Ocorrencia> getOcorrList(){
        return ocorrenciaService.findAll();
    }

    @GetMapping("/{idOcorr}")
    public ResponseEntity<Ocorrencia> getOcorrByID(@PathVariable("idOcorr") Long idOcorr) throws Exception {
        return  ResponseEntity.ok(ocorrenciaService.getById(idOcorr).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Ocorrencia updateOcorr(@RequestBody Ocorrencia ocorrencia){
        return ocorrenciaService.updateOcorrServ(ocorrencia);
    }

    @DeleteMapping("/{idOcorr}")
    public ResponseEntity deleteByID(@PathVariable("idOcorr") Long idOcorr) throws Exception {
        try {
            ocorrenciaService.deleteOcorrServ(idOcorr);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idOcorr, HttpStatus.OK);
    }

}
