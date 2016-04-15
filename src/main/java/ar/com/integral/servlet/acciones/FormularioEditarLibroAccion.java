package ar.com.integral.servlet.acciones;

import ar.com.integral.bean.Categoria;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.integral.bean.Libro;

public class FormularioEditarLibroAccion extends Accion {


	@Override
	public String ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		
		String isbn = request.getParameter("isbn");
		List<Categoria> listaDeCategorias = Categoria.buscarTodos();
		Libro libro = Libro.buscarPorClave(isbn);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("libro", libro);
		return "FormularioEditarLibro.jsp";
	}

}
