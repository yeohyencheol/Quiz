package quiztest_01;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteUser {
	public static void main(String[] args) {
		DbQuizDao dao = DbQuizDaoImpl.getInstance();

		Scanner scan = new Scanner(System.in);
		System.out.println("<회월탈퇴>");
		System.out.println("등록된 아이디를 입력하세요.");
		int id = 0;

		while(true) {
			id = scan.nextInt();

			try {
				User usercheck = dao.findById(id);
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
			dao.deleteUser(id);
			System.out.println("회원탈퇴완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
