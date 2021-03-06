package com.example.demo.controller;

import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api("TED-02")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    @ApiOperation(value = "Salva um novo usuário")
    public ResponseEntity salvar(@RequestBody Usuario usuario){
        service.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    @ApiOperation(value= "Lista todos os usuários do banco")
    public ResponseEntity listarTodos(){
        return ResponseEntity.ok(this.service.listar());
    }

    @GetMapping("/{id}")
    @ApiOperation(value= "Busca um usuário no banco")
    public Optional<Usuario> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value= "Atualiza um usuário no banco")
    public void atualizar(@RequestBody Usuario usuario, @PathVariable Long id){
        service.updateUsuario(usuario, id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value= "Deleta um usuário do banco")
    public ResponseEntity deletarPorId(@PathVariable Long id) {
        service.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
