package com.bellacode.homebudget.Controller;

import com.bellacode.homebudget.ErrorResponse.NotFoundException;
import com.bellacode.homebudget.ErrorResponse.UserEmailExistException;
import com.bellacode.homebudget.Model.User;
import com.bellacode.homebudget.Repository.UserRepository;
import com.bellacode.homebudget.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserRepository userRepository;

    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userRepository.findAll();
        if (users.isEmpty()){
            throw new NotFoundException("Not found any user");
        }else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<User> registerNewUser(@Valid User user){
        User userExist = userService.findUserByEmail(user.getEmail());
        if (userExist != null){
            throw new UserEmailExistException("Email is already registered: " + user.getEmail());
        }else {
            userService.saveUser(user);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") long id){
        Optional<User> userExist = userRepository.findById(id);
        if (userExist.isPresent()){
            return new ResponseEntity<>(userExist, HttpStatus.OK);
        }else {
            throw new NotFoundException("Not found user with ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") long id){
        Optional<User> userExist = userRepository.findById(id);
        if (userExist.isPresent()){
            userService.deleteUser(id);
        }else {
            throw new NotFoundException("Not found user with ID: " + id);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") long id, @Valid User user){
        Optional<User> updateUser = userRepository.findById(id);
        if (updateUser.isPresent()){
            userService.updateUser(id, user);
        }else{
            throw new NotFoundException("Not found user with ID: " + id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
