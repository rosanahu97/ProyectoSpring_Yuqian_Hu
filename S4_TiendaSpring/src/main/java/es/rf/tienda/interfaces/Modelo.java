package es.rf.tienda.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.rf.tienda.exception.DomainException;
import jakarta.persistence.Transient;

public interface Modelo {

	
	@Transient
	@JsonIgnore	
	public boolean isValidaUpdate() throws DomainException;
	@Transient
	@JsonIgnore	
	public boolean isValidaInsert() throws DomainException;
	}

