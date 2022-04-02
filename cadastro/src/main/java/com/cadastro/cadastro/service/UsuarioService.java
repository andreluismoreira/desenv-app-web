package com.cadastro.cadastro.service;

import com.cadastro.cadastro.DTO.UsuarioRequest;
import com.cadastro.cadastro.DTO.UsuarioResponse;
import com.cadastro.cadastro.entity.Usuario;
import com.cadastro.cadastro.exception.EntityNotFoundException;
import com.cadastro.cadastro.exception.ResourceNotFoundException;
import com.cadastro.cadastro.repository.UsuarioRepository;
import com.cadastro.cadastro.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public List<UsuarioResponse> listar(){
        return (List<UsuarioResponse>) converterUtils
                .convertToListResponse(this.repository.findAll(), UsuarioResponse.class);

    }

    public void salvarUsuario(UsuarioRequest request){
        this.repository.save(
                (Usuario) converterUtils.convertRequestToEntity(request, Usuario.class)
        );
    }

    public UsuarioResponse buscarPorId(Long id){
        return (UsuarioResponse)
        converterUtils.convertEntityToResponse(this.repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found")),UsuarioResponse.class);
    }

    public void updateUsuario(UsuarioRequest request, Long id){
         var entity = this.repository.findById(id)
                 .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
         var entityUpdated = (Usuario) converterUtils.convertRequestToEntity(request, entity.getClass());
         entityUpdated.setId(id);
         this.repository.save(entityUpdated);
    }

    public void deletarUsuario(Long id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("User not found");
        }
    }

}
