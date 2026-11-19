package com.kelompok2.rusunawagriya.service;

import com.kelompok2.rusunawagriya.entity.Admin;
import com.kelompok2.rusunawagriya.entity.Kamar;
import com.kelompok2.rusunawagriya.entity.LogAktivitas;
import com.kelompok2.rusunawagriya.entity.Pemesanan;
import com.kelompok2.rusunawagriya.repository.AdminRepository;
import com.kelompok2.rusunawagriya.repository.KamarRepository;
import com.kelompok2.rusunawagriya.repository.LogAktivitasRepository;
import com.kelompok2.rusunawagriya.repository.PemesananRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AdminVerifikasiService {

    private static final String ADMIN_DUMMY_USERNAME = "admin_rusunawa";

    private final PemesananRepository pemesananRepository;
    private final KamarRepository kamarRepository;
    private final AdminRepository adminRepository;
    private final LogAktivitasRepository logAktivitasRepository;

    public AdminVerifikasiService(
            PemesananRepository pemesananRepository,
            KamarRepository kamarRepository,
            AdminRepository adminRepository,
            LogAktivitasRepository logAktivitasRepository) {
        this.pemesananRepository = pemesananRepository;
        this.kamarRepository = kamarRepository;
        this.adminRepository = adminRepository;
        this.logAktivitasRepository = logAktivitasRepository;
    }

    // 1. Mengambil daftar pesanan berstatus 'Menunggu'
    public List<Pemesanan> getDaftarPemesananMenunggu() {
        return pemesananRepository.findAllByStatusWithDetail("Menunggu");
    }

    // 2. Proses verifikasi pesanan, update kamar, dan catat log aktivitas secara atomik
    @Transactional
    public void verifikasiPemesanan(UUID idPemesanan) {
        Admin admin = adminRepository.findByUsername(ADMIN_DUMMY_USERNAME)
                .orElseThrow(() -> new IllegalStateException(
                        "Admin dummy '" + ADMIN_DUMMY_USERNAME + "' tidak ditemukan di database."));

        Pemesanan pemesanan = pemesananRepository.findById(idPemesanan)
                .orElseThrow(() -> new IllegalArgumentException("Data pemesanan tidak ditemukan."));

        if (!"Menunggu".equals(pemesanan.getStatusPemesanan())) {
            throw new IllegalStateException("Pemesanan ini sudah diproses sebelumnya (Status: "
                    + pemesanan.getStatusPemesanan() + ").");
        }

        // Ubah status pemesanan -> 'Terverifikasi' & pembayaran -> 'Lunas'
        pemesanan.setStatusPemesanan("Terverifikasi");
        pemesanan.setStatusPembayaran("Lunas");
        pemesanan.setAdmin(admin);
        pemesananRepository.save(pemesanan);

        // Ubah status ketersediaan kamar -> 'Terisi'
        Kamar kamar = pemesanan.getKamar();
        if (kamar != null) {
            kamar.setStatusKetersediaan("Terisi");
            kamarRepository.save(kamar);
        }

        // Otomatis catat riwayat ke log_aktivitas
        LogAktivitas log = new LogAktivitas();
        log.setAdmin(admin);
        log.setAksi("Verifikasi Pemesanan & Pembayaran");
        log.setNamaTabel("pemesanan");
        log.setIdRecord(pemesanan.getIdPemesanan());
        log.setWaktuLog(OffsetDateTime.now());
        logAktivitasRepository.save(log);
    }
}