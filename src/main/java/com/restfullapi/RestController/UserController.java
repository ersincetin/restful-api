package com.restfullapi.RestController;

import com.restfullapi.Business.UserManager;
import com.restfullapi.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    private UserManager userManager;

    @Autowired
    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @RequestMapping(value = "/users")
    public List<User> getAll() {
        return this.userManager.getAll();
    }

}
