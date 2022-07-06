package test.main;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class MainClass02 {
	public static void main(String[] args) {
		//암호화 해서 DB에 저장된 비밀번호라고 가정하자
		String encodedPwd="$2a$10$oq4pFqmHlUROezdMpCa1OO1rz9mjb5..mEYS1vs.sl5PPSxTkY62S";
		
		//로그인시 입력한 비밀번호
		Scanner scan = new Scanner(System.in);
		System.out.println("비밀번호 입력:");
		String inputPwd=scan.nextLine();
		
		//입력한 비밀번호와 암호화된 비밀번호가 일치하는지 여부를 얻어낸다.
		boolean isValid=BCrypt.checkpw(inputPwd, encodedPwd);
		if(isValid) {
			System.out.println("비밀번호가 일치합니다.");
		}else {
			System.out.println("비밀번호가 틀려요!");
		}
	}
}
