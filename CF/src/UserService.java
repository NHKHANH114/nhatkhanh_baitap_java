package com.example.cafemanagement.services;

import com.example.cafemanagement.models.User;
import com.example.cafemanagement.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Đăng ký tài khoản (mã hóa mật khẩu)
    public boolean registerUser(String username, String password, String role) {
        if (userRepository.findByUsername(username).isPresent()) {
            return false; // Username đã tồn tại
        }
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
        User user = new User();
        user.setUsername(username);
        user.setPassword(hashedPassword);
        user.setRole(role);
        userRepository.save(user);
        return true;
    }

    // Đăng nhập (kiểm tra mật khẩu và trả về vai trò)
    public String authenticateUser(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (BCrypt.checkpw(password, user.getPassword())) {
                return user.getRole(); // Trả về quyền
            }
        }
        return null;
    }
}
