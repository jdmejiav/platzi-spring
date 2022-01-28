package com.platzi.market.persistance.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.platzi.market.persistance.entity.Producto;

public interface ProductoCRUDRepostory extends CrudRepository<Producto, Integer> {
	List<Producto> findByidCategoriaOrderByNombreAsc(int idCategoria);

	Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadEstock, boolean estado);
}
