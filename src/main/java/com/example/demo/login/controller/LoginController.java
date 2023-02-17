package com.example.demo.login.controller;

import com.example.demo.login.entity.Login;
import com.example.demo.login.repository.LoginRepository;
import com.example.demo.login.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class LoginController {
//
//    private LoginRepository loginRepository;
//
    private LoginService loginService;
    @GetMapping("/login")
    public String login(){
        System.out.println("login login");
        return "login";
    }

//    @GetMapping("/test")
//    public String logintest(){
//        String data = loginRepository.findByCustomId();
//
//        return "login";
//    }
//
    @GetMapping("/insert")
    //@Transactional 트랙잰션 사용
    public Mono<Login> insert() throws Exception {
        System.out.println("insert controller start");
        Mono<Login> result = this.loginService.insert();
//        loginRepository.insertLogin();
        //data.subscribe();
//        if(true) {
//            //강제로 Exception 발생
//            throw new Exception("Error");
//        }
        System.out.println("controller :" + result);
        System.out.println("insert controller end");
        return result;
    }
    @GetMapping("/junit")
    public Mono<String> logintest(){
        return Mono.just("login junit");
    }
}
