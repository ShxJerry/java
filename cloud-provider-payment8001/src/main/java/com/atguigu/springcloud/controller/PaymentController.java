package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
       int result = paymentService.create(payment);
       log.info("结果"+result);
       if (result > 0){
           return new CommonResult(200,"插入成功",result);
       }else {
           return new CommonResult(444,"插入失败",null);
       }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id){
        Payment payment= paymentService.getPaymentById(id);
        log.info("结果"+payment);
        if (payment != null){
            return new CommonResult(200,"插入成功了",payment);
        }else {
            return new CommonResult(444,"插入失败",null);
        }
    }
}
