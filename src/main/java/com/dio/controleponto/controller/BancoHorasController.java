package com.dio.controleponto.controller;

import com.dio.controleponto.model.BancoHoras;
import com.dio.controleponto.sevice.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bancoHoras")
public class BancoHorasController {

    @Autowired
    BancoHorasService bancoHorasService;

    @PostMapping
    public BancoHoras createBHoras(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.save(bancoHoras);
    }

    @GetMapping
    public List<BancoHoras> getBHorasList(){
        return bancoHorasService.findAll();
    }

    @GetMapping("/{idBHoras}")
    public List<BancoHoras> getBHorasByID(@PathVariable("idBHoras") Long idBHoras) throws Exception {
        return bancoHorasService.getById(idBHoras);
    }

    @PutMapping
    public BancoHoras updateBHoras(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.updateBancoHoras(bancoHoras);
    }

    @DeleteMapping("/{idBHoras}")
    public ResponseEntity deleteByID(@PathVariable("idBHoras") Long idBHoras) throws Exception {
        try {
            bancoHorasService.deleteBancoHoras(idBHoras);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idBHoras, HttpStatus.OK);
    }

}
