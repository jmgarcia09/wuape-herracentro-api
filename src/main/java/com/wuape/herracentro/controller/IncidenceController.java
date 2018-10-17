package com.wuape.herracentro.controller;

import com.wuape.herracentro.bean.Incidence;
import com.wuape.herracentro.repository.IncidenceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/incidence")
public class IncidenceController {
    
    private final IncidenceRepository incidenceRepository;

    public IncidenceController(IncidenceRepository incidenceRepository) {
        this.incidenceRepository = incidenceRepository;
    }

    @PostMapping("/add")
    private ResponseEntity<Incidence> addIncidence(@RequestBody Incidence incidence) {
        return ResponseEntity.ok(incidenceRepository.save(incidence));
    }

    @PutMapping("/{id}")
    private ResponseEntity<Incidence> updateIncidence(@PathVariable(name = "id") Long id, @RequestBody Incidence Incidence) {
        Incidence currentIncidence = incidenceRepository.findOne(id);

        Assert.notNull(currentIncidence, "Incidence with id [" + id + "] cannot be found.");
        if (!Incidence.getId().equals(id)) {
            Incidence.setId(id);
        }
        Incidence = incidenceRepository.save(Incidence);
        return ResponseEntity.ok(Incidence);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Incidence> findIncidenceById(@PathVariable(name = "id") Long id) {
        Incidence Incidence = incidenceRepository.findOne(id);

        Assert.notNull(Incidence, "Incidence with id [" + id + "] cannot be found.");
        return ResponseEntity.ok(Incidence);
    }

    @GetMapping()
    private Iterable<Incidence> listAllIncidences() {
        return incidenceRepository.findAll();
    }
}
