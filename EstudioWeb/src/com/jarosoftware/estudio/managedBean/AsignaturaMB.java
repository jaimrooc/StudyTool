package com.jarosoftware.estudio.managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jarosoftware.estudio.beans.interfaces.AsignaturaDAOLocal;
import com.jarosoftware.estudio.model.Asignatura;

@ViewScoped
@ManagedBean
public class AsignaturaMB {
	
	@EJB
	public AsignaturaDAOLocal asignaturaDAOLocal;
	
	public Asignatura asignaturaForm = new Asignatura();
	
	public void create() {
		asignaturaDAOLocal.create(asignaturaForm);
	}
	
	public void update() {
		asignaturaDAOLocal.update(asignaturaForm);
	}
	
	public void delete(long codigo) {
		asignaturaDAOLocal.remove(codigo);
	}
	
	public void getAsignatura(long codigo) {
		asignaturaForm = asignaturaDAOLocal.getAsignatura(codigo);
	}
	
	public List<Asignatura> getAllAsignaturas() {
		return asignaturaDAOLocal.getAllAsignaturas();
	}
	
	// ----------------> Atributos propios

	public Asignatura getAsignaturaForm() {
		return asignaturaForm;
	}

	public void setAsignaturaForm(Asignatura asignaturaForm) {
		this.asignaturaForm = asignaturaForm;
	}
}
