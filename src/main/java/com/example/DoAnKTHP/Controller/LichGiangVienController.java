package com.example.DoAnKTHP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.DoAnKTHP.models.LichGiangVien;
import com.example.DoAnKTHP.service.LichGiangVienService;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/schedule")
public class LichGiangVienController {
    @Autowired
    private LichGiangVienService service;

    @GetMapping
    public List<LichGiangVien> getSchedule(@RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date); // Format: yyyy-MM-dd
        return service.getScheduleByDate(localDate);
    }
    @GetMapping("/schedule")
    public String viewSchedule(Model model) {
        LocalDate today = LocalDate.now();
        List<LichGiangVien> scheduleList = service.getScheduleByDate(today);

        model.addAttribute("date", today);
        model.addAttribute("dayOfWeek", today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("vi")));
        model.addAttribute("scheduleList", scheduleList);

        return "schedule";
    }

}
