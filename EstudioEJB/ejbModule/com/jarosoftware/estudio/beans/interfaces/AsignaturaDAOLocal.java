package com.jarosoftware.estudio.beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.jarosoftware.estudio.model.Asignatura;

@Local
public interface AsignaturaDAOLocal {
	
	public Asignatura create(Asignatura asignatura);
	public Asignatura update(Asignatura asignatura);
	public boolean remove(long codigo);
	public Asignatura getAsignatura(long codigo);
	public List<Asignatura> getAllAsignaturas();

}
