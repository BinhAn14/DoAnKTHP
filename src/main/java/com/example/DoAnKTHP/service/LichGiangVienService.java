package com.example.DoAnKTHP.service;

import com.example.DoAnKTHP.Repository.LichGiangVienRepository;
import com.example.DoAnKTHP.models.LichGiangVien;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LichGiangVienService {

    @Autowired
    private LichGiangVienRepository lichGiangVienRepository;

    public List<LichGiangVien> getAllSchedules() {
        return lichGiangVienRepository.findAll();
    }

    public Optional<LichGiangVien> getScheduleById(Long id) {
        return lichGiangVienRepository.findById(id);
    }

    public LichGiangVien saveSchedule(LichGiangVien lichGiangVien) {
        return lichGiangVienRepository.save(lichGiangVien);
    }
    @Transactional
    public void deleteSchedule(Long id) {
        lichGiangVienRepository.deleteById(id);
    }
    
}
