package quiztest_01;

import java.sql.SQLException;
import java.util.List;

public interface DbQuizDao {
	//회원등록
	public int insertUser(User user) throws ClassNotFoundException, SQLException;
	//회원정보수정
	public int updateUser(User user) throws ClassNotFoundException, SQLException;
	//회원탈퇴
	public int deleteUser(int id) throws ClassNotFoundException, SQLException;
	//아이디로 정보찾기
	public User findById(int id) throws ClassNotFoundException, SQLException;
	//티어정보 등록
	public int insertTier(UserScore userScore) throws ClassNotFoundException, SQLException;
	//아이디로 티어조회
	public UserScore findTierById(int id) throws ClassNotFoundException, SQLException;
	//티어테이블 전체조회
	public List<UserScore> findTierAll() throws ClassNotFoundException, SQLException;
	//티어테이블 수정
	public int updateTier(UserScore userScore) throws ClassNotFoundException, SQLException;
}
