package com.jarosoftware.estudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the alumnos database table.
 * 
 */
@Entity
@Table(name="alumnos")
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlumnoPK id;

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

	//bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name="tipo_documento", insertable=false, updatable=false)
	private TipoDocumento tipoDocumentoBean;

	//bi-directional many-to-one association to AsignaturaAlumno
	@OneToMany(mappedBy="alumnoBean")
	private List<AsignaturaAlumno> asignaturaAlumnos;
	
	@Transient
	private boolean editar;

	public Alumno() {
		if (this.id == null) {
			id = new AlumnoPK();
		}
	}

	public AlumnoPK getId() {
		return this.id;
	}

	public void setId(AlumnoPK id) {
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

	public TipoDocumento getTipoDocumentoBean() {
		return this.tipoDocumentoBean;
	}

	public void setTipoDocumentoBean(TipoDocumento tipoDocumentoBean) {
		this.tipoDocumentoBean = tipoDocumentoBean;
	}

	public List<AsignaturaAlumno> getAsignaturaAlumnos() {
		return this.asignaturaAlumnos;
	}

	public void setAsignaturaAlumnos(List<AsignaturaAlumno> asignaturaAlumnos) {
		this.asignaturaAlumnos = asignaturaAlumnos;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public AsignaturaAlumno addAsignaturaAlumno(AsignaturaAlumno asignaturaAlumno) {
		getAsignaturaAlumnos().add(asignaturaAlumno);
		asignaturaAlumno.setAlumnoBean(this);

		return asignaturaAlumno;
	}

	public AsignaturaAlumno removeAsignaturaAlumno(AsignaturaAlumno asignaturaAlumno) {
		getAsignaturaAlumnos().remove(asignaturaAlumno);
		asignaturaAlumno.setAlumnoBean(null);

		return asignaturaAlumno;
	}
}