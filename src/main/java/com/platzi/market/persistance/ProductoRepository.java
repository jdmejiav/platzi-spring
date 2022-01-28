package com.platzi.market.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistance.crud.ProductoCRUDRepostory;
import com.platzi.market.persistance.entity.Producto;
import com.platzi.market.persistance.mapper.ProductMapper;

@Repository
public class ProductoRepository implements ProductRepository {

	@Autowired
	private ProductoCRUDRepostory productoRepository;

	@Autowired
	private ProductMapper mapper;

	@Override
	public List<Product> getAll() {
		List<Producto> productos = (List<Producto>) productoRepository.findAll();
		return mapper.toProducts(productos);
	}

	@Override
	public Product save(Product product) {
		Producto producto = mapper.toProducto(product);
		return mapper.toProduct(productoRepository.save(producto));
	}

	@Override
	public void delete(int idProducto) {
		productoRepository.deleteById(idProducto);
	}

	@Override
	public Optional<List<Product>> getByCategory(int categoryId) {
		List<Producto> productos = productoRepository.findByidCategoriaOrderByNombreAsc(categoryId);
		return Optional.of(mapper.toProducts(productos));
	}

	@Override
	public Optional<List<Product>> getScaseProducts(int quantity) {
		Optional<List<Producto>> productos = productoRepository.findByCantidadStockLessThanAndEstado(quantity, true);
		return productos.map(prods -> mapper.toProducts(prods));
	}

	@Override
	public Optional<Product> getProduct(int productId) {
		return productoRepository.findById(productId).map(product -> mapper.toProduct(product));
	}
}
