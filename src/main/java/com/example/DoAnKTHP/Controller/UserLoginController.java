package com.example.DoAnKTHP.Controller;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DoAnKTHP.models.User;
import com.example.DoAnKTHP.service.UserGVService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserLoginController {

    @Autowired
    private UserGVService userGVService;

    @GetMapping("/")
    public String showSignup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            ModelMap model) {

        // Kiểm tra nếu username hoặc email rỗng
        if (username == null || username.isEmpty()) {
            model.addAttribute("message", "Tên đăng nhập không được để trống!");
            return "signup";
        }

        if (email == null || email.isEmpty()) {
            model.addAttribute("message", "Email không được để trống!");
            return "signup";
        }

        System.out.println("Received signup request for username: " + username);

        User existingUser = userGVService.findUserByUsername(username);
        if (existingUser != null) {
            System.out.println("Username already exists: " + username);
            model.addAttribute("message", "Tên đăng nhập đã tồn tại!");
            return "signup";
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email); // Thêm email
        newUser.setPassword(password); // Lưu trực tiếp mật khẩu
        newUser.setRole("USER");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createdAt = java.time.LocalDateTime.now().format(formatter);
        newUser.setCreatedAt(createdAt);
        newUser.setUpdatedAt(createdAt);

        System.out.println("Saving new user: " + newUser);
        userGVService.saveUser(newUser);

        model.addAttribute("message", "Đăng ký thành công! Vui lòng đăng nhập.");
        return "login";
    }

    @GetMapping("/login")
    public String showLogin(ModelMap model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            ModelMap model,
            HttpSession session) {

        User user = userGVService.findUserByUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            model.addAttribute("ERROR", "Username hoặc Password không chính xác");
            return "login";
        }

        session.setAttribute("USERS", user);
        return "index";
    }

    // Đăng xuất
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("USERS");
        return "redirect:/";
    }
}
