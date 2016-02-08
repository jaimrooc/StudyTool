package com.jarosoftware.estudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the asignaturas database table.
 * 
 */
@Entity
@Table(name="asignaturas")
@NamedQuery(name="Asignatura.findAll", query="SELECT a FROM Asignatura a")
public class Asignatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to AsignaturaDescripcion
	@OneToMany(mappedBy="asignaturaBean")
	private List<AsignaturaDescripcion> asignaturaDescripcions;

	public Asignatura() {
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AsignaturaDescripcion> getAsignaturaDescripcions() {
		return this.asignaturaDescripcions;
	}

	public void setAsignaturaDescripcions(List<AsignaturaDescripcion> asignaturaDescripcions) {
		this.asignaturaDescripcions = asignaturaDescripcions;
	}

	public AsignaturaDescripcion addAsignaturaDescripcion(AsignaturaDescripcion asignaturaDescripcion) {
		getAsignaturaDescripcions().add(asignaturaDescripcion);
		asignaturaDescripcion.setAsignaturaBean(this);

		return asignaturaDescripcion;
	}

	public AsignaturaDescripcion removeAsignaturaDescripcion(AsignaturaDescripcion asignaturaDescripcion) {
		getAsignaturaDescripcions().remove(asignaturaDescripcion);
		asignaturaDescripcion.setAsignaturaBean(null);

		return asignaturaDescripcion;
	}

}