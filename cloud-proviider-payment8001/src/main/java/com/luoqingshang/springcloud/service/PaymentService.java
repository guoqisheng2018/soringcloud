package com.luoqingshang.springcloud.service;

import com.luoqingshang.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
