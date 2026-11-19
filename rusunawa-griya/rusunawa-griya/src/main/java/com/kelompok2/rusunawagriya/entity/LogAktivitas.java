package com.kelompok2.rusunawagriya.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "log_aktivitas")
public class LogAktivitas {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_log")
    private UUID idLog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_admin", nullable = false)
    private Admin admin;

    @Column(name = "aksi", length = 50, nullable = false)
    private String aksi;

    @Column(name = "nama_tabel", length = 50, nullable = false)
    private String namaTabel;

    @Column(name = "id_record", nullable = false)
    private UUID idRecord;

    @Column(name = "waktu_log", nullable = false)
    private OffsetDateTime waktuLog = OffsetDateTime.now();

    public LogAktivitas() {}

    public UUID getIdLog() { return idLog; }
    public void setIdLog(UUID idLog) { this.idLog = idLog; }

    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }

    public String getAksi() { return aksi; }
    public void setAksi(String aksi) { this.aksi = aksi; }

    public String getNamaTabel() { return namaTabel; }
    public void setNamaTabel(String namaTabel) { this.namaTabel = namaTabel; }

    public UUID getIdRecord() { return idRecord; }
    public void setIdRecord(UUID idRecord) { this.idRecord = idRecord; }

    public OffsetDateTime getWaktuLog() { return waktuLog; }
    public void setWaktuLog(OffsetDateTime waktuLog) { this.waktuLog = waktuLog; }
}