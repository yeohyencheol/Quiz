package quiztest_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			
			pst.setString(1, user.getId());;
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
			pst.setString(3, user.getId());
			
			return pst.executeUpdate();
		}
	}

	@Override
	public int deleteUser(String id) throws ClassNotFoundException, SQLException {
		String sql = "delete from users where user_id=?";
		try(Connection conn = DbConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, id);
			
			return pst.executeUpdate();
		}
	}
	@Override
	public User findById(String id) throws ClassNotFoundException, SQLException {
		String sql = "select * from users where user_id=?";
		try(Connection conn = DbConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, id);
			
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					return new User(rs.getString("user_id"), 
							rs.getString("user_password"), 
							rs.getString("user_nickname"));
				} else {
					return null;
				}
			}
		}
	}
	@Override
	public int insertTier(UserScore userScore) throws ClassNotFoundException, SQLException {
		String sql = "insert into users_tier values(?, ?, ?, ?)";
		try(Connection conn = DbConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, userScore.getId());
			pst.setInt(2, userScore.getScore());
			pst.setString(3, userScore.getTier());
			pst.setInt(4, userScore.getRank());
			
			
			return pst.executeUpdate();
		}
	}
	@Override
	public UserScore findTierById(String id) throws ClassNotFoundException, SQLException {
		String sql = "select * from users_tier where user_id=?";
		try(Connection conn = DbConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, id);
			
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					return new UserScore(rs.getString("user_id"), 
							rs.getInt("score"), 
							rs.getString("tier"), 
							rs.getInt("ranking"));
				} else {
					return null;
				}
			}
		}
	}
	@Override
	public List<UserScore> findTierAll() throws ClassNotFoundException, SQLException {
		String sql = "select * from users_tier";
		try(Connection conn = DbConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()){
			List<UserScore> userScList = new ArrayList<UserScore>();
			while(rs.next()) {
				userScList.add(new UserScore(rs.getString("user_id"), 
						rs.getInt("score"), 
						rs.getString("tier"), 
						rs.getInt("ranking")));
			}
			return userScList;
		}
	}
	@Override
	public int updateTier(UserScore userScore) throws ClassNotFoundException, SQLException {
		String sql = "update users_tier set score=?, ranking=?, tier=? where user_id=?";
		
		try(Connection conn = DbConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, userScore.getScore());
			pst.setInt(2, userScore.getRank());
			pst.setString(3, userScore.getTier());
			pst.setString(4, userScore.getId());
			
			return pst.executeUpdate();
		}
	}
	@Override
	public int deleteTier(String id) throws ClassNotFoundException, SQLException {
		String sql = "delete from users_tier where user_id=?";
		try(Connection conn = DbConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, id);
			
			return pst.executeUpdate();
		}
	}
	
}
