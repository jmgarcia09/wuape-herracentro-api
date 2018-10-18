package com.wuape.herracentro.controller;

import com.wuape.herracentro.bean.User;
import com.wuape.herracentro.repository.UserRepository;
import com.wuape.herracentro.util.EncryptUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserRepository userRepository;

    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    private ResponseEntity<MessageHandler> authUser(@RequestBody Map<String,String> values){
        MessageHandler responseMessage = new MessageHandler("/auth/login",null);
        if(!values.containsKey("user") || !values.containsKey("password")){
            responseMessage.setMessage("[user] and [password] must be provided.");
            return ResponseEntity.badRequest().body(responseMessage);
        }

        String user = values.get("user");
        String password = EncryptUtil.convertToMd5(values.get("password"));

        User authenticatedUser = userRepository.findByLoginIdAndPassword(user,password);

        if(authenticatedUser != null){
            responseMessage.setMessage("User '" + authenticatedUser.getLoginId() + "' authenticated successfully.");
            responseMessage.setData(authenticatedUser);
            return ResponseEntity.ok(responseMessage);
        }

        responseMessage.setMessage("Invalid credentials.");
        return ResponseEntity.badRequest().body(responseMessage);

    }
}
