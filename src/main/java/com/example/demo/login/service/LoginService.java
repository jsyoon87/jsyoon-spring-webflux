package com.example.demo.login.service;

import com.example.demo.login.entity.Login;
import com.example.demo.login.repository.LoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class LoginService {

    private LoginRepository loginRepository;

    public Flux<Login> login() {
        Flux<Login> data = loginRepository.findByUsername("aaa");
        data.subscribe(a -> System.out.println("@@:" + a.getUsername()));
        return data;
    }

    public Mono<Login> insert(){
        System.out.println("!!!!");
        return loginRepository.insertLogin();
    }
}
