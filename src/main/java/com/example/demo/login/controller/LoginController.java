package com.example.demo.login.controller;

import com.example.demo.login.entity.Login;
import com.example.demo.login.repository.LoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
public class LoginController {

    private LoginRepository loginRepository;

    @GetMapping("/login")
    public String login(){
        Flux<Login> data = loginRepository.findByUsername("aaa");
        data.subscribe(a -> System.out.println("@@:" +a.getUsername()));
        return "login";
    }
}
