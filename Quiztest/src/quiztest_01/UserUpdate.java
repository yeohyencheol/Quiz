package quiztest_01;

import java.sql.SQLException;
import java.util.Scanner;

public class UserUpdate {
	public static void main(String[] args) {
		DbQuizDao dao = DbQuizDaoImpl.getInstance();
		Scanner scan = new Scanner(System.in);

		System.out.println("<회원정보수정>등록된 회원정보를 수정합니다.");
		String id = null;

		while(true) {
			System.out.println("등록된 아이디를 입력하세요.");
			id = scan.next();
			System.out.println("패스워드를 입력하세요.");
			String password = scan.next();
			User user = null;
			try {
				user = dao.findById(id);
				if (user == null || !user.getPassword().equals(password)) {//아이디가 존재하지 않거나, 비밀번호가 틀린 경우
					System.out.println("등록되지 않은 아이디이거나 잘못된 비밀번호입니다. 다시 입력하세요.");
				} else {//아이디가 존재하고 비밀번호가 맞는 경우
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
