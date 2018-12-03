package com.pro1.order.repository;

import com.pro1.order.dataobject.DiagnosisCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisCardRepository extends JpaRepository<DiagnosisCard, String> {

    DiagnosisCard findByUserId(String userId);
}
