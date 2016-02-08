package com.jarosoftware.estudio.beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.jarosoftware.estudio.model.TipoDocumento;


@Local
public interface TipoDocumentoDAOLocal {
	
	public TipoDocumento create(TipoDocumento tipoDocumento);
	public TipoDocumento update(TipoDocumento tipoDocumento);
	public boolean remove(long codigo);
	public TipoDocumento getTipoDocumento(long codigo);
	public List<TipoDocumento> getAllTipoDocumentos();

}
