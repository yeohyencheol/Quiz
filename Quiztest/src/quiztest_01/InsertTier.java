package quiztest_01;

import java.sql.SQLException;

public class InsertTier {
	public static void main(String[] args) {
		//티어정보를 데이터베이스에 넣는 코드
		DbQuizDao dao = DbQuizDaoImpl.getInstance();
		
		//티어정보(값은 차후 취합후 상황에 맞게 코드 수정 요망)
		int id = 100;
		int score = 80;
		String tier = "Platinum";
		int rank = 3;
		
		UserScore us = new UserScore(id, score, tier, rank);
		
		try {
			dao.insertTier(us);
			System.out.println("티어정보 입력완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
