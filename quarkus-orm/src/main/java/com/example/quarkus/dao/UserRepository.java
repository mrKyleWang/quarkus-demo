package com.example.quarkus.dao;

import com.example.quarkus.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

/**
 * @author KyleWang
 * @date 2020/09/02
 */
@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    /**
     * 通过手机号查询
     */
    public User getByPhone(String phone) {
        return find("phone", phone).firstResult();
    }

    /**
     * 查询所有
     */
    public List<User> getAll() {
        return findAll().list();
    }

    /**
     * 新增
     */
    public void addUser(User user) {
        persist(user);
    }
}
