package com.atalaykaan.controller;

import com.atalaykaan.dto.FraudCheckHistoryResponse;
import com.atalaykaan.service.FraudCheckHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
public class FraudCheckHistoryController {

    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping(path = "{customerId}")
    public ResponseEntity<FraudCheckHistoryResponse> isFraudster(@PathVariable("customerId") Long customerId) {

        boolean isFraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);

        return ResponseEntity.ok(
                FraudCheckHistoryResponse.builder()
                        .isFraudster(isFraudulentCustomer)
                        .build()
        );
    }
}
