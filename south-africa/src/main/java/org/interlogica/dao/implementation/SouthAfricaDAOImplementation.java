package org.interlogica.dao.implementation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.interlogica.dao.SouthAfricaDAO;
import org.interlogica.entity.SouthAfrica;

@ApplicationScoped
public class SouthAfricaDAOImplementation implements SouthAfricaDAO {

	@Inject
	EntityManager em;

	@Override
	public SouthAfrica save(SouthAfrica t) {
		return em.merge(t);
	}

}
