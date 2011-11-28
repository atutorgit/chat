package fr.tutornet.struts.model.db;

import java.util.Collection;

import fr.tutornet.struts.model.javabeans.User;

public interface UserDAO {
	public boolean insertUser(User u);

	public boolean deleteUser(User u);

	public User findUser(String login);

	public boolean updateUser(User u);

	public Collection<User> allUsers();
}
