package com.jarosoftware.estudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_documento database table.
 * 
 */
@Entity
@Table(name="tipo_documento")
@NamedQuery(name="TipoDocumento.findAll", query="SELECT t FROM TipoDocumento t")
public class TipoDocumento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="seq_tipo_doc", sequenceName="seq_tipo_doc", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_tipo_doc")
	private long codigo;

	private String nombre;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="tipoDocumentoBean")
	private List<Alumno> alumnos;

	//bi-directional many-to-one association to Profesore
	@OneToMany(mappedBy="tipoDocumentoBean")
	private List<Profesore> profesores;

	public TipoDocumento() {
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Alumno addAlumno(Alumno alumno) {
		getAlumnos().add(alumno);
		alumno.setTipoDocumentoBean(this);

		return alumno;
	}

	public Alumno removeAlumno(Alumno alumno) {
		getAlumnos().remove(alumno);
		alumno.setTipoDocumentoBean(null);

		return alumno;
	}

	public List<Profesore> getProfesores() {
		return this.profesores;
	}

	public void setProfesores(List<Profesore> profesores) {
		this.profesores = profesores;
	}

	public Profesore addProfesore(Profesore profesore) {
		getProfesores().add(profesore);
		profesore.setTipoDocumentoBean(this);

		return profesore;
	}

	public Profesore removeProfesore(Profesore profesore) {
		getProfesores().remove(profesore);
		profesore.setTipoDocumentoBean(null);

		return profesore;
	}

}