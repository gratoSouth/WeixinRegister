package com.pro1.order.service.impl;

import com.pro1.order.dataobject.DoctorInfo;
import com.pro1.order.repository.DepartmentCategoryRepository;
import com.pro1.order.repository.DoctorInfoRepository;
import com.pro1.order.service.DoctorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorInfoServiceImpl implements DoctorInfoService {

    @Autowired
    private DoctorInfoRepository repository;

    @Override
    public List<DoctorInfo> findByDepartmentType(Integer departmentType) {
        return repository.findByDepartmentType(departmentType);
    }

    @Override
    public List<DoctorInfo> findByDoctorNameLike(String doctorName) {
        return repository.findByDoctorNameLike("%"+doctorName+"%");
    }
}
