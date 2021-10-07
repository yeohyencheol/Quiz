package quiztest_01;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteUser {
	public static void main(String[] args) {
		DbQuizDao dao = DbQuizDaoImpl.getInstance();

		Scanner scan = new Scanner(System.in);
		System.out.println("<회원탈퇴> 회원탈퇴시 모든 정보가 삭제됩니다.");
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
		System.out.println("회원탈퇴시 모든 정보가 삭제됩니다. 계속하시겠습니까?(진행하려면 y 입력, 다른 문자 입력시 탈퇴 취소)");
		String ans = scan.next();
		if(!ans.equals("y") && !ans.equals("Y")) {
			System.out.println("회원탈퇴가 취소되었습니다.");
			System.exit(0);
		}
		System.out.println("회원탈퇴 진행 중...");
		//users 테이블 정보 삭제
		try {
			dao.deleteUser(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//users_tier 테이블 정보 삭제
		try {
			dao.deleteTier(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("회원탈퇴완료");
	}
}
