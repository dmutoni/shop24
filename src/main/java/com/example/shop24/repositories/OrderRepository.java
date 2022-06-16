package com.example.shop24.repositories;


import com.example.shop24.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    @Query(nativeQuery = true, value = "select * from order where status = 'PAID' order by quantity desc limit 10")
    List<Order> findTopTenPaid();

    @Query(nativeQuery = true, value = "SELECT  t.* FROM ( SELECT  DISTINCT groupid FROM order ) mo CROSS APPLY SELECT TOP 1 FROM order WHERE mi.groupid = mo.groupid ORDER BY createdAt DESC ) t")
    List<Order> findTopFive();
}
