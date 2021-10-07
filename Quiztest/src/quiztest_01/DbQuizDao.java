package quiztest_01;

import java.sql.SQLException;
import java.util.List;

public interface DbQuizDao {
	//회원등록
	public int insertUser(User user) throws ClassNotFoundException, SQLException;
	//회원정보수정
	public int updateUser(User user) throws ClassNotFoundException, SQLException;
	//회원탈퇴
	public int deleteUser(String id) throws ClassNotFoundException, SQLException;
	//아이디로 정보찾기
	public User findById(String id) throws ClassNotFoundException, SQLException;
	//티어정보 등록
	public int insertTier(UserScore userScore) throws ClassNotFoundException, SQLException;
	//아이디로 티어조회
	public UserScore findTierById(String id) throws ClassNotFoundException, SQLException;
	//티어테이블 전체조회
	public List<UserScore> findTierAll() throws ClassNotFoundException, SQLException;
	//티어테이블 수정
	public int updateTier(UserScore userScore) throws ClassNotFoundException, SQLException;
	//티어테이블 삭제(회원탈퇴시 티어테이블에 있는 정보도 같이 삭제한다)
	public int deleteTier(String id) throws ClassNotFoundException, SQLException;
}
