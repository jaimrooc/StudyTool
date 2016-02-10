package com.jarosoftware.estudio.beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.jarosoftware.estudio.model.Asignatura;


@Remote
public interface AsignaturaDAORemote {
	
	public Asignatura create(Asignatura asignatura);
	public Asignatura update(Asignatura asignatura);
	public boolean remove(long codigo);
	public Asignatura getAsignatura(long codigo);
	public List<Asignatura> getAllAsignaturas();

}
