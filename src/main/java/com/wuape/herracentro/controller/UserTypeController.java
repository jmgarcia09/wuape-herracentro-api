package com.wuape.herracentro.controller;

import com.wuape.herracentro.bean.UserType;
import com.wuape.herracentro.repository.UserTypeRepository;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Bowpi GT
 * Created by Jose on 28/12/2017.
 */
@RestController
@RequestMapping("/user-type")
public class UserTypeController {

    private final UserTypeRepository userTypeRepository;

    public UserTypeController(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    @PostMapping("/add")
    private ResponseEntity<UserType> addUserType(@RequestBody UserType userType) {
        return ResponseEntity.ok(userTypeRepository.save(userType));
    }

    @PutMapping("/{id}")
    private ResponseEntity<UserType> updateUserType(@PathVariable(name = "id") Long id, @RequestBody UserType userType) throws NotFoundException {
        UserType currentUserType = userTypeRepository.findOne(id);

        if (currentUserType == null) {
            throw new NotFoundException("User type with id [" + id + "] cannot be found ");
        }
        if (userType.getId() == 0 || userType.getId() != id) {
            userType.setId(id);
        }
        userType = userTypeRepository.save(userType);
        return ResponseEntity.ok(userType);
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserType> getUserTypeById(@PathVariable(name = "id") Long id) throws NotFoundException {
        UserType userType = userTypeRepository.findOne(id);

        if (userType == null) {
            throw new NotFoundException("User type with id [" + id + "] cannot be found ");
        }
        return ResponseEntity.ok(userType);
    }

    @GetMapping
    private Iterable<UserType> listAllUserType() {
        return userTypeRepository.findAll();
    }
}
