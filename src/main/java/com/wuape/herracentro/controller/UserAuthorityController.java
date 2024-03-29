package com.wuape.herracentro.controller;

import com.wuape.herracentro.bean.UserAuthority;
import com.wuape.herracentro.repository.UserAuthorityRepository;
import javassist.NotFoundException;
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

    @PutMapping("/{id}")
    private ResponseEntity<UserAuthority> updateUserAuthority(@PathVariable(name = "id") Long id, @RequestBody UserAuthority userAuthority) throws NotFoundException {
        UserAuthority currentUserAuthority = userAuthorityRepository.findOne(id);

        if (currentUserAuthority == null) {
            throw new NotFoundException("User authority with id [" + id + "] cannot be found ");
        }
        if (userAuthority.getId() == 0 || userAuthority.getId() != id) {
            userAuthority.setId(id);
        }
        userAuthority = userAuthorityRepository.save(userAuthority);
        return ResponseEntity.ok(userAuthority);
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserAuthority> findUserAuthorityById(@PathVariable(name = "id") Long id) throws NotFoundException {
        UserAuthority userAuthority = userAuthorityRepository.findOne(id);

        if (userAuthority == null) {
            throw new NotFoundException("User authority with id [" + id + "] cannot be found in system.");
        }

        return ResponseEntity.ok(userAuthority);
    }

    @GetMapping()
    private Iterable<UserAuthority> listAllUserAuthority() {
        return userAuthorityRepository.findAll();
    }
}
