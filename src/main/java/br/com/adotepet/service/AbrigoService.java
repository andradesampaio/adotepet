package br.com.adotepet.service;

import br.com.adotepet.exception.AbrigoBusinessException;
import br.com.adotepet.exception.ErrorEnum;
import br.com.adotepet.model.Abrigo;
import br.com.adotepet.repository.AbrigoRepository;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AbrigoService implements AbrigoServiceImpl{

    private AbrigoRepository repository;
    public AbrigoService(AbrigoRepository repository){
        this.repository = repository;
    }

    @Override
    public void cadastrar(Abrigo abrigo) {
        boolean nomeJaCadastrado = repository.existsByNome(abrigo.getNome());
        boolean telefoneJaCadastrado = repository.existsByTelefone(abrigo.getTelefone());
        boolean emailJaCadastrado = repository.existsByEmail(abrigo.getEmail());

        if (nomeJaCadastrado || telefoneJaCadastrado || emailJaCadastrado) {
            throw new AbrigoBusinessException(ErrorEnum.API_ERROR_400, HttpStatus.BAD_REQUEST);
        } else {
            repository.save(abrigo);
        }
    }
}
