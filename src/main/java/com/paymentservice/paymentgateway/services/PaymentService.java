package com.paymentservice.paymentgateway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentGateway paymentGateway;

    public String createLink(String orderId){
        /*
         make a call to order service and get the order details
         OrderDetail order = restTemplate.getMapping(orderId)
         name = order.getCustomerName()
         amount = order.getAmount()
         phone = order.getCustomerPhone()
         */
        return paymentGateway.createPaymentLink(orderId,"Sai",
                "1234567891",100);
    }
}
