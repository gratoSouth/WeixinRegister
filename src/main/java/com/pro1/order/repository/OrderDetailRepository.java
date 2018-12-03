package com.pro1.order.repository;

import com.pro1.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByDiagnosiscardId(String diagnosiscardId);
}
