package com.wuape.herracentro.controller;

import com.wuape.herracentro.bean.IncidenceType;
import com.wuape.herracentro.repository.IncidenceTypeRepository;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Bowpi GT
 * Created by Jose on 8/01/2018.
 */

@RestController
@RequestMapping("/incidence-type")
public class IncidenceTypeController {

    private final IncidenceTypeRepository incidenceTypeRepository;

    public IncidenceTypeController(IncidenceTypeRepository incidenceTypeRepository) {
        this.incidenceTypeRepository = incidenceTypeRepository;
    }

    @PostMapping("/add")
    private ResponseEntity<IncidenceType> addIncidenceType(@RequestBody IncidenceType incidenceType) {
        return ResponseEntity.ok(incidenceTypeRepository.save(incidenceType));
    }

    @PutMapping("/{id}")
    private ResponseEntity<IncidenceType> updateIncidenceType(@PathVariable(name = "id") Long id, @RequestBody IncidenceType incidenceType) throws NotFoundException {
        IncidenceType currentIncidenceType = incidenceTypeRepository.findOne(id);

        if (currentIncidenceType == null) {
            throw new NotFoundException("User authority with id [" + id + "] cannot be found ");
        }
        if (incidenceType.getId() == 0 || incidenceType.getId() != id) {
            incidenceType.setId(id);
        }
        incidenceType = incidenceTypeRepository.save(incidenceType);
        return ResponseEntity.ok(incidenceType);
    }

    @GetMapping("/{id}")
    private ResponseEntity<IncidenceType> findIncidenceTypeById(@PathVariable(name = "id") Long id) throws NotFoundException {
        IncidenceType incidenceType = incidenceTypeRepository.findOne(id);

        if (incidenceType == null) {
            throw new NotFoundException("User authority with id [" + id + "] cannot be found in system.");
        }

        return ResponseEntity.ok(incidenceType);
    }

    @GetMapping()
    private Iterable<IncidenceType> listAllIncidenceType() {
        return incidenceTypeRepository.findAll();
    }
}
