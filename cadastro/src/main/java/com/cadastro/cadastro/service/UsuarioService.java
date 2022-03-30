package com.cadastro.cadastro.service;

import com.cadastro.cadastro.DTO.UsuarioRequest;
import com.cadastro.cadastro.DTO.UsuarioResponse;
import com.cadastro.cadastro.entity.Usuario;
import com.cadastro.cadastro.exception.EntityNotFoundException;
import com.cadastro.cadastro.repository.UsuarioRepository;
import com.cadastro.cadastro.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ConverterUtils converterUtils;

    public UsuarioService(UsuarioRepository repository, ConverterUtils converterUtils) {
        this.repository = repository;
        this.converterUtils = converterUtils;
    }

    public void salvarUsuario(UsuarioRequest request){
        this.repository.save(
                (Usuario) converterUtils.convertRequestToEntity(request, Usuario.class)
        );
    }

    public void updateUsuario(UsuarioRequest request, Long id){
         var entity = this.repository.findById(id)
                 .orElseThrow(() -> new EntityNotFoundException("entidade não encontrada"));
         var entityUpdated = (Usuario) converterUtils.convertRequestToEntity(request, entity.getClass());
         entityUpdated.setId(id);
         this.repository.save(entityUpdated);
//        var user = this.repository.findById(id).get();
//        user.setCpf(usuario.getCpf());
//        user.setEmail(usuario.getEmail());
//        user.setNome(usuario.getNome());
//        user.setTelefone(usuario.getTelefone());
//        user.setSenha(usuario.getSenha());
//        repository.save(user);
    }

    public List<UsuarioResponse> listar(){
        return (List<UsuarioResponse>) converterUtils
                .convertToListResponse(this.repository.findAll(), UsuarioResponse.class);
//        return this.repository.findAll()
//                .stream()
//                .map(this::convertToResponse)
//                .collect(Collectors.toList());
    }

    public UsuarioResponse buscarPorId(Long id){
        return (UsuarioResponse)
                converterUtils.convertEntityToResponse(this.repository.findById(id).get(),
                        UsuarioResponse.class);
//        return convertToResponse(this.repository.findById(id).get());
    }

    public void deletarUsuario(Long id){
        this.repository.deleteById(id);
    }

//    private Usuario convertToEntity(UsuarioRequest request){
//        return Usuario.builder()
//                .cpf(request.getCpf())
//                .email(request.getEmail())
//                .telefone(request.getTelefone())
//                .nome(request.getNome())
//                .senha(request.getSenha())
//                .build();
//    }
//
//    private UsuarioResponse convertToResponse(Usuario usuario){
//        return UsuarioResponse.builder()
//                .cpf(usuario.getCpf())
//                .email(usuario.getEmail())
//                .telefone(usuario.getTelefone())
//                .nome(usuario.getNome())
//                .id(usuario.getId())
//                .build();
//    }
}
