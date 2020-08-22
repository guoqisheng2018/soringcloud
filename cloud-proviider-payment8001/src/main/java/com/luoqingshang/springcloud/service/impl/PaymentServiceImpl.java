package com.luoqingshang.springcloud.service.impl;

import com.luoqingshang.springcloud.entity.Payment;
import com.luoqingshang.springcloud.repository.PaymentRepository;
import com.luoqingshang.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public int create(Payment payment) {
        paymentRepository.save(payment);
        return 1;
    }

    @Override
    public Payment getPaymentById(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.get();
    }
}
