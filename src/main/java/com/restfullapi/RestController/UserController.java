package com.restfullapi.RestController;

import com.restfullapi.Business.UserManager;
import com.restfullapi.Entities.User;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<User> getAllUsers() {
        return this.userManager.getAll();
    }

    @RequestMapping(value = "/user/create")
    public void create(@RequestBody User user) {
        this.userManager.create(user);
    }

    @RequestMapping(value = "/user/{id}")
    public Object getByUser(@PathVariable int id) {
        return this.userManager.getById(id);
    }

    @RequestMapping(value = "/user/update")
    public void update(@RequestBody User user) {
        this.userManager.update(user);
    }

    @RequestMapping(value = "/user/delete")
    public void delete(@RequestBody int id) {
        this.userManager.delete(id);
    }

}
