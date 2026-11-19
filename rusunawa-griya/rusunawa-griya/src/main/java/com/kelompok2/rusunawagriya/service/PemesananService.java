// package com.kelompok2.rusunawagriya.service;

// import java.time.LocalDateTime;

// import com.kelompok2.rusunawagriya.dto.PemesananRequest;
// import com.kelompok2.rusunawagriya.entity.Pemesanan;
// import com.kelompok2.rusunawagriya.entity.Penyewa;

// public class PemesananService {

//     private final KamarRepository kamarRepo;
//     private final PenyewaRepository penyewaRepo;
//     private final PemesananRepository pemesananRepo;

//     public PemesananService(KamarRepository kamarRepo,
//                             PenyewaRepository penyewaRepo,
//                             PemesananRepository pemesananRepo) {
//         this.kamarRepo = kamarRepo;
//         this.penyewaRepo = penyewaRepo;
//         this.pemesananRepo = pemesananRepo;
//     }

//     // 1. Ambil semua kamar untuk ditampilkan di katalog
//     public List<Kamar> getSemuaKamar() {
//         return kamarRepo.findAll();
//     }

//     // 2. Cek apakah kamar masih TERSEDIA sebelum buka form / simpan
//     public Kamar cekKetersediaan(Long idKamar) {
//         Kamar kamar = kamarRepo.findById(idKamar)
//                 .orElseThrow(() -> new IllegalArgumentException("Kamar tidak ditemukan."));

//         if (!"TERSEDIA".equalsIgnoreCase(kamar.getStatusKetersediaan())) {
//             throw new KamarPenuhException(kamar.getNomorKamar());
//         }
//         return kamar;
//     }

//     // 3. Proses simpan data penyewa + transaksi pemesanan baru
//     @Transactional
//     public Pemesanan submitPemesanan(PemesananRequest req) {
//         validasiInput(req);
//         Kamar kamar = cekKetersediaan(req.getIdKamar());

//         // Simpan data calon penyewa
//         Penyewa penyewa = new Penyewa();
//         penyewa.setNama(req.getNama());
//         penyewa.setNikKtp(req.getNikKtp());
//         penyewa.setNoTelepon(req.getNoTelepon());
//         penyewa.setEmail(req.getEmail());
//         penyewa.setFakultas(req.getFakultas());
//         penyewaRepo.save(penyewa);

//         // Simpan data transaksi pemesanan
//         Pemesanan pesanan = new Pemesanan();
//         pesanan.setPenyewa(penyewa);
//         pesanan.setKamar(kamar);
//         pesanan.setTanggalPemesanan(LocalDateTime.now());
//         pesanan.setTanggalMulai(req.getTanggalMulai());
//         pesanan.setTanggalSelesai(req.getTanggalSelesai());
//         pesanan.setTipeSewa(req.getTipeSewa());
//         pesanan.setHargaDisepakati(kamar.getHargaPerPeriode());
//         pesanan.setStatusPemesanan("MENUNGGU_VERIFIKASI");
//         pesanan.setStatusPembayaran("BELUM_LUNAS");

//         // Kunci status kamar agar tidak dipesan orang lain
//         kamar.setStatusKetersediaan("DIPESAN");
//         kamarRepo.save(kamar);

//         return pemesananRepo.save(pesanan);
//     }
//     public void validasiInput(PemesananRequest req) {
//         if (req.getNama() == null || req.getNama().isBlank()) {
//             throw new IllegalArgumentException("Nama lengkap wajib diisi.");
//         }
//         if (req.getNikKtp() == null || req.getNikKtp().trim().length() != 16) {
//             throw new IllegalArgumentException("NIK KTP harus terdiri dari tepat 16 digit.");
//         }
//         if (req.getNoTelepon() == null || req.getNoTelepon().isBlank()) {
//             throw new IllegalArgumentException("Nomor telepon wajib diisi.");
//         }
//         if (req.getEmail() == null || !req.getEmail().contains("@")) {
//             throw new IllegalArgumentException("Format email tidak valid.");
//         }
//         if (req.getTanggalMulai() == null || req.getTanggalSelesai() == null) {
//             throw new IllegalArgumentException("Tanggal mulai dan tanggal selesai sewa wajib diisi.");
//         }
//         if (req.getTanggalSelesai().isBefore(req.getTanggalMulai())) {
//             throw new IllegalArgumentException("Tanggal selesai tidak boleh lebih awal dari tanggal mulai.");
//         }
//     }
// }