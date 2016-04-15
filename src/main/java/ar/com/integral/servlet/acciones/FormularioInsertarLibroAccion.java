
package ar.com.integral.servlet.acciones;

import ar.com.integral.bean.Categoria;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.integral.bean.Libro;

public class FormularioInsertarLibroAccion extends Accion {


	@Override
	public String ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		List<Categoria> listaDeCategorias = null;

		listaDeCategorias = Categoria.buscarTodos();
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		return "FormularioInsertarLibro.jsp";
	}

}
