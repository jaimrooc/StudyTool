package com.jarosoftware.estudio.managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jarosoftware.estudio.beans.interfaces.ProfesorDAOLocal;
import com.jarosoftware.estudio.beans.interfaces.TipoDocumentoDAOLocal;
import com.jarosoftware.estudio.model.Profesore;
import com.jarosoftware.estudio.model.TipoDocumento;

@ViewScoped
@ManagedBean
public class ProfesorMB {
	
	@EJB
	private ProfesorDAOLocal profesorDAOLocal;
	
	@EJB
	private TipoDocumentoDAOLocal tipoDocumentoDAOLocal;
	
	private Profesore profesorForm = new Profesore();

	public void create() {
		profesorForm.setEditar(false);
		profesorDAOLocal.create(profesorForm);
	}
	
	public void update() {
		profesorForm.setEditar(false);
		profesorDAOLocal.update(profesorForm);
	}
	
	public void delete(long codigo) {
		profesorDAOLocal.remove(codigo);
	}
	
	public void getProfesor(long codigo) {
		profesorForm = profesorDAOLocal.getProfesor(codigo);
		profesorForm.setEditar(true);
	}
	
	public List<Profesore> getAllProfesors() {
		return profesorDAOLocal.getAllProfesors();
	}
	
	public List<TipoDocumento> getAllTipoDocumentos() {
		return tipoDocumentoDAOLocal.getAllTipoDocumentos();
	}
	
	// ----------------> Atributos propios
	
	public Profesore getProfesorForm() {
		return profesorForm;
	}

	public void setProfesorForm(Profesore profesorForm) {
		this.profesorForm = profesorForm;
	}
}
