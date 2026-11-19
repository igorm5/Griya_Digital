package com.kelompok2.rusunawagriya.repository;
import com.kelompok2.rusunawagriya.entity.LogAktivitas;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface LogAktivitasRepository extends JpaRepository<LogAktivitas, UUID> {}