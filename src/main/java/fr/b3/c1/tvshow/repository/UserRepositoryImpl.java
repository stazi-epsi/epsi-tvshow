package fr.b3.c1.tvshow.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fr.b3.c1.tvshow.entity.User;

public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> search(String email, String nickname) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
 
        Root<User> user = cq.from(User.class);
        List<Predicate> predicates = new ArrayList<>();
        
        if (email != null) {
        	predicates.add(cb.like(user.get("email"), "%" + email + "%"));
        }
        if (nickname != null) {
        	predicates.add(cb.like(user.get("nickname"), "%" + nickname + "%"));
        }
        cq.where(predicates.toArray(new Predicate[]{}));
         
        TypedQuery<User> query = em.createQuery(cq);
        return query.getResultList();
	}

	@Override
	public List<User> searchJpql(String email, String nickname) {
		String userSearchQuery = "from User u where 1=1";
		if (email != null) {
			userSearchQuery += " and u.email = :email";
		}
		if (nickname != null) {
			userSearchQuery += " and nickname like :nickname";
		}

		TypedQuery<User> query = em.createQuery(userSearchQuery, User.class);
		
		if (email != null) {
			query.setParameter("email", email);
		}
		if (email != null) {
			query.setParameter("email", "%" + email + "%");
		}
		
        return query.getResultList();
	}
	
}
