package com.example.Mpesa;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/mpesa")
public class MpesaController {

    private final RestTemplate restTemplate = new RestTemplate();

    // Endpoint to process payment
    @PostMapping("/process-payment")
    public String processPayment(@RequestBody PaymentRequest paymentRequest) {
        // Simulate payment processing
        System.out.println("Processing payment for: " + paymentRequest.getPhoneNumber() + ", Amount: " + paymentRequest.getAmount());

        // Notify the Loan Management System about the payment
        String loanServiceUrl = "http://localhost:8081/loan/update-loan-status";
        String response = restTemplate.postForObject(loanServiceUrl, paymentRequest, String.class);

        return "Payment processed successfully. " + response;
    }
}

class PaymentRequest {
    private String phoneNumber;
    private double amount;

    // Getters and Setters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}