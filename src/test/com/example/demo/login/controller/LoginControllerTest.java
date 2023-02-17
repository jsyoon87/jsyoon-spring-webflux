package com.example.demo.login.controller;

import static org.junit.jupiter.api.Assertions.*;
import static reactor.core.publisher.Mono.when;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import com.example.demo.login.entity.Login;
import com.example.demo.login.repository.LoginRepository;
import com.example.demo.login.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@WebFluxTest(LoginController.class)
class LoginControllerTest {

    @MockBean
    LoginService loginService;

    @Autowired
    WebTestClient webTestClient;

    private Login initModel;

    @BeforeEach
    public void setUp() {
        this.initModel = Login.builder().username("aaa").password("123").build();
    }

    @Test
    public void 조회테스트() {
        //Mockito.when(this.loginRepository.findByUsername("aaa")).thenReturn(Flux.just(new Login()));
        Login model = new Login();
        model.setUsername("bbb");
        Mockito.when(this.loginService.login()).thenReturn(Flux.just(model));
        this.loginService.login().subscribe(v -> System.out.println("@@" + v.getUsername()));
        //Mockito.verify(this.loginRepository).findByUsername("aaa");
        this.webTestClient.get()
                          .uri("/login")
                          .exchange()
                          .expectStatus()
                          .isOk()
                          .expectBody(String.class)
                          .value(result -> System.out.println(result));
    }

    @Test
    public void 저장테스트() {
        Mockito.when(this.loginService.login())
               .thenReturn(Flux.just(Login.builder().username("bbb").build()));
        this.webTestClient.get()
                          .uri("/insert")
                          .exchange()
                          .expectStatus()
                          .isOk()
                          .expectBody(String.class)
                          .value(result -> System.out.println(result));
    }
}