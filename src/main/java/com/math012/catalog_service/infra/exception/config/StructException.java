package com.math012.catalog_service.infra.exception.config;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class StructException {
    private String msg;
    private Date timestamp;
    private String details;
}
