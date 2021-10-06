package quiztest_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbQuizDaoImpl implements DbQuizDao {
	private static DbQuizDaoImpl instance = new DbQuizDaoImpl();
	private DbQuizDaoImpl() {}
	public static DbQuizDaoImpl getInstance() {
		return instance;
	}

	@Override
	public int insertUser(User user) throws ClassNotFoundException, SQLException {
		String sql = "insert into users values(?, ?, ?)";
		try(Connection conn = DbConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setInt(1, user.getId());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getNickname());
			
			return pst.executeUpdate();
		}
	}

	@Override
	public int updateUser(User user) throws ClassNotFoundException, SQLException {
		String sql = "update users set user_password=?, user_nickname=? where user_id=?";
		
		try(Connection conn = DbConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, user.getPassword());
			pst.setString(2, user.getNickname());
			pst.setInt(3, user.getId());
			
			return pst.executeUpdate();
		}
	}

	@Override
	public int deleteUser(int id) throws ClassNotFoundException, SQLException {
		String sql = "delete from users where user_id=?";
		try(Connection conn = DbConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, id);
			
			return pst.executeUpdate();
		}
	}
	@Override
	public User findById(int id) throws ClassNotFoundException, SQLException {
		String sql = "select * from users where user_id=?";
		try(Connection conn = DbConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, id);
			
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					return new User(rs.getInt("user_id"), 
							rs.getString("user_password"), 
							rs.getString("user_nickname"));
				} else {
					return null;
				}
			}
		}
	}
	
}
