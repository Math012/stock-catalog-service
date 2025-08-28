package com.math012.catalog_service.business.DTO.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CatalogResponseDTO {
    private String productName;
    private String productCategory;
    private double productPrice;
}