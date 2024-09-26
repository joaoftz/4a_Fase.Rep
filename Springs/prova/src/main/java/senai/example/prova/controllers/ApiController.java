package senai.example.prova.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import senai.example.prova.entities.AdotantesEntity;
import senai.example.prova.entities.AnimaisEntity;
import senai.example.prova.repositories.AdotantesRepository;
import senai.example.prova.repositories.AnimaisRepository;

@RestController
@RequestMapping("/prova")
public class ApiController {
    
    @Autowired
    private AdotantesRepository adotantesRepository;

    @Autowired
    private AnimaisRepository animaisRepository;

    @PostMapping("/adotantes")
    public AdotantesEntity createAdotantesEntity(@RequestBody AdotantesEntity adotantesEntity){
        return adotantesRepository.save(adotantesEntity);
    }

    @PostMapping("/animais")
    public AnimaisEntity createAnimaisEntity(@RequestBody AnimaisEntity animaisEntity){
        return animaisRepository.save(animaisEntity);
    }

    @GetMapping("adotantes/{id}")
    public AdotantesEntity getAdotantesEntity(@PathVariable Long id) {
        return adotantesRepository.findById(id).orElse(null);
    }

    @GetMapping("/animais/{id}")
    public AnimaisEntity getAnimaisEntity(@PathVariable Long id) {
        return animaisRepository.findById(id).orElse(null);

    }

    @GetMapping("/adotantes/{id}/animais")
    public List<AnimaisEntity> getAnimaisEntityByAdotantesEntity(@PathVariable long id) {
        AdotantesEntity adotantesEntity = adotantesRepository.findById(id).orElse(null);
        return adotantesEntity != null ? adotantesEntity.getAnimais() : null;
    }
}
