package es.rf.tienda.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Transient;

public interface Modelo {

	
	@Transient
	@JsonIgnore	
	public boolean isValidaUpdate();
	@Transient
	@JsonIgnore	
	public boolean isValidaInsert();
	}

