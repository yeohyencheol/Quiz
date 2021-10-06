package quiztest_01;

import java.sql.SQLException;
import java.util.Scanner;

public class UserUpdate {
	public static void main(String[] args) {
		DbQuizDao dao = DbQuizDaoImpl.getInstance();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("<회원정보수정>");
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
		
		System.out.println("변경할 패스워드를 입력하세요.");
		String password = scan.next();
		System.out.println("변경할 닉네임을 입력하세요.");
		String nickname = scan.next();
		
		User user = new User(id, password, nickname);
		
		try {
			dao.updateUser(user);
			System.out.println("회원정보수정완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
