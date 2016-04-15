
package ar.com.integral.servlet.acciones;
import ar.com.integral.bean.Categoria;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.integral.bean.Libro;

public class MostrarLibrosAccion extends Accion {


	@Override
	public String ejecutar(HttpServletRequest request,
			HttpServletResponse response) {

			List<Libro> listaDeLibros = Libro.buscarTodos();
			List<Categoria> listaDeCategorias = Categoria.buscarTodos();
			request.setAttribute("listaDeLibros", listaDeLibros);
			request.setAttribute("listaDeCategorias", listaDeCategorias);
			return "MostrarLibros.jsp";
		

	}

}
