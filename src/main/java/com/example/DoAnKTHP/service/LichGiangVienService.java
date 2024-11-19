package com.example.DoAnKTHP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DoAnKTHP.Repository.LichGiangVienRepository;
import com.example.DoAnKTHP.models.LichGiangVien;

import java.time.LocalDate;
import java.util.List;

@Service
public class LichGiangVienService {
    @Autowired
    private LichGiangVienRepository repository;

    public List<LichGiangVien> getScheduleByDate(LocalDate date) {
        List<LichGiangVien> scheduleList = repository.findByNgay(date);
        System.out.println(scheduleList); // Thử in dữ liệu để kiểm tra
        return scheduleList;
    }
}
