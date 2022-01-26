package com.platzi.market.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.platzi.market.persistance.crud.ProductoCRUDRepostory;
import com.platzi.market.persistance.entity.Producto;


@Repository	
public class ProductoRepository {
	
	private ProductoCRUDRepostory productoRepository;
	
	public List<Producto> getAll(){
		return (List<Producto>)productoRepository.findAll();
	}
	public List<Producto> findByidCategoria (int idCategoria){
		return productoRepository.findByidCategoriaOrderByNombreAsc(idCategoria);	
	}
	
	public Optional<List<Producto>> getEscasos (int cantidad){
		return productoRepository.findByCantidadStockLessThanAndEstado(cantidad,true);
	}
	
	public Optional<Producto> getProducto(int idProducto){
		return productoRepository.findById(idProducto);
	}
	
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}
	public void delete(int idProducto) {
		productoRepository.deleteById(idProducto);
	}
}
