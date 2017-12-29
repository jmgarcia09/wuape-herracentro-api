package com.wuape.herracentro.controller;

import com.wuape.herracentro.bean.UserAuthority;
import com.wuape.herracentro.repository.UserAuthorityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Bowpi GT
 * Created by Jose on 28/12/2017.
 */

@RestController
@RequestMapping("/user-authority")
public class UserAuthorityController {

    private final UserAuthorityRepository userAuthorityRepository;

    public UserAuthorityController(UserAuthorityRepository userAuthorityRepository) {
        this.userAuthorityRepository = userAuthorityRepository;
    }

    @PostMapping("/add")
    private ResponseEntity<UserAuthority> addUserAuthority(@RequestBody UserAuthority userAuthority) {
        return ResponseEntity.ok(userAuthorityRepository.save(userAuthority));
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserAuthority> findUserAuthorityById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userAuthorityRepository.findOne(id));
    }

    @GetMapping()
    private Iterable<UserAuthority> listAllUserAuthority() {
        return userAuthorityRepository.findAll();
    }
}
