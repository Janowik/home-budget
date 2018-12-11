package com.bellacode.homebudget.ServiceImplementation;

import com.bellacode.homebudget.Model.Role;
import com.bellacode.homebudget.Model.User;
import com.bellacode.homebudget.Repository.UserRepository;
import com.bellacode.homebudget.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void saveUser(User user) {
        user.setActive(0);
        user.setRole(Role.ROLE_USER);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
    }
}
