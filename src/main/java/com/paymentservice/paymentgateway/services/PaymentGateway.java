package com.paymentservice.paymentgateway.services;


import org.springframework.stereotype.Component;

@Component
public interface PaymentGateway {

    String createPaymentLink(String orderId,String customerName,String phone
    ,int amount);
}
