package com.jarosoftware.estudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the asignatura_logros database table.
 * 
 */
@Entity
@Table(name="asignatura_logros")
@NamedQuery(name="AsignaturaLogro.findAll", query="SELECT a FROM AsignaturaLogro a")
public class AsignaturaLogro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;

	private String descripcion;

	private BigDecimal porcentaje;

	//bi-directional many-to-one association to AsignaturaDescripcion
	@ManyToOne
	@JoinColumn(name="asignatura_descripcion")
	private AsignaturaDescripcion asignaturaDescripcionBean;

	//bi-directional many-to-one association to AsignaturaNota
	@OneToMany(mappedBy="asignaturaLogro")
	private List<AsignaturaNota> asignaturaNotas;

	public AsignaturaLogro() {
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

	public BigDecimal getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
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
		asignaturaNota.setAsignaturaLogro(this);

		return asignaturaNota;
	}

	public AsignaturaNota removeAsignaturaNota(AsignaturaNota asignaturaNota) {
		getAsignaturaNotas().remove(asignaturaNota);
		asignaturaNota.setAsignaturaLogro(null);

		return asignaturaNota;
	}

}