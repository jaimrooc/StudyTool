package com.jarosoftware.estudio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the asignatura_horarios database table.
 * 
 */
@Entity
@Table(name="asignatura_horarios")
@NamedQuery(name="AsignaturaHorario.findAll", query="SELECT a FROM AsignaturaHorario a")
public class AsignaturaHorario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;

	@Column(name="dia_semana")
	private String diaSemana;

	@Temporal(TemporalType.DATE)
	@Column(name="hora_final")
	private Date horaFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="hora_inicio")
	private Date horaInicio;

	//bi-directional many-to-one association to AsignaturaDescripcion
	@ManyToOne
	@JoinColumn(name="asignatura_descripcion")
	private AsignaturaDescripcion asignaturaDescripcionBean;

	public AsignaturaHorario() {
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDiaSemana() {
		return this.diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Date getHoraFinal() {
		return this.horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Date getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public AsignaturaDescripcion getAsignaturaDescripcionBean() {
		return this.asignaturaDescripcionBean;
	}

	public void setAsignaturaDescripcionBean(AsignaturaDescripcion asignaturaDescripcionBean) {
		this.asignaturaDescripcionBean = asignaturaDescripcionBean;
	}

}