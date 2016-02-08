package com.jarosoftware.estudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the profesores database table.
 * 
 */
@Entity
@Table(name="profesores")
@NamedQuery(name="Profesore.findAll", query="SELECT p FROM Profesore p")
public class Profesore implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProfesorePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String nombre;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="segundo_apellido")
	private String segundoApellido;

	@Column(name="telefono_celular")
	private BigDecimal telefonoCelular;

	@Column(name="telefono_fijo")
	private BigDecimal telefonoFijo;

	//bi-directional many-to-one association to AsignaturaDescripcion
	@OneToMany(mappedBy="profesore")
	private List<AsignaturaDescripcion> asignaturaDescripcions;

	//bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name="tipo_documento", insertable=false, updatable=false)
	private TipoDocumento tipoDocumentoBean;

	public Profesore() {
	}

	public ProfesorePK getId() {
		return this.id;
	}

	public void setId(ProfesorePK id) {
		this.id = id;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public BigDecimal getTelefonoCelular() {
		return this.telefonoCelular;
	}

	public void setTelefonoCelular(BigDecimal telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public BigDecimal getTelefonoFijo() {
		return this.telefonoFijo;
	}

	public void setTelefonoFijo(BigDecimal telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public List<AsignaturaDescripcion> getAsignaturaDescripcions() {
		return this.asignaturaDescripcions;
	}

	public void setAsignaturaDescripcions(List<AsignaturaDescripcion> asignaturaDescripcions) {
		this.asignaturaDescripcions = asignaturaDescripcions;
	}

	public AsignaturaDescripcion addAsignaturaDescripcion(AsignaturaDescripcion asignaturaDescripcion) {
		getAsignaturaDescripcions().add(asignaturaDescripcion);
		asignaturaDescripcion.setProfesore(this);

		return asignaturaDescripcion;
	}

	public AsignaturaDescripcion removeAsignaturaDescripcion(AsignaturaDescripcion asignaturaDescripcion) {
		getAsignaturaDescripcions().remove(asignaturaDescripcion);
		asignaturaDescripcion.setProfesore(null);

		return asignaturaDescripcion;
	}

	public TipoDocumento getTipoDocumentoBean() {
		return this.tipoDocumentoBean;
	}

	public void setTipoDocumentoBean(TipoDocumento tipoDocumentoBean) {
		this.tipoDocumentoBean = tipoDocumentoBean;
	}

}