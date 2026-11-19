package com.kelompok2.rusunawagriya.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "kamar")
public class Kamar {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_kamar")
    private UUID idKamar;

    @Column(name = "nomor_kamar", length = 20, unique = true, nullable = false)
    private String nomorKamar;

    @Column(name = "gedung", length = 50, nullable = false)
    private String gedung;

    @Column(name = "lantai", nullable = false)
    private Integer lantai;

    @Column(name = "kategori_kamar", length = 50, nullable = false)
    private String kategoriKamar;

    @Column(name = "kapasitas_max", nullable = false)
    private Integer kapasitasMax = 1;

    @Column(name = "harga_per_periode", precision = 12, scale = 2, nullable = false)
    private BigDecimal hargaPerPeriode;

    @Column(name = "fasilitas", columnDefinition = "TEXT")
    private String fasilitas;

    @Column(name = "foto_kamar", columnDefinition = "TEXT")
    private String fotoKamar;

    // Nilai wajib Title Case: 'Tersedia', 'Dipesan', 'Terisi', 'Penuh'
    @Column(name = "status_ketersediaan", length = 20, nullable = false)
    private String statusKetersediaan = "Tersedia";

    @Column(name = "created_at", insertable = false, updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private OffsetDateTime updatedAt;

    public Kamar() {}

    public UUID getIdKamar() { return idKamar; }
    public void setIdKamar(UUID idKamar) { this.idKamar = idKamar; }

    public String getNomorKamar() { return nomorKamar; }
    public void setNomorKamar(String nomorKamar) { this.nomorKamar = nomorKamar; }

    public String getGedung() { return gedung; }
    public void setGedung(String gedung) { this.gedung = gedung; }

    public Integer getLantai() { return lantai; }
    public void setLantai(Integer lantai) { this.lantai = lantai; }

    public String getKategoriKamar() { return kategoriKamar; }
    public void setKategoriKamar(String kategoriKamar) { this.kategoriKamar = kategoriKamar; }

    public Integer getKapasitasMax() { return kapasitasMax; }
    public void setKapasitasMax(Integer kapasitasMax) { this.kapasitasMax = kapasitasMax; }

    public BigDecimal getHargaPerPeriode() { return hargaPerPeriode; }
    public void setHargaPerPeriode(BigDecimal hargaPerPeriode) { this.hargaPerPeriode = hargaPerPeriode; }

    public String getFasilitas() { return fasilitas; }
    public void setFasilitas(String fasilitas) { this.fasilitas = fasilitas; }

    public String getFotoKamar() { return fotoKamar; }
    public void setFotoKamar(String fotoKamar) { this.fotoKamar = fotoKamar; }

    public String getStatusKetersediaan() { return statusKetersediaan; }
    public void setStatusKetersediaan(String statusKetersediaan) { this.statusKetersediaan = statusKetersediaan; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public OffsetDateTime getUpdatedAt() { return updatedAt; }
}