package com.platzi.market.persistance.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.platzi.market.domain.Category;
import com.platzi.market.persistance.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	@Mappings({ 
		@Mapping(source = "idCategoria", target = "categoryId"),
		@Mapping(source = "description", target = "category"),
		@Mapping(source = "estado", target = "active") 
	})
	Category toCategory(Categoria categoria);
	
	@InheritInverseConfiguration
	@Mapping(target = "productos", ignore = true)
	Categoria toCategoria (Category category);
}	
