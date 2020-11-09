package com.mh.trektrekker.daphehmis;

import com.mh.trektrekker.daphehmis.enums.UserType;
import com.mh.trektrekker.daphehmis.user.entity.User;
import com.mh.trektrekker.daphehmis.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DapheHmisApplication {

    private final static String DEFAULT_ADMIN_USER_NAME = "The Administrator";

    @Autowired
    private UserService userService;


    public static void main(String[] args) {

        SpringApplication.run(DapheHmisApplication.class, args);
    }

    @PostConstruct
    public void createAdminUser() {
        User user = userService.findByName(DEFAULT_ADMIN_USER_NAME);
        if (user == null) {
            user = new User();
            user.setName(DEFAULT_ADMIN_USER_NAME);
            user.setEmail("admin@admin.com");
            user.setPassword("123456");
            user.setUserType(UserType.ADMIN);
            userService.save(user);

        }

    }

}
