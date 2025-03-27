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
public class LichDeXuatController {

    @Autowired
    private LichDeXuatService lichDeXuatService;

    @GetMapping("/lich-de-xuat")
    public String hienThiLichDeXuat(@RequestParam(name = "giangVienId", required = false, defaultValue = "1") Long giangVienId, Model model) {
        // Lấy danh sách lịch đề xuất
        List<LichDeXuat> danhSachLichDeXuat = lichDeXuatService.deXuatLich(giangVienId);
        model.addAttribute("danhSachLichDeXuat", danhSachLichDeXuat);
        return "lich-de-xuat"; // Tên của template HTML (lich-de-xuat.html)
    }
}
