package com.jarosoftware.estudio.beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.jarosoftware.estudio.model.Profesore;

@Remote
public interface ProfesorDAORemote {
	
	public Profesore create(Profesore profesor);
	public Profesore update(Profesore profesor);
	public boolean remove(long codigo);
	public Profesore getProfesor(long codigo);
	public List<Profesore> getAllProfesors();

}
