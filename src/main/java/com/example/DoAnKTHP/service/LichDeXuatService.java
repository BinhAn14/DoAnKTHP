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
    private LichPhongMayRepository lichPhongMayRepository;

    @Autowired
    private LichGiangVienRepository lichGiangVienRepository;

    // Phương thức đề xuất lịch
    public List<LichDeXuat> deXuatLich(Long giangVienId) {
        List<LichDeXuat> danhSachDeXuat = new ArrayList<>();

        // Lấy lịch giảng viên từ cơ sở dữ liệu
        List<LichGiangVien> lichGiangVienList = lichGiangVienRepository.findByGiangVienId(giangVienId);
        
        // Lấy danh sách phòng máy còn trống
        List<LichPhongMay> phongTrongList = lichPhongMayRepository.findPhongTrong();

        // Kiểm tra các phòng, các ngày trong tuần và ca học
        for (LichPhongMay phongTrong : phongTrongList) {
            for (int thu = 2; thu <= 7; thu++) {  // Thứ 2 đến thứ 7
                for (int ca = 1; ca <= 5; ca++) {  // 5 ca học
                    boolean giangVienRanh = kiemTraGiangVienRanh(lichGiangVienList, thu, ca);

                    // Nếu giảng viên rảnh, thêm vào danh sách lịch đề xuất
                    if (giangVienRanh) {
                        LichDeXuat lichDeXuat = new LichDeXuat(
                                phongTrong.getPhong(),
                                thu,
                                ca,
                                null, giangVienId);
                        danhSachDeXuat.add(lichDeXuat);
                    }
                }
            }
        }

        return danhSachDeXuat;
    }

    // Kiểm tra xem giảng viên có rảnh vào thời gian đã cho không
    private boolean kiemTraGiangVienRanh(List<LichGiangVien> lichGiangVienList, int thu, int ca) {
        for (LichGiangVien lichGiangVien : lichGiangVienList) {
            if (lichGiangVien.getThu() == thu && lichGiangVien.getCa() == ca) {
                return false; // Giảng viên đã có lịch
            }
        }
        return true; // Giảng viên không có lịch
    }
}

