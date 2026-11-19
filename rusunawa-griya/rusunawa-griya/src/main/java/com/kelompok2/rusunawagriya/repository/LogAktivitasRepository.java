package com.kelompok2.rusunawagriya.repository;

import com.kelompok2.rusunawagriya.entity.LogAktivitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LogAktivitasRepository extends JpaRepository<LogAktivitas, UUID> {
}