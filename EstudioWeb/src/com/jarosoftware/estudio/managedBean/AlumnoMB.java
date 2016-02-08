package com.jarosoftware.estudio.managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jarosoftware.estudio.beans.interfaces.AlumnoDAOLocal;
import com.jarosoftware.estudio.beans.interfaces.TipoDocumentoDAOLocal;
import com.jarosoftware.estudio.model.Alumno;
import com.jarosoftware.estudio.model.TipoDocumento;

@ViewScoped
@ManagedBean
public class AlumnoMB {
	
	@EJB
	private AlumnoDAOLocal alumnoDAOLocal;
	
	@EJB
	private TipoDocumentoDAOLocal tipoDocumentoDAOLocal;
	
	private Alumno alumnoForm = new Alumno();

	public void create() {
		alumnoForm.setEditar(false);
		alumnoDAOLocal.create(alumnoForm);
	}
	
	public void update() {
		alumnoForm.setEditar(false);
		alumnoDAOLocal.update(alumnoForm);
	}
	
	public void delete(long tipoDocumento, long documento) {
		alumnoDAOLocal.remove(tipoDocumento, documento);
	}
	
	public void getAlumno(long tipoDocumento, long documento) {
		alumnoForm = alumnoDAOLocal.getAlumno(tipoDocumento, documento);
		alumnoForm.setEditar(true);
	}
	
	public List<Alumno> getAllAlumnos() {
		return alumnoDAOLocal.getAllAlumnos();
	}
	
	public List<TipoDocumento> getAllTipoDocumentos() {
		return tipoDocumentoDAOLocal.getAllTipoDocumentos();
	}
	
	// ----------------> Atributos propios
	
	public Alumno getAlumnoForm() {
		return alumnoForm;
	}

	public void setAlumnoForm(Alumno alumnoForm) {
		this.alumnoForm = alumnoForm;
	}
}
