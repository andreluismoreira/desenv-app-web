package com.example.demo.controller;

import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping
    @ApiOperation(value = "Salva um novo usuário")
    public void salvar(@RequestBody Usuario usuario){
        service.salvarUsuario(usuario);
    }

    @GetMapping
    @ApiOperation(value= "Lista todos os usuários do banco")
    public List<Usuario> listaAll(){
        return service.listar();
    }

    @GetMapping("/{id}")
    @ApiOperation(value= "Busca um usuário no banco")
    public Optional<Usuario> findById(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value= "Atualiza um usuário no banco")
    public void atualizaUsuario(@RequestBody Usuario usuario, @PathVariable Long id){
        service.updateUsuario(usuario, id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value= "Deleta um usuário do banco")
    public void deletaById(@PathVariable Long id) {
        service.deletarUsuario(id);
    }

}
