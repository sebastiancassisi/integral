package ar.com.integral.servlet.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.integral.bean.Libro;

public class FiltrarLibrosPorCategoriaAccion extends Accion {

 
    @Override
    public String ejecutar(HttpServletRequest request,
            HttpServletResponse response) {

        List<Libro> listaDeLibros = null;
        List<String> listaDeCategorias = Libro.buscarTodasLasCategorias();

        if (request.getParameter("categoria") == null
                || request.getParameter("categoria").equals("seleccionar")) {

            listaDeLibros = Libro.buscarTodos();

        } else {

            listaDeLibros = Libro.buscarPorCategoria(request
                    .getParameter("categoria"));

        }
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);

        return "MostrarLibros.jsp";
    }

}
