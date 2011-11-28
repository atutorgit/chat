package fr.tutornet.struts.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import fr.tutornet.struts.model.javabeans.User;

public class UserDAOImpl implements UserDAO {

	private Connection con;
	private PreparedStatement pstmt;

	public UserDAOImpl() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/MyDB", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertUser(User u) {
		int nbRowsAffected = 0;
		try {
			pstmt = con
					.prepareStatement("INSERT INTO users(login, password, admin) VALUES(?, ?, ?)");

			pstmt.setString(1, u.getLogin());
			pstmt.setString(2, u.getPassword());
			pstmt.setBoolean(3, u.isAdmin());

			nbRowsAffected = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nbRowsAffected > 0;
	}

	@Override
	public boolean deleteUser(User u) {
		int nbRowsAffected = 0;
		try {
			pstmt = con.prepareStatement("DELETE FROM users WHERE login= ?");

			pstmt.setString(1, u.getLogin());

			nbRowsAffected = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nbRowsAffected > 0;
	}

	@Override
	public User findUser(String login) {
		String password = "";
		boolean admin = false;
		try {
			pstmt = con
					.prepareStatement("SELECT password, admin FROM users WHERE login=?");

			pstmt.setString(1, login);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				password = rs.getString("PASSWORD");
				admin = rs.getBoolean("ADMIN");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User u = new User();
		u.setLogin(login);
		u.setPassword(password);
		u.setAdmin(admin);

		return u;
	}

	@Override
	public boolean updateUser(User u) {
		int nbRowsAffected = 0;
		try {
			pstmt = con
					.prepareStatement("UPDATE users SET password=?, admin=? WHERE login=?");

			pstmt.setString(1, u.getPassword());
			pstmt.setBoolean(2, u.isAdmin());
			pstmt.setString(3, u.getLogin());

			nbRowsAffected = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nbRowsAffected > 0;
	}

	@Override
	public Collection<User> allUsers() {
		Collection<User> users = new ArrayList<User>();

		try {
			pstmt = con.prepareStatement("SELECT * FROM users");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setLogin(rs.getString("LOGIN"));
				u.setPassword(rs.getString("PASSWORD"));
				u.setAdmin(rs.getBoolean("ADMIN"));

				users.add(u);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}

}
