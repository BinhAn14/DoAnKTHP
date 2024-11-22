package com.example.DoAnKTHP.service;

import com.example.DoAnKTHP.Repository.GiangVienRepository;
import com.example.DoAnKTHP.models.GiangVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TKBGiangVienService {

    @Autowired
    private GiangVienRepository giangVienRepository;

    public GiangVien getThoiKhoaBieuById(Long id) {
        return giangVienRepository.findById(id).orElse(null);
    }
}
