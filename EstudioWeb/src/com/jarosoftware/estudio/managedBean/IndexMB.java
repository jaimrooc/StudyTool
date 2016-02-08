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
}
