package com.kelompok2.rusunawagriya.service;

import com.kelompok2.rusunawagriya.dto.PemesananRequest;
import com.kelompok2.rusunawagriya.entity.Kamar;
import com.kelompok2.rusunawagriya.entity.Pemesanan;
import com.kelompok2.rusunawagriya.entity.Penyewa;
import com.kelompok2.rusunawagriya.exception.KamarPenuhException;
import com.kelompok2.rusunawagriya.repository.KamarRepository;
import com.kelompok2.rusunawagriya.repository.PemesananRepository;
import com.kelompok2.rusunawagriya.repository.PenyewaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PemesananService {

    private final KamarRepository kamarRepo;
    private final PenyewaRepository penyewaRepo;
    private final PemesananRepository pemesananRepo;

    public PemesananService(KamarRepository kamarRepo,
                            PenyewaRepository penyewaRepo,
                            PemesananRepository pemesananRepo) {
        this.kamarRepo = kamarRepo;
        this.penyewaRepo = penyewaRepo;
        this.pemesananRepo = pemesananRepo;
    }

    public List<Kamar> getSemuaKamar() {
        return kamarRepo.findAll();
    }

    public Kamar cekKetersediaan(UUID idKamar) {
        Kamar kamar = kamarRepo.findById(idKamar)
                .orElseThrow(() -> new IllegalArgumentException("Data kamar tidak ditemukan."));

        if (!"Tersedia".equalsIgnoreCase(kamar.getStatusKetersediaan())) {
            throw new KamarPenuhException(kamar.getNomorKamar());
        }
        return kamar;
    }

    public Pemesanan getPemesananById(UUID idPemesanan) {
        return pemesananRepo.findById(idPemesanan)
                .orElseThrow(() -> new IllegalArgumentException("Data pemesanan tidak ditemukan."));
    }

    @Transactional
    public Pemesanan submitPemesanan(PemesananRequest req) {
        validasiInput(req);
        Kamar kamar = cekKetersediaan(req.getIdKamar());

        // Cegah error UNIQUE nik_ktp jika penyewa memesan ulang
        Penyewa penyewa = penyewaRepo.findByNikKtp(req.getNikKtp().trim())
                .orElseGet(Penyewa::new);

        penyewa.setNama(req.getNama().trim());
        penyewa.setNikKtp(req.getNikKtp().trim());
        penyewa.setNoTelepon(req.getNoTelepon().trim());
        penyewa.setEmail(req.getEmail().trim());
        penyewa.setKategoriPenyewa(
                (req.getKategoriPenyewa() == null || req.getKategoriPenyewa().isBlank())
                        ? "Mahasiswa" : req.getKategoriPenyewa()
        );
        penyewa.setFakultas(req.getFakultas());
        penyewaRepo.save(penyewa);

        // Simpan transaksi pemesanan (status Title Case sesuai CHECK constraint)
        Pemesanan pesanan = new Pemesanan();
        pesanan.setPenyewa(penyewa);
        pesanan.setKamar(kamar);
        pesanan.setTipeSewa(req.getTipeSewa());
        pesanan.setTanggalPemesanan(OffsetDateTime.now());
        pesanan.setTanggalMulai(req.getTanggalMulai());
        pesanan.setTanggalSelesai(req.getTanggalSelesai());
        pesanan.setStatusPemesanan("Menunggu");
        pesanan.setStatusPembayaran("Belum Lunas");

        // Kunci status kamar menjadi 'Dipesan'
        kamar.setStatusKetersediaan("Dipesan");
        kamarRepo.save(kamar);

        return pemesananRepo.save(pesanan);
    }

    private void validasiInput(PemesananRequest req) {
        if (req.getNama() == null || req.getNama().isBlank()) {
            throw new IllegalArgumentException("Nama lengkap wajib diisi.");
        }
        if (req.getNikKtp() == null || req.getNikKtp().trim().length() != 16) {
            throw new IllegalArgumentException("NIK KTP harus terdiri dari tepat 16 digit.");
        }
        if (req.getNoTelepon() == null || req.getNoTelepon().isBlank()) {
            throw new IllegalArgumentException("Nomor telepon wajib diisi.");
        }
        if (req.getEmail() == null || !req.getEmail().contains("@")) {
            throw new IllegalArgumentException("Format email tidak valid.");
        }
        if (req.getTanggalMulai() == null || req.getTanggalSelesai() == null) {
            throw new IllegalArgumentException("Tanggal mulai dan tanggal selesai wajib diisi.");
        }
        if (req.getTanggalSelesai().isBefore(req.getTanggalMulai())) {
            throw new IllegalArgumentException("Tanggal selesai tidak boleh lebih awal dari tanggal mulai.");
        }
    }
}