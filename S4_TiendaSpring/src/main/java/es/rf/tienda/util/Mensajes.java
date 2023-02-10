package es.rf.tienda.util;

import es.rf.tienda.dominio.Categoria;
//defino una clase mensaje para mostrar el mensaje de error 
public class Mensajes {
	//codigo 500 significa que ha tenido un error, en caso contrario codigo 200
	private String codigo;
	private String mensaje;
	private Categoria categoria;
	

	public Mensajes() {}
	
	
	public Mensajes(String codigo, String mensaje, Categoria categoria) {
		setCodigo(codigo);
		setMensaje(mensaje);
		setCategoria(categoria);
	}


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
