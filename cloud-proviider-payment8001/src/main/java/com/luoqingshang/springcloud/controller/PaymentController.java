package com.luoqingshang.springcloud.controller;

import com.luoqingshang.springcloud.entity.CommonResult;
import com.luoqingshang.springcloud.entity.Payment;
import com.luoqingshang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果"+result+"...");
        if(result>0){
            return new CommonResult(200,"插入成功,serverPort:"+serverPort,result);
        }else{

            return new CommonResult(444,"插入数据库失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){
        Payment paymentById = paymentService.getPaymentById(id);
        return new CommonResult<>(200,"查询成功,serverPort"+serverPort,paymentById);
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"-"+instance.getHost()+"-"+instance.getPort()+"-"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
