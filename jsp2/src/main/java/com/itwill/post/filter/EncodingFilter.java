package com.itwill.post.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class EncodingFilter
 */

// Filter가 처리할 요청 주소(패턴) 설정:
// (1) web.xml 파일에서 설정하거나
// (2) @WebFilter 애너테이션으로 설정할 수 있음.
public class EncodingFilter extends HttpFilter implements Filter {
    
    private static final Logger log = LoggerFactory.getLogger(EncodingFilter.class);
    
    // 생성자

    public EncodingFilter() {
        log.info("EncodingFilter 생성자 호출");
        
    }
    
    
    
    /**
     * @see HttpFilter#HttpFilter()
     */
    

	/**
	 * @see Filter#destroy()
	 */
    @Override
	public void destroy() {
        // Filter 객체를 메모리에서 제거할 때 WAS가 호출하는 생명주기(life cycle)메서드. 
		// Filter 객체가 소멸될 때 리소스 해체와 같은 작업이 필요하면 해당 작업들을 수행함.
        log.info("destory 호출 ()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
	    log.info("dofilter() : chain.doFilter() 호출 전");
		// 클라이언트에서 온 요청을 컨트롤러(서블릿)에게 전달하기 전에 실행할 코드들을 작성.
	    // 요청(request)인 인코딩 타입을 "UTF-8" 설정:
	    request.setCharacterEncoding("UTF-8");
		// place your code here

		// 요청을 필터체인의 그 다음 단계로 전달 -> 컨트롤러 메서드가 호출됨.
		chain.doFilter(request, response);
		
		log.info("dofilter() : chain.doFilter() 호출 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// 필터 객체가 생성된 후 초기화(initialization) 작업이 필요할 때 
	    // WAS가 호츨하는 생명주기 메서드.
	    log.info("init() 호출");
	}

}
