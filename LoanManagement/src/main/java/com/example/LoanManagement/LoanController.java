package com.example.LoanManagement;

import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/loan")
    public class LoanController {

        // Endpoint to update loan status after payment
        @PostMapping("/update-loan-status")
        public String updateLoanStatus(@RequestBody PaymentRequest paymentRequest) {
            // Simulate updating loan status
            System.out.println("Updating loan status for: " + paymentRequest.getPhoneNumber() + ", Amount: " + paymentRequest.getAmount());

            return "Loan status updated for payment: " + paymentRequest.getAmount();
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

