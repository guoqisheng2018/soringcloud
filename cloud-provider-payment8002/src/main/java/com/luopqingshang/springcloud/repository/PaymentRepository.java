package com.luopqingshang.springcloud.repository;


import com.luopqingshang.springcloud.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaymentRepository extends JpaRepository<Payment, Long> , JpaSpecificationExecutor<Payment> {

}
