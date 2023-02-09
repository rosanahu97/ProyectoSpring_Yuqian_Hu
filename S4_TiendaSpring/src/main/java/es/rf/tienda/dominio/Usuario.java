package es.rf.tienda.dominio;

import java.time.LocalDate;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Validator;
/**
 * 
 * Nombre		Uusario
 * Descripcion	Informacion de un usuario
 * @author 		Yuqian Hu
 * @version		Enero de 2023
 *
 */
public class Usuario {
	//definir las variables 
	private int id_usuario;
	private String user_nombre;
	private String user_email;
	private String user_pass;
	private int user_tipo;
	private String user_dni;
	private LocalDate user_fecAlta;
	private LocalDate user_fecConfirmacion;
	private Direccion datos_pago;
	private Direccion datos_envio;
	
	//crear constructor con o sin parametros

	public Usuario() {}
	

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUser_nombre() {
		return user_nombre;
	}

	public void setUser_nombre(String user_nombre) throws DomainException {
		if(!Validator.cumpleLongitud(user_nombre,0, 200)) {
			throw new DomainException("Nombre longitud incorrecto");
		}
		
		this.user_nombre = user_nombre;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) throws DomainException {
		
		if(!Validator.cumpleLongitud(user_email,0, 200)) {
			throw new DomainException("Email longitud incorrecto");
		}
		this.user_email = user_email;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) throws DomainException {
		
		if(!Validator.esPasswordValida(user_pass)) {
			throw new DomainException("Contraseña formato incorrecto");
		}
		
		this.user_pass = user_pass;
	}

	public int getUser_tipo() {
		return user_tipo;
	}

	public void setUser_tipo(int user_tipo) {
		this.user_tipo = user_tipo;
	}

	public String getUser_dni() {
		return user_dni;
	}

	public void setUser_dni(String user_dni) throws DomainException {
		if(!Validator.cumpleDNI(user_dni)) {
			throw new DomainException("DNI incorrecto");
		}	
		this.user_dni = user_dni;
	}

	public LocalDate getUser_fecAlta() {
		return user_fecAlta;
	}

	public void setUser_fecAlta(LocalDate user_fecAlta) throws DomainException {
		
		if(!Validator.esFechaActual(user_fecAlta)) {
			throw new DomainException("Fecha alta incorrecta");
		}
		
		this.user_fecAlta = user_fecAlta;
	}

	public LocalDate getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}

	public void setUser_fecConfirmacion(LocalDate user_fecConfirmacion) throws DomainException {
		if(!Validator.esFechaActual(user_fecConfirmacion)) {
			throw new DomainException("Fecha confirmacion incorrecta");
		}
		
		this.user_fecConfirmacion = user_fecConfirmacion;
	}

	public Direccion getDatos_pago() {
		return datos_pago;
	}


	public void setDatos_pago(Direccion datos_pago) {
		this.datos_pago = datos_pago;
	}


	public Direccion getDatos_envio() {
		return datos_envio;
	}


	public void setDatos_envio(Direccion datos_envio) {
		this.datos_envio = datos_envio;
	}


	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", user_nombre=" + user_nombre + ", user_email=" + user_email
				+ ", user_pass=" + user_pass + ", user_tipo=" + user_tipo + ", user_dni=" + user_dni + ", user_fecAlta="
				+ user_fecAlta + ", user_fecConfirmacion=" + user_fecConfirmacion + "]";
	}
	
	
	
	
	





}
