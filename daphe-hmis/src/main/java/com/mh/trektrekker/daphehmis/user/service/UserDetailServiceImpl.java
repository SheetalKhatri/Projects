package com.mh.trektrekker.daphehmis.user.service;

import com.mh.trektrekker.daphehmis.user.bean.UserDetailBean;
import com.mh.trektrekker.daphehmis.user.entity.User;
import com.mh.trektrekker.daphehmis.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        if (null == user) {
            throw new UsernameNotFoundException(email + "doesn't exist in system");
        }
        return new UserDetailBean(user);
    }
}
