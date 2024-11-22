package com.example.DoAnKTHP.Controller;

import com.example.DoAnKTHP.Repository.LichGiangVienRepository;
import com.example.DoAnKTHP.models.CaHoc;
import com.example.DoAnKTHP.models.GiangVien;
import com.example.DoAnKTHP.models.LichGiangVien;
import com.example.DoAnKTHP.service.TKBGiangVienService;
import com.example.DoAnKTHP.service.ThoiKhoaBieuService;

import java.util.List;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lich")
public class TKBGiangVienController {

    // @Autowired
    // private TKBGiangVienService giangVienService;
    // @Autowired
    // private ThoiKhoaBieuService thoiKhoaBieuService;

    @Autowired
    private LichGiangVienRepository lichGiangVienRepository;

    // @GetMapping("/nhap-id-giang-vien")
    // public String showInputPage() {
    // return "nhap-id-giang-vien";
    // }

    // @GetMapping("/thoi-khoa-bieu")
    // public String hienThiThoiKhoaBieu(Model model) {
    // List<CaHoc> thoiKhoaBieu = thoiKhoaBieuService.layThoiKhoaBieu();
    // model.addAttribute("thoiKhoaBieu", thoiKhoaBieu);
    // return "thoi-khoa-bieu-giang-vien";
    // }

    // @PostMapping("/hien-thi-thoi-khoa-bieu")
    // public String showThoiKhoaBieu(@RequestParam("id") Long id, Model model) {
    // GiangVien giangVien = giangVienService.getThoiKhoaBieuById(id);
    // model.addAttribute("giangVien", giangVien);
    // return "thoi-khoa-bieu-giang-vien";
    // }

    @GetMapping("/giangvien")
    public String getThoiKhoaBieu(@RequestParam("giangVienId") Long giangVienId, Model model) {
        List<LichGiangVien> lichGiangVienList = lichGiangVienRepository.findByGiangVienId(giangVienId);
        model.addAttribute("thoiKhoaBieu", lichGiangVienList);
        return "thoiKhoaBieu";
    }

}
