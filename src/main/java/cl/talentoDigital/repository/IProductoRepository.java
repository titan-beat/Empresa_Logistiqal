package cl.talentoDigital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import cl.talentoDigital.modelo.Producto;

public interface IProductoRepository extends CrudRepository<Producto, Integer> {
	
	@Query("FROM Producto WHERE nombre like %?1%")
	public List<Producto> findByNombre(String nombre);
	

}
