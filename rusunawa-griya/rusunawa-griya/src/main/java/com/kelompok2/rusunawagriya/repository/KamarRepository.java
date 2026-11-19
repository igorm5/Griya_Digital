package com.kelompok2.rusunawagriya.repository;

import com.kelompok2.rusunawagriya.entity.Kamar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KamarRepository extends JpaRepository<Kamar, UUID> {
    List<Kamar> findByStatusKetersediaan(String statusKetersediaan);
}