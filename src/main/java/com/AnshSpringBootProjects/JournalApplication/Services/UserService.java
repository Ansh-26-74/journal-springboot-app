package com.AnshSpringBootProjects.JournalApplication.Services;

import com.AnshSpringBootProjects.JournalApplication.Entity.User;
import com.AnshSpringBootProjects.JournalApplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository ur;

    public List<User> getAllUsers() {
        return ur.findAll();
    }

    public void createUser(User user) {
        ur.save(user);
    }

    public User findByUsername(String username) {
        return ur.findByUsername(username);
    }

}
