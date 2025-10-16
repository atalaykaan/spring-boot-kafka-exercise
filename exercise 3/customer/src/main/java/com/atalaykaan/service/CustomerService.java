package com.atalaykaan.service;

import com.atalaykaan.dto.FraudCheckHistoryResponse;
import com.atalaykaan.entity.Customer;
import com.atalaykaan.dto.CustomerRegistrationRequest;
import com.atalaykaan.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.getFirstName())
                .lastName(customerRegistrationRequest.getLastName())
                .email(customerRegistrationRequest.getEmail())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckHistoryResponse fraudCheckResponse = restTemplate.getForObject(

                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckHistoryResponse.class,
                customer.getId()
        );

        if(fraudCheckResponse.getIsFraudster()) {

            throw new IllegalStateException("Fraudster");
        }
    }
}
