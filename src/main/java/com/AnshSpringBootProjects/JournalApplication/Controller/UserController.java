package com.AnshSpringBootProjects.JournalApplication.Controller;

import com.AnshSpringBootProjects.JournalApplication.Entity.User;
import com.AnshSpringBootProjects.JournalApplication.Entity.UserUpdateDTO;
import com.AnshSpringBootProjects.JournalApplication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService us;

    @GetMapping
    public ResponseEntity<?> GetAll() {
        List<User> allUsers = us.getAllUsers();
        if(allUsers != null) {
            return new ResponseEntity<>(allUsers, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<?> creteUser(@RequestBody User user) {
        if(user != null) {
            us.createUser(user);
            return new ResponseEntity<>("New User Created", HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateDTO user, @PathVariable String username) {
        User userInDB = us.findByUsername(username);
        if(userInDB != null) {
            userInDB.setUsername(user.getUsername() == null ? userInDB.getUsername() : user.getUsername());
            userInDB.setPassword(user.getPassword() == null ? userInDB.getPassword() : user.getPassword());
            us.createUser(userInDB);
            return new ResponseEntity<>("User Updated !", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
