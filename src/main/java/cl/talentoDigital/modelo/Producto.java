package cl.talentoDigital.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="SQ_PRODUCTO", initialValue=1, allocationSize=1,sequenceName ="SQ_USUARIO")
public class Producto {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SQ_PRODUCTO")
	private Integer id;
	private String codigo;
	private String nombre;
	private Integer precio;
	private Integer stock;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(Integer id, String codigo, String nombre, Integer precio, Integer stock) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", stock="
				+ stock + "]";
	}
	
	
	
}