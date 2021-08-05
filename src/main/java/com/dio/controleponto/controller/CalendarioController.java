package com.dio.controleponto.controller;

import com.dio.controleponto.model.Calendario;
import com.dio.controleponto.model.CategoriaUsuario;
import com.dio.controleponto.sevice.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

    @Autowired
    CalendarioService calendarioService;

    @PostMapping
    public Calendario createCalend(@RequestBody Calendario calendario){
        return calendarioService.save(calendario);
    }

    @GetMapping
    public List<Calendario> getCalendList(){
        return calendarioService.findAll();
    }

    @GetMapping("/{idCalend}")
    public ResponseEntity<Calendario> getCalendByID(@PathVariable("idCalend") Long idCalend) throws Exception {
        return  ResponseEntity.ok(calendarioService.getById(idCalend).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Calendario updateCalend(@RequestBody Calendario calendario){
        return calendarioService.updateCalendario(calendario);
    }

    @DeleteMapping("/{idCalend}")
    public ResponseEntity deleteByID(@PathVariable("idCalend") Long idCalend) throws Exception {
        try {
            calendarioService.deleteCalendario(idCalend);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idCalend, HttpStatus.OK);
    }

}
