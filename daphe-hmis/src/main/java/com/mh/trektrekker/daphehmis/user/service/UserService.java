package com.mh.trektrekker.daphehmis.user.service;

import com.mh.trektrekker.daphehmis.user.entity.User;

import java.util.List;

public interface UserService {

    List<User> findUsers();

    User save(User user);

    List<User> getPatients();

    User findByName(String name);
}
