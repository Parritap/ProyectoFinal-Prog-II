package co.uniquindio.proyectoFinal.test;

import co.uniquindio.proyectoFinal.Utilidades.MyUtils;
import co.uniquindio.proyectoFinal.model.Empresa;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtilsTest {

    public static void main(String[] args) throws Exception {

    	//String fecha = "2022/07/21";
		//System.out.println(traducirFecha(fecha));
    	Empresa empresa = new Empresa ();
    	
    	String nombre = "juan";
    	String documento = "234234";
    	String email= "juan@gmail";
    	String contrasenia = "2323";
    	String direccion = "lol";
    	String fechaNacimiento = "10/90";
    	String ciudad = "juan";
    	String departamento = "juan";
    	
    	
    	empresa.crearCliente(nombre, direccion, documento, email, contrasenia, fechaNacimiento, ciudad, departamento);
    
    	System.out.println(empresa.getListaClientes().get(0).toString());

	}
	 private static String obtenerFechaActual() {
	        Date date = new Date();
	        SimpleDateFormat sfd = new SimpleDateFormat ("yyyy/MM/dd");
	        String fechaFormateada = sfd.format(date);		
	        return fechaFormateada;
	    }
	 private static int traducirFecha(String fecha_anio_mes_dia) {
			int fechaTraducida = 0;
			String [] fechaDescompuesta = fecha_anio_mes_dia.split("/");
			String fechaArreglada = "";
			for (int i = 0; i < fechaDescompuesta.length; i++) {
				fechaArreglada +=fechaDescompuesta [i];
			}
			fechaTraducida = Integer.parseInt(fechaArreglada);
			return fechaTraducida;
		}
}
