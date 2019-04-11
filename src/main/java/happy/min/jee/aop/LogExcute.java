package happy.min.jee.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogExcute {
	
	// 메소드가 실행되기 전에 Argument정보를 출력
	public void before(JoinPoint j) {
		// 멤버필드에서 Logger를 찍는 것은 LogExcute.class의 로그만 찍는 것인데,
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		// 다른 클래스 들에서 찍을 것이고, 그 정보를 Joinpoint가 가지고 있음
		// j.getTarget()하면 Object를 가지고 와서 "" 붙여주면 클래스를 줍니다.
		logger.debug("시작");
		
		// 우리가 보냈던 아규먼트를 배열로 만들어 줍니다.
		// int, String 등 타입이 여러개일 수 있기 때문에 Object로 받아줍니다. 
		Object[] args = j.getArgs();  
		if(args!=null) {
			// j.getSignature() 하면 메소드 전체를 가지고오고, getName()으로 메소드 명만 가지고 온다.
			logger.debug("Method:\t"+j.getSignature().getName());
			for (int i = 0; i < args.length; i++) {
				logger.debug(i+"번째:\t"+args[i]);
			}
			logger.debug("method:\t"+j.getSignature().getName());
		}
	}
	
	// 메소드가 실행된 후 Return이 있을 때
	public void afterReturning(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.debug("끝");
	}
	
	// 예외가 발생 했을 때
	public void daoError(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.debug("에러:\t"+j.getArgs());
		logger.debug("에러:\t"+j.toString());
	}
	
	

}
