package com.wuape.herracentro.controller;

import com.wuape.herracentro.bean.User;
import com.wuape.herracentro.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Bowpi GT
 * Created by Jose on 3/01/2018.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    private ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PutMapping("/{id}")
    private ResponseEntity<User> updateUser(@PathVariable(name = "id") Long id, @RequestBody User user) throws NotFoundException {
        User currentUser = userRepository.findOne(id);

        if (currentUser == null) {
            throw new NotFoundException("User with id [" + id + "] cannot be found ");
        }
        if (user.getId() == 0 || user.getId() != id) {
            user.setId(id);
        }
        user = userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    private ResponseEntity<User> getUserById(@PathVariable(name = "id") Long id) throws NotFoundException {
        User user = userRepository.findOne(id);

        if (user == null) {
            throw new NotFoundException("User with id [" + id + "] cannot be found ");
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping
    private Iterable<User> listAllUser() {
        return userRepository.findAll();
    }
}
