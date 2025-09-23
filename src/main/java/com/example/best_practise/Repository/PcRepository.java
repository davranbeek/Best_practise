package com.example.best_practise.Repository;

import com.example.best_practise.Entity.PcEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcRepository extends JpaRepository<PcEntity, Long> {

}
