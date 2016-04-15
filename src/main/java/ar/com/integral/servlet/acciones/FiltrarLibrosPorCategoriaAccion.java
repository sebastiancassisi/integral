package ar.com.integral.servlet.acciones;

import ar.com.integral.bean.Categoria;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.integral.bean.Libro;

public class FiltrarLibrosPorCategoriaAccion extends Accion {

 
    @Override
    public String ejecutar(HttpServletRequest request,
            HttpServletResponse response) {

        List<Libro> listaDeLibros = null;
        List<Categoria> listaDeCategorias = Categoria.buscarTodos();

        if (request.getParameter("categoria") == null
                || request.getParameter("categoria").equals("seleccionar")) {

            listaDeLibros = Libro.buscarTodos();

        } else {

            Categoria categoriaSeleccionada= Categoria.buscarPorClave(Integer.parseInt(request.getParameter("categoria")));
            listaDeLibros = Libro.buscarPorCategoria(categoriaSeleccionada);

        }
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);

        return "MostrarLibros.jsp";
    }

}
