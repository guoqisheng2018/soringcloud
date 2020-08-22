package com.luopqingshang.springcloud.service;


import com.luopqingshang.springcloud.entity.Payment;
import org.springframework.stereotype.Component;


@Component
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
