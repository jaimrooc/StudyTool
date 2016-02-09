package com.jarosoftware.estudio.beans;

import com.jarosoftware.estudio.beans.interfaces.AsignaturaDAOLocal;
import com.jarosoftware.estudio.beans.interfaces.AsignaturaDAORemote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class AsignaturaDAO
 */
@Stateless
public class AsignaturaDAO implements AsignaturaDAORemote, AsignaturaDAOLocal {

    /**
     * Default constructor. 
     */
    public AsignaturaDAO() {
        // TODO Auto-generated constructor stub
    }

}
