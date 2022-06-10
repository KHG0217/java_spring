package test.main;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass01 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("비밀번호 입력:");
		String inputPwd=scan.nextLine();
		
		//비밀번호를 암호화 할 수 있는 객체 생성
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		
		//암호화한 문자열 얻어내기
		String encodedPwd=encoder.encode(inputPwd);
		
		//콘솔창에 출력해 보기
		System.out.println(encodedPwd);
	}
}
