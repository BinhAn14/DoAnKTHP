package com.example.DoAnKTHP.Controller;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.format.DateTimeFormatter;

import com.example.DoAnKTHP.models.LichLop;
import com.example.DoAnKTHP.models.User;
import com.example.DoAnKTHP.models.GiangVien;
import com.example.DoAnKTHP.service.UserGVService;
import com.example.DoAnKTHP.service.LichDeXuatService;

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

    System.out.println("Received signup request for username: " + username);

    // Kiểm tra username đã tồn tại chưa
    User existingUser = userGVService.findUserByUsername(username);
    if (existingUser != null) {
        System.out.println("Username already exists: " + username);
        model.addAttribute("message", "Tên đăng nhập đã tồn tại!");
        return "signup";
    }

    // Tạo User mới
    User newUser = new User();
    newUser.setUsername(username);
    newUser.setPassword(password);
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

    // Tìm user theo username
    User user = userGVService.findUserByUsername(username);

    // Kiểm tra nếu user không tồn tại hoặc mật khẩu không khớp
    if (user == null || !user.getPassword().equals(password)) {
        model.addAttribute("ERROR", "Username hoặc Password không chính xác");
        return "login";
    }

    // Đặt thông tin user vào session
    session.setAttribute("USERS", user);
    return "schedule";
}

// Đăng xuất
@GetMapping("/logout")
public String logout(HttpSession session) {
session.removeAttribute("USERS");
return "redirect:/";
}
}
