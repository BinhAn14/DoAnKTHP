package com.example.DoAnKTHP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DoAnKTHP.Repository.CaHocRepository;
import com.example.DoAnKTHP.models.CaHoc;

import java.util.List;

@Service
public class ThoiKhoaBieuService {

    @Autowired
    private CaHocRepository caHocRepository;

    public List<CaHoc> layThoiKhoaBieu() {
        return caHocRepository.findAll();
    }
}
