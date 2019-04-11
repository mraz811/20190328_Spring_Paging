package happy.min.jee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// 8^^번
//Filter도 servlet구현이기 때문에 life-cycle을 따라가 준다. 강제구현해야하는 life-cycle이 있다.
public class AccessLoggerFilter implements Filter{ 
	// filter는 가로채서 무언갈 할 수 있다! intercepter.. 로그인 안 되어 있는 상태에서 페이지이동 안되게, 
	// cache 지워줘서 로그아웃시 뒤로 못가게.. 등
	
	// Filter로 갖고 오는 정보는 filter로 찍고, log는 logger로 찍겠다.
	private Logger logger = LoggerFactory.getLogger(AccessLoggerFilter.class);
	

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 가로 채고, chain Filter를 통해서 이동 시킬 건지.. 흐름은 그대로 보내줄 건지.. 
		// httpServletRequest의 상위객체가 ServletRequest! 우리는 화면ㅇ서 전송된 애들을 사용할 것이기 때문에
		// ServletRequest를 가지고 HttpServletRequest를 구현해주어야 함
		HttpServletRequest request = (HttpServletRequest) req; // Down-casting
		
		// remoteAddr()에 아무것도 없다면 "-" 찍겠다. lang3 사용
		// 외부에서 요청된 (외부포트로 접근한:8091로 들어온 애) 의 주소.. 그 접근한 애의 주소! 나에게 들어온 주소를 찍어준다. 
		String remoteAddr = StringUtils.defaultString(request.getRemoteAddr(), "-");
		
		// defaultString은 Null 만 판단, defaultifempty는 null과 ""판단해서 NULL로.
		String uri = StringUtils.defaultIfEmpty(request.getRequestURI(), "");
		String url = (request.getRequestURL()==null)? "": request.getRequestURL().toString();
		
		// 주소의 ?뒤에 있는 "?키=값&..."
		String queryString = StringUtils.defaultIfEmpty(request.getQueryString(), "");
		
		// Header 정보(Referer)
		String refer = StringUtils.defaultString(request.getHeader("Referer"), "-");
		
		// Header 정보(User-Agent)
		String agent = StringUtils.defaultString(request.getHeader("User-Agent"),"-");
		
		// Concat 사용하면 메모리 너무 많이 사용하므로 String Buffer를 사용할 예정
		
		String fullUrl = url;
		fullUrl += StringUtils.isNotEmpty(queryString) ? "?"+queryString : queryString;
		
		StringBuffer result = new StringBuffer();
		result.append(":").append(remoteAddr).append(":").append(fullUrl).append(":").append(refer).append(":").append(agent);
		
		logger.warn("[Log Filter]" +result.toString());
		
		chain.doFilter(req, resp); // 정보 찍었으니까 가던길 가세요
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
	
}
