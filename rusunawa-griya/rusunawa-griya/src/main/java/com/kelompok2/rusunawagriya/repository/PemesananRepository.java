package com.kelompok2.rusunawagriya.repository;

import com.kelompok2.rusunawagriya.entity.Pemesanan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface PemesananRepository extends JpaRepository<Pemesanan, UUID> {
    List<Pemesanan> findByStatusPemesanan(String statusPemesanan);
}
