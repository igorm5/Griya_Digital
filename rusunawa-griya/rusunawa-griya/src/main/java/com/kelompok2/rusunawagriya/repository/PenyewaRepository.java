package com.kelompok2.rusunawagriya.repository;
import com.kelompok2.rusunawagriya.entity.Penyewa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface PenyewaRepository extends JpaRepository<Penyewa, UUID> {
    Optional<Penyewa> findByNikKtp(String nikKtp);
}