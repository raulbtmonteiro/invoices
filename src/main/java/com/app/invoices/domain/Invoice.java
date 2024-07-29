package com.app.invoices.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {

    private Long id;
    private String code;
    private String status;
    private String description;
    private String clientName;
    private String clientEmail;
    private Long clientAddressId;
    private String paymentDue;
    private Integer paymentTerms;
    private String createdAt;
    private Long senderAddressId;

}
