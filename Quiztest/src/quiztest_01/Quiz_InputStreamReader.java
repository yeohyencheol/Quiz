package quiztest_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Quiz_InputStreamReader {
	public static void main(String[] args) {
	
		System.out.println("수도(퀴즈)게임을 시작하시겠습니까? Yes or No");
		Scanner scan = new Scanner(System.in);
		while(true) {
			String yesno_cheek = scan.next();
			if(yesno_cheek.equals("yes")||yesno_cheek.equals("Yes")) {
				System.out.println("시작하겠습니다");
			}else if(yesno_cheek.equals("no")||yesno_cheek.equals("No")) {
				System.out.println("안녕히가십시오");
				System.exit(1);
			}else {
				System.out.println("다시 입력해주세요");
			}
			 
			String[] m= new String[10];
			m[0] = "키프로스의 수도는?"; //니코시아(북키프로스)
			m[1] = "우루과이의 수도는?"; //몬테비데오
			m[2] = "아일랜드 수도는?";	//더블린
			m[3] = "벨기에의 수도는?"; 	//브리쉘
			m[4] = "수리남의 수도는?";	//파라마리보
			m[5] = "체코의 수도는?";	//프라하
			m[6] = "우크라이나 수도는?";	//키예프
			m[7] = "포르투갈의 수도는?";	//리스본
			m[8] = "마케도니아의 수도는?";//스코페
			m[9] = "스위스의 수도는?";	//베른
			String[] c = new String[10];
			c[0] = "니코시아(북키프로스)";
			c[1] = "베른";
			c[2] = "파두츠";
			c[3] = "세인트존스";
			c[4] = "파라마리보";
			c[5] = "프라하";
			c[6] = "킹스타운";
			c[7] = "사라예보";
			c[8] = "파두츠";
			c[9] = "워싱턴 D.C";
			
			String[] c1 = new String[10];
			c1[0] = "브리쉘";
			c1[1] = "레이캬비크";
			c1[2] = "더블린";
			c1[3] = "브리쉘";
			c1[4] = "프라하";
			c1[5] = "베이징";
			c1[6] = "서울";
			c1[7] = "런던";
			c1[8] = "프라하";
			c1[9] = "베른";
			String[] c2 = new String[10];
			c2[0] = "부다페스트";
			c2[1] = "브라질리아";
			c2[2] = "스톡홀름";
			c2[3] = "세인트존스";
			c2[4] = "빌뉴스";
			c2[5] = "벨라루스";
			c2[6] = "키예프";
			c2[7] = "스코페";
			c2[8] = "파라마리보";
			c2[9] = "킹스타운";
			String[] c3 = new String[10];
			c3[0] = "몬테비데오";
			c3[1] = "몬테비데오";
			c3[2] = "키예프";
			c3[3] = "모가디슈";
			c3[4] = "카르툼";
			c3[5] = "앙골라";
			c3[6] = "에리트레아";
			c3[7] = "리스본";
			c3[8] = "스코페";
			c3[9] = "캄팔라";
			
			int answer = 1;
			int sco = 0;
			
			System.out.println("첫번째 문제: "+m[0]);
			System.out.println("1."+c[0]);
			System.out.println("2."+c1[0]);
			System.out.println("3."+c2[0]);
			System.out.println("4."+c3[0]);
			
			System.out.println("정답을 선택해주세요");
			String input = scan.nextLine();
			int inputN = Integer.parseInt(input);
			
			if(inputN == answer) {
				System.out.println("정답입니다");
				sco = sco+10;
			}else {
				System.out.println("틀렸습니다");
			}
			int answer1 = 4;
			
			System.out.println("두번째 문제: "+m[1]);
			System.out.println("1."+c[1]);
			System.out.println("2."+c1[1]);
			System.out.println("3."+c2[1]);
			System.out.println("4."+c3[1]);
			
			input = scan.nextLine();
			int inputA = Integer.parseInt(input);
			
			if(inputA == answer1) {
				System.out.println("정답입니다");
				sco = sco+10;
			}else {
				System.out.println("틀렸습니다");
			}
			int answer2 = 2;
			
			System.out.println("세번째 문제: "+m[2]);
			System.out.println("1."+c[2]);
			System.out.println("2."+c1[2]);
			System.out.println("3."+c2[2]);
			System.out.println("4."+c3[2]);
			
			input = scan.nextLine();
			int inputB = Integer.parseInt(input);
			
			if(inputB == answer2) {
				System.out.println("정답입니다");
				sco = sco+10;
			}else {
				System.out.println("틀렸습니다");
			}
			int answer3 = 2;
			
			System.out.println("네번째 문제: "+m[3]);
			System.out.println("1."+c[3]);
			System.out.println("2."+c1[3]);
			System.out.println("3."+c2[3]);
			System.out.println("4."+c3[3]);
			
			input = scan.nextLine();
			int inputC = Integer.parseInt(input);
			
			if(inputC == answer3) {
				System.out.println("정답입니다");
				sco = sco+10;
			}else {
				System.out.println("틀렸습니다");
			}
			int answer4 = 1;
			
			System.out.println("다섯번째 문제: "+m[4]);
			System.out.println("1."+c[4]);
			System.out.println("2."+c1[4]);
			System.out.println("3."+c2[4]);
			System.out.println("4."+c3[4]);
			
			input = scan.nextLine();
			int inputD = Integer.parseInt(input);
			
			if(inputD == answer4) {
				System.out.println("정답입니다");
				sco = sco+10;
			}else {
				System.out.println("틀렸습니다");
			}
			int answer5 = 1;
			
			System.out.println("여섯번째 문제: "+m[5]);
			System.out.println("1."+c[5]);
			System.out.println("2."+c1[5]);
			System.out.println("3."+c2[5]);
			System.out.println("4."+c3[5]);
			
			input = scan.nextLine();
			int inputE = Integer.parseInt(input);
			
			if(inputE == answer5) {
				System.out.println("정답입니다");
				sco = sco+10;
			}else {
				System.out.println("틀렸습니다");
			}
			int answer6 = 3;
			
			System.out.println("일곱번째 문제: "+m[6]);
			System.out.println("1."+c[6]);
			System.out.println("2."+c1[6]);
			System.out.println("3."+c2[6]);
			System.out.println("4."+c3[6]);
			
			input = scan.nextLine();
			int inputF = Integer.parseInt(input);
			
			if(inputF == answer6) {
				System.out.println("정답입니다");
				sco = sco+10;
			}else {
				System.out.println("틀렸습니다");
			}
			int answer7 = 4;
			
			System.out.println("여덟번째 문제: "+m[7]);
			System.out.println("1."+c[7]);
			System.out.println("2."+c1[7]);
			System.out.println("3."+c2[7]);
			System.out.println("4."+c3[7]);
			
			input = scan.nextLine();
			int inputG = Integer.parseInt(input);
			
			if(inputG == answer7) {
				System.out.println("정답입니다");
				sco = sco+10;
			}else {
				System.out.println("틀렸습니다");
			}
			int answer8 = 4;
			
			System.out.println("아홉번째 문제: "+m[8]);
			System.out.println("1."+c[8]);
			System.out.println("2."+c1[8]);
			System.out.println("3."+c2[8]);
			System.out.println("4."+c3[8]);
			
			input = scan.nextLine();
			int inputH = Integer.parseInt(input);
			
			if(inputH == answer8) {
				System.out.println("정답입니다");
				sco = sco+10;
			}else {
				System.out.println("틀렸습니다");
			}
			int answer9 = 2;
			
			System.out.println("열번째 문제: "+m[9]);
			System.out.println("1."+c[9]);
			System.out.println("2."+c1[9]);
			System.out.println("3."+c2[9]);
			System.out.println("4."+c3[9]);
			
			input = scan.nextLine();
			int inputI = Integer.parseInt(input);
			
			if(inputI == answer9) {
				System.out.println("정답입니다");
				sco = sco+10;
			
			}else {
				System.out.println("틀렸습니다");
			}
			System.out.println("총합 점수:"+sco);
		
			
			File file = new File("src/quiztest_01/quiz.txt");
			
			try(InputStreamReader ier 
					= new InputStreamReader(new FileInputStream(file),"utf-8")){
				
				int data = -1;
				while((data=ier.read()) != -1) {
					System.out.print((char)data);
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
		
	
		
						
