package com.mh.trektrekker.daphehmis.user.service;

import com.mh.trektrekker.daphehmis.enums.UserType;
import com.mh.trektrekker.daphehmis.user.entity.User;
import com.mh.trektrekker.daphehmis.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getPatients() {
        return userRepository.findUserByUserType(UserType.PATIENT);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findUserByName(name);
    }
}
