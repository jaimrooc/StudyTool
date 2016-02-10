package com.jarosoftware.estudio.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jarosoftware.estudio.util.Contantes;

@ViewScoped
@ManagedBean
public class IndexMB {
	

	/**
	 * Send to 'students' form
	 * @return
	 */
	public String goToHome() {
		return Contantes.PAGE_HOME;
	}
	
	/**
	 * Send to 'students' form
	 * @return
	 */
	public String goToAlumnos() {
		return Contantes.PAGE_STUDENT;
	}
	
	/**
	 * Send to 'document type' form
	 * @return
	 */
	public String goToTiposDocumentos() {
		return Contantes.PAGE_DOCUMENT_TYPE;
	}
	
	/**
	 * Send to 'document type' form
	 * @return
	 */
	public String goToAsignaturas() {
		return Contantes.PAGE_SUBJECT;
	}
	
	/**
	 * Send to 'teacher' form
	 * @return
	 */
	public String goToProfesor() {
		return Contantes.PAGE_TEACHER;
	}
}
