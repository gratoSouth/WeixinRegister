package com.pro1.order.repository;

import com.pro1.order.dataobject.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {

    List<Schedule> findByDoctorId(Integer doctorId);

}
