package quiztest_01;

import java.sql.SQLException;
import java.util.Scanner;

public class SelectTier {
	public static void main(String[] args) {
		//id로 티어 조회
		DbQuizDao dao = DbQuizDaoImpl.getInstance();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("<티어조회>");
		System.out.println("등록된 아이디를 입력하세요.");
		String id = null;
		User usercheck = null;
		while(true) {
			id = scan.next();

			try {
				usercheck = dao.findById(id);
				if (usercheck == null) {
					System.out.println("등록되지 않은 아이디입니다. 다시 입력하세요.");
				} else {
					break;
				}
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		try {
			UserScore usT = dao.findTierById(id);
			if(usT != null) {
				System.out.println(usercheck.getNickname()+"("+usT.getId()+")의 티어정보");
				System.out.println(usT);
			} else {
				System.out.println("정보없음");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
