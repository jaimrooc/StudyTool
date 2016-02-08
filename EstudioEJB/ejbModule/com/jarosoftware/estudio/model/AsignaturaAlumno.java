package com.jarosoftware.estudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the asignatura_alumnos database table.
 * 
 */
@Entity
@Table(name="asignatura_alumnos")
@NamedQuery(name="AsignaturaAlumno.findAll", query="SELECT a FROM AsignaturaAlumno a")
public class AsignaturaAlumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="alumno", referencedColumnName="identificacion"),
		@JoinColumn(name="alumno_doc", referencedColumnName="tipo_documento")
		})
	private Alumno alumnoBean;

	//bi-directional many-to-one association to AsignaturaDescripcion
	@ManyToOne
	@JoinColumn(name="asignatura_descripcion")
	private AsignaturaDescripcion asignaturaDescripcionBean;

	//bi-directional many-to-one association to AsignaturaNota
	@OneToMany(mappedBy="asignaturaAlumno")
	private List<AsignaturaNota> asignaturaNotas;

	public AsignaturaAlumno() {
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Alumno getAlumnoBean() {
		return this.alumnoBean;
	}

	public void setAlumnoBean(Alumno alumnoBean) {
		this.alumnoBean = alumnoBean;
	}

	public AsignaturaDescripcion getAsignaturaDescripcionBean() {
		return this.asignaturaDescripcionBean;
	}

	public void setAsignaturaDescripcionBean(AsignaturaDescripcion asignaturaDescripcionBean) {
		this.asignaturaDescripcionBean = asignaturaDescripcionBean;
	}

	public List<AsignaturaNota> getAsignaturaNotas() {
		return this.asignaturaNotas;
	}

	public void setAsignaturaNotas(List<AsignaturaNota> asignaturaNotas) {
		this.asignaturaNotas = asignaturaNotas;
	}

	public AsignaturaNota addAsignaturaNota(AsignaturaNota asignaturaNota) {
		getAsignaturaNotas().add(asignaturaNota);
		asignaturaNota.setAsignaturaAlumno(this);

		return asignaturaNota;
	}

	public AsignaturaNota removeAsignaturaNota(AsignaturaNota asignaturaNota) {
		getAsignaturaNotas().remove(asignaturaNota);
		asignaturaNota.setAsignaturaAlumno(null);

		return asignaturaNota;
	}

}