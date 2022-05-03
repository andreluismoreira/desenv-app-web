package com.cadastro.cadastro.controller;

import com.cadastro.cadastro.DTO.UsuarioRequest;
import com.cadastro.cadastro.DTO.UsuarioResponse;
import com.cadastro.cadastro.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Api("Primeira-avaliação-web")
@RestController
@RequestMapping("/usuarios")
@Tag(name = "Cadastro de usuarios", description = "Crud completo da entidade usuario")
public class UsuarioController {

    @Autowired
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @Operation(summary = "Cria um usuario", description = "cria um novo usuario na base de dados")
    @ApiResponse( responseCode = "201", description = "criação de usuario execultada com sucesso")
    @PostMapping(produces = {"application/json","application/xml"})
    @ApiOperation(value = "Salva um novo usuário")
    public ResponseEntity salvar(@RequestBody UsuarioRequest request){
        service.salvarUsuario(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Lista os usuarios", description = "lista todos os usuarios na base de dados")
    @ApiResponse( responseCode = "200", description = "listagem de usuarios execultada com sucesso")
    @GetMapping(produces = {"application/json","application/xml"})
    @ApiOperation(value= "Lista todos os usuários do banco")
    public ResponseEntity<?> listarTodos(){
        return ResponseEntity.ok(this.service.listar());
    }

    @Operation(summary = "Lista um usuario", description = "lista o usuario selecionado da base de dados")
    @ApiResponse( responseCode = "200", description = "retorno de usuario execultada com sucesso")
    @ApiResponse( responseCode = "404", description = "usuario não encontrado")
    @GetMapping("/{id}")
    @ApiOperation(value= "Busca um usuário no banco")
    public UsuarioResponse buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @Operation(summary = "atualiza um usuario", description = "atualiza o usuario selecionado na base de dados")
    @ApiResponse( responseCode = "404", description = "usuario não encontrado")
    @ApiResponse( responseCode = "200", description = "atualização de usuario execultada com sucesso")
    @PutMapping("/{id}")
    @ApiOperation(value= "Atualiza um usuário no banco")
    public ResponseEntity<?> atualizar(@RequestBody UsuarioRequest request, @PathVariable Long id) {
        service.updateUsuario(request, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation(summary = "apaga um usuarios", description = "apaga o usuario selecionado da base de dados")
    @ApiResponse( responseCode = "204", description = "usuario apagado com sucesso")
    @ApiResponse( responseCode = "404", description = "usuario não encontrado")
    @DeleteMapping("/{id}")
    @ApiOperation(value= "Deleta um usuário do banco")
    public ResponseEntity deletarPorId(@PathVariable Long id) {
        service.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
