package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessengerAspect {
	
	//메소드에 전달한 인자 조사, 메소드가 리턴하는값 조사 가능
	@Around("execution(void send*(..))")
	public void checkGreeting(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args=joinPoint.getArgs(); //Aspect Around로 전달받은 값(send*(여기)))들을 오브젝트 배열로 저장
		//Aspect Around 실행되기 전
		
		//반복문 돌면서 원하는 type 의 값을 찾아서 작업한다
		for(Object tmp:args) {
			//만일 String type 이면
			if(tmp instanceof String) {
				//원래 타입으로 캐스팅
				String msg=(String)tmp;
				System.out.println("aspect에서 읽어낸 내용"+msg);
				if(msg.contains("바보")) {
					System.out.println("바보는 금지된 단어입니다.");
					return; //메소드 종료
				}
			}
		}
		
		joinPoint.proceed(); //Aspect Around를 실행하는 순간 
		//Aspect Around 실행된 후
		System.out.println("aspect가 적용된 메소드가 리턴 했습니다.");
	}
}
