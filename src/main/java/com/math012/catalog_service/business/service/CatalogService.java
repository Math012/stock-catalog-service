package com.math012.catalog_service.business.service;

import com.math012.catalog_service.business.DTO.response.CatalogResponseDTO;
import com.math012.catalog_service.business.mapper.CatalogMapper;
import com.math012.catalog_service.infra.exception.config.ResourceNotFoundException;
import com.math012.catalog_service.infra.model.CatalogEntity;
import com.math012.catalog_service.infra.repository.CatalogRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class CatalogService {

    private final CatalogRepository repository;
    private final CatalogMapper mapper;

    public Map<String, Object> findAllProductsByCategory(int page, int size, String category){
        List<CatalogEntity> catalogEntities;
        List<CatalogResponseDTO> catalogResponseDTOS;
        Pageable paging = PageRequest.of(page,size);
        Page<CatalogEntity> pageCatalog = repository.findByProductCategory(category,paging).orElseThrow(() -> new ResourceNotFoundException("Erro ao consultar produtos por categoria"));
        catalogEntities = pageCatalog.getContent();
        catalogResponseDTOS = mapper.forListCatalogResponseDTOFromListCatalogEntity(catalogEntities);
        Map<String, Object> response = new HashMap<>();
        response.put("Products with category: "+ category,catalogResponseDTOS);
        response.put("currentPage", pageCatalog.getNumber());
        response.put("totalItems", pageCatalog.getTotalElements());
        response.put("totalPages", pageCatalog.getTotalPages());
        return response;
    }
}