package com.kelompok2.rusunawagriya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/penghuni")
public class PenghuniWebController {

    @GetMapping("/katalog")
    public String katalog() {
        return "penghuni/katalog";
    }

    @GetMapping("/detail-kamar")
    public String detailKamar() {
        return "penghuni/detail-kamar";
    }

    @GetMapping("/detail-kamar-penuh")
    public String detailKamarPenuh() {
        return "penghuni/detail-kamar-penuh";
    }

    @GetMapping("/form-pemesanan")
    public String formPemesanan() {
        return "penghuni/form-pemesanan";
    }

    @GetMapping("/konfirmasi-pemesanan")
    public String konfirmasiPemesanan() {
        return "penghuni/konfirmasi-pemesanan";
    }

    @GetMapping("/pesanan-saya")
    public String pesananSaya() {
        return "penghuni/pesanan-saya";
    }

    @GetMapping("/profil")
    public String profil() {
        return "penghuni/profil";
    }

    @GetMapping("/verifikasi-mahasiswa")
    public String verifikasiMahasiswa() {
        return "penghuni/verifikasi-mahasiswa";
    }

    @GetMapping("/lengkapi-data")
    public String lengkapiData() {
        return "penghuni/lengkapi-data";
    }
}
