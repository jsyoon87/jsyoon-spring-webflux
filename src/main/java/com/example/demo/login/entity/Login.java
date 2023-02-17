package com.example.demo.login.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("SYSTEM_USER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    @Id
    private int idx;

    @Column(value="username")
    private String username;

    @Column(value="password")
    private String password;

}
