package com.example.farmfarm_refact.repository;


import com.example.farmfarm_refact.entity.FarmEntity;
import com.example.farmfarm_refact.entity.OrderDetailEntity;
import com.example.farmfarm_refact.entity.UserEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepository extends CrudRepository<OrderDetailEntity, Long> {
    List<OrderDetailEntity> findByOrderUserAndType(UserEntity user, Integer type);

}

