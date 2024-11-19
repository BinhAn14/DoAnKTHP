package com.example.DoAnKTHP.Controller;

import com.example.DoAnKTHP.models.LichDeXuat;
import com.example.DoAnKTHP.service.LichDeXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lichdexuat")
public class LichDeXuatController {

    @Autowired
    private LichDeXuatService lichDeXuatService;

    @GetMapping("/dexuat")
    public List<LichDeXuat> getLichDeXuat(@RequestParam String lop, @RequestParam Long giangVienId) {
        return lichDeXuatService.deXuatLich(lop, giangVienId);
    }

    @PostMapping("/dexuat-lich")
    public String deXuatLich(
            @RequestParam("lop") String lop,
            @RequestParam("giangVienId") Long giangVienId,
            Model model) {
        List<LichDeXuat> danhSachLichDeXuat = lichDeXuatService.deXuatLich(lop, giangVienId);
        model.addAttribute("danhSachLichDeXuat", danhSachLichDeXuat);
        return "lichdexuat";
    }
}