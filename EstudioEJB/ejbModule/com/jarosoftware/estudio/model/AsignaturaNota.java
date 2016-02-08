package com.jarosoftware.estudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the asignatura_notas database table.
 * 
 */
@Entity
@Table(name="asignatura_notas")
@NamedQuery(name="AsignaturaNota.findAll", query="SELECT a FROM AsignaturaNota a")
public class AsignaturaNota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;

	private BigDecimal nota;

	//bi-directional many-to-one association to AsignaturaAlumno
	@ManyToOne
	@JoinColumn(name="alumno")
	private AsignaturaAlumno asignaturaAlumno;

	//bi-directional many-to-one association to AsignaturaLogro
	@ManyToOne
	@JoinColumn(name="logro")
	private AsignaturaLogro asignaturaLogro;

	public AsignaturaNota() {
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getNota() {
		return this.nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	public AsignaturaAlumno getAsignaturaAlumno() {
		return this.asignaturaAlumno;
	}

	public void setAsignaturaAlumno(AsignaturaAlumno asignaturaAlumno) {
		this.asignaturaAlumno = asignaturaAlumno;
	}

	public AsignaturaLogro getAsignaturaLogro() {
		return this.asignaturaLogro;
	}

	public void setAsignaturaLogro(AsignaturaLogro asignaturaLogro) {
		this.asignaturaLogro = asignaturaLogro;
	}

}