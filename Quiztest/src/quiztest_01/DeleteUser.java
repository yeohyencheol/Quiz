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
		
		id = scan.nextInt();
		
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
