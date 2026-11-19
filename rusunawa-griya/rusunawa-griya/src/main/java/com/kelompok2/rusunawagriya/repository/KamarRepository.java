package com.kelompok2.rusunawagriya.repository;
import com.kelompok2.rusunawagriya.entity.Kamar;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface KamarRepository extends JpaRepository<Kamar, UUID> {}