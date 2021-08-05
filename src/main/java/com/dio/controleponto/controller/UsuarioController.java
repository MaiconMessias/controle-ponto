package com.dio.controleponto.controller;

import com.dio.controleponto.model.Usuario;
import com.dio.controleponto.sevice.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario createUsu(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @GetMapping
    public List<Usuario> getUsuList(){
        return usuarioService.findAll();
    }

    @GetMapping("/{idUsu}")
    public ResponseEntity<Usuario> getUsuByID(@PathVariable("idUsu") Long idUsu) throws Exception {
        return  ResponseEntity.ok(usuarioService.getById(idUsu).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Usuario updateUsu(@RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/{idUsu}")
    public ResponseEntity deleteByID(@PathVariable("idUsu") Long idUsu) throws Exception {
        try {
            usuarioService.deleteUsuario(idUsu);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idUsu, HttpStatus.OK);
    }

}
