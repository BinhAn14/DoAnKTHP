package com.example.DoAnKTHP.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LopHoc")
public class LopHoc {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten_lop", nullable = false, length = 100)
    private String tenLop;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by_user_id", nullable = false)
    private Long createdByUserId;

    @Column(name = "updated_by_user_id")
    private Long updatedByUserId;

    // Phương thức này được gọi khi đối tượng được tạo lần đầu tiên
    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now(); // Gán thời gian hiện tại cho created_at
        }
        if (this.updatedAt == null) {
            this.updatedAt = LocalDateTime.now(); // Gán thời gian hiện tại cho updated_at
        }

        // Nếu createdByUserId là null, gán giá trị mặc định
        if (this.createdByUserId == null) {
            this.createdByUserId = getCurrentUserId(); // Lấy userId từ session hoặc một nguồn hợp lý
        }
    }

    // Phương thức này được gọi khi đối tượng được cập nhật
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now(); // Cập nhật thời gian hiện tại cho updated_at

        // Nếu updatedByUserId là null, gán giá trị mặc định
        if (this.updatedByUserId == null) {
            this.updatedByUserId = getCurrentUserId(); // Lấy userId từ session hoặc một nguồn hợp lý
        }
    }

    // Giả sử bạn có một phương thức để lấy thông tin người dùng từ session hoặc nguồn khác
    private Long getCurrentUserId() {
        // Đây là một ví dụ giả định, bạn có thể thay đổi để lấy thông tin từ session, security context hoặc từ API người dùng.
        // Trong trường hợp này, chúng tôi sẽ gán giá trị mặc định là 1L (ID của người quản trị).
        Long userId = 1L; // Gán giá trị mặc định cho userId nếu không có thông tin người dùng
        return userId;
    }

    // Getter và Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
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
