package com.example.DoAnKTHP.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PhongHoc")
public class PhongHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten_phong", nullable = false, length = 100)
    private String tenPhong;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by_user_id", nullable = false)
    private Long createdByUserId;

    @Column(name = "updated_by_user_id")
    private Long updatedByUserId;

    // Getter and Setter methods

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;  // Gán thời gian tạo
        this.updatedAt = now;  // Gán thời gian cập nhật
        this.createdByUserId = currentUserId();  // Giả sử bạn có phương thức lấy ID người tạo
        this.updatedByUserId = currentUserId();  // Giả sử bạn có phương thức lấy ID người sửa
    }

    private Long currentUserId() {
        // Phương thức giả định để lấy ID người dùng hiện tại
        // Bạn cần thay thế bằng cách lấy ID người dùng thực tế
        return 1L;  // Ví dụ, ID người dùng hiện tại là 1
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Long getUpdatedByUserId() {
        return updatedByUserId;
    }

    public void setUpdatedByUserId(Long updatedByUserId) {
        this.updatedByUserId = updatedByUserId;
    }

}
