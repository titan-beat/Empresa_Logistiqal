package cl.talentoDigital.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.talentoDigital.modelo.Producto;
import cl.talentoDigital.repository.IProductoRepository;
import cl.talentoDigital.vo.ProductoVO;





@Service
public class ProductoServicioImpl implements IProductoService {
	private static final Logger log = LoggerFactory.getLogger(ProductoServicioImpl.class);
	
	@Autowired
	IProductoRepository dao;
	
	ProductoVO respuesta;

	@Override
	@Transactional(readOnly = true)
	public ProductoVO getAllProductos() {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Houston, we have a problem", "101");
		try {
			respuesta.setProductos((List<Producto>) dao.findAll());
			respuesta.setMensaje("hay " + respuesta.getProductos().size() + " registro/s");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoVO findByNombre(String nombre) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Houston, we have a problem", "102");
		try {
			List<Producto> productos = dao.findByNombre(nombre);
			if (productos.size() > 0) {
				respuesta.setProductos(productos);
				respuesta.setMensaje("Producto encontrado correctamente.");
				respuesta.setCodigo("0");
			} else {
				respuesta.setMensaje("Productos no encontrado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}


	@Override
	@Transactional
	public ProductoVO add(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Houston, we have a problem", "104");
		try {
			dao.save(producto);
			respuesta.setMensaje("Se ha guardado correctamente el producto "+producto.getNombre());
			respuesta.setCodigo("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	@Transactional
	public ProductoVO update(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Houston, we have a problem", "105");
		try {
			dao.save(producto);
			respuesta.setMensaje("Se ha actualizado correctamente el producto "+producto.getNombre());
			respuesta.setCodigo("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	@Transactional
	public ProductoVO delete(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Houston, we have a problem", "106");
		try {
			dao.delete(producto);
			respuesta.setMensaje("Se ha eliminado correctamente el producto "+producto.getNombre());
			respuesta.setCodigo("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoVO findById(Integer id) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Houston, we have a problem", "107");
		try {
			Producto producto = dao.findById(id).get();
			respuesta.getProductos().add(producto);
			respuesta.setMensaje("Producto encontrado correctamente.");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}


}
