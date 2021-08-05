package com.dio.controleponto.controller;

import com.dio.controleponto.model.CategoriaUsuario;
import com.dio.controleponto.model.Localidade;
import com.dio.controleponto.model.NivelAcesso;
import com.dio.controleponto.sevice.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    LocalidadeService localidadeService;

    @PostMapping
    public Localidade createLocal(@RequestBody Localidade localidade){
        return localidadeService.save(localidade);
    }

    @GetMapping
    public List<Localidade> getCatUsuList(){
        return localidadeService.findAll();
    }

    @GetMapping("/{idLocal}")
    public ResponseEntity<Localidade> getLocalByID(@PathVariable("idLocal") Long idLocal) throws Exception {
        return  ResponseEntity.ok(localidadeService.getById(idLocal).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Localidade updateCatUsu(@RequestBody Localidade localidade){
        return localidadeService.updateLocal(localidade);
    }

    @DeleteMapping("/{idLocal}")
    public ResponseEntity deleteByID(@PathVariable("idLocal") Long idLocal) throws Exception {
        try {
            localidadeService.deleteLocal(idLocal);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idLocal, HttpStatus.OK);
    }

}
