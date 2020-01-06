package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

// 설정 파일의 userMethodNameResolver 프로퍼티를 사용하려면 반드시 MultiActionController를 상속받아야 합니다.
public class UserController extends MultiActionController {
//	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String userID = "";
//		String passwd = "";
//		ModelAndView mav = new ModelAndView();
//		request.setCharacterEncoding("utf-8");
//		userID = request.getParameter("userID");
//		passwd = request.getParameter("passwd");
//
//		// ModelAndView에 로그인 정보를 바인딩합니다.
//		mav.addObject("userID", userID);
//		mav.addObject("passwd", passwd);
//		// ModelAndView 객체에 포워딩할 JSP 이름을 설정합니다.
//		mav.setViewName("result");
//		return mav;
//	}
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String passwd = "";
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");
		//getViewName() 메서드를 호출해 요청명에서 확장명 .do를 제외한 뷰이름을 가져옵니다.
		String viewName=getViewName(request);
		
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		//mav.setViewName("result");
		// 뷰 이름을 지정합니다.
		mav.setViewName(viewName);
	    System.out.println("ViewName:"+viewName);
		return mav;
	}

	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
	    ModelAndView mav=new ModelAndView();
	    String id=request.getParameter("id");
	    String pwd=request.getParameter("pwd");
	    String name=request.getParameter("name");
	    String email=request.getParameter("email");

	    mav.addObject("id",id);
	    mav.addObject("pwd",pwd);
	    mav.addObject("name",name);
	    mav.addObject("email",email);
	    mav.setViewName("memberInfo");
	    return mav;
	}
	
	// request 객체에서 URL 요청명을 가져와 .do를 제외한 요청명을 구합니다. 
	private  String getViewName(HttpServletRequest request) throws Exception {
	      String contextPath = request.getContextPath();
	      String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
	      System.out.println("uri : " + uri);
	      //trim() 공백제거했는 데 빈 문자열이면
	      if(uri == null || uri.trim().equals("")) {
	    	 //request객체에서 uri를 가져온다.
	         uri = request.getRequestURI();
	         System.out.println("uri1 : " + uri);
	      }

	      int begin = 0;
	      //contextPath가 빈 문자열이 아니면
	      if(!((contextPath==null)||("".equals(contextPath)))){
	    	 // contextPath의 길이를 begin에 넣는다.
	    	 
	         begin = contextPath.length();
	         System.out.println("contextPath : " +  contextPath);
	         System.out.println("begin1 : "+ begin);
	      }

	      int end;
	      if(uri.indexOf(";")!=-1){
	         end=uri.indexOf(";");
	         System.out.println("end1 : " + end);
	      }else if(uri.indexOf("?")!=-1){
	         end=uri.indexOf("?");
	         System.out.println("end2 : "+ end);
	      }else{
	         end=uri.length();
	         System.out.println("end3 : " + end);
	      }
	      
	      String fileName=uri.substring(begin,end);
	      System.out.println("fileName1 : " + fileName);
	      if(fileName.indexOf(".")!=-1){
	         fileName=fileName.substring(0,fileName.lastIndexOf("."));
	         System.out.println("fileName2 : " + fileName);
	      }
	      if(fileName.lastIndexOf("/")!=-1){
	         fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length());
	         
	         int fileName3LIO = fileName.lastIndexOf("/");
	         int fileName3Length = fileName.length();
	        
	         System.out.println("fileName3LIO : " + fileName3LIO);
	         System.out.println("fileName3Length : " + fileName3Length);
	         System.out.println("fileName3 : " + fileName);
	      }
	      return fileName;
	   }
}
