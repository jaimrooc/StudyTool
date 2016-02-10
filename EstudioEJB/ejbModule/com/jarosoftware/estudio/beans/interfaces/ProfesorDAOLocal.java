package com.jarosoftware.estudio.beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.jarosoftware.estudio.model.Profesore;

@Local
public interface ProfesorDAOLocal {
	
	public Profesore create(Profesore profesor);
	public Profesore update(Profesore profesor);
	public boolean remove(long codigo);
	public Profesore getProfesor(long codigo);
	public List<Profesore> getAllProfesors();

}
