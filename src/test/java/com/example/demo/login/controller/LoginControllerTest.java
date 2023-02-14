package com.example.demo.login.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;


@WebFluxTest(LoginController.class)
class LoginControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public  void 테스트(){
        this.webTestClient.get().uri("/insert").exchange();
    }

}