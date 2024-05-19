package com.paymentservice.paymentgateway.controllers;

import com.paymentservice.paymentgateway.services.PaymentService;
import com.sun.jdi.PrimitiveValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/createLink")
    public String createPaymentLink(@RequestParam String orderId){
        return paymentService.createLink(orderId);

    }




}
