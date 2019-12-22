package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
// WebFilter 애너테이션을 이용해 모든 요청이 필터를 거치게 합니다.
@WebFilter("/*")
public class EncoderFilter implements Filter { // 사용자 정의 필터는 반드시 Filter 인터페이스를 구현해야 합니다.
	ServletContext context;
    /**
     * Default constructor. 
     */
    public EncoderFilter() {
        // TODO Auto-generated constructor stub
    	System.out.println("destroy 호출");    
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	// doFilter() 안에서 실제 필터 기능을 구현합니다.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		System.out.println("doFilter 호출");
		
		// 한글 인코딩 설정 작업을 합니다.
		request.setCharacterEncoding("utf-8");
		
		// 웹 애플리케이션의 컨텍스트 이름을 가져옵니다.
		String context = ((HttpServletRequest) request).getContextPath();
		
		// 웹 브라우저에서 요청한 요청 URI를 가져옵니다.
		String pathinfo = ((HttpServletRequest) request).getRequestURI();
		
		// 요청 URI의 실제 경로를 가져옵니다.
		String realPath = request.getRealPath(pathinfo);
		String mesg = " Context  정보:" + context + "\n URI 정보 : " + pathinfo + "\n 물리적 경로:  " + realPath;
		System.out.println(mesg);
		
		// 요청 필터에서 요청 처리 전의 시각을 구합니다.
		long begin = System.currentTimeMillis();
		
		// 다음 필터로 넘기는 작업을 수행합니다.
		chain.doFilter(request, response);
		
		// 응답 필터에서 요청 처리 후의 시각을 구합니다.
		long end = System.currentTimeMillis();
		
		// 작업 요청 전과 후의 시각 차를 구해 작업 수행 시간을 구합니다.
		System.out.println("작업 시간:" + (end - begin) + "ms");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("utf-8 인코딩............");
		context = fConfig.getServletContext();
	}

}
