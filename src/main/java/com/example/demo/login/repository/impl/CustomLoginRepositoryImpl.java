package com.example.demo.login.repository.impl;

import com.example.demo.login.entity.Login;
import com.example.demo.login.repository.CustomLoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class CustomLoginRepositoryImpl implements CustomLoginRepository {

    private R2dbcEntityTemplate r2dbcEntityTemplate;

    @Override
    public String findByCustomId() {
        System.out.println("123");
        Flux<Login> aa = r2dbcEntityTemplate.select(Login.class)
                           .matching(Query.query(Criteria.where("username").is("aaa")))
                           .all();
        aa.subscribe(a -> System.out.println("@@:" +a.getUsername()));
        return "123";
    }

    @Override
    public Mono<Login> insertLogin() {
        Login model = new Login();
        model.setUsername("bbb");
        model.setPassword("123");
        System.out.println("insert start");
        System.out.println("insert end");
        return r2dbcEntityTemplate.insert(model);
    }
}
