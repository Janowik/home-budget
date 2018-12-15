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
    public void deleteUser(long id) {

        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(long id, User user) {
        User updateUser = User.builder()
                .id(id)
                .name(user.getName())
                .email(user.getEmail())
                .password(bCryptPasswordEncoder.encode(user.getPassword()))
                .active(user.getActive())
                .role(Role.ROLE_USER)
                .build();
        userRepository.save(updateUser);
    }

    @Override
    public User findUserByEmail(String email) {
        return  userRepository.findUserByEmail(email);
    }
}
