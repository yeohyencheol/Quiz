package quiztest_01;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInsert {
	public static void main(String[] args) {
		DbQuizDao dao = DbQuizDaoImpl.getInstance();
		
		Scanner scan = new Scanner(System.in);
		int id = 0;
		System.out.println("아이디를 입력하세요.(숫자로만)");
		while(true) {
			id = scan.nextInt();
			
			try {
				User usercheck = dao.findById(id);
				if(usercheck != null) {
					System.out.println("중복된 아이디입니다. 다시 입력하세요.");
				} else {
					break;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		System.out.println("아이디를 입력하세요.(숫자로만)");
//		id = scan.nextInt();
		System.out.println("패스워드를 입력하세요.");
		String password = scan.next();
		System.out.println("닉네임을 입력하세요.");
		String nickname = scan.next();
		
		User user = new User(id, password, nickname);
		
		try {
			int result = dao.insertUser(user);
			System.out.println("회원등록이 완료되었습니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
