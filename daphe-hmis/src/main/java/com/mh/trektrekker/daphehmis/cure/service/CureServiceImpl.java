package com.mh.trektrekker.daphehmis.cure.service;

import com.mh.trektrekker.daphehmis.user.entity.User;
import com.mh.trektrekker.daphehmis.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CureServiceImpl implements CureService {

    private final UserService userService;

    public CureServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getCureNeededUser() {
        return userService.getPatients();
    }
}
