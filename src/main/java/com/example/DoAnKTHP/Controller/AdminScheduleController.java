package com.example.DoAnKTHP.Controller;

import com.example.DoAnKTHP.models.LichGiangVien;
import com.example.DoAnKTHP.service.LichGiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin/schedule")
public class AdminScheduleController {

    @Autowired
    private LichGiangVienService lichGiangVienService;

    // Hiển thị danh sách thời khóa biểu
    @GetMapping
    public String listSchedules(Model model) {
        model.addAttribute("schedules", lichGiangVienService.getAllSchedules());
        return "admin/schedule/list"; // Tên file Thymeleaf
    }

    // Thêm thời khóa biểu mới
    @GetMapping("/add")
    public String addScheduleForm(Model model) {
        model.addAttribute("schedule", new LichGiangVien());
        return "admin/schedule/add"; // Tên file Thymeleaf
    }

    @PostMapping("/add")
    public String saveSchedule(@ModelAttribute LichGiangVien schedule) {
        lichGiangVienService.saveSchedule(schedule);
        return "redirect:/admin/schedule";
    }

    // Sửa thời khóa biểu
    @GetMapping("/edit/{id}")
    public String editScheduleForm(@PathVariable Long id, Model model) {
        Optional<LichGiangVien> schedule = lichGiangVienService.getScheduleById(id);
        if (schedule.isPresent()) {
            model.addAttribute("schedule", schedule.get());
            return "admin/schedule/edit"; // Tên file Thymeleaf
        }
        return "redirect:/admin/schedule";
    }

    @PostMapping("/edit/{id}")
    public String updateSchedule(@PathVariable Long id, @ModelAttribute LichGiangVien schedule) {
        Optional<LichGiangVien> existingSchedule = lichGiangVienService.getScheduleById(id);
        if (existingSchedule.isPresent()) {
            LichGiangVien updatedSchedule = existingSchedule.get();
            updatedSchedule.setGiangVien(schedule.getGiangVien());
            updatedSchedule.setCa(schedule.getCa());
            updatedSchedule.setThu(schedule.getThu());
            updatedSchedule.setNgay(schedule.getNgay());
            updatedSchedule.setPhong(schedule.getPhong());
            updatedSchedule.setHocPhan(schedule.getHocPhan());
            updatedSchedule.setLopHoc(schedule.getLopHoc());
            lichGiangVienService.saveSchedule(updatedSchedule);
        }
        return "redirect:/admin/schedule";
    }
    

    // Xóa thời khóa biểu
    @GetMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable Long id) {
        lichGiangVienService.deleteSchedule(id);
        return "redirect:/admin/schedule";
    }
}
