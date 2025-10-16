package com.atalaykaan.controller;

import com.atalaykaan.dto.CustomerRegistrationRequest;
import com.atalaykaan.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerRegistrationRequest> registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {

        log.info("New customer registration: {}", customerRegistrationRequest);

        customerService.registerCustomer(customerRegistrationRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
