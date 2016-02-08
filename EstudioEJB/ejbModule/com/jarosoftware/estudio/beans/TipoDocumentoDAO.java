package com.jarosoftware.estudio.beans;

import java.util.List;

import com.jarosoftware.estudio.beans.interfaces.TipoDocumentoDAOLocal;
import com.jarosoftware.estudio.beans.interfaces.TipoDocumentoDAORemote;
import com.jarosoftware.estudio.model.TipoDocumento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class TipoDocumentoDAO
 */
@Stateless
public class TipoDocumentoDAO implements TipoDocumentoDAORemote, TipoDocumentoDAOLocal {
    
    @PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public TipoDocumentoDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public TipoDocumento create(TipoDocumento tipoDocumento) {
		em.persist(tipoDocumento);
		return tipoDocumento;
	}

	@Override
	public TipoDocumento update(TipoDocumento tipoDocumento) {
		em.merge(tipoDocumento);
		return tipoDocumento;
	}

	@Override
	public boolean remove(long codigo) {
		try {
			em.remove(getTipoDocumento(codigo));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public TipoDocumento getTipoDocumento(long codigo) {
		try {
			Query query = em
					.createQuery(
							"SELECT t FROM TipoDocumento t WHERE t.codigo = ?1",
							TipoDocumento.class);
            query.setParameter(1, codigo);
            try {
                return (TipoDocumento) query.getSingleResult();
            } catch (Exception e) {
                return null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
	}

	@Override
	public List<TipoDocumento> getAllTipoDocumentos() {
		return em.createNamedQuery("TipoDocumento.findAll", TipoDocumento.class).getResultList();
	}

}
