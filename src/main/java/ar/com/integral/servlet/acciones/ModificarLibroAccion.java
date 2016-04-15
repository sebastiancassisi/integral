
package ar.com.integral.servlet.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.integral.bean.Libro;
import ar.com.integral.database.DataBaseException;

public class ModificarLibroAccion extends Accion {


	@Override
	public String ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		Libro libro = new Libro(isbn, titulo, categoria);
            try {
                libro.salvar();
            } catch (DataBaseException ex) {
               
            }
		return "MostrarLibros.do";
	}

}

