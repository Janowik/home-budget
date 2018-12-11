package com.bellacode.homebudget.Controller;

import com.bellacode.homebudget.Model.User;
import com.bellacode.homebudget.Repository.UserRepository;
import com.bellacode.homebudget.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;

    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserByID(@PathVariable("id") long id){
        return userRepository.findById(id);
    }

    @PostMapping("/users")
    public void registerNewUser(@Valid User user, BindingResult bindingResult) {
        //
        userService.saveUser(user);
    }

    @DeleteMapping("/users")
    public void deleteUser(User user){
        userService.deleteUser(user);
    }
}
