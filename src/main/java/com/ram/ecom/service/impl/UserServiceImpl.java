package com.ram.ecom.service.impl;

import com.ram.ecom.entity.User;
import com.ram.ecom.repository.UserRepo;
import com.ram.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

//@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        User user1 = this.userRepo.save(user);

        return user1;
    }

    @Override
    public User getUserById(Integer id) throws Exception {

        Optional<User> user = this.userRepo.findById(id);
        if(user.isPresent()){
            return user.get();
        }else {
            throw new Exception("User with userId "+id+" is not found");
        }


    }

    @Override
    public List<User> getAll() {
        List<User> userList = this.userRepo.findAll();
        return userList;
    }

    @Override
    public User updateUser(User user, Integer id) throws Exception {
        Optional<User> user1 = this.userRepo.findById(id);
        if (user1.isPresent()){
            User user2 = user1.get();
            user2.setUserMail(user.getUserMail());
            user2.setUserName(user.getUserName());
            user2.setAbout(user.getAbout());
            User updatedUser = this.userRepo.save(user2);
            return updatedUser;
        }else {
            throw new Exception("User with userId "+id+" is not found");
        }


    }

    @Override
    public String deleteUser(Integer id) throws Exception {

        Optional<User> user = this.userRepo.findById(id);
        if(user.isPresent()){
            this.userRepo.delete(user.get());
            return "User deleted successfully!";
        }else {
            throw new Exception("User with userId "+id+" is not found");
        }
    }
}
