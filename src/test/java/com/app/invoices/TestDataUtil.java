package com.app.invoices;

import com.app.invoices.domain.Address;
import com.app.invoices.domain.Invoice;
import com.app.invoices.domain.Item;

public class TestDataUtil {

    private TestDataUtil(){
    }

    public static Item createTestItemA(){
        return Item.builder()
                .id(1L)
                .invoiceId(1L)
                .name("Nome do item")
                .price(1500f)
                .quantity(1f)
                .build();
    }

    public static Item createTestItemB(){
        return Item.builder()
                .id(2L)
                .invoiceId(2L)
                .name("Nome do item B")
                .price(1900f)
                .quantity(4f)
                .build();
    }

    public static Item createTestItemC(){
        return Item.builder()
                .id(3L)
                .invoiceId(3L)
                .name("Nome do item C")
                .price(800f)
                .quantity(30f)
                .build();
    }

    public static Invoice createInvoiceTest(){
        return Invoice.builder()
                .id(1L)
                .code("XRT03")
                .status("paid")
                .description("Test invoice")
                .createdAt("teste")
                .clientName("John Smith")
                .clientEmail("john_smith@test.com")
                .clientAddressId(1L)
                .senderAddressId(2L)
                .paymentTerms(1)
                .paymentDue("teste")
                .build();
    }

    public static Address createTestAddress(){
        return Address.builder()
                .id(1L)
                .street("Avenida Afonso Pena, 1710")
                .postCode("13.025-152")
                .city("São Paulo")
                .country("Brasil")
                .build();
    }
}
