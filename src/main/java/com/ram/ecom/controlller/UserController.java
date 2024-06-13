package com.ram.ecom.controlller;

import com.ram.ecom.entity.User;
import com.ram.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/ecom")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/") // New Way
//    @RequestMapping(method = RequestMethod.POST, name = "/") // Old Way
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = this.userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> savedUser = this.userService.getAll();
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) throws Exception {
        User userById = this.userService.getUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public  ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id) throws Exception {
        User updateUser = this.userService.updateUser(user, id);
        return  new ResponseEntity<>(updateUser, HttpStatus.CREATED);
    }

}
