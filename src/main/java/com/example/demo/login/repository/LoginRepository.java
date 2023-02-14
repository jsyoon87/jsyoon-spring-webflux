package com.example.demo.login.repository;

import com.example.demo.login.entity.Login;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface LoginRepository extends R2dbcRepository<Login, Long>, CustomLoginRepository {

    public Flux<Login> findByUsername(String username);

    @Query("SELECT username FROM SYSTEM_USER")
    public Flux<Login> findUserId();

}

