package test.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * 	Aspect: 횡단 관심사
 * 
 * 	- 핵심 비지니스 로직과는 상관없는 횡단관심사(공통관심사)를 따로 작성한다
 * 	- Spring이 관리하는 bean들끼리 가능
 */
@Aspect
@Component
public class WritingAspect {
	
	//수행 이전에 적용
	//write*->시작하는()를 수행하기 이전에
	@Before("execution(void write*())")
	public void prepare() {
		System.out.println("검정색 Pen을 준비해요.");
	}
	
	@After("execution(void write*())")
	public void end() {
		System.out.println("Pen 뚜껑을 닫아요");
	}
}
/*
 *    -Aspectj Expression @Before(여기가 어스펙j)
 * 
 *    1. execution(* *(..)) => 접근 가능한 모든 메소드 point cut
 *    
 *                             모든클레스에  모든메소드
 *    2. execution(* test.service.*.*(..)) 
 *       => test.service 패키지의 모든 메소드 point cut
 *    
 *    3. execution(void insert*(..))
 *       =>리턴 type 은 void 이고 메소드명이 
 *       insert 로 시작하는 모든 메소드가 point cut
 *    
 *    4. execution(* delete*(*))
 *       => 메소드 명이 delete 로 시작하고 인자로 1개 전달받는 
 *      메소드가 point cut (aop 가 적용되는 위치)
 *    
 *    5. execution(* delete*(*,*))
 *       => 메소드 명이 delete 로 시작하고 인자로 2개 전달받는 
 *      메소드가 point cut (aop 가 적용되는 위치)
 *  
 *    6. execution(String update*(Integer,*))
 *      => 메소드 명이 update 로 시작하고 리턴 type 은 String
 *      메소드의 첫번째 인자는 Integer type, 두번째 인자는 아무 type 다되는 
 *      메소드가 point cut (aop 가 적용되는 위치)
 */
