package quiztest_01;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertTier {
	public static void main(String[] args) {
		//		//티어정보를 데이터베이스에 넣는 코드
		DbQuizDao dao = DbQuizDaoImpl.getInstance();
		

		//아이디와 점수만 일단 세팅
		//이 부분은 코드수정이 필요함

		UserScore us = new UserScore();
		us.setId(200);
		us.setScore(95);
		//----------------------------------------------

		try {
			dao.insertTier(us);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//티어와 랭킹을 정하기 위해 users_tier 전체 테이블을 불러온다.
		List<UserScore> usr = null;
		try {
			usr = dao.findTierAll();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//순위를 매기기 위해 점수만 뽑아서 내림차순으로 정렬할 리스트와 랭킹을 담을 리스트를 만든다.
		List<Integer> scoreList = new ArrayList<Integer>();
		List<Integer> rankList = new ArrayList<Integer>();
		for (int i = 0; i < usr.size(); i++) {
			scoreList.add(usr.get(i).getScore());
		}
		Collections.sort(scoreList, Collections.reverseOrder());
		for (int i = 0; i < scoreList.size(); i++) {
			int check = 0;
			for (int j = 0; j < i; j++) {
				if(scoreList.get(i)==scoreList.get(j)) {
					check++;
				}
			}
			rankList.add((i+1)-check);
		}

		for (int i = 0; i < usr.size(); i++) {
			for (int j = 0; j < scoreList.size(); j++) {
				if(scoreList.get(j) == usr.get(i).getScore()) {
					usr.get(i).setRank(rankList.get(j));
					break;
				}
			}
		}
		//티어정보를 넣는다.
		for (UserScore u : usr) {
			if(u.getScore()>= 80 && u.getScore()<=100) {
				u.setTier("Diamond");
			} else if (u.getScore()>=60) {
				u.setTier("Platinum");
			} else if (u.getScore()>=40) {
				u.setTier("Silver");
			} else if (u.getScore()>=20) {
				u.setTier("Bronze");
			} else {
				u.setTier("Beginner");
			}
		}

		try {
			for(UserScore u : usr ) {
				dao.updateTier(u);
			}
			System.out.println("삽입완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
