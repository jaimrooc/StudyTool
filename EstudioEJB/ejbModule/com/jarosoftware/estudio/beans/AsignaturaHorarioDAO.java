package com.jarosoftware.estudio.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jarosoftware.estudio.beans.interfaces.AsignaturaHorarioDAOLocal;
import com.jarosoftware.estudio.beans.interfaces.AsignaturaHorarioDAORemote;
import com.jarosoftware.estudio.model.AsignaturaHorario;

/**
 * Session Bean implementation class AsignaturaHorarioDAO
 */
@Stateless
public class AsignaturaHorarioDAO implements AsignaturaHorarioDAORemote, AsignaturaHorarioDAOLocal {
	
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public AsignaturaHorarioDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public AsignaturaHorario create(AsignaturaHorario asignaturaHorario) {
		em.persist(asignaturaHorario);
		return asignaturaHorario;
	}

	@Override
	public AsignaturaHorario update(AsignaturaHorario asignaturaHorario) {
		em.merge(asignaturaHorario);
		return asignaturaHorario;
	}

	@Override
	public boolean remove(long codigo) {
		try {
			em.remove(getAsignaturaHorario(codigo));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public AsignaturaHorario getAsignaturaHorario(long codigo) {
		try {
			Query query = em
					.createQuery(
							"SELECT ah FROM AsignaturaHorario ah WHERE ah.codigo = ?1",
							AsignaturaHorario.class);
            query.setParameter(1, codigo);
            try {
                return (AsignaturaHorario) query.getSingleResult();
            } catch (Exception e) {
                return null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
	}

	@Override
	public List<AsignaturaHorario> getAllAsignaturaHorarios(long asignatura) {
		return em.createNamedQuery("AsignaturaHorario.findAll", AsignaturaHorario.class).getResultList();
	}

}
