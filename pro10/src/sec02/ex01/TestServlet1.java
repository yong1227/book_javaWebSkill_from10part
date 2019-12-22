package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet1
 */
// 정확히 이름까지 일치하는 URL 패턴
@WebServlet("/first/test")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 컨텍스트 이름만 가져온다.
		String context = request.getContextPath();
		// URI를 가져온다.
		String uri = request.getRequestURI().toString();
		// 전체 URL을 가져온다
		String url = request.getRequestURL().toString();
		// 서블릿 매핑 이름만 가져온다.
		String mapping = request.getServletPath();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Test Servlet </title>");
		out.println("</head>");
		out.println("<body bgcolor = 'green'>");
		out.println("<b> TestServlet 입니다. </b><br>");
		out.println("<b>컨텍스트 이름 : " + context + "</b><br>");
		out.println("<b>URI : " + uri + "</b><br>");
		out.println("<b>URL : " + url + "</b><br>");
		out.println("<b>매핑 이름 : " + mapping + "</b><br>");
		out.println("</body>");
		out.print("</html>");
		out.close();
		
		
	}

}
