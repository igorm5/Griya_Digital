package com.kelompok2.rusunawagriya.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_admin")
    private UUID idAdmin;

    @Column(name = "auth_user_id")
    private UUID authUserId;

    @Column(name = "nama", length = 100, nullable = false)
    private String nama;

    @Column(name = "username", length = 50, unique = true, nullable = false)
    private String username;

    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(name = "status_aktif", nullable = false)
    private Boolean statusAktif = true;

    @Column(name = "terakhir_login")
    private OffsetDateTime terakhirLogin;

    @Column(name = "created_at", insertable = false, updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private OffsetDateTime updatedAt;

    public Admin() {}

    public UUID getIdAdmin() { return idAdmin; }
    public void setIdAdmin(UUID idAdmin) { this.idAdmin = idAdmin; }

    public UUID getAuthUserId() { return authUserId; }
    public void setAuthUserId(UUID authUserId) { this.authUserId = authUserId; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getStatusAktif() { return statusAktif; }
    public void setStatusAktif(Boolean statusAktif) { this.statusAktif = statusAktif; }

    public OffsetDateTime getTerakhirLogin() { return terakhirLogin; }
    public void setTerakhirLogin(OffsetDateTime terakhirLogin) { this.terakhirLogin = terakhirLogin; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public OffsetDateTime getUpdatedAt() { return updatedAt; }
}