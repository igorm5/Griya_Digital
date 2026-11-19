package com.kelompok2.rusunawagriya.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "pemesanan")
public class Pemesanan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_pemesanan")
    private UUID idPemesanan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_penyewa", nullable = false)
    private Penyewa penyewa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kamar", nullable = false)
    private Kamar kamar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_admin")
    private Admin admin;

    @Column(name = "tipe_sewa", length = 30, nullable = false)
    private String tipeSewa;

    @Column(name = "tanggal_pemesanan", nullable = false)
    private OffsetDateTime tanggalPemesanan = OffsetDateTime.now();

    @Column(name = "tanggal_mulai", nullable = false)
    private LocalDate tanggalMulai;

    @Column(name = "tanggal_selesai", nullable = false)
    private LocalDate tanggalSelesai;

    // Nilai wajib Title Case: 'Menunggu', 'Terverifikasi', 'Ditolak', 'Dibatalkan'
    @Column(name = "status_pemesanan", length = 30, nullable = false)
    private String statusPemesanan = "Menunggu";

    // Nilai wajib Title Case: 'Belum Lunas' atau 'Lunas'
    @Column(name = "status_pembayaran", length = 30, nullable = false)
    private String statusPembayaran = "Belum Lunas";

    @Column(name = "created_at", insertable = false, updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private OffsetDateTime updatedAt;

    public Pemesanan() {}

    public UUID getIdPemesanan() { return idPemesanan; }
    public void setIdPemesanan(UUID idPemesanan) { this.idPemesanan = idPemesanan; }

    public Penyewa getPenyewa() { return penyewa; }
    public void setPenyewa(Penyewa penyewa) { this.penyewa = penyewa; }

    public Kamar getKamar() { return kamar; }
    public void setKamar(Kamar kamar) { this.kamar = kamar; }

    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }

    public String getTipeSewa() { return tipeSewa; }
    public void setTipeSewa(String tipeSewa) { this.tipeSewa = tipeSewa; }

    public OffsetDateTime getTanggalPemesanan() { return tanggalPemesanan; }
    public void setTanggalPemesanan(OffsetDateTime tanggalPemesanan) { this.tanggalPemesanan = tanggalPemesanan; }

    public LocalDate getTanggalMulai() { return tanggalMulai; }
    public void setTanggalMulai(LocalDate tanggalMulai) { this.tanggalMulai = tanggalMulai; }

    public LocalDate getTanggalSelesai() { return tanggalSelesai; }
    public void setTanggalSelesai(LocalDate tanggalSelesai) { this.tanggalSelesai = tanggalSelesai; }

    public String getStatusPemesanan() { return statusPemesanan; }
    public void setStatusPemesanan(String statusPemesanan) { this.statusPemesanan = statusPemesanan; }

    public String getStatusPembayaran() { return statusPembayaran; }
    public void setStatusPembayaran(String statusPembayaran) { this.statusPembayaran = statusPembayaran; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public OffsetDateTime getUpdatedAt() { return updatedAt; }
}