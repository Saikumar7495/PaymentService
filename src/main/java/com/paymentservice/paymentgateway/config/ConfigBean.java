package com.paymentservice.paymentgateway.config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {

    @Value("${razorpay.key}")
    private String key;

    @Value("${razorpay.secret}")
    private String secret;

    @Bean
    public RazorpayClient getRazorPayClient(){
        try {
            return new RazorpayClient(key,secret);
        } catch (RazorpayException e) {
            System.out.println("Unable to create razorpay client");
            throw new RuntimeException("failed to instantiate ");
        }
    }
}
