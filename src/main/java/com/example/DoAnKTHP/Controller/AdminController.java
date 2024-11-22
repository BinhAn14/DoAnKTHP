package com.example.DoAnKTHP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.example.DoAnKTHP.models.User;
import com.example.DoAnKTHP.service.UserGVService;

import jakarta.servlet.http.HttpSession;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserGVService userGVService;

    @GetMapping("")
    public String showAdminHome() {
        return "admin"; // Trang chính
    }

    @GetMapping("/users")
public String showUsers(ModelMap model) {
    try {
        List<User> users = userGVService.findAllUsers(); // Giả sử bạn có phương thức này để lấy tất cả người dùng
        model.addAttribute("users", users);
    } catch (Exception e) {
        model.addAttribute("error", "Đã xảy ra lỗi khi tải danh sách người dùng.");
        return "error"; // Hoặc trang lỗi bạn muốn hiển thị
    }
    return "admin/users";
}


    // Thêm người dùng
    @GetMapping("/addUser")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/addUser"; // Tạo form để thêm người dùng
    }

   @PostMapping("/addUser")
public String addUser(@ModelAttribute User user, Model model) {
    // Kiểm tra xem người dùng đã tồn tại chưa
    if (userGVService.findUserByUsername(user.getUsername()) != null) {
        model.addAttribute("message", "Tên đăng nhập đã tồn tại!");
        return "admin/addUser";
    }

    // Lấy thời gian hiện tại để gán cho created_at và updated_at
    String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    user.setCreatedAt(currentTime);
    user.setUpdatedAt(currentTime); // Bạn cũng có thể muốn cập nhật updated_at

    user.setRole("USER"); // Gán vai trò mặc định là USER
    userGVService.saveUser(user);
    return "redirect:/admin/users";
}
// Chỉnh sửa người dùng
@GetMapping("/editUser/{id}")
public String showEditUserForm(@PathVariable Long id, Model model) {
    User user = userGVService.findUserById(id);
    if (user == null) {
        model.addAttribute("error", "Người dùng không tồn tại.");
        return "error"; // Nếu người dùng không tồn tại, bạn có thể hiển thị trang lỗi.
    }
    model.addAttribute("user", user);
    return "admin/editUser"; // Chuyển đến trang chỉnh sửa người dùng.
}

@PostMapping("/editUser")
public String editUser(@ModelAttribute User user, Model model) {
    // Tìm người dùng trong cơ sở dữ liệu theo ID trước khi chỉnh sửa
    User existingUser = userGVService.findUserById(user.getId());
    if (existingUser == null) {
        model.addAttribute("error", "Người dùng không tồn tại.");
        return "error"; // Nếu không tìm thấy người dùng trong cơ sở dữ liệu.
    }

    // Gán lại thời gian cập nhật mới
    String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    user.setUpdatedAt(currentTime); // Cập nhật lại thời gian cập nhật.

    // Giữ nguyên các trường không thay đổi của người dùng (trong trường hợp người dùng chỉ muốn thay đổi một số trường)
    if (user.getUsername() == null || user.getUsername().isEmpty()) {
        user.setUsername(existingUser.getUsername()); // Giữ tên người dùng cũ nếu không có sự thay đổi.
    }
    if (user.getPassword() == null || user.getPassword().isEmpty()) {
        user.setPassword(existingUser.getPassword()); // Giữ mật khẩu cũ nếu không thay đổi.
    }
    // ... (Thực hiện tương tự cho các trường khác như email, vai trò, v.v.)

    // Lưu lại người dùng đã chỉnh sửa
    userGVService.saveUser(user);
    return "redirect:/admin/users";
}


 // Xóa người dùng
@GetMapping("/deleteUser/{id}")
public String deleteUser(@PathVariable Long id, Model model) {
    try {
        userGVService.deleteUser(id); // Xóa người dùng theo ID.
        return "redirect:/admin/users"; // Sau khi xóa, quay lại trang danh sách người dùng.
    } catch (Exception e) {
        model.addAttribute("error", "Có lỗi xảy ra khi xóa người dùng.");
        return "error"; // Nếu có lỗi trong quá trình xóa, bạn có thể hiển thị trang lỗi.
    }
}

}
