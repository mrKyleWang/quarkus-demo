package com.example.quarkus.service;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author KyleWang
 * @date 2020/08/30
 */
@ApplicationScoped
public class TestService {

    public String hello() {
        return "Hello!";
    }
}
