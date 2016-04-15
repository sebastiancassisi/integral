
package ar.com.integral.servlet.acciones;

import ar.com.integral.bean.Categoria;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.integral.bean.Libro;

public class ModificarLibroAccion extends Accion {


	@Override
	public String ejecutar(HttpServletRequest request,HttpServletResponse response) {
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
                Categoria objetoCategoria = new Categoria(Integer.parseInt(categoria));
		Libro libro = new Libro(isbn, titulo, objetoCategoria);
                libro.salvar();
		return "MostrarLibros.do";
	}

}

