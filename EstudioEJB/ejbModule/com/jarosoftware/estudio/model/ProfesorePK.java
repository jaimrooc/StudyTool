package com.jarosoftware.estudio.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the profesores database table.
 * 
 */
@Embeddable
public class ProfesorePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Long identificacion;

	@Column(name="tipo_documento", insertable=false, updatable=false)
	private long tipoDocumento;

	public ProfesorePK() {
	}
	public Long getIdentificacion() {
		return this.identificacion;
	}
	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}
	public long getTipoDocumento() {
		return this.tipoDocumento;
	}
	public void setTipoDocumento(long tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProfesorePK)) {
			return false;
		}
		ProfesorePK castOther = (ProfesorePK)other;
		return 
			(this.identificacion == castOther.identificacion)
			&& (this.tipoDocumento == castOther.tipoDocumento);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.identificacion ^ (this.identificacion >>> 32)));
		hash = hash * prime + ((int) (this.tipoDocumento ^ (this.tipoDocumento >>> 32)));
		
		return hash;
	}
}