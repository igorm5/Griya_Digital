package com.kelompok2.rusunawagriya.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;

import com.kelompok2.rusunawagriya.entity.Kamar;
import com.kelompok2.rusunawagriya.entity.Pemesanan;
import com.kelompok2.rusunawagriya.entity.Penyewa;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class PemesananRequest {

    private Long idKamar;
    private String nama;
    private String nikKtp;
    private String noTelepon;
    private String email;
    private String fakultas; // opsional untuk penyewa umum

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalMulai;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalSelesai;

    private String tipeSewa;

    public PemesananRequest() {}

    public interface KamarRepository extends JpaRepository<Kamar, UUID> {}
    public interface PenyewaRepository extends JpaRepository<Penyewa, UUID> {
        Optional<Penyewa> findByNikKtp(String nikKtp);
    }
public interface PemesananRepository extends JpaRepository<Pemesanan, UUID> {}

    public Long getIdKamar() { return idKamar; }
    public void setIdKamar(Long idKamar) { this.idKamar = idKamar; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNikKtp() { return nikKtp; }
    public void setNikKtp(String nikKtp) { this.nikKtp = nikKtp; }

    public String getNoTelepon() { return noTelepon; }
    public void setNoTelepon(String noTelepon) { this.noTelepon = noTelepon; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFakultas() { return fakultas; }
    public void setFakultas(String fakultas) { this.fakultas = fakultas; }

    public LocalDate getTanggalMulai() { return tanggalMulai; }
    public void setTanggalMulai(LocalDate tanggalMulai) { this.tanggalMulai = tanggalMulai; }

    public LocalDate getTanggalSelesai() { return tanggalSelesai; }
    public void setTanggalSelesai(LocalDate tanggalSelesai) { this.tanggalSelesai = tanggalSelesai; }

    public String getTipeSewa() { return tipeSewa; }
    public void setTipeSewa(String tipeSewa) { this.tipeSewa = tipeSewa; }
}