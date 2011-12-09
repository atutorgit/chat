package fr.tutornet.struts.model.db;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.tutornet.struts.model.javabeans.User;

public class UserDAOImpl implements UserDAO {

	private EntityManagerFactory entityManagerFactory;

	public UserDAOImpl() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("fr.tutornet.struts.model.db.jpa");
	}

	@Override
	public boolean insertUser(User u) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(u);

		entityManager.getTransaction().commit();
		entityManager.close();

		return true;
	}

	@Override
	public boolean deleteUser(User u) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();
		
		User toRemove = entityManager.find(User.class, u.getLogin());
		entityManager.remove(toRemove);

		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@Override
	public User findUser(String login) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();
		ArrayList<User> result = (ArrayList<User>) entityManager.createQuery(
				"from User where login='" + login + "'").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();

		return result.size() >= 1 ? (User) result.get(0) : new User();
	}

	@Override
	public boolean updateUser(User u) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.merge(u);

		entityManager.getTransaction().commit();
		entityManager.close();

		return true;
	}

	@Override
	public Collection<User> allUsers() {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();
		ArrayList<User> result = (ArrayList<User>) entityManager.createQuery(
				"from User").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();

		return result;
	}

}
