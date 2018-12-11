package com.bellacode.homebudget.Service;

import com.bellacode.homebudget.Model.User;
import org.springframework.stereotype.Service;

@Service("userService")
public interface UserService {
    void saveUser(User user);
    void deleteUser(User user);
}
