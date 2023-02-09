package es.rf.tienda.dominio;

import java.time.LocalDate;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Validator;
/**
 * 
 * Nombre		Producto
 * Descripcion	Informacion de un producto
 * @author 		Yuqian Hu
 * @version		Enero de 2023
 *
 */
public class Producto {
	private String id_producto;
	private String pro_descripcion;
	private String pro_desLarga;
	private double pro_precio;
	private int pro_stock;
	private LocalDate pro_fecRepos;
	private LocalDate pro_fecActi;
	private LocalDate pro_fecDesacti;
	private String pro_uniVenta;
	private double pro_cantXUniVenta;
	private String pro_uniUltNivel;
	private int id_pais;
	private String pro_usoRecomendado;
	private int id_categoria;
	private int pro_stkReservado;
	private int pro_nStkAlto;
	private int pro_nStkBajo;
	private char pro_stat;
	
	public Producto() {}


	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) throws DomainException {
		if(!Validator.isCodigoValido(id_producto)) {
			throw new DomainException("Codigo producto formato incorrecto");
		}	
		this.id_producto = id_producto;
		
		
	}

	public String getPro_descripcion() {
		return pro_descripcion;
	}

	public void setPro_descripcion(String pro_descripcion) throws DomainException {
		if(!Validator.cumpleLongitud(pro_descripcion, 0,100 )) {
			throw new DomainException("La descripcion no puede superar 100 caracteres");
		}
		
		this.pro_descripcion = pro_descripcion;
	}

	public String getPro_desLarga() {
		return pro_desLarga;
	}

	public void setPro_desLarga(String pro_desLarga) throws DomainException {
		if(!Validator.cumpleLongitud(pro_descripcion, 0,200 )) {
			throw new DomainException("La descripcion larga no puede superar 200 caracteres");
		}
		this.pro_desLarga = pro_desLarga;
	}

	public double getPro_precio() {
		return pro_precio;
	}

	public void setPro_precio(double pro_precio) throws DomainException {

		this.pro_precio = pro_precio;
	}

	public int getPro_stock() {
		return pro_stock;
	}

	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}

	public LocalDate getPro_fecRepos() {
		return pro_fecRepos;
	}

	public void setPro_fecRepos(LocalDate pro_fecRepos) throws DomainException {
		if(!Validator.valDateMin(pro_fecRepos, LocalDate.now())) {
			throw new DomainException("Fecha prevista reposicion incorrecta");
		}
		
		this.pro_fecRepos = pro_fecRepos;
	}

	public LocalDate getPro_fecActi() {
		return pro_fecActi;
	}

	public void setPro_fecActi(LocalDate pro_fecActi) throws DomainException {
		
		if(!Validator.valDateMin(pro_fecActi, LocalDate.now())) {
			throw new DomainException("Fecha activacion incorrecta");
		}
		
		this.pro_fecActi = pro_fecActi;
	}

	public LocalDate getPro_fecDesacti() {
		return pro_fecDesacti;
	}

	public void setPro_fecDesacti(LocalDate pro_fecDesacti) throws DomainException {
		
		if(!Validator.valDateMin(pro_fecRepos, LocalDate.now())) {
			throw new DomainException("Fecha desactivacion incorrecta");
		}
		if(getPro_fecActi()!=null && !Validator.valDateMin(pro_fecDesacti, getPro_fecActi()) ) {
			throw new DomainException("Fecha desactivacion incorrecta");
		}
		
		this.pro_fecDesacti = pro_fecDesacti;
	}

	public String getPro_uniVenta() {
		return pro_uniVenta;
	}

	public void setPro_uniVenta(String pro_uniVenta) {
		this.pro_uniVenta = pro_uniVenta;
	}

	public double getPro_cantXUniVenta() {
		return pro_cantXUniVenta;
	}

	public void setPro_cantXUniVenta(double pro_cantXUniVenta) {
		this.pro_cantXUniVenta = pro_cantXUniVenta;
	}

	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}

	public void setPro_uniUltNivel(String pro_uniUltNivel) {
		this.pro_uniUltNivel = pro_uniUltNivel;
	}

	public int getId_pais() {
		return id_pais;
	}

	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}

	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}

	public void setPro_usoRecomendado(String pro_usoRecomendado) throws DomainException {
		
		if(!Validator.cumpleLongitud(pro_usoRecomendado, 0,200 )) {
			throw new DomainException("EL texto no puede superar 200 caracteres");
		}
		
		this.pro_usoRecomendado = pro_usoRecomendado;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public int getPro_stkReservado() {
		return pro_stkReservado;
	}

	public void setPro_stkReservado(int pro_stkReservado) {
		this.pro_stkReservado = pro_stkReservado;
	}

	public int getPro_nStkAlto() {
		return pro_nStkAlto;
	}

	public void setPro_nStkAlto(int pro_nStkAlto) {
		this.pro_nStkAlto = pro_nStkAlto;
	}

	public int getPro_nStkBajo() {
		return pro_nStkBajo;
	}

	public void setPro_nStkBajo(int pro_nStkBajo) {
		this.pro_nStkBajo = pro_nStkBajo;
	}

	public char getPro_stat() {
		return pro_stat;
	}

	public void setPro_stat(char pro_stat) throws DomainException {
		if(!Validator.isEstadoCorrecto(pro_stat)) {
			throw new DomainException("Estado incorrecto");
		}
		this.pro_stat = pro_stat;
	}
	
	
}
