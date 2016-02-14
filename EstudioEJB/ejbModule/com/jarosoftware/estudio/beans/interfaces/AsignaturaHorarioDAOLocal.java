package com.jarosoftware.estudio.beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.jarosoftware.estudio.model.AsignaturaHorario;

@Local
public interface AsignaturaHorarioDAOLocal {
	
	public AsignaturaHorario create(AsignaturaHorario asignaturaHorario);
	public AsignaturaHorario update(AsignaturaHorario asignaturaHorario);
	public boolean remove(long codigo);
	public AsignaturaHorario getAsignaturaHorario(long codigo);
	public List<AsignaturaHorario> getAllAsignaturaHorarios(long asignatura);

}
