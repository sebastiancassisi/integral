package ar.com.integral.servlet.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.integral.bean.Libro;

public class BorrarLibroAccion extends Accion {


	@Override
	public String ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		String isbn = request.getParameter("isbn");
		Libro libro = new Libro(isbn);
                libro.borrar();
		return "MostrarLibros.do";
	}

}
