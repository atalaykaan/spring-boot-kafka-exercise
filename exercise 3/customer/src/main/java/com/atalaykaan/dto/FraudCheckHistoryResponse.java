package com.atalaykaan.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckHistoryResponse {

    private Boolean isFraudster;
}
