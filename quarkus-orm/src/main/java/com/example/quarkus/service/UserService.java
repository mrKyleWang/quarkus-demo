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

    /**
     * 查询所有用户
     */
    public List<User> getAll() {
        return userRepository.listAll();
    }

    /**
     * 通过手机号查询用户
     */
    public User getByPhone(String phone) {
        return userRepository.find("phone", phone).firstResult();
    }

    /**
     * 保存用户 (事务操作)
     */
    @Transactional
    public User saveUser(User user) {
        // 通过手机号查询，如果存在则更新name，否则新增
        User persistUser = getByPhone(user.getPhone());
        if (persistUser == null) {
            userRepository.persist(user);
        } else {
            persistUser.setName(user.getName());
        }
        return persistUser;
    }

    /**
     * 通过id删除用户
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
