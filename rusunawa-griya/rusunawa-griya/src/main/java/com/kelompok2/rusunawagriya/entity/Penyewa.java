package com.kelompok2.rusunawagriya.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "penyewa")
public class Penyewa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_penyewa")
    private UUID idPenyewa;

    @Column(name = "auth_user_id")
    private UUID authUserId;

    @Column(name = "nama", length = 100, nullable = false)
    private String nama;

    @Column(name = "nik_ktp", length = 16, unique = true, nullable = false)
    private String nikKtp;

    @Column(name = "no_telepon", length = 20, nullable = false)
    private String noTelepon;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    // Nilai wajib Title Case: 'Mahasiswa' atau 'Umum'
    @Column(name = "kategori_penyewa", length = 30, nullable = false)
    private String kategoriPenyewa = "Mahasiswa";

    @Column(name = "fakultas", length = 100)
    private String fakultas;

    @Column(name = "created_at", insertable = false, updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private OffsetDateTime updatedAt;

    public Penyewa() {}

    public UUID getIdPenyewa() { return idPenyewa; }
    public void setIdPenyewa(UUID idPenyewa) { this.idPenyewa = idPenyewa; }

    public UUID getAuthUserId() { return authUserId; }
    public void setAuthUserId(UUID authUserId) { this.authUserId = authUserId; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNikKtp() { return nikKtp; }
    public void setNikKtp(String nikKtp) { this.nikKtp = nikKtp; }

    public String getNoTelepon() { return noTelepon; }
    public void setNoTelepon(String noTelepon) { this.noTelepon = noTelepon; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getKategoriPenyewa() { return kategoriPenyewa; }
    public void setKategoriPenyewa(String kategoriPenyewa) { this.kategoriPenyewa = kategoriPenyewa; }

    public String getFakultas() { return fakultas; }
    public void setFakultas(String fakultas) { this.fakultas = fakultas; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public OffsetDateTime getUpdatedAt() { return updatedAt; }
}