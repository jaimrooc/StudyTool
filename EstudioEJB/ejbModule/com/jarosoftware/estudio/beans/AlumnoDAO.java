package com.jarosoftware.estudio.beans;

import java.util.List;

import com.jarosoftware.estudio.beans.interfaces.AlumnoDAOLocal;
import com.jarosoftware.estudio.beans.interfaces.AlumnoDAORemote;
import com.jarosoftware.estudio.model.Alumno;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class AlumnoDAO
 */
@Stateless
public class AlumnoDAO implements AlumnoDAORemote, AlumnoDAOLocal {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public AlumnoDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Alumno create(Alumno alumno) {
		em.persist(alumno);
		return alumno;
	}

	@Override
	public Alumno update(Alumno alumno) {
		em.merge(alumno);
		return alumno;
	}

	@Override
	public boolean remove(long tipoDocumento, long documento) {
		try {
			em.remove(getAlumno(tipoDocumento, documento));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Alumno getAlumno(long tipoDocumento, long documento) {
		try {
			Query query = em
					.createQuery(
							"SELECT a FROM Alumno a WHERE a.id.tipoDocumento = ?1 AND a.id.identificacion = ?2",
							Alumno.class);
            query.setParameter(1, tipoDocumento);
            query.setParameter(2, documento);
            try {
                return (Alumno) query.getSingleResult();
            } catch (Exception e) {
                return null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
//            if (em != null) {
//                em.close();
//            }
        }
	}

	@Override
	public List<Alumno> getAllAlumnos() {
		return em.createNamedQuery("Alumno.findAll", Alumno.class).getResultList();
	}

}
