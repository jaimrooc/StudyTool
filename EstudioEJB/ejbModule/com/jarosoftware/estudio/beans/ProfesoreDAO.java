package com.jarosoftware.estudio.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jarosoftware.estudio.beans.interfaces.ProfesorDAOLocal;
import com.jarosoftware.estudio.beans.interfaces.ProfesorDAORemote;
import com.jarosoftware.estudio.model.Profesore;

/**
 * Session Bean implementation class Profesore
 */
@Stateless
public class ProfesoreDAO implements ProfesorDAORemote, ProfesorDAOLocal {
	
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public ProfesoreDAO() {
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public Profesore create(Profesore profesore) {
		em.persist(profesore);
		return profesore;
	}

	@Override
	public Profesore update(Profesore profesore) {
		em.merge(profesore);
		return profesore;
	}

	@Override
	public boolean remove(long codigo) {
		try {
			em.remove(getProfesor(codigo));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Profesore getProfesor(long codigo) {
		try {
			Query query = em
					.createQuery(
							"SELECT t FROM Profesore t WHERE t.codigo = ?1",
							Profesore.class);
            query.setParameter(1, codigo);
            try {
                return (Profesore) query.getSingleResult();
            } catch (Exception e) {
                return null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
	}

	@Override
	public List<Profesore> getAllProfesors() {
		return em.createNamedQuery("Profesore.findAll", Profesore.class).getResultList();
	}

}
