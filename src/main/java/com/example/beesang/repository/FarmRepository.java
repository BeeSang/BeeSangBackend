package com.example.beesang.repository;

import com.example.beesang.domain.farm.Farm;
import com.example.beesang.domain.farm.FarmType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
    Optional<Farm> findByUserIdAndFarmType(Long userId, FarmType farmType);
}
