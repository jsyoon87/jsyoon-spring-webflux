package com.example.demo.login.controller;

import com.example.demo.login.entity.Login;
import com.example.demo.login.repository.LoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @GetMapping("/test")
    public String logintest(){
        String data = loginRepository.findByCustomId();

        return "login";
    }

    @GetMapping("/insert")
    //@Transactional 트랙잰션 사용
    public Mono<Login> insert() throws Exception {
        System.out.println("insert controller start");
//        loginRepository.insertLogin();
        //data.subscribe();
//        if(true) {
//            //강제로 Exception 발생
//            throw new Exception("Error");
//        }
        System.out.println("insert controller end");
        return loginRepository.insertLogin();
    }
}
