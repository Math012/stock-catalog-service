package com.math012.catalog_service.controller;

import com.math012.catalog_service.business.service.CatalogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RequestMapping("/catalog")
@RestController
public class CatalogController {

    private final CatalogService service;

    @GetMapping("/product/{category}")
    public ResponseEntity<Map<String, Object>> findAllProductsByCategory(@PathVariable("category")String category,
                                                                         @RequestParam(defaultValue = "0", required = false) int page,
                                                                         @RequestParam(defaultValue = "10", required = false) int size){
        return ResponseEntity.ok(service.findAllProductsByCategory(page,size,category));
    }
}