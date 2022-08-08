package cl.talentoDigital.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import cl.talentoDigital.modelo.Producto;
import cl.talentoDigital.service.IProductoService;
import cl.talentoDigital.vo.ProductoVO;



@Controller
public class ProductoController {
	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private IProductoService svc;


	@GetMapping({ "/", "/inicio" })
	public String home(Model model) {
		model.addAttribute("VO", svc.getAllProductos());
		return "home";
	}
	

	@GetMapping("/editarForm")
	public ModelAndView editarForm(Model model, @RequestParam Integer id, RedirectAttributes ra) {
		ProductoVO respuestaServicio = new ProductoVO();
		respuestaServicio.setMensaje("No se puede cargar la vista de edición, intente nuevamente.");
		try {
			respuestaServicio = svc.findById(id);
			model.addAttribute("mensaje", respuestaServicio.getMensaje());
			model.addAttribute("miProducto", respuestaServicio.getProductos().get(0));
			return new ModelAndView("editar");
		} catch (Exception e) {
			log.error("Error en ProductoController eliminar", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		respuestaServicio = svc.getAllProductos();
		return new ModelAndView("redirect:/inicio");
	}


	@PostMapping("/editar")
	public ModelAndView editar(@ModelAttribute Producto producto, RedirectAttributes ra) {
		ProductoVO respuestaServicio = svc.update(producto);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/inicio");
		} else {
			return new ModelAndView("redirect:/editarForm");
		}
	}
	

	@GetMapping("/agregarForm")
	public String agregarForm(Model model) {
		return "agregar";
	}


	@PostMapping("/agregar")
	public ModelAndView agregarSubmit(@ModelAttribute Producto producto, RedirectAttributes ra) {
		ProductoVO respuestaServicio = svc.add(producto);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/inicio");
		} else {
			return new ModelAndView("redirect:/agregarForm");
		}
	}


	@GetMapping("/eliminar")
	public ModelAndView eliminar(Model model, @RequestParam String id, RedirectAttributes ra) {
		ProductoVO respuestaServicio = new ProductoVO();
		respuestaServicio.setMensaje("No se pudo eliminar el producto, intente nuevamente.");
		try {
			Producto eliminado = new Producto();
			eliminado.setId(Integer.parseInt(id));
			respuestaServicio = svc.delete(eliminado);
			ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
			return new ModelAndView("redirect:/inicio");
		} catch (Exception e) {
			log.error("Error en ProductoController eliminar", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		respuestaServicio = svc.getAllProductos();
		ra.addAttribute("VO", respuestaServicio);
		return new ModelAndView("redirect:/inicio");
	}
	
	@PostMapping("/buscar")
	public String agregarSubmit(Model model, @RequestParam String productoBuscado) {
		System.out.println(productoBuscado);
		ProductoVO respuestaServicio = svc.findByNombre(productoBuscado);
		model.addAttribute("mensaje", respuestaServicio.getMensaje());
		model.addAttribute("VO", respuestaServicio);
		return "home";
	}

}
