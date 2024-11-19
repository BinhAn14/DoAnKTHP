package com.example.DoAnKTHP.service;

import com.example.DoAnKTHP.Repository.LichGiangVienRepository;
import com.example.DoAnKTHP.Repository.LichLopRepository;
import com.example.DoAnKTHP.Repository.LichPhongMayRepository;
import com.example.DoAnKTHP.models.LichDeXuat;
import com.example.DoAnKTHP.models.LichGiangVien;
import com.example.DoAnKTHP.models.LichLop;
import com.example.DoAnKTHP.models.LichPhongMay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LichDeXuatService {

    @Autowired
    private LichLopRepository lichLopRepository;

    @Autowired
    private LichPhongMayRepository lichPhongMayRepository;

    @Autowired
    private LichGiangVienRepository lichGiangVienRepository;

    public List<LichDeXuat> deXuatLich(String lop, Long giangVienId) {
        List<LichDeXuat> danhSachDeXuat = new ArrayList<>();

        List<LichLop> lichLopList = lichLopRepository.findByLop(lop);

        List<LichGiangVien> lichGiangVienList = lichGiangVienRepository.findByGiangVienId(giangVienId);

        List<LichPhongMay> phongTrongList = lichPhongMayRepository.findPhongTrong();
        for (LichPhongMay phongTrong : phongTrongList) {
            for (int thu = 2; thu <= 7; thu++) {
                for (int ca = 1; ca <= 5; ca++) {
                    boolean lopRanh = kiemTraLopRanh(lichLopList, thu, ca);
                    boolean giangVienRanh = kiemTraGiangVienRanh(lichGiangVienList, thu, ca);

                    if (lopRanh && giangVienRanh) {

                        LichDeXuat lichDeXuat = new LichDeXuat(
                                phongTrong.getPhong(),
                                thu,
                                ca,
                                lop,
                                giangVienId);
                        danhSachDeXuat.add(lichDeXuat);
                    }
                }
            }
        }

        return danhSachDeXuat;
    }

    private boolean kiemTraLopRanh(List<LichLop> lichLopList, int thu, int ca) {
        for (LichLop lichLop : lichLopList) {
            if (lichLop.getThu() == thu && lichLop.getCa() == ca) {
                return false;
            }
        }
        return true;
    }

    private boolean kiemTraGiangVienRanh(List<LichGiangVien> lichGiangVienList, int thu, int ca) {
        for (LichGiangVien lichGiangVien : lichGiangVienList) {
            if (lichGiangVien.getThu() == thu && lichGiangVien.getCa() == ca) {
                return false;
            }
        }
        return true;
    }
}
