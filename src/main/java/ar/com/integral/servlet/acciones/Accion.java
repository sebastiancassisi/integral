package ar.com.integral.servlet.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Accion {


	public abstract String ejecutar(HttpServletRequest request,
			HttpServletResponse response);

	
	public  static Accion getAccion(String tipo) {

		Accion accion = null;
		try {
			accion = (Accion) Class.forName(getPackage()+"."+tipo+"Accion").newInstance();
                        System.out.println("Accion: "+getPackage()+"."+tipo+"Accion");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accion;

	}
	
	private static  String getPackage() {
		
		
		return Accion.class.getPackage().getName();
	}
}
