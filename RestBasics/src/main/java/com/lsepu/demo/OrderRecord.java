package com.lsepu.demo;

public record OrderRecord(
        String customerName,
        String productName,
        Integer quantity
) {
}
