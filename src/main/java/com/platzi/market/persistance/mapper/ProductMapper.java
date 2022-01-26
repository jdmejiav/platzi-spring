package com.platzi.market.persistance.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.platzi.market.domain.Product;
import com.platzi.market.persistance.entity.Producto;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	@Mappings({ 
		@Mapping(source = "idProducto", target = "productId"), @Mapping(source = "nombre", target = "name"),
		@Mapping(source = "idCtegoria", target = "categoryId"), @Mapping(source = "precioVenta", target = "price"),
		@Mapping(source = "cantidadStock", target = "stock"),
		@Mapping(source = "idProducto", target = "productId"), 
		@Mapping(source = "estado", target = "active"),
		@Mapping(source = "categoria", target = "category"),
	})
	Product toProduct(Producto producto);
	
	List<Product> toProducts (List<Product> productos);
	
	@InheritInverseConfiguration
	@Mapping(target = "codigoBarras", ignore=true)
	Producto toProducto (Product Producto);
}
