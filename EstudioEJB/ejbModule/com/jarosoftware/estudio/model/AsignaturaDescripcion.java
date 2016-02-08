package com.jarosoftware.estudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the asignatura_descripcion database table.
 * 
 */
@Entity
@Table(name="asignatura_descripcion")
@NamedQuery(name="AsignaturaDescripcion.findAll", query="SELECT a FROM AsignaturaDescripcion a")
public class AsignaturaDescripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;

	private String estado;

	//bi-directional many-to-one association to AsignaturaAlumno
	@OneToMany(mappedBy="asignaturaDescripcionBean")
	private List<AsignaturaAlumno> asignaturaAlumnos;

	//bi-directional many-to-one association to Asignatura
	@ManyToOne
	@JoinColumn(name="asignatura")
	private Asignatura asignaturaBean;

	//bi-directional many-to-one association to Profesore
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="profesor", referencedColumnName="identificacion"),
		@JoinColumn(name="profesor_doc", referencedColumnName="tipo_documento")
		})
	private Profesore profesore;

	//bi-directional many-to-one association to AsignaturaHorario
	@OneToMany(mappedBy="asignaturaDescripcionBean")
	private List<AsignaturaHorario> asignaturaHorarios;

	//bi-directional many-to-one association to AsignaturaLogro
	@OneToMany(mappedBy="asignaturaDescripcionBean")
	private List<AsignaturaLogro> asignaturaLogros;

	public AsignaturaDescripcion() {
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<AsignaturaAlumno> getAsignaturaAlumnos() {
		return this.asignaturaAlumnos;
	}

	public void setAsignaturaAlumnos(List<AsignaturaAlumno> asignaturaAlumnos) {
		this.asignaturaAlumnos = asignaturaAlumnos;
	}

	public AsignaturaAlumno addAsignaturaAlumno(AsignaturaAlumno asignaturaAlumno) {
		getAsignaturaAlumnos().add(asignaturaAlumno);
		asignaturaAlumno.setAsignaturaDescripcionBean(this);

		return asignaturaAlumno;
	}

	public AsignaturaAlumno removeAsignaturaAlumno(AsignaturaAlumno asignaturaAlumno) {
		getAsignaturaAlumnos().remove(asignaturaAlumno);
		asignaturaAlumno.setAsignaturaDescripcionBean(null);

		return asignaturaAlumno;
	}

	public Asignatura getAsignaturaBean() {
		return this.asignaturaBean;
	}

	public void setAsignaturaBean(Asignatura asignaturaBean) {
		this.asignaturaBean = asignaturaBean;
	}

	public Profesore getProfesore() {
		return this.profesore;
	}

	public void setProfesore(Profesore profesore) {
		this.profesore = profesore;
	}

	public List<AsignaturaHorario> getAsignaturaHorarios() {
		return this.asignaturaHorarios;
	}

	public void setAsignaturaHorarios(List<AsignaturaHorario> asignaturaHorarios) {
		this.asignaturaHorarios = asignaturaHorarios;
	}

	public AsignaturaHorario addAsignaturaHorario(AsignaturaHorario asignaturaHorario) {
		getAsignaturaHorarios().add(asignaturaHorario);
		asignaturaHorario.setAsignaturaDescripcionBean(this);

		return asignaturaHorario;
	}

	public AsignaturaHorario removeAsignaturaHorario(AsignaturaHorario asignaturaHorario) {
		getAsignaturaHorarios().remove(asignaturaHorario);
		asignaturaHorario.setAsignaturaDescripcionBean(null);

		return asignaturaHorario;
	}

	public List<AsignaturaLogro> getAsignaturaLogros() {
		return this.asignaturaLogros;
	}

	public void setAsignaturaLogros(List<AsignaturaLogro> asignaturaLogros) {
		this.asignaturaLogros = asignaturaLogros;
	}

	public AsignaturaLogro addAsignaturaLogro(AsignaturaLogro asignaturaLogro) {
		getAsignaturaLogros().add(asignaturaLogro);
		asignaturaLogro.setAsignaturaDescripcionBean(this);

		return asignaturaLogro;
	}

	public AsignaturaLogro removeAsignaturaLogro(AsignaturaLogro asignaturaLogro) {
		getAsignaturaLogros().remove(asignaturaLogro);
		asignaturaLogro.setAsignaturaDescripcionBean(null);

		return asignaturaLogro;
	}

}