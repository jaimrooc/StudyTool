package com.jarosoftware.estudio.managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jarosoftware.estudio.beans.interfaces.TipoDocumentoDAOLocal;
import com.jarosoftware.estudio.model.TipoDocumento;

@ViewScoped
@ManagedBean
public class TipoDocumentoMB {
	
	@EJB
	public TipoDocumentoDAOLocal tipoDocumentoDAOLocal;
	
	public TipoDocumento tipoDocumentoForm = new TipoDocumento();
	
	public void create() {
		tipoDocumentoDAOLocal.create(tipoDocumentoForm);
	}
	
	public void update() {
		tipoDocumentoDAOLocal.update(tipoDocumentoForm);
	}
	
	public void delete(long codigo) {
		tipoDocumentoDAOLocal.remove(codigo);
	}
	
	public void getTipoDocumento(long codigo) {
		tipoDocumentoForm = tipoDocumentoDAOLocal.getTipoDocumento(codigo);
	}
	
	public List<TipoDocumento> getAllTipoDocumentos() {
		return tipoDocumentoDAOLocal.getAllTipoDocumentos();
	}
	
	// ----------------> Atributos propios

	public TipoDocumento getTipoDocumentoForm() {
		return tipoDocumentoForm;
	}

	public void setTipoDocumentoForm(TipoDocumento tipoDocumentoForm) {
		this.tipoDocumentoForm = tipoDocumentoForm;
	}
}