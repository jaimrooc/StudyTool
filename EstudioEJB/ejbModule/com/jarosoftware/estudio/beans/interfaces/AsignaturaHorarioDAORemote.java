package com.jarosoftware.estudio.beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.jarosoftware.estudio.model.AsignaturaHorario;

@Remote
public interface AsignaturaHorarioDAORemote {
	
	public AsignaturaHorario create(AsignaturaHorario asignaturaHorario);
	public AsignaturaHorario update(AsignaturaHorario asignaturaHorario);
	public boolean remove(long codigo);
	public AsignaturaHorario getAsignaturaHorario(long codigo);
	public List<AsignaturaHorario> getAllAsignaturaHorarios(long asignatura);

}
