package com.dio.controleponto.controller;

import com.dio.controleponto.model.CategoriaUsuario;
import com.dio.controleponto.sevice.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categoriaUsuario")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaUsuarioService categoriaUsuarioService;

    @PostMapping
    public CategoriaUsuario createCatUsu(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.save(categoriaUsuario);
    }

    @GetMapping
    public List<CategoriaUsuario> getCatUsuList(){
        return categoriaUsuarioService.findAll();
    }

    @GetMapping("/{idCatUsu}")
    public ResponseEntity<CategoriaUsuario> getCatUsuByID(@PathVariable("idCatUsu") Long idCatUsu) throws Exception {
        return  ResponseEntity.ok(categoriaUsuarioService.getById(idCatUsu).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public CategoriaUsuario updateCatUsu(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.updateJornada(categoriaUsuario);
    }

    @DeleteMapping("/{idCatUsu}")
    public ResponseEntity deleteByID(@PathVariable("idCatUsu") Long idCatUsu) throws Exception {
        try {
            categoriaUsuarioService.deleteJornada(idCatUsu);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idCatUsu, HttpStatus.OK);
    }

}
