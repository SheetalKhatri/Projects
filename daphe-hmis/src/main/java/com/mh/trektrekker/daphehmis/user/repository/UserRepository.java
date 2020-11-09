package com.mh.trektrekker.daphehmis.user.repository;

import com.mh.trektrekker.daphehmis.enums.UserType;
import com.mh.trektrekker.daphehmis.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findUserByUserType(UserType userType);

    User findUserByEmail(String email);
    User findUserByName(String name);
}
