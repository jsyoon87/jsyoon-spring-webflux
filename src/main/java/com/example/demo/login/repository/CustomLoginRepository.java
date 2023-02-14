package com.example.demo.login.repository;

import com.example.demo.login.entity.Login;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomLoginRepository {

    public String findByCustomId();

    public Mono<Login> insertLogin();
}
