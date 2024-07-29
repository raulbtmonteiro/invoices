package com.app.invoices.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    private Long id;
    private String street;
    private String city;
    private String postCode;
    private String country;

}
