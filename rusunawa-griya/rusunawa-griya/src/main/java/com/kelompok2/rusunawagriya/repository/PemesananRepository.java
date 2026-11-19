package com.kelompok2.rusunawagriya.repository;

import com.kelompok2.rusunawagriya.entity.Pemesanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PemesananRepository extends JpaRepository<Pemesanan, UUID> {

    List<Pemesanan> findByStatusPemesanan(String statusPemesanan);

    // JOIN FETCH agar data penyewa & kamar langsung ikut terambil tanpa error LazyInitializationException di HTML
    @Query("SELECT p FROM Pemesanan p JOIN FETCH p.penyewa JOIN FETCH p.kamar WHERE p.statusPemesanan = :status ORDER BY p.tanggalPemesanan ASC")
    List<Pemesanan> findAllByStatusWithDetail(@Param("status") String status);
}