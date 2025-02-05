package com.paymentservice.paymentgateway.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RazorPayGateway implements PaymentGateway{

    /*

       There are generally two ways to integrate with a 3rd party
       1. Make an api call
       2. Client sdk (Code in a jar)

     */

    @Autowired
    private RazorpayClient razorpayClient;

    @Override
    public String createPaymentLink(String orderId, String customerName,
                                    String phone, int amount) {
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",false);
        paymentLinkRequest.put("expire_by",1716316200);
        paymentLinkRequest.put("reference_id",orderId);
        paymentLinkRequest.put("description","Payment for orderid"+orderId);

        JSONObject customer = new JSONObject();
        customer.put("name",customerName);
        customer.put("contact",phone);
        customer.put("email","gaurav.kumar@example.com");
        paymentLinkRequest.put("customer",customer);


        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");

        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://scaler.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment=null;

        try {
            payment = razorpayClient.paymentLink.create(paymentLinkRequest);
        } catch (RazorpayException e) {
            throw new RuntimeException("Unable to create the link from razorpay, \" +\n" +
                    "try with a different gateway maybe");
        }
//        RazorpayClient razorpayClient=new RazorpayClient("key","secret");
        return null;
    }
}
