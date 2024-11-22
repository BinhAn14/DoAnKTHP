package com.example.DoAnKTHP.Controller;

import com.example.DoAnKTHP.models.LichDeXuat;
import com.example.DoAnKTHP.service.LichDeXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/lichdexuat")
public class LichDeXuatController {

    @Autowired
    private LichDeXuatService lichDeXuatService;

    @GetMapping("/dexuat")
    public String getLichDeXuat(@RequestParam String lop, @RequestParam Long giangVienId, Model model) {
        List<LichDeXuat> danhSachLichDeXuat = lichDeXuatService.deXuatLich(lop, giangVienId);
        model.addAttribute("danhSachLichDeXuat", danhSachLichDeXuat);
        return "lichdexuat";
    }

    @GetMapping("/timlichdexuat")
    public String timLichDeXuat(@RequestParam String lop, @RequestParam Long giangVienId, Model model) {
        List<LichDeXuat> danhSachLichDeXuat = lichDeXuatService.deXuatLich(lop, giangVienId);
        model.addAttribute("danhSachLichDeXuat", danhSachLichDeXuat);
        return "timlichdexuat";
    }
}
