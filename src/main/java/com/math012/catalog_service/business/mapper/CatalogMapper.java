package com.math012.catalog_service.business.mapper;

import com.math012.catalog_service.business.DTO.response.CatalogResponseDTO;
import com.math012.catalog_service.infra.model.CatalogEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatalogMapper {
    List<CatalogResponseDTO> forListCatalogResponseDTOFromListCatalogEntity(List<CatalogEntity> catalogEntityList);
}