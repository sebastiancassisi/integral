/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.integral.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.integral.servlet.acciones.Accion;



public class ControladorLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
        @Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher despachador = null;
		String url=request.getServletPath();
                System.out.println("url: "+url);
                  System.out.println("url: "+url);
                  System.out.println("getNombreAccion(url): "+getNombreAccion(url));
                  
		Accion accion= Accion.getAccion(getNombreAccion(url));
		despachador = request.getRequestDispatcher(accion.ejecutar(request,
				response));
		despachador.forward(request, response);

	}

	
        @Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private String getNombreAccion(String url) {
		
		System.out.println("url.substring(1,url.length()-3): "+url.substring(1,url.length()-3));
		return url.substring(1,url.length()-3);
		
	}

}
