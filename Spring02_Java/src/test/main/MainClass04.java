package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.util.Messenger;
import test.util.WritingUtil;

public class MainClass04 {
	public static void main(String[] args) {

		
		ApplicationContext context=new ClassPathXmlApplicationContext("test/main/init.xml");
		
		//spring이 관리하는 객체중에서 Car type 객체를 찾아서 가지고 오기
		WritingUtil wu=context.getBean(WritingUtil.class);
		wu.write1();
		wu.write2();
		wu.write3();
		
		Messenger m=context.getBean(Messenger.class);
		m.sendGreeting("너 바보셈?");
	}
}
