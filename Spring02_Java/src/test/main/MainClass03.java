package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.auto.Car;
import test.util.WritingUtil;

public class MainClass03 {
	public static void main(String[] args) {
		/*
		 * 	택시가 타고싶다.
		 * 
		 * 	Taxi t=new Taxi();
		 * 	t.drive();
		 * 
		 * 	위에 처럼 해도 되지만 Taxi 클래스에 직접적으로 
		 * 	의존하고 싶지 않다.
		 */
		
		ApplicationContext context=new ClassPathXmlApplicationContext("test/main/init.xml");
		
		//spring이 관리하는 객체중에서 Car type 객체를 찾아서 가지고 오기
		Car c1=context.getBean(Car.class);
		c1.drive();
		
		WritingUtil wu=context.getBean(WritingUtil.class);
		wu.write1();
		wu.write2();
		wu.write3();
	}
}
