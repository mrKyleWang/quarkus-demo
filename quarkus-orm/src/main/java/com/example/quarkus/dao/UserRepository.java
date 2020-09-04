package com.example.quarkus.dao;

import com.example.quarkus.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author KyleWang
 * @date 2020/09/02
 */
@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

}
