package com.example.quarkus.service;

import com.example.quarkus.dao.UserRepository;
import com.example.quarkus.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author KyleWang
 * @date 2020/09/02
 */
@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User getByPhone(String phone) {
        return userRepository.getByPhone(phone);
    }

    @Transactional
    public User saveUser(User user) {
        User persistUser = userRepository.getByPhone(user.getPhone());
        if (persistUser == null) {
            userRepository.addUser(user);
        } else {
            persistUser.setName(user.getName());
        }
        return persistUser;
    }
}
