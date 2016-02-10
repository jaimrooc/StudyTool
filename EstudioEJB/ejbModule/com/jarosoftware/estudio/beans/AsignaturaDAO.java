package com.jarosoftware.estudio.beans;

import java.util.List;

import com.jarosoftware.estudio.beans.interfaces.AsignaturaDAOLocal;
import com.jarosoftware.estudio.beans.interfaces.AsignaturaDAORemote;
import com.jarosoftware.estudio.model.Asignatura;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class AsignaturaDAO
 */
@Stateless
public class AsignaturaDAO implements AsignaturaDAORemote, AsignaturaDAOLocal {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public AsignaturaDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Asignatura create(Asignatura asignatura) {
		em.persist(asignatura);
		return asignatura;
	}

	@Override
	public Asignatura update(Asignatura asignatura) {
		em.merge(asignatura);
		return asignatura;
	}

	@Override
	public boolean remove(long codigo) {
		try {
			em.remove(getAsignatura(codigo));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Asignatura getAsignatura(long codigo) {
		try {
			Query query = em
					.createQuery(
							"SELECT t FROM Asignatura t WHERE t.codigo = ?1",
							Asignatura.class);
            query.setParameter(1, codigo);
            try {
                return (Asignatura) query.getSingleResult();
            } catch (Exception e) {
                return null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
	}

	@Override
	public List<Asignatura> getAllAsignaturas() {
		return em.createNamedQuery("Asignatura.findAll", Asignatura.class).getResultList();
	}
}
