package com.ram.ecom.service;

import com.ram.ecom.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    //    C-Create:-
    public User createUser(User user);

    //    R-Retrive:-
    public User getUserById(Integer id) throws Exception;
    public List<User> getAll();

    //    U-Update:-
    public User updateUser(User user, Integer id) throws Exception;

    //    D-Delete:-
    public String deleteUser(Integer id) throws Exception;


}
