package com.wuape.herracentro.controller;

import com.wuape.herracentro.bean.Maintenance;
import com.wuape.herracentro.repository.MaintenanceRepository;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Bowpi GT
 * Created by Jose on 19/03/2018.
 */
@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    private final MaintenanceRepository maintenanceRepository;

    public MaintenanceController(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @PostMapping("/add")
    private ResponseEntity<Maintenance> addMaintenance(@RequestBody Maintenance maintenance) {
        return ResponseEntity.ok(maintenanceRepository.save(maintenance));
    }

    @PutMapping("/{id}")
    private ResponseEntity<Maintenance> updateMaintenance(@PathVariable(name = "id") Long id, @RequestBody Maintenance maintenance) throws NotFoundException {
        Maintenance currentMaintenance = maintenanceRepository.findOne(id);

        if (currentMaintenance == null) {
            throw new NotFoundException("User authority with id [" + id + "] cannot be found ");
        }
        if (maintenance.getId() == 0 || maintenance.getId() != id) {
            maintenance.setId(id);
        }
        maintenance = maintenanceRepository.save(maintenance);
        return ResponseEntity.ok(maintenance);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Maintenance> findMaintenanceById(@PathVariable(name = "id") Long id) throws NotFoundException {
        Maintenance maintenance = maintenanceRepository.findOne(id);

        if (maintenance == null) {
            throw new NotFoundException("User authority with id [" + id + "] cannot be found in system.");
        }

        return ResponseEntity.ok(maintenance);
    }

    @GetMapping()
    private Iterable<Maintenance> listAllMaintenance() {
        return maintenanceRepository.findAll();
    }


}
