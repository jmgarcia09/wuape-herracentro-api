package com.wuape.herracentro.controller;

import com.wuape.herracentro.bean.User;
import com.wuape.herracentro.repository.UserRepository;
import com.wuape.herracentro.util.EncryptUtil;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

        user.setPassword(EncryptUtil.convertToMd5(user.getPassword()));
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

        if(user.getPassword() != null && !user.getPassword().isEmpty()){
            user.setPassword(EncryptUtil.convertToMd5(user.getPassword()));
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
        user.setPassword(null);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    private Iterable<User> listAllUser() {
        return StreamSupport.stream(userRepository.findAll().spliterator(),false).map(user -> {
            user.setPassword(null);
            return user;
        }).collect(Collectors.toList());
    }
}
