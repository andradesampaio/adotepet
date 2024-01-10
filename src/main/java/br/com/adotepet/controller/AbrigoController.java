package br.com.adotepet.controller;

import br.com.adotepet.model.Abrigo;
import br.com.adotepet.model.Pet;
import br.com.adotepet.repository.AbrigoRepository;
import br.com.adotepet.service.AbrigoService;
import br.com.adotepet.service.AbrigoServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    private AbrigoServiceImpl abrigoService;

    public AbrigoController(AbrigoServiceImpl abrigoService) {
        this.abrigoService = abrigoService;
    }


//    @GetMapping
//    public ResponseEntity<List<Abrigo>> listar() {
//        return ResponseEntity.ok(repository.findAll());
//    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid Abrigo abrigo) {

        try {
            abrigoService.cadastrar(abrigo);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred. Check the logs for details.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Operation successful", HttpStatus.OK);
    }

//    @GetMapping("/{idOuNome}/pets")
//    public ResponseEntity<List<Pet>> listarPets(@PathVariable String idOuNome) {
//        try {
//            Long id = Long.parseLong(idOuNome);
//            List<Pet> pets = repository.getReferenceById(id).getPets();
//            return ResponseEntity.ok(pets);
//        } catch (EntityNotFoundException enfe) {
//            return ResponseEntity.notFound().build();
//        } catch (NumberFormatException e) {
//            try {
//                List<Pet> pets = repository.findByNome(idOuNome).getPets();
//                return ResponseEntity.ok(pets);
//            } catch (EntityNotFoundException enfe) {
//                return ResponseEntity.notFound().build();
//            }
//        }
//    }
//
//    @PostMapping("/{idOuNome}/pets")
//    @Transactional
//    public ResponseEntity<String> cadastrarPet(@PathVariable String idOuNome, @RequestBody @Valid Pet pet) {
//        try {
//            Long id = Long.parseLong(idOuNome);
//            Abrigo abrigo = repository.getReferenceById(id);
//            pet.setAbrigo(abrigo);
//            pet.setAdotado(false);
//            abrigo.getPets().add(pet);
//            repository.save(abrigo);
//            return ResponseEntity.ok().build();
//        } catch (EntityNotFoundException enfe) {
//            return ResponseEntity.notFound().build();
//        } catch (NumberFormatException nfe) {
//            try {
//                Abrigo abrigo = repository.findByNome(idOuNome);
//                pet.setAbrigo(abrigo);
//                pet.setAdotado(false);
//                abrigo.getPets().add(pet);
//                repository.save(abrigo);
//                return ResponseEntity.ok().build();
//            } catch (EntityNotFoundException enfe) {
//                return ResponseEntity.notFound().build();
//            }
//        }
//    }

}
