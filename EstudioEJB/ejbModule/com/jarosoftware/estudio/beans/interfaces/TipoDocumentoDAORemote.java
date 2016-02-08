package com.jarosoftware.estudio.beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.jarosoftware.estudio.model.TipoDocumento;

@Remote
public interface TipoDocumentoDAORemote {
	
	public TipoDocumento create(TipoDocumento tipoDocumento);
	public TipoDocumento update(TipoDocumento tipoDocumento);
	public boolean remove(long codigo);
	public TipoDocumento getTipoDocumento(long codigo);
	public List<TipoDocumento> getAllTipoDocumentos();

}
