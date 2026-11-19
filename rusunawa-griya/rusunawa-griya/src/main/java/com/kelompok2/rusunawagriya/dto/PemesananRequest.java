package com.kelompok2.rusunawagriya.dto;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.UUID;

public class PemesananRequest {

    private UUID idKamar;
    private String nama;
    private String nikKtp;
    private String noTelepon;
    private String email;
    private String kategoriPenyewa = "Mahasiswa";
    private String fakultas;
    private String tipeSewa;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate tanggalMulai;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate tanggalSelesai;

    public PemesananRequest() {}

    public UUID getIdKamar() { return idKamar; }
    public void setIdKamar(UUID idKamar) { this.idKamar = idKamar; }

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

    public String getTipeSewa() { return tipeSewa; }
    public void setTipeSewa(String tipeSewa) { this.tipeSewa = tipeSewa; }

    public LocalDate getTanggalMulai() { return tanggalMulai; }
    public void setTanggalMulai(LocalDate tanggalMulai) { this.tanggalMulai = tanggalMulai; }

    public LocalDate getTanggalSelesai() { return tanggalSelesai; }
    public void setTanggalSelesai(LocalDate tanggalSelesai) { this.tanggalSelesai = tanggalSelesai; }
}