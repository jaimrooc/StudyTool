package com.jarosoftware.estudio.beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.jarosoftware.estudio.model.Alumno;

@Remote
public interface AlumnoDAORemote {
	
	public Alumno create(Alumno alumno);
	public Alumno update(Alumno alumno);
	public boolean remove(long tipoDocumento, long documento);
	public Alumno getAlumno(long tipoDocumento, long documento);
	public List<Alumno> getAllAlumnos();

}
