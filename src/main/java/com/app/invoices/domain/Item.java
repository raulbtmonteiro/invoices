package com.app.invoices.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    private Long id;
    private Long invoiceId;
    private String name;
    private float quantity;
    private float price;

}
